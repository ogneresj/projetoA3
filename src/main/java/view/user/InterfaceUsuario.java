package view.user;
import service.MenuUsuario;
import util.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfaceUsuario extends Menu {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;

    // Construtor
    public InterfaceUsuario() {
        super("Tela de Usuário");
        MenuUsuario menuUsuario = new MenuUsuario();

        JLabel textMenuUsuario = new JLabel("Menu de Usuário");
        textMenuUsuario.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        textMenuUsuario.setBounds(120, 20, 250,30);

        JLabel textEdit = new JLabel("---------------------------------------------------");
        textEdit.setBounds(90, 35, 250, 30);

        JButton botaoCadastrarRecurso = new JButton("Cadastrar Recurso");
        botaoCadastrarRecurso.setBounds(100, 65, 180,20);

        JButton botaoEditarRecurso = new JButton("Editar Recurso");
        botaoEditarRecurso.setBounds(100, 95, 180, 20);

        JButton botaoExibirRecurso = new JButton("Exibir todos recursos");
        botaoExibirRecurso.setBounds(100, 125, 180, 20);

        JButton botaoDeletarRecurso = new JButton("Deletar Recursos");
        botaoDeletarRecurso.setBounds(100,155,180,20);


        botaoCadastrarRecurso.addActionListener(e ->
                new TelaCadastrarRecursos());

        botaoEditarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Qual ID do recurso que deseja atualizar: "));
                new TelaAtualizarRecurso(id);
            }
        });

        botaoExibirRecurso.addActionListener(e ->
                new TelaListarRecursos().setVisible(true));

        botaoDeletarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID do recurso que deseja deletar: "));
                menuUsuario.removerRecurso(id);
            }
        });

        add(botaoEditarRecurso);
        add(botaoExibirRecurso);
        add(botaoCadastrarRecurso);
        add(botaoDeletarRecurso);
        add(textMenuUsuario);
        add(textEdit);
        setVisible(true);
    }
}

