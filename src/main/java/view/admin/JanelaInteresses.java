package view.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class JanelaInteresses extends JFrame {

    public JanelaInteresses() {
        new JCheckBox();
        JFrame janelaInteresses = new JFrame("Interesses");

        JLabel escolhaLabel = new JLabel("Escolhas os interesses do Usuário: ");
        escolhaLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JButton botaoEscolhas = new JButton("Definir categorias");

        JCheckBox cbIA = new JCheckBox("IA Responsável");
        JCheckBox cbCiberSeguranca = new JCheckBox("Cibersegurança");
        JCheckBox cbPrivacidade = new JCheckBox("Privacidade & Ética Digital");

        Container painel = janelaInteresses.getContentPane();
        painel.setLayout(new GridLayout(5,1,2,2));

        ItemListener limitador = e -> {
            int contador = 0;
            if (cbIA.isSelected()) contador++;
            if (cbCiberSeguranca.isSelected()) contador++;
            if (cbPrivacidade.isSelected()) contador++;

            if (contador > 2){
                JCheckBox fonte = (JCheckBox) e.getItem();
                fonte.setSelected(false);
                JOptionPane.showMessageDialog(janelaInteresses,
                        "Você só pode escolher 2 interesses",
                        "Limite de escolhas",
                        JOptionPane.WARNING_MESSAGE);
            }
        };

        cbIA.addItemListener(limitador);
        cbCiberSeguranca.addItemListener(limitador);
        cbPrivacidade.addItemListener(limitador);

        // Botão (Confirmar)
        List<String> interesses = new ArrayList<String>();
        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(e -> {
            if(cbIA.isSelected()) interesses.add("IA Responsável");
            if(cbCiberSeguranca.isSelected()) interesses.add("Cibersegurança");
            if(cbPrivacidade.isSelected()) interesses.add("Privacidade & Ética Digital");
            dispose();
            System.out.println(interesses);
        });

        // Adicionando componentes
        painel.add(escolhaLabel);
        painel.add(cbIA);
        painel.add(cbCiberSeguranca);
        painel.add(cbPrivacidade);
        painel.add(confirmar);

        janelaInteresses.pack();
        janelaInteresses.setLocationRelativeTo(null);
        janelaInteresses.setVisible(true);
    }
}
