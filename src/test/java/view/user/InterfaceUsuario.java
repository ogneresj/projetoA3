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

        // Botão para abrir Escolhas
        JButton botaoEscolhas = new JButton("Escolher Categorias");
        botaoEscolhas.setBounds(90,40,180,20);

        JButton botaoCadastrarRecurso = new JButton("Cadastrar Recurso");
        botaoCadastrarRecurso.setBounds(90,70,180,20);

        botaoCadastrarRecurso.addActionListener(e ->
                new TelaCadastrarRecursos());

        botaoEscolhas.addActionListener(e ->
                Escolhas());

        add(botaoCadastrarRecurso);
        add(botaoEscolhas);
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

            if (contador > 1) {
                JCheckBox fonte = (JCheckBox) e.getItem();
                fonte.setSelected(false);
                JOptionPane.showMessageDialog(frameEscolhas,
                        "Você só pode escolher 1 opção",
                        "Limite de escolhas",
                        JOptionPane.WARNING_MESSAGE);
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

            if (escolhas.equals("Você escolheu:\n")) {
                JOptionPane.showMessageDialog(frameEscolhas,
                        "Nenhuma opção escolhida!",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frameEscolhas, escolhas);
            }
        });

        frameEscolhas.add(iaResponsavel);
        frameEscolhas.add(ciberseguranca);
        frameEscolhas.add(privacidade);
        frameEscolhas.add(confirmar);

        frameEscolhas.setLocationRelativeTo(null);
        frameEscolhas.setVisible(true);
    }
}

