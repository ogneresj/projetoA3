package view.user;

import model.Recurso;
import service.MenuUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCadastrarRecursos extends JFrame {


    public TelaCadastrarRecursos () {

        setTitle("Cadastro de Recursos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);

        // Painel principal com GridBagLayout
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel tituloLabel = new JLabel("Título: ");
        JTextField campoTitulo = new JTextField(20);

        JLabel autorLabel = new JLabel("Autor: ");
        JTextField campoAutor = new JTextField(20);

        JLabel categoriaLabel = new JLabel("Categoria: ");
        String[] categoria = {"IA Responsável", "Cibersegurança", "Privacidade & Ética Digital"};
        JComboBox<String> categoriaList = new JComboBox<>(categoria);

        JLabel urlLabel = new JLabel ("URL (OPCIONAL): ");
        JTextField campoURL = new JTextField (20);

        JLabel anotacoesLabel = new JLabel ("Anotações: ");
        JTextArea campoAnotacoes = new JTextArea (5,20);
        campoAnotacoes.setLineWrap(true);
        campoAnotacoes.setWrapStyleWord(true);
        JScrollPane scrollAnotacoes = new JScrollPane (campoAnotacoes);

        JButton botaoCadastrarRecurso = new JButton("Cadastrar Recursos");
        JButton botaoDesconectar = new JButton("Desconectar");
        JButton botaoVerRecursos = new JButton("Ver Recursos");

        // Titulo
        gbc.gridx = 0; gbc.gridy = 0;
        painel.add(tituloLabel, gbc);
        gbc.gridx = 1;
        painel.add(campoTitulo, gbc);

        // Autor
        gbc.gridx = 0; gbc.gridy = 1;
        painel.add(autorLabel, gbc);
        gbc.gridx = 1;
        painel.add(campoAutor, gbc);

        // Categorias
        gbc.gridx = 0; gbc.gridy = 2;
        painel.add(categoriaLabel, gbc);
        gbc.gridx = 1;
        painel.add(categoriaList, gbc);

        // URL
        gbc.gridx = 0; gbc.gridy = 3;
        painel.add(urlLabel, gbc);
        gbc.gridx = 1;
        painel.add(campoURL, gbc);

        // ANOTAÇÕES
        gbc.gridx = 0; gbc.gridy = 4;
        painel.add(anotacoesLabel, gbc);
        gbc.gridx = 1;
        painel.add(scrollAnotacoes, gbc);

        // Botão Desconectar
        JPanel botoes = new JPanel();
        botoes.add(botaoCadastrarRecurso);
        botoes.add(botaoDesconectar);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        painel.add(botoes, gbc);

        add(painel);

        // Execução dos botões e lógica de campos
        botaoCadastrarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String categoriaSelecionada = (String) categoriaList.getSelectedItem();
                String url = campoURL.getText();
                String anotacoes = campoAnotacoes.getText();

                if (titulo.isEmpty() || autor.isEmpty() || anotacoes.isEmpty()) {
                    JOptionPane.showMessageDialog (null,"Preencha todos os campos obrigatórios (Título, Autor, Anotações).");
                    return;
                }

                Recurso recurso = new Recurso(titulo, autor, categoriaSelecionada, url, anotacoes);

                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.cadastrarRecurso(recurso);

                campoTitulo.setText("");
                campoAutor.setText("");
                campoURL.setText("");
                campoAnotacoes.setText("");
                categoriaList.setSelectedIndex(0);
            }
        });

        botaoDesconectar.addActionListener(e -> {
                dispose();
                JOptionPane.showMessageDialog(null, "Você foi desconectado");
        });

        // Botão para ver os recursos do User
        botoes.add(botaoVerRecursos);
        botaoVerRecursos.addActionListener(e -> new view.user.TelaListarRecursos());

        pack();
        setVisible(true);
    }

}



