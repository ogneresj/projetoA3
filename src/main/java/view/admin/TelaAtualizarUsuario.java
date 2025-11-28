package view.admin;

import model.Usuario;
import service.MenuAdmin;
import view.user.TelaAtualizarRecurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TelaAtualizarUsuario extends JFrame {

    MenuAdmin menuAdmin = new MenuAdmin();
    private Set<String> interessesSelecionados = new HashSet<>();

    public TelaAtualizarUsuario(int id) {
        JFrame telaAtualizarUsuario = new JFrame("Atualizar Usuário");

        JLabel usuarioLabel = new JLabel("Usuário: ");
        JTextField campoUsuario = new JTextField(2);

        JLabel idadeLabel = new JLabel("Idade: ");
        JTextField campoIdade = new JTextField(10);

        JLabel senhaLabel = new JLabel("Senha: ");
        JTextField campoSenha = new JTextField(10);

        JLabel categoriaLabel = new JLabel("Categoria: ");
        JButton botaoCategoria = new JButton("Escolher categoria");

        JButton botaoAtualizarUsuario = new JButton("Atualizar Usuário");
        JButton botaoCancelar = new JButton("Cancelar");

        JLabel textTipo = new JLabel("Tipo de Usuário");
        String[] tipo = {"Admin", "Usuário Comum"};
        JComboBox<String> tipoList = new JComboBox<>(tipo);


        Container painel = telaAtualizarUsuario.getContentPane();
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

        painel.add(botaoAtualizarUsuario);
        painel.add(botaoCancelar);

        Usuario usuarioExistente = null;
        try {
            usuarioExistente = menuAdmin.buscarUsuarioPorId(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar usuário: " + ex.getMessage());
            telaAtualizarUsuario.dispose();
            return;
        }

        campoUsuario.setText(usuarioExistente.getNome());
        campoIdade.setText(String.valueOf(usuarioExistente.getIdade()));
        tipoList.setSelectedItem(usuarioExistente.isAdmin() ? "Admin" : "Usuário Comum");

        if (usuarioExistente.getInteresses() != null) {
            interessesSelecionados = new HashSet<>(usuarioExistente.getInteresses());
        } else {
            interessesSelecionados = new HashSet<>();
        }

        botaoCategoria.addActionListener(e -> {
            String selectedItem = (String) tipoList.getSelectedItem();
            boolean isAdmin = "Admin".equals(selectedItem);

            if(!isAdmin) {
                JanelaInteresses janelaInteresses = new JanelaInteresses(this);
                interessesSelecionados = janelaInteresses.getInteresses();
            } else {
                JOptionPane.showMessageDialog(null, "Como Administrador, a seleção de interesses não é necessária.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                interessesSelecionados.remove(interessesSelecionados);
                interessesSelecionados = new HashSet<>();
            }
                }
        );

        // Execução dos botões e lógica de campos
        botaoAtualizarUsuario.addActionListener(new ActionListener() {
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

                Usuario usuario_updated = new Usuario(usuario, idade, isAdmin, password);

                if(!isAdmin){
                    if(interessesSelecionados != null && !interessesSelecionados.isEmpty()) {
                        usuario_updated.setInteresses(new ArrayList<>(interessesSelecionados));
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário Comum deve selecionar interesses.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    interessesSelecionados.clear();

                    usuario_updated.setInteresses(new ArrayList<>(interessesSelecionados));
                }

                menuAdmin.atualizarUsuario(id, usuario_updated);

                campoUsuario.setText("");
                campoSenha.setText("");
                campoIdade.setText("");
                telaAtualizarUsuario.dispose();
            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAtualizarUsuario.dispose();
            }
        });

        telaAtualizarUsuario.pack();
        telaAtualizarUsuario.setLocationRelativeTo(null);
        telaAtualizarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaAtualizarUsuario.setVisible(true);
    }
}
