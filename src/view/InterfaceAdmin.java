package view;

import service.MenuAdmin;
import util.Menu;

import javax.swing.*;
import java.awt.*;

public class InterfaceAdmin extends Menu {

    public InterfaceAdmin() {
        super("Tela do administrador");
        MenuAdmin menuAdmin = new MenuAdmin();

        JLabel textGestao = new JLabel("Menu de Gestão de Usuários");
        textGestao.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        textGestao.setBounds(80, 40, 250, 30);

        JLabel textEdit = new JLabel("---------------------------------------------------");
        textEdit.setBounds(90, 50, 250, 30);

        JButton botaoCadastrar = new JButton("Cadastrar Usuários");
        botaoCadastrar.setBounds(100, 80, 180, 20);

        JButton botaoEditarUsuario = new JButton("Editar Usuários");
        botaoEditarUsuario.setBounds(100, 110, 180,20);

        JButton botaoDeletarUsuario = new JButton("Deletar/Desativar Usuário");
        botaoDeletarUsuario.setBounds(100,140,180,20);

        // Adiciona a Lógica de Desconexão
        botaoCadastrar.addActionListener(e ->
                menuAdmin.cadastrarUsuarios());

        botaoEditarUsuario.addActionListener(e ->
                menuAdmin.editarUsuario());

        botaoDeletarUsuario.addActionListener(e ->
                menuAdmin.deletarUsuario()
        );

        // Adicionando componentes na tela de ADMIN
        add(textEdit);
        add(botaoDeletarUsuario);
        add(botaoEditarUsuario);
        add(botaoCadastrar);
        add(textGestao);
    }
}
