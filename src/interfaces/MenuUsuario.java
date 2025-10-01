package interfaces;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUsuario extends JFrame {

    // Construtor
    public MenuUsuario() {
        // Configurações básicas da janela
        setTitle("Área do Usuário"); // texto que aparece na barra superior da sua janela
        setSize(400,300); // define tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura o "X" que o usuário clicar, encerra a janela
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Layout vertical simples

        // Criação Botão("Desconectar")
        JButton botao = new JButton("Desconectar");

        // Adiciona a Lógica de Desconexão
        botao.addActionListener(new ActionListener() {
            @Override // Herança
            public void actionPerformed(ActionEvent e) {
                // executa a lógica para "fazer o logout" ou encerrar uma sessão à cada vez que o botão for acionado
                handleLogout(); 
            }
        });

        // Adiciona o Botão na Janela
        add(Box.createVerticalStrut(20)); 
        add(botao);
        
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

