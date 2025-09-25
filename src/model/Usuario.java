package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private int idade;
    private boolean admin;
    private List<String> interesses = new ArrayList<>();

    public Usuario(String nome, int idade, boolean admin) {
        this.nome = nome;
        this.idade = idade;
        this.admin = admin;
    }

    public void adicionarInteresses(String interesse) {

        if(admin) {
            System.out.println("O administrador não pode ter interesses.");
            return;
        }

        if(interesses.size() > 2) {
            System.out.println("Erro: Só é permitido até 2 interesses.");
            return;
        }

        if(!interesses.contains(interesse)){
            interesses.add(interesse);
        }

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<String> getInteresses() {
        return new ArrayList<>(interesses);
    }

}

