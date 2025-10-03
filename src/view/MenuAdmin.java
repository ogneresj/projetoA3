package view;

import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JFrame é a janela principol
public class MenuAdmin extends Menu {

    public MenuAdmin() {
        super("Tela do administrador");

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(70, 20, 100, 30);
        add(Box.createVerticalStrut(20));
        add(Box.createVerticalStrut(10));

        // Adiciona a Lógica de Desconexão
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override // Herança
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuarios();
            }
        });

        add(botaoCadastrar);
    }

    // Exibe a Janela
    public void exibeJanela() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void cadastrarUsuarios() {
        System.out.println("Cadastro feito com sucesso");
    }
}