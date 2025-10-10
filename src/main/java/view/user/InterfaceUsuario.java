package view.user;
import util.Menu;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfaceUsuario extends Menu {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;

    // Construtor
    public InterfaceUsuario() {
        super("Tela de Usuário");

        JButton botaoCadastrarRecurso = new JButton("Cadastrar Recurso");
        botaoCadastrarRecurso.setBounds(90,70,180,20);

        botaoCadastrarRecurso.addActionListener(e ->
                new TelaCadastrarRecursos());

        add(botaoCadastrarRecurso);
    }
}

