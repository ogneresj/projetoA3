package service;

import view.admin.InterfaceAdmin;
import view.user.InterfaceUsuario;

import javax.swing.*;

// Classe Principal
public class ValidarLogin {

    public void validar(String usuario, String password) {

        if (usuario != null && usuario.equals("admin") &&  password != null && password.equals("admin")) {
           //verifica se o usuário e senha correspondem ao ADMIN
            new InterfaceAdmin();
        } else if (usuario != null && usuario.equals("usuario") && password != null && password.equals("usuario")) {
            //verifica se o usuário e senha correspondem ao USUÁRIO COMUM
            new InterfaceUsuario();
        } else {
            // Caso nenhuma validação seja verdadeira mostra uma mensagem de erro informando que o login falhou
             JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

