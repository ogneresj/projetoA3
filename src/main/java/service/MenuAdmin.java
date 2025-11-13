package service;

import database.Conexao;
import model.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// JFrame é a janela principol
public class MenuAdmin {

    public void cadastrarUsuarios(Usuario usuario) {
        String sql = "INSERT INTO tb_usuarios (nome, idade, tipoUsuario, password) values (?, ?, ?, ?)";

        Conexao conexao = new Conexao();

        try(Connection c = conexao.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setBoolean(3, usuario.isAdmin());
            ps.setString(4, usuario.getSenha());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void editarUsuario() {
        System.out.println("Editando Usuário");
    }

    public void deletarUsuario(int id) {
        String sql = "DELETE FROM tb_usuarios WHERE id = ?";
        Conexao conexao = new Conexao();

        try(Connection c = conexao.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuário com ID " + id + " foi deletado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null,"Nenhum usuário encontrado com ID " + id + ".");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }
}