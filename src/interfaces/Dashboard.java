package interfaces;


// BOTÃO DE SAIR/DESCONECTAR

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame { // JFrame é a janela principol
    
         public Dashboard() {
        // Configurações básicas da janela
        setTitle("Área do Usuário");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Layout vertical simples

        // Criação Botão("Desconectar")
        JButton logoutButton = new JButton("Desconectar");

        // Adiciona a Lógica de Desconexão
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método que cuida do logout
                handleLogout(); 
            }
        });

        // Adiciona os componentes à Janela
        add(Box.createVerticalStrut(20)); 
        add(logoutButton);
        
        // Exibe a Janela
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    /**
     * O método que executa a ação de Desconectar (Logout).
     */
    private void handleLogout() {
        // O passo mais importante: Fecha a janela atual (o Dashboard)
        this.dispose(); 
        
        // Opcional: Confirma o logout
        JOptionPane.showMessageDialog(null, "Você foi desconectado com sucesso.", "Logout", JOptionPane.INFORMATION_MESSAGE);
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Dashboard(); // Cria e exibe a janela
        });
      }
    }