package view.admin;

import service.MenuAdmin;
import util.LimitText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarUsuario extends JFrame {

    public TelaCriarUsuario() {
        setTitle("Janela de Criação de Usuário");
        setSize(500,400);


        JLabel textTitle = new JLabel("Menu de Criação de Usuário");
        textTitle.setFont(new Font("Arial", Font.BOLD, 16));
        textTitle.setBounds(120, 30, 300,30);

        JLabel textUsuario = new JLabel("Usuário: ");
        textUsuario.setBounds(120,60, 150,30);
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(120, 85, 200,25);
        campoUsuario.setDocument(new LimitText(20));

        JLabel textSenha = new JLabel("Senha: ");
        textSenha.setBounds(120, 105 ,300, 30);
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 130 ,200, 25);

        JLabel textTipo = new JLabel("Tipo de Usuário: ");
        textTipo.setBounds(120, 150, 300,30);
        String[] tipo = {"Admin", "Usuário Comum"};
        JComboBox<String> tipoList = new JComboBox<>(tipo);
        tipoList.setBounds(120, 177,200,20);

        JButton botaoCadastrarUsuario = new JButton("Cadastrar Usuário");
        botaoCadastrarUsuario.setBounds(140, 220, 150, 20);

        JButton botaoDesconectar = new JButton("Desconectar");
        botaoDesconectar.setBounds(80,280,120,20);

        // Execução dos botões e lógica de campos
        botaoCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  MenuAdmin menuAdmin = new MenuAdmin();

                  String usuario = campoUsuario.getText();
                  String password = new String(campoSenha.getPassword());
                  String selectedItem = (String) tipoList.getSelectedItem();

                  boolean resultItem;

                  if("Admin".equals(selectedItem)) {
                      resultItem = true;
                  } else {
                      resultItem = false;
                  }
            }
        });

        botaoDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Você foi desconectado");
            }
        });


        // Adicionando componentes
        add(botaoDesconectar);
        // Titulo da janela
        add(textTitle);
        // Texto e campo de texto para Usuário
        add(campoUsuario);
        add(textUsuario);
        // Texto e campo para senha
        add(textSenha);
        add(campoSenha);
        // Box para escolher entre ADMIN e Usuário Comum
        add(textTipo);
        add(tipoList);
        // Botão de Cadastrar Usuário
        add(botaoCadastrarUsuario);

        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
