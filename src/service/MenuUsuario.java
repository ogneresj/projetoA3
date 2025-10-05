package service;

import util.Menu;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.*;

public class MenuUsuario extends Menu {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;

    // Construtor
    public MenuUsuario() {
        super("Tela de Usuário");

        // Botão para abrir Escolhas
        JButton botaoEscolhas = new JButton("Escolher Categorias");

        botaoEscolhas.addActionListener(e -> Escolhas());

        add(Box.createVerticalStrut(20));
        add(Box.createVerticalStrut(10));
        add(botaoEscolhas);
        }

        // Exibe a Janela
        public void exibeJanela() {
            setLocationRelativeTo(null);
            setVisible(true);
    }

    // Tela de escolhas
    public void Escolhas() {
        JFrame frameEscolhas = new JFrame("Categorias do Usuário");
        frameEscolhas.setSize(300, 200);
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
                JOptionPane.showMessageDialog(frameEscolhas, "Você só pode escolher até 2 opções!", "Limite de escolhas", JOptionPane.WARNING_MESSAGE);
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

    // O metodo que executa a ação de Desconectar(Logout).
    public void handleLogout () {
        this.dispose(); //Fecha a janela atual (o Dashboard)
        // Confirma o logout
        JOptionPane.showMessageDialog(null, "Você foi desconectado com sucesso.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}