package com;
import controller.PetController;
import dao.PetDao;
import view.View;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        PetDao dao = new PetDao("C:\\projetos\\projects\\sistema_cadastro\\pets.json");
        PetController controller = new PetController(view, dao);
        view.setController(controller);
        view.showView();
    }
}