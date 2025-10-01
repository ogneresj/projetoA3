package interfaces;

import javax.swing.*;

// Classe Principal
public class Login {

    // Construtor da Classe (Tudo que está aqui dentro é executado no momento em que a classe "Login" é chamada.)
    public Login() {
        // Caixas de Diálogo
        String user = JOptionPane.showInputDialog(null, "Usuário ou Email ");
        String senha = JOptionPane.showInputDialog(null, "Senha ");

    // boolean admin = (user != null && user.equals("admin") &&  senha != null && senha.equals("admin"));
    // boolean usuario = (user != null && user.equals("diego007@gmail.com") && senha != null && senha.equals("diego007"));

    if (user != null && user.equals("admin") && senha != null && senha.equals("admin")) {
        // Agora com a tela principal com o botão de logout
        new MenuAdmin();
    } else if (user != null && user.equals("diego007") && senha != null && senha.equals("diego007")) {
        // Chama o construtor novamente para tentar fazer login de novo
        new MenuUsuario();
    } else {
        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }
}

