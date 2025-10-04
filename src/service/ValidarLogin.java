package service;

import javax.swing.*;

// Classe Principal
public class ValidarLogin {

    public void validar(String usuario, String password) {

        // Variáveis para teste
        //boolean admin = (usuario != null && usuario.equals("admin") &&  password != null && password.equals("admin"));
        //boolean usuarioComum = (usuario != null && usuario.equals("usuario") && password != null && password.equals("usuario"));

        if (usuario != null && usuario.equals("admin") &&  password != null && password.equals("admin")) {
            // Agora com a tela principal com o botão de logout
            new MenuAdmin();
        } else if (usuario != null && usuario.equals("usuario") && password != null && password.equals("usuario")) {
            // Chama o construtor novamente para tentar fazer login de novo
            new MenuUsuario();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou password inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

