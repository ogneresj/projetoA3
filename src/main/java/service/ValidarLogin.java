package service;

import database.Conexao;
import view.admin.InterfaceAdmin;
import view.user.InterfaceUsuario;
import org.mindrot.jbcrypt.BCrypt;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ValidarLogin {

//    public void validar(String usuario, String password) {
//
//        if (usuario != null && usuario.equals("admin") &&  password != null && password.equals("admin")) {
//           //verifica se o usuário e senha correspondem ao ADMIN
//            new InterfaceAdmin();
//        } else if (usuario != null && usuario.equals("usuario") && password != null && password.equals("usuario")) {
//            //verifica se o usuário e senha correspondem ao USUÁRIO COMUM
//            new InterfaceUsuario();
//        } else {
//            // Caso nenhuma validação seja verdadeira mostra uma mensagem de erro informando que o login falhou
//             JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }



    public String[] buscarSenha(String nomeUsuario) {
        String sql = "SELECT password, tipoUsuario FROM tb_usuarios WHERE nome = ?";

        Conexao conexao = new Conexao();

        try (Connection conn = conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nomeUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new String[]{
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


    public boolean verificandoLogin(String nomeUsuario, String senhaDigitada) {

        String[] credenciais = buscarSenha(nomeUsuario);
        if (credenciais == null) {
            return false;
        }

        String senhaHashBanco = credenciais[0];

        return BCrypt.checkpw(senhaDigitada, senhaHashBanco);

    }
}

