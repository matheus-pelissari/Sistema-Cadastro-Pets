package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
}
