package view.user;
import service.MenuUsuario;
import util.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class InterfaceUsuario extends Menu {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;

    // Construtor
    public InterfaceUsuario() {
        super("Tela de Usuário");
        MenuUsuario menuUsuario = new MenuUsuario();

        JButton botaoCadastrarRecurso = new JButton("Cadastrar Recurso");
        botaoCadastrarRecurso.setBounds(90,70,180,20);

        JButton botaoDeletarRecurso = new JButton("Deletar Recursos");
        botaoDeletarRecurso.setBounds(90,100,180,20);

        botaoCadastrarRecurso.addActionListener(e ->
                new TelaCadastrarRecursos());

        botaoDeletarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID do recurso que deseja deletar: "));
                menuUsuario.removerRecurso(id);
            }
        });

        add(botaoCadastrarRecurso);
        add(botaoDeletarRecurso);
        setVisible(true);
    }
}

