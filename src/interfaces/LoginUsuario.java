package interfaces;

import javax.swing.JOptionPane;

public class LoginUsuario {

// Construtor da Classe (Tudo que está aqui dentro é executado no momento em que a classe "Login" é chamada.)
    public LoginUsuario() {
        // Caixas de Diálogo
        String user = JOptionPane.showInputDialog(null, "Usuário ou Email ");
        String senha = JOptionPane.showInputDialog(null, "Senha ");
        
        
        // Validação - Se for && Se não fot
        boolean loginSucesso = (user != null && user.equals("diego007@gmail.com")    &&      senha != null && senha.equals("diego007")); 
        if (loginSucesso) {
            // Se o login for True:
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Bem-Vindo", JOptionPane.INFORMATION_MESSAGE);
            // Agora com a tela principal com o botão de logout
            new MenuAdmin();
        } else if (user != null || senha != null) {
            // Se o login falhou (e o usuário não apenas cancelou)
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            // Chama o construtor novamente para tentar fazer login de novo
            new LoginUsuario();
            }   
        }
}

    
