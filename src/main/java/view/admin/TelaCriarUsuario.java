package view.admin;

import model.Usuario;
import service.MenuAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TelaCriarUsuario extends JFrame {

    private Set<String> interessesSelecionados = new HashSet<>();

    public TelaCriarUsuario() {
        JFrame telaCriarUsuario = new JFrame("Criação de usuários");

        JLabel usuarioLabel = new JLabel("Usuário: ");
        JTextField campoUsuario = new JTextField(2);

        JLabel idadeLabel = new JLabel("Idade: ");
        JTextField campoIdade = new JTextField(10);

        JLabel senhaLabel = new JLabel("Senha: ");
        JTextField campoSenha = new JTextField(10);

        JLabel categoriaLabel = new JLabel("Categoria: ");
        JButton botaoCategoria = new JButton("Escolher categoria");

        JButton botaoCadastrarUsuario = new JButton("Cadastrar Usuário");
        JButton botaoVoltar = new JButton("Voltar");

        JLabel textTipo = new JLabel("Tipo de Usuário");
        String[] tipo = {"Admin", "Usuário Comum"};
        JComboBox<String> tipoList = new JComboBox<>(tipo);


        Container painel = telaCriarUsuario.getContentPane();
        painel.setLayout(new GridLayout(6,2,2,10));

        painel.add(usuarioLabel);
        painel.add(campoUsuario);

        painel.add(senhaLabel);
        painel.add(campoSenha);

        painel.add(idadeLabel);
        painel.add(campoIdade);

        painel.add(textTipo);
        painel.add(tipoList);

        painel.add(categoriaLabel);
        painel.add(botaoCategoria);

        painel.add(botaoCadastrarUsuario);
        painel.add(botaoVoltar);

        botaoCategoria.addActionListener(e -> {
            String selectedItem = (String) tipoList.getSelectedItem();
            boolean isAdmin = "Admin".equals(selectedItem);

            if(!isAdmin) {
                JanelaInteresses janelaInteresses = new JanelaInteresses(this);
                interessesSelecionados = janelaInteresses.getInteresses();
            } else {
                JOptionPane.showMessageDialog(null, "Como Administrador, a seleção de interesses não é necessária.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                interessesSelecionados = new HashSet<>();
            }

                }
        );

        // Execução dos botões e lógica de campos
        botaoCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAdmin menuAdmin = new MenuAdmin();

                String usuario = campoUsuario.getText();
                int idade = Integer.parseInt(campoIdade.getText());
                String password = new String(campoSenha.getText());
                String selectedItem = (String) tipoList.getSelectedItem();

                boolean isAdmin;

                if("Admin".equals(selectedItem)) {
                    isAdmin = true;
                } else {
                    isAdmin = false;
                }

                Usuario usuario_create = new Usuario(usuario, idade, isAdmin, password);
                usuario_create.setInteresses(new ArrayList<>(interessesSelecionados));

                if(!isAdmin) {
                    if (interessesSelecionados != null && !interessesSelecionados.isEmpty()) {
                        usuario_create.setInteresses(new ArrayList<>(interessesSelecionados));
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário Comum deve selecionar interesses.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    usuario_create.setInteresses(new ArrayList<>());
                }

                menuAdmin.cadastrarUsuarios(usuario_create);

                campoUsuario.setText("");
                campoSenha.setText("");
                campoIdade.setText("");
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCriarUsuario.dispose();
            }
        });

        telaCriarUsuario.pack();
        telaCriarUsuario.setLocationRelativeTo(null);
        telaCriarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaCriarUsuario.setVisible(true);
    }
}
