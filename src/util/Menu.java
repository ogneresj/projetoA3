package util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    // Construtor
    public Menu(String tituloDaJanela) {

        // Configurações básicas da janela
        setTitle(tituloDaJanela); // texto que aparece na barra superior da sua janela
        setSize(400,300); // define tamanho da janela

        // Criação Botão("Desconectar")
        JButton botaoDesconectar = new JButton("Desconectar");
        botaoDesconectar.setBounds(250,220,120,20);

        // Adiciona a Lógica de Desconexão
        botaoDesconectar.addActionListener(new ActionListener() {
            @Override // Herança
            public void actionPerformed(ActionEvent e) {
                // executa a lógica para "fazer o logout" ou encerrar uma sessão à cada vez que o botão for acionado
                handleLogout();
            }
        });

        // Adiciona o Botão na Janela
        add(botaoDesconectar);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura o "X" que o usuário clicar, encerra a janela
        setLayout(null);
        setVisible(true); // Exibe a janela
    }

    // O metodo que executa a ação de Desconectar(Logout).
    private void handleLogout() {
        this.dispose(); //Fecha a janela atual (o Dashboard)
        // Confirma o logout
        JOptionPane.showMessageDialog(null, "Você foi desconectado com sucesso.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}
