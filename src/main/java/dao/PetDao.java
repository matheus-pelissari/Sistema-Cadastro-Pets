package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Sexo;
import jsonutil.JsonUtil;
import model.Pet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetDao {

    private final File arquivo;
    private final ObjectMapper mapper = JsonUtil.MAPPER;

    public PetDao(String path){
        this.arquivo = new File(path);
    }

    public List<Pet> listarPets() throws IOException{
        if(!arquivo.exists() || arquivo.length() == 0){
            return new ArrayList<>();
        }
        return mapper.readValue(arquivo, new TypeReference<List<Pet>>(){});
    }

    public void salvarPets(List<Pet> pets) throws IOException{
        mapper.writerWithDefaultPrettyPrinter().writeValue(arquivo, pets);
    }

    public void adicionarPets(Pet novoPet)throws  IOException{
        List<Pet> pets = listarPets();
        pets.add(novoPet);
        salvarPets(pets);
    }

    public void buscarPetNome(String nome) throws  IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComNome = new ArrayList<>();

        for (Pet pet : pets) {
            if (pet.getNomeSobrenome().contains(nome)) {
                petsComNome.add(pet);
            }
        }
        if(petsComNome.isEmpty()){
            return;
        }
        for (Pet pet : petsComNome) {
            System.out.println(pet);
        }
    }

    public void buscarPetSexo(String sexo) throws IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComSexoProcurado = new ArrayList<>();
        Sexo sexoEscolhido;

        if(sexo.equals("feminino")){
            sexoEscolhido = Sexo.Feminino;
        }
        else{
            sexoEscolhido = Sexo.Masculino;
        }

        for(Pet pet : pets){
            if(pet.getSexo().equals(sexoEscolhido)){
                petsComSexoProcurado.add(pet);
            }
        }
        if(petsComSexoProcurado.isEmpty()){
            return;
        }
        for(Pet pet: petsComSexoProcurado){
            System.out.println(pet);
        }
    }

}
