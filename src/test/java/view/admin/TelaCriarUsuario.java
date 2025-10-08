package view.admin;

import service.MenuAdmin;
import util.LimitText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarUsuario extends JFrame {

    public TelaCriarUsuario() {
        JFrame telaCriarUsuario = new JFrame("Criação de usuários");

        JLabel usuarioLabel = new JLabel("Usuário: ");
        JTextField campoUsuario = new JTextField(10);

        JLabel idadeLabel = new JLabel("Idade: ");
        JTextField campoIdade = new JTextField(10);

        JLabel senhaLabel = new JLabel("Senha: ");
        JTextField campoSenha = new JTextField(10);

        JButton botaoCadastrarUsuario = new JButton("Cadastrar Usuário");
        JButton botaoDesconectar = new JButton("Desconectar");

        JLabel textTipo = new JLabel("Tipo de Usuário");
        String[] tipo = {"Admin", "Usuário Comum"};
        JComboBox<String> tipoList = new JComboBox<>(tipo);


        Container painel = telaCriarUsuario.getContentPane();
        painel.setLayout(new GridLayout(5,2,5,5));
        //painel.add(textTitle);

        painel.add(usuarioLabel);
        painel.add(campoUsuario);

        painel.add(senhaLabel);
        painel.add(campoSenha);

        painel.add(idadeLabel);
        painel.add(campoIdade);

        painel.add(textTipo);
        painel.add(tipoList);

        painel.add(botaoCadastrarUsuario);
        painel.add(botaoDesconectar);

        // Execução dos botões e lógica de campos
        botaoCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAdmin menuAdmin = new MenuAdmin();

                String usuario = campoUsuario.getText();
                int idade = Integer.parseInt(campoIdade.getText());
                String password = new String(campoSenha.getText());
                String selectedItem = (String) tipoList.getSelectedItem();

                boolean isAdmin;

                if("Admin".equals(selectedItem)) {
                    isAdmin = true;
                } else {
                    isAdmin = false;
                }

                menuAdmin.cadastrarUsuarios(usuario, idade , password, isAdmin);
            }
        });

        botaoDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCriarUsuario.dispose();
                JOptionPane.showMessageDialog(null, "Você foi desconectado");
            }
        });

        telaCriarUsuario.pack();
        telaCriarUsuario.setLocationRelativeTo(null);
        telaCriarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCriarUsuario.setVisible(true);
    }
}
