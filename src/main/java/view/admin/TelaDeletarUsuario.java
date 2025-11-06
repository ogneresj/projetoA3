package view.admin;

import service.MenuAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeletarUsuario extends JFrame {

    public TelaDeletarUsuario() {
        JFrame telaDeletarUsuario = new JFrame("Deletar Usuário");

        JLabel idLabel = new JLabel("ID: ");
        JTextField campoID = new JTextField();

        JButton botaoDeletarUsuario = new JButton("Deletar Usuário");

        Container painel = telaDeletarUsuario.getContentPane();
        painel.setLayout(new GridLayout(3,4,10,10));

        painel.add(idLabel);
        painel.add(campoID);
        painel.add(botaoDeletarUsuario);

        botaoDeletarUsuario.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               MenuAdmin menuAdmin = new MenuAdmin();

               int id = Integer.parseInt(campoID.getText());

               menuAdmin.deletarUsuario(id);
            }
        });

        telaDeletarUsuario.pack();
        telaDeletarUsuario.setLocationRelativeTo(null);
        telaDeletarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaDeletarUsuario.setVisible(true);
    }
}
