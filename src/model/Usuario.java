package model;

public class Usuario {

    private String nome;
    private int idade;
    private boolean admin;
    //private List<String> interesses;

    public Usuario(String nome, int idade, boolean admin) {
        this.nome = nome;
        this.idade = idade;
        this.admin = admin;
        //this.interesses = interesses;
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

    //public List<String> getInteresses() {
    //    return interesses;
    //}

    //public void setInteresses(List<String> interesses) {
    //    this.interesses = interesses;
    //}
}

