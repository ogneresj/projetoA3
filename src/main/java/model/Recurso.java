package model;

public class Recurso {
    private String id;
    private String titulo;
    private String autor;
    private String categoria;
    private String url;
    private String anotacoes;

    public Recurso(String titulo, String autor, String categoria, String url, String anotacoes) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.url = url;
        this.anotacoes = anotacoes;
    }

    public Recurso() {};

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getAnotacoes() { return anotacoes; }
    public void setAnotacoes(String anotacoes) { this.anotacoes = anotacoes; }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + categoria + ")";
    }
}