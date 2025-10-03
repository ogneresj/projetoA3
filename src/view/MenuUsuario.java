package view;

import model.Menu;

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

        // Botão para cadastrar recurso
        JButton botaoCadastro = new JButton("Cadastrar Recurso");
        botaoCadastro.addActionListener(e -> cadastrarRecurso());

        // Botão para visualizar recurso
        JButton botaoVisualizar = new JButton("Visualizar Recursos");
        botaoVisualizar.addActionListener(e -> visualizarRecursos());

        add(Box.createVerticalStrut(20));
        add(botaoEscolhas);
        add(Box.createVerticalStrut(10));
        add(botaoCadastro);
        add(Box.createVerticalStrut(10));
        add(botaoVisualizar);
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

    // Cadastro de recursos
    private void cadastrarRecurso() {
        JTextField campoTitulo = new JTextField(15);
        JTextField campoAutor = new JTextField(15);
        JTextField campoCategoria = new JTextField(15);

        JPanel painel = new JPanel(new GridLayout(3, 2));
        painel.add(new JLabel("Título:"));
        painel.add(campoTitulo);
        painel.add(new JLabel("Autor:"));
        painel.add(campoAutor);
        painel.add(new JLabel("Categoria:"));
        painel.add(campoCategoria);

        int resultado = JOptionPane.showConfirmDialog(null, painel,
                "Cadastro de Recurso", JOptionPane.OK_CANCEL_OPTION);

        if (resultado == JOptionPane.OK_OPTION) {
            String titulo = campoTitulo.getText().trim();
            String autor = campoAutor.getText().trim();
            String categoria = campoCategoria.getText().trim();

            if (!titulo.isEmpty() && !autor.isEmpty() && !categoria.isEmpty()) {
                listaRecursos.add(new Recurso(titulo, autor, categoria));
                JOptionPane.showMessageDialog(null, "Recurso cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Visualização dos recursos em ordem alfabética
    private void visualizarRecursos() {
        if (listaRecursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum recurso cadastrado.");
            return;
        }

        Collections.sort(listaRecursos, Comparator.comparing(Recurso::getTitulo));

        StringBuilder sb = new StringBuilder("Lista de Recursos:\n\n");
        for (Recurso r : listaRecursos) {
            sb.append(r.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(),
                "Recursos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método de logout
    private void handleLogout() {
        this.dispose();
        JOptionPane.showMessageDialog(null,
                "Você foi desconectado com sucesso.",
                "Logout", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new MenuUsuario().exibeJanela();
    }
}