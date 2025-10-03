package interfaces;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.*;

public class MenuUsuario extends JFrame {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;

    // Construtor
    public MenuUsuario() {
        setTitle("Área do Usuário"); 
        setSize(400,300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
        // Configurações básicas da janela
        setTitle("Menu de Usuário"); // texto que aparece na barra superior da sua janela
        setSize(400,300); // define tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura o "X" que o usuário clicar, encerra a janela
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Layout vertical simples

        // Botão "Desconectar"
        JButton botao = new JButton("Desconectar");
        botao.addActionListener(e -> handleLogout());

        // Botão para abrir Escolhas
        JButton botaoEscolhas = new JButton("Escolher Categorias");
        botaoEscolhas.addActionListener(e -> Escolhas());
        // Adiciona a Lógica de Desconexão
        botao.addActionListener(new ActionListener() {
            @Override // Sobrescrevendo o metodo
            public void actionPerformed(ActionEvent e) {
                // executa a lógica para "fazer o logout" ou encerrar uma sessão à cada vez que o botão for acionado
                handleLogout(); 
            }
        });

        add(Box.createVerticalStrut(20)); 
        add(botao);
        add(Box.createVerticalStrut(10));
        add(botaoEscolhas);

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    // Tela de escolhas
    public void Escolhas () {
        JFrame frameEscolhas = new JFrame("Categorias do Usuário");
        frameEscolhas.setSize(300,200);
        frameEscolhas.setLayout(new FlowLayout());

        // Opções
        iaResponsavel = new JCheckBox("IA Responsável");
        ciberseguranca = new JCheckBox("Cibersegurança");
        privacidade = new JCheckBox("Privacidade & Ética Digital");

        // Listener que limita em tempo real
        ItemListener limitador = e -> {
            int contador = 0;
            if (iaResponsavel.isSelected()) contador++;
            if (ciberseguranca.isSelected()) contador++;
            if (privacidade.isSelected()) contador++;

            if (contador > 2) {
                JCheckBox fonte = (JCheckBox) e.getItem();
                fonte.setSelected(false); // desfaz a seleção
                JOptionPane.showMessageDialog(frameEscolhas, "Você só pode escolher até 2 opções!","Limite de escolhas",JOptionPane.WARNING_MESSAGE);
            }
        };

        iaResponsavel.addItemListener(limitador);
        ciberseguranca.addItemListener(limitador);
        privacidade.addItemListener(limitador);

        // Botão (Confirmar)
        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(e -> {
            String escolhas = "Você escolheu:\n";

            if (iaResponsavel.isSelected()) escolhas += "- IA Responsável\n";
            if (ciberseguranca.isSelected()) escolhas += "- Cibersegurança\n";
            if (privacidade.isSelected()) escolhas += "- Privacidade & Ética Digital\n";

            JOptionPane.showMessageDialog(frameEscolhas, escolhas);
        });

        // Adicionando os componentes na tela
        frameEscolhas.add(iaResponsavel);
        frameEscolhas.add(ciberseguranca);
        frameEscolhas.add(privacidade);
        frameEscolhas.add(confirmar);

        frameEscolhas.setLocationRelativeTo(null);
        frameEscolhas.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuUsuario();
    }

    
    
     // O metodo que executa a ação de Desconectar(Logout).
     private void handleLogout() {
         this.dispose(); //Fecha a janela atual (o Dashboard)
         // Confirma o logout
        JOptionPane.showMessageDialog(null, "Você foi desconectado com sucesso.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}


