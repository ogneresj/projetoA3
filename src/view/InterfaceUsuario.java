package view;

import service.MenuUsuario;
import util.Menu;

import javax.swing.*;

public class InterfaceUsuario extends Menu {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;

    // Construtor
    public InterfaceUsuario() {
        super("Tela de Usuário");
        MenuUsuario menuUsuario = new MenuUsuario();

        // Botão para abrir Escolhas
        JButton botaoEscolhas = new JButton("Escolher Categorias");
        botaoEscolhas.addActionListener(e ->
                menuUsuario.Escolhas()
        );

        add(Box.createVerticalStrut(20));
        add(Box.createVerticalStrut(10));
        add(botaoEscolhas);
    }

    // Exibe a Janela
    public void exibeJanela() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
