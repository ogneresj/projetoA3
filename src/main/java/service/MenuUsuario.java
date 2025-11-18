package service;

import database.Conexao;
import model.Recurso;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuUsuario {

    private static final List<Recurso> recursos = new ArrayList<>();

    public void cadastrarRecurso(Recurso recurso) {

        // System.out.println("Recurso cadastrado com sucesso!");
        // System.out.println("Título: " + recurso.getTitulo());
        // System.out.println("Autor: " + recurso.getAutor());
        // System.out.println("Categoria: " + recurso.getCategoria());
        // System.out.println("URL: " + recurso.getUrl());
        // System.out.println("Anotações: " + recurso.getAnotacoes());

        String sql = "INSERT INTO tb_recursos (titulo, autor, categoria, url, anotacoes) values (?, ?, ?, ?, ?)";

        Conexao conexao = new Conexao();

        try(Connection c = conexao.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, recurso.getTitulo());
            ps.setString(2, recurso.getAutor());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getUrl());
            ps.setString(5, recurso.getAnotacoes());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recurso> listarRecursos() {
        return recursos;
    }

    public void removerRecurso(int id) {
        String sql = "DELETE FROM tb_recursos WHERE id = ?";
        Conexao conexao = new Conexao();

        try(Connection c = conexao.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Recurso com ID " + id + " foi deletado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null,"Nenhum Recurso encontrado com ID " + id + ".");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Recurso: " + e.getMessage());
        }
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