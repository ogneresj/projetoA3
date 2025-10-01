package interfaces;

import javax.swing.*;

// Classe Principal
public class Verificacao {

    public void fazerVerificacao(String usuario, String password) {

    // boolean admin = (usuario != null && usuario.equals("admin") &&  password != null && password.equals("admin"));
    // boolean usuario = (usuario != null && usuario.equals("diego007@gmail.com") && password != null && password.equals("diego007"));

    if (usuario != null && usuario.equals("admin") && password != null && password.equals("admin")) {
        // Agora com a tela principal com o botão de logout
        new MenuAdmin();
    } else if (usuario != null && usuario.equals("diego007") && password != null && password.equals("diego007")) {
        // Chama o construtor novamente para tentar fazer login de novo
        new MenuUsuario();
    } else {
        JOptionPane.showMessageDialog(null, "Usuário ou password inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }
}

