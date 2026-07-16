package controller;

import dao.PetDao;
import jsonutil.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import model.Pet;
import view.View;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PetController {

    private View view;
    private PetDao dao;

    public PetController(View view, PetDao dao) {
        this.view = view;
        this.dao = dao;
    }

    Scanner sc = new Scanner(System.in);
    String nomeSobrenome;
    String raca;
    String escolhaTipo;
    String escolhaSexo;
    String enderecoCidade;
    String enderecoRua;
    String enderecoNumeroRua;
    Double idade;
    Double peso;

    public void cadastrarPet(){

        try {
            JsonNode root = JsonUtil.MAPPER.readTree(new File("formulario.json"));

            JsonNode pergunta = root.get("1");
            view.escolha(pergunta);
            nomeSobrenome = sc.nextLine().toLowerCase();

            pergunta = root.get("2");
            view.escolha(pergunta);
            escolhaTipo = sc.nextLine().toLowerCase();

            pergunta = root.get("3");
            view.escolha(pergunta);
            escolhaSexo = sc.nextLine().toLowerCase();

            pergunta = root.get("4");
            view.escolha(pergunta);
            enderecoCidade = sc.nextLine().toLowerCase();

            pergunta = root.get("5");
            view.escolha(pergunta);
            enderecoRua = sc.nextLine().toLowerCase();

            pergunta = root.get("6");
            view.escolha(pergunta);
            enderecoNumeroRua = sc.nextLine();

            pergunta = root.get("7");
            view.escolha(pergunta);
            idade = sc.nextDouble();
            sc.nextLine();

            pergunta = root.get("8");
            view.escolha(pergunta);
            peso = sc.nextDouble();
            sc.nextLine();

            view.escolha(root.get("9"));
            raca = sc.nextLine();

            try{
                Pet p = new Pet(nomeSobrenome, escolhaTipo, escolhaSexo, enderecoCidade,enderecoRua, enderecoNumeroRua, idade, peso, raca);
                dao.adicionarPets(p);
            }catch (Exception e){
                view.mostrarMsgLn(e.getMessage());
            }

        }catch (IOException e){
            view.mostrarMsgLn("Erro ao ler o arquivo");
        }
    }

    public void buscarPet(){

        view.menuBusca();

        try{
            String escolha = sc.nextLine().toLowerCase();

            if(escolha.equals("nome ou sobrenome")){
                view.mostrarMsg("Informe o nome/sobrenome: ");
                String nome = sc.nextLine().toLowerCase();
                dao.buscarPetNome(nome);
            }




        }catch (IOException i){
            view.mostrarMsgLn("[buscar pet] erro");
        }
    }



}
