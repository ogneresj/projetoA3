package service;

import model.Recurso;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuUsuario {

    private static final List<Recurso> recursos = new ArrayList<>();

    public void cadastrarRecurso(String titulo, String autor, String categoria, String url, String anotacoes) {
        Recurso recurso = new Recurso(titulo, autor, categoria, url, anotacoes);
        recursos.add(recurso);

        System.out.println("Recurso cadastrado com sucesso!");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Categoria: " + categoria);
        System.out.println("URL: " + url);
        System.out.println("Anotações: " + anotacoes);
    }

    public List<Recurso> listarRecursos() {
        return recursos;
    }

    public void removerRecurso(Recurso r) {
        recursos.remove(r);
    }

    public void atualizarRecurso(Recurso r, String titulo, String autor, String categoria, String url, String anotacoes) {
        r.setTitulo(titulo);
        r.setAutor(autor);
        r.setCategoria(categoria);
        r.setUrl(url);
        r.setAnotacoes(anotacoes);
    }

    public void mostrarRecursosNaTela() {
        if (recursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum recurso cadastrado ainda.");
            return;
        }

        StringBuilder lista = new StringBuilder("Recursos cadastrados:\n\n");
        for (Recurso r : recursos) {
            lista.append("Título: ").append(r.getTitulo()).append("\n");
            lista.append("Autor: ").append(r.getAutor()).append("\n");
            lista.append("Categoria: ").append(r.getCategoria()).append("\n");
            lista.append("URL: ").append(r.getUrl()).append("\n");
            lista.append("Anotações: ").append(r.getAnotacoes()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    // Visualização dos recursos em ordem alfabética
    // private void visualizarRecursos() {
        // if (listaRecursos.isEmpty()) {
            // JOptionPane.showMessageDialog(null, "Nenhum recurso cadastrado.");
            // return;
        // }
// 
        // Collections.sort(listaRecursos, Comparator.comparing(Recurso::getTitulo));
// 
        // StringBuilder sb = new StringBuilder("Lista de Recursos:\n\n");
        // for (Recurso r : listaRecursos) {
            // sb.append(r.toString()).append("\n");
        // }
// 
        // JOptionPane.showMessageDialog(null, sb.toString(),
                // "Recursos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    // }
// 
// 
    // public void visualizarRecursos() {
// 
    // }
}