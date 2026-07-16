package view;

import controller.PetController;
import jsonutil.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import model.Pet;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {

    private PetController petControler;

    public void setController(PetController controller) {
        this.petControler = controller;
    }

    Scanner sc = new Scanner(System.in);

    public void showView(){

        boolean inicializador = true;

        while(inicializador){
            int escolha = 0;

            // Leitura do menu.json
            try{
                JsonNode node = JsonUtil.MAPPER.readTree(new File("menu.json"));
                mostrarMenu(node.toPrettyString());
            }catch(java.io.IOException e){
                mostrarMsgLn("Erro ao ler o arquivo Menu");
                break;
            }

            // Escolha da opção
            try{
                mostrarMsg("Escolha: ");
                escolha = sc.nextInt();
                sc.nextLine();
                if(escolha <= 0 || escolha > 6){
                    throw new IllegalArgumentException();
                }
            }catch (InputMismatchException e){
                mostrarMsgLn("Input não foi um int");
                sc.nextLine();
                continue;
            }catch (IllegalArgumentException e){
                mostrarMsgLn("O valor da escolha deve ser >= 0 && <= 6");
                continue;
            }


            switch(escolha){

                // Cadastrar Pet
                case 1:
                    petControler.cadastrarPet();
                    break;

                case 2 :
                    petControler.alterarPet();
                    break;

                case 3 :
                    petControler.removerPet();
                    break;

                case 4 :
                    petControler.listarPets();
                    break;

                case 5:
                    petControler.buscarPet();
                    break;

                case 6:
                    inicializador = false;
                    break;
            }
        }
    }

    public void escolha(JsonNode pergunta){
        System.out.println(pergunta);
        System.out.print("Escolha: ");
    }

    public void mostrarMsgLn(String s){
        System.out.println("[INFO] " + s);
    }

    public void mostrarMsg(String s){
        System.out.print(s);
    }

    public void mostrarMenu(String s){
        System.out.println("\n**MENU** " + s);
    }

    public void menuBusca(){
        System.out.println("Nome ou Sobrenome");
        System.out.println("Sexo");
        System.out.println("Idade");
        System.out.println("Peso");
        System.out.println("Raca");
        System.out.println("Endereco");
        System.out.println("Tipo");
        System.out.print("Escolha: ");
    }

    public void printarLista(List<Pet> p){
        for(Pet pet: p){
            System.out.println(pet);
        }
    }

    public void printPet(Pet o){
        System.out.println(o);
    }
}
