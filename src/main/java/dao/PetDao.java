package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Sexo;
import enums.Tipo;
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


    public List<Pet> buscarPetNome(String nome) throws  IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComNome = new ArrayList<>();

        for (Pet pet : pets) {
            if (pet.getNomeSobrenome().contains(nome)) {
                petsComNome.add(pet);
            }
        }
        if(petsComNome.isEmpty()){
            return null;
        }
        return petsComNome;
    }

    public List<Pet> buscarPetSexo(String sexo) throws IOException{
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
            return null;
        }
        return petsComSexoProcurado;
    }

    public List<Pet> buscarPetPorIdade(Double idade) throws IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComIdade = new ArrayList<>();

        for(Pet pet : pets){
            if(pet.getIdade().equals(idade)){
                petsComIdade.add(pet);
            }
        }
        if(petsComIdade.isEmpty()){
            return null;
        }
        return petsComIdade;
    }

    public List<Pet> buscarPetPorPeso(Double peso) throws IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComPeso = new ArrayList<>();

        for(Pet pet : pets){
            if(pet.getPeso().equals(peso)){
                petsComPeso.add(pet);
            }
        }
        if(petsComPeso.isEmpty()){
            return null;
        }
        return petsComPeso;
    }

    public List<Pet> buscarPetPorRaca(String raca) throws IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComRaca = new ArrayList<>();

        for(Pet pet : pets){
            if(pet.getRaca().equals(raca)){
                petsComRaca.add(pet);
            }
        }
        if(petsComRaca.isEmpty()){
            return null;
        }
        return petsComRaca;
    }

    public List<Pet> buscarPetPorEndereco(String endereco) throws IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComEndereco = new ArrayList<>();

        for(Pet pet: pets){
            if(pet.getEndereco().contains(endereco)){
                petsComEndereco.add(pet);
            }
        }
        if(petsComEndereco.isEmpty()){
            return null;
        }
        return petsComEndereco;
    }

    public List<Pet> buscarPetPorTipo(String tipo) throws IOException{
        List<Pet> pets = listarPets();
        List<Pet> petsComTipo = new ArrayList<>();
        Tipo tipoEnum;

        if(tipo.equals("gato")){
            tipoEnum = Tipo.Gato;
        }
        else{
            tipoEnum = Tipo.Cachorro;
        }

        for(Pet pet : pets){
            if(pet.getTipo().equals(tipoEnum)){
                petsComTipo.add(pet);
            }
        }
        if(petsComTipo.isEmpty()){
            return null;
        }
        return petsComTipo;
    }

}
