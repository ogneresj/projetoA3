package model;

import java.util.ArrayList;

public class Usuario {

    private String nome;
    private int idade;
    private boolean admin;

    public Usuario(String nome, int idade, boolean admin) {
        this.nome = nome;
        this.idade = idade;
        this.admin = admin;
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
}

