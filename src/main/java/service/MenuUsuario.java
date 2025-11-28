package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.Conexao;
import model.Recurso;
import util.UsuarioLogado;

public class MenuUsuario {

    Conexao conexao = new Conexao();

    public void cadastrarRecurso(Recurso recurso) {

        String sql = "INSERT INTO tb_recursos (titulo, autor, categoria, url, anotacoes, usuario_id) values (?, ?, ?, ?, ?, ?)";

        try(Connection c = conexao.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, recurso.getTitulo());
            ps.setString(2, recurso.getAutor());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getUrl());
            ps.setString(5, recurso.getAnotacoes());

            ps.setInt(6, UsuarioLogado.Sessao.usuarioLogadoId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerRecurso (int id){
            String sql = "DELETE FROM tb_recursos WHERE id = ?";
            try (Connection c = conexao.obtemConexao();
                 PreparedStatement ps = c.prepareStatement(sql)) {

                ps.setInt(1, id);
                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Recurso com ID " + id + " foi deletado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Recurso encontrado com ID " + id + ".");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao deletar Recurso: " + e.getMessage());
            }
        }
        // Ordem composta = Categoria, depois Anotaçõeslista.sort(

    public void atualizarRecurso (int id, Recurso recurso) {

        String sql = "UPDATE tb_recursos SET titulo = ?, autor = ?, categoria = ?, url = ?, anotacoes = ? WHERE id = ?";

        try(Connection conn = conexao.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, recurso.getTitulo());
            ps.setString(2, recurso.getAutor());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getUrl());
            ps.setString(5, recurso.getAnotacoes());
            ps.setInt(6, id);
            ps.executeUpdate();

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Recurso com ID " + id + " foi atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum Recurso encontrado com ID " + id + ".");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método com ordenação por categoria > anotações
    public List<Recurso> listarRecursos() {

        List<Recurso> lista = new ArrayList<>();

        String sql = "SELECT id, titulo, autor, categoria, url, anotacoes, usuario_id "
                + "FROM tb_recursos ORDER BY categoria ASC, titulo ASC";

        try(Connection conn = conexao.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Recurso recurso = new Recurso();
                    recurso.setId(String.valueOf(rs.getInt("id")));
                    recurso.setTitulo(rs.getString("titulo"));
                    recurso.setAutor(rs.getString("autor"));
                    recurso.setCategoria(rs.getString("categoria"));
                    recurso.setUrl(rs.getString("url"));
                    recurso.setAnotacoes(rs.getString("anotacoes"));

                    recurso.setUsuarioID(rs.getInt("usuario_id"));

                    lista.add(recurso);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Recurso buscarRecursoPorId(int id) throws SQLException {
        String sql = "SELECT id, titulo, autor, categoria, url, anotacoes, usuario_id FROM tb_recursos WHERE id = ?";

        try (Connection conn = conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Recurso r = new Recurso();
                    // Se sua coluna id for numérica, converta para String conforme o modelo
                    r.setId(rs.getString("id"));
                    r.setTitulo(rs.getString("titulo"));
                    r.setAutor(rs.getString("autor"));
                    r.setCategoria(rs.getString("categoria"));
                    r.setUrl(rs.getString("url"));
                    r.setAnotacoes(rs.getString("anotacoes"));
                    r.setUsuarioID(rs.getInt("usuario_id"));
                    return r;
                } else {
                    return null;
                }
            }
        }
    }

}

