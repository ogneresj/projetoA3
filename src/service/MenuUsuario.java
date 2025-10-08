package service;

import util.Menu;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;


class Recurso {
    private String titulo;
    private String autor;
    private String categoria;

    public Recurso(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return titulo + " | " + autor + " | " + categoria;
    }
}

public class MenuUsuario extends Menu {
    private JCheckBox iaResponsavel, ciberseguranca, privacidade;
    private ArrayList<Recurso> listaRecursos = new ArrayList<>(); // lista para salvar cadastros

    // Construtor
    public MenuUsuario() {
        super("Tela de Usuário");

        // Botão para abrir Escolhas
        JButton botaoEscolhas = new JButton("Escolher Categorias");

        botaoEscolhas.addActionListener(e -> Escolhas());

        add(Box.createVerticalStrut(20));
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
                fonte.setSelected(false);
                JOptionPane.showMessageDialog(frameEscolhas,
                        "Você só pode escolher até 2 opções!",
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

    // O metodo que executa a ação de Desconectar(Logout).
    public void handleLogout () {
        this.dispose(); //Fecha a janela atual (o Dashboard)
        // Confirma o logout
        JOptionPane.showMessageDialog(null, "Você foi desconectado com sucesso.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}