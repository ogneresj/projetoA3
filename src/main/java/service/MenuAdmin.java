package service;

import database.Conexao;
import model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        Conexao conexao = new Conexao();

        String senhaOriginal = usuario.getSenha();
        String senhaHash = BCrypt.hashpw(senhaOriginal, BCrypt.gensalt());

        String interesseString = null;

        if (!usuario.isAdmin()) {
            if (usuario.getInteresses() != null && !usuario.getInteresses().isEmpty()) {
                interesseString = String.join(", ", usuario.getInteresses());
            } else {
                JOptionPane.showMessageDialog(null, "Você precisa selecionar os interesses.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String sql = "UPDATE tb_usuarios SET nome = ?, idade = ?, tipoUsuario = ?, password = ?, interesses = ? WHERE id = ?";

        try (Connection conn = conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setBoolean(3, usuario.isAdmin());
            ps.setString(4, senhaHash);

            if (interesseString == null) {
                ps.setNull(5, java.sql.Types.VARCHAR);
            } else {
                ps.setString(5, interesseString);
            }

            ps.setInt(6, id);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Usuário: " + e.getMessage());
            e.printStackTrace();
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

    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, idade, tipoUsuario, password, interesses FROM tb_usuarios WHERE id = ?";

        try (Connection conn = new Conexao().obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String usuario = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    boolean isAdmin = rs.getBoolean("tipoUsuario");
                    String senha = rs.getString("password");
                    String interessesStr = rs.getString("interesses");

                    Usuario u = new Usuario(usuario, idade, isAdmin, senha);

                    if (interessesStr != null && !interessesStr.isEmpty()) {
                        String[] parts = interessesStr.split(",");
                        List<String> interesses = new ArrayList<>(Arrays.asList(parts));
                        u.setInteresses(interesses);
                    }

                    return u;
                } else {
                    return null;
                }
            }
        }
    }
}