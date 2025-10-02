package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JFrame é a janela principol
public class MenuAdmin extends JFrame { 
    
    // Construtor
    public MenuAdmin() {
        // Configurações básicas da janela
        setTitle("Tela do Administrador"); // texto que aparece na barra superior da sua janela
        setSize(400,300); // define tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura o "X" que o usuário clicar, encerra a janela
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Layout vertical simples

        // Criação Botão("Desconectar")
        JButton botaoDesconectar = new JButton("Desconectar");

        // Adiciona a Lógica de Desconexão
        botaoDesconectar.addActionListener(new ActionListener() {
            @Override // Herança
            public void actionPerformed(ActionEvent e) {
                // executa a lógica para "fazer o logout" ou encerrar uma sessão à cada vez que o botão for acionado
                handleLogout();
            }
        });

        // Adiciona o Botão na Janela
        add(Box.createVerticalStrut(20)); 
        add(botaoDesconectar);
        
        // Exibe a Janela
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    
     // O método que executa a ação de Desconectar(Logout).
     private void handleLogout() {
         this.dispose(); //Fecha a janela atual (o Dashboard)
         // Confirma o logout
        JOptionPane.showMessageDialog(null, "Você foi desconectado com sucesso.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}