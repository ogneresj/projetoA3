package service;

import database.Conexao;
import model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// JFrame é a janela principol
public class MenuAdmin {

    public void cadastrarUsuarios(Usuario usuario) {

        Conexao conexao = new Conexao();
        String senhaOriginal = usuario.getSenha();
        String senhaHash = BCrypt.hashpw(senhaOriginal, BCrypt.gensalt());

        String interesseString;
        if(!usuario.isAdmin()) {
            if (usuario.getInteresses() != null && !usuario.getInteresses().isEmpty()) {
                interesseString = String.join(", ", usuario.getInteresses());
                String sql = "INSERT INTO tb_usuarios (nome, idade, tipoUsuario, password, interesses) values (?, ?, ?, ?, ?)";
                try (Connection conn = conexao.obtemConexao();
                     PreparedStatement ps = conn.prepareStatement(sql)) {

                    ps.setString(1, usuario.getNome());
                    ps.setInt(2, usuario.getIdade());
                    ps.setBoolean(3, usuario.isAdmin());
                    ps.setString(4, senhaHash);

                    ps.setString(5, interesseString);
                    ps.execute();

                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você precisa selecionar os interesses: ");
            }
        } else {
            interesseString = "";
            String sql = "INSERT INTO tb_usuarios (nome, idade, tipoUsuario, password) values (?, ?, ?, ?)";
            try (Connection conn = conexao.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, usuario.getNome());
                ps.setInt(2, usuario.getIdade());
                ps.setBoolean(3, usuario.isAdmin());
                ps.setString(4, senhaHash);
                ps.execute();

                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void atualizarUsuario(int id, Usuario usuario) {

        String interesseString;
        if (usuario.getInteresses() != null && !usuario.getInteresses().isEmpty()){
            interesseString = String.join(", ", usuario.getInteresses());
        } else {
            interesseString = "";
        }

        String sql = "UPDATE tb_usuarios SET nome = ?, idade = ?, tipoUsuario = ?, password = ?, interesses = ? WHERE id = ?";

        Conexao conexao = new Conexao();
        try (Connection conn = conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String senhaOriginal = usuario.getSenha();
            String senhaHash = BCrypt.hashpw(senhaOriginal, BCrypt.gensalt());

            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setBoolean(3, usuario.isAdmin());
            ps.setString(4, senhaHash);

            ps.setString(5, interesseString);
            ps.setInt(6, id);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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