package interfaces;

import javax.swing.JOptionPane;

public class Login {

    public Login() {
        String user = JOptionPane.showInputDialog(null, "Usuário ou Email ");
        String senha = JOptionPane.showInputDialog(null, "Senha ");
        // LÓGICA DE VALIDAÇÃO SIMPLES
        // Substitua esta lógica pela sua verificação real (ex: banco de dados)
        boolean loginSucesso = (user != null && user.equals("admin") && senha != null && senha.equals("123")); 
        if (loginSucesso) {
            // Se o login for BEM-SUCEDIDO:
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
            // ABRE a tela principal com o botão de logout
            new Dashboard();
        } else if (user != null || senha != null) {
            // Se o login falhou (e o usuário não apenas cancelou)
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            // Opcional: Chama o construtor novamente para tentar o login de novo
            new Login();
            }   
        }
}
