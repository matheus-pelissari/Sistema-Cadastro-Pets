package model;

import enums.Sexo;
import enums.Tipo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Pet {

    private String nomeSobrenome;
    private String raca;
    private Tipo tipo;
    private Sexo sexo;
    private Double idade;
    private Double peso;
    private String endereco;
    private String dateCreation;
    private final String naoInf = "NAO_INFORMADO";

    public Pet(){}

    public Pet(String nomeSobrenome,String tipo,String sexo, String enderecoCidade, String enderecoRua, String enderecoNumeroRua, Double idade, Double peso, String raca){

        // nomeSobrenome
        String[] dividido = nomeSobrenome.split(" ");
        if (nomeSobrenome.isEmpty()){
            this.nomeSobrenome = naoInf;
        }
        else if(!nomeSobrenome.matches("[A-Z a-z]+")){
            throw new InputMismatchException("[nomeSobrenome] Caracteres Invalidos");
        }
        else if(dividido.length < 2){
            throw new InputMismatchException("[nomeSobrenome] Precisa ter nome e sobrenome");
        }
        else{
            this.nomeSobrenome = nomeSobrenome;
        }

        // tipo
        if(tipo.equals("gato")){
            this.tipo = Tipo.Gato;
        }
        else if(tipo.equals("cachorro")){
            this.tipo = Tipo.Cachorro;
        }
        else{
            throw new IllegalArgumentException("[tipo] Tipo inválido !!!");
        }

        // Sexo
        if(sexo.equals("masculino")){
            this.sexo = Sexo.Masculino;
        }
        else if(sexo.equals("feminino")){
            this.sexo = Sexo.Feminino;
        }
        else{
            throw new IllegalArgumentException("[sexo] Sexo inválido !!!");
        }

        // Endereco Cidade
        if(!enderecoCidade.matches("[A-Z a-z]+")){
            throw new InputMismatchException("[enderecoCidade] Cidade Invalida");
        }

        // Endereco Rua
        if(!enderecoRua.matches("[A-z a-z]+")){
            throw new InputMismatchException("[enderecoRua] Rua inválida");
        }

        // Endereco Rua Número
        if(enderecoNumeroRua.isEmpty()){
            enderecoNumeroRua = naoInf;
        }
        else if(!enderecoNumeroRua.matches("[0-9]+")){
            throw new InputMismatchException("[enderecoRuaNumero] Número inválido");
        }

        this.endereco = enderecoCidade + ", " + enderecoRua + ", " + enderecoNumeroRua;

        // Idade
        if(idade > 20){
            throw new IllegalArgumentException("[idade] Idade inválida");
        }
        else if(idade < 1){
            this.idade = idade / 12;
        }
        else{
            this.idade = idade;
        }

        // Peso
        if(peso > 60.00 || peso < 0.5){
            throw new IllegalArgumentException("[peso] Peso inválido");
        }
        this.peso = peso;

        // Raca
        if(raca.isEmpty()){
            this.raca = naoInf;
        }
        else if(!raca.matches("[A-Z a-z]+")){
            throw new InputMismatchException("[raca] Raça invalida");
        }
        else{
            this.raca = raca;
        }

        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.dateCreation = dataHora.format(formato);
    }


    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }



    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
