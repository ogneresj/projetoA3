package view;

import service.ValidarLogin;
import util.LimitText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceLogin extends JFrame {

    public InterfaceLogin(){
        setTitle("Tela de login");
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
        // Usuário
        JTextField campoUsuario = new JTextField();
        campoUsuario.setDocument(new LimitText(20));
        campoUsuario.setBounds(70, 45, 200, 25);

        // Senha
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setDocument(new LimitText(20));
        campoSenha.setBounds(70, 95, 200, 25);

        // Botão de Login
        JButton botaoLogin = new JButton("Login");
        botaoLogin.setBounds(95, 130, 150, 30);
        botaoLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega o texto digitado em usuário a armazeno na variavel user.
                String user = campoUsuario.getText();
                // Pega a senha digitada em usuário e armazeno na variavel password
                String password = new String(campoSenha.getPassword());

                // A classe ValidarLogin e instanciada para fazer a verificação do login
                ValidarLogin validarLogin = new ValidarLogin();
                // Utilizando o metodo validar para testar o login e redirecionar ou para o menuAdmin() ou para menuUsuario()
                validarLogin.validar(user, password);
            }
        });

        // Adicionando os componentes a tela de login
        add(campoSenha);
        add(textUsuario);
        add(textSenha);
        add(campoUsuario);
        add(botaoLogin);

        // Configurações da janela de login
        setResizable(false); // Este metodo não deixa redimensionar a janela
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Assim que clicar no "X" para fechar a janela, ele para a aplicação
        setVisible(true); // Torna a janela visivel
    }
}
