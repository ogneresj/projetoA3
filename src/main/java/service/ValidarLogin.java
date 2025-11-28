package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import database.Conexao;
import model.Usuario;
import util.UsuarioLogado.Sessao;
import view.admin.InterfaceAdmin;
import view.user.InterfaceUsuario;


public class ValidarLogin {

    Usuario usuario = new Usuario();

    public void realizarLogin(String nomeUsuario, String senha) {
        String tipoUsuarioLogado = verificandoLogin(nomeUsuario, senha);

        if (tipoUsuarioLogado == null) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
        } else if (tipoUsuarioLogado.equals("true")) {
            JOptionPane.showMessageDialog(null, "Login de Administrador bem-sucedido!");
            new InterfaceAdmin();
        } else if (tipoUsuarioLogado.equals("false")) {
            JOptionPane.showMessageDialog(null, "Login de Usuário bem-sucedido!");
            new InterfaceUsuario();
        }
    }

    public String[] buscarSenha(String nomeUsuario) {
        String sql = "SELECT id, password, tipoUsuario FROM tb_usuarios WHERE nome = ?";

        Conexao conexao = new Conexao();

        try (Connection conn = conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nomeUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new String[]{
                            rs.getString("id"),
                            rs.getString("password"),
                            String.valueOf(rs.getBoolean("tipoUsuario"))
                    };
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String verificandoLogin(String nomeUsuario, String senhaDigitada) {

        String[] credenciais = buscarSenha(nomeUsuario);
        if (credenciais == null) {
            return null;
        }

        String idUsuario = credenciais[0];
        String senhaHashBanco = credenciais[1];
        String tipoUsuario = credenciais[2];

        if (BCrypt.checkpw(senhaDigitada, senhaHashBanco)) {
            Sessao.usuarioLogadoId = Integer.parseInt(idUsuario);
            return tipoUsuario;
        } else {
            return null;

    }
}
}

