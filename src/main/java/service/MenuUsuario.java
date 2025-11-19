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

    // Método com ordenação por categoria > anotações
    public List<Recurso> listarRecursos() {
        List<Recurso> lista = new ArrayList<>();

        String sql = "SELECT id, titulo, autor, categoria, url, anotacoes FROM tb_recursos";

        Conexao conexao = new Conexao();

        try (Connection c = conexao.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                Recurso r = new Recurso(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("categoria"),
                        rs.getString("url"),
                        rs.getString("anotacoes")
                );
                lista.add(r);
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

       // Ordem composta = Categoria, depois Anotações
            lista.sort(
                    Comparator.comparing(Recurso::getCategoria)
                            .thenComparing(Recurso::getAnotacoes)
            );

            return lista;

    public void atualizarRecurso(Recurso r, String titulo, String autor, String categoria, String url, String anotacoes) {
        r.setTitulo(titulo);
        r.setAutor(autor);
        r.setCategoria(categoria);
        r.setUrl(url);
        r.setAnotacoes(anotacoes);
    }

    // puxar ordenando dá SQL
    public void mostrarRecursosNaTela() {
                List<Recurso> lista = listarRecursos();

                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum recurso cadastrado ainda.");
                    return;
                }

                StringBuilder lista = new StringBuilder("Recursos cadastrados (ordenados):\n\n");

                for (Recurso r : lista) {
                    sb.append("ID: ").append(r.getId()).append("\n");
                    sb.append("Título: ").append(r.getTitulo()).append("\n");
                    sb.append("Autor: ").append(r.getAutor()).append("\n");
                    sb.append("Categoria: ").append(r.getCategoria()).append("\n");
                    sb.append("URL: ").append(r.getUrl()).append("\n");
                    sb.append("Anotações: ").append(r.getAnotacoes()).append("\n\n");
                }

                JOptionPane.showMessageDialog(null, lista.toString());
    }
}