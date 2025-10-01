package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaLogin extends JFrame {

    //   = new ("Tela de Login");

    public TelaLogin(){
        // Tamanho da janela de login e onde ela irá aparecer na tela
        setBounds(600, 400, 350, 250);

        // Campos de texto da janela de login
        // Usuario
        JLabel textUsuario = new JLabel("Usuário: ");
        textUsuario.setBounds(70, 20, 100, 30);

        // Senha
        JLabel textSenha = new JLabel("Senha: ");
        textSenha.setBounds(70, 70, 100,30);


        // Campos de digitalização da janela
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(70, 45, 200, 25);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(70, 95, 200, 25);

        // Botão de Login
        JButton botaoLogin = new JButton("Login");
        botaoLogin.setBounds(95, 130, 150, 30);
        botaoLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String password = new String(campoSenha.getPassword());
                fazerVerificacao(usuario, password);
            }
        });

        // Adicionando os componentes extras
        add(campoSenha);
        add(textUsuario);
        add(textSenha);
        add(campoUsuario);
        add(botaoLogin);

        // Configurações da janela de login
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

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
