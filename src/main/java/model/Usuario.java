package model;

import java.util.Set;

public class Usuario {

    private String nome;
    private int idade;
    private boolean admin;
    private Set<String> interesses;

    public Usuario(String nome, int idade, boolean admin, Set<String> interesses) {
        this.nome = nome;
        this.idade = idade;
        this.admin = admin;
        this.interesses = interesses;
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

    public Set<String> getInteresses() {
        return interesses;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", admin=" + admin +
                ", interesses=" + interesses +
                '}';
    }
}

