package view.user;

import model.Recurso;
import service.MenuUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaListarRecursos extends JFrame {

    private MenuUsuario menuUsuario;
    private DefaultListModel<Recurso> listModel;
    private JList<Recurso> listaRecursos;

    public TelaListarRecursos() {
        menuUsuario = new MenuUsuario();

        setTitle("Meus Recursos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        listaRecursos = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listaRecursos);

        JButton btnAtualizar = new JButton("Atualizar Lista");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");

        JPanel botoes = new JPanel();
        botoes.add(btnAtualizar);
        botoes.add(btnEditar);
        botoes.add(btnExcluir);

        add(scroll, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnAtualizar.addActionListener((ActionEvent e) -> atualizarLista());
        btnExcluir.addActionListener((ActionEvent e) -> excluirSelecionado());
        btnEditar.addActionListener((ActionEvent e) -> editarSelecionado());

        atualizarLista();
        setVisible(true);
    }

    private void atualizarLista() {
        listModel.clear();
        List<Recurso> recursos = menuUsuario.listarRecursos();
        for (Recurso r : recursos) listModel.addElement(r);
    }

    private void excluirSelecionado() {
        Recurso selecionado = listaRecursos.getSelectedValue();
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um recurso para excluir.");
            return;
        }
        menuUsuario.removerRecurso(selecionado);
        atualizarLista();
    }

    private void editarSelecionado() {
        Recurso selecionado = listaRecursos.getSelectedValue();
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um recurso para editar.");
            return;
        }

        String novoTitulo = JOptionPane.showInputDialog("Novo título:", selecionado.getTitulo());
        String novoAutor = JOptionPane.showInputDialog("Novo autor:", selecionado.getAutor());
        String novaCategoria = JOptionPane.showInputDialog("Nova categoria:", selecionado.getCategoria());
        String novaUrl = JOptionPane.showInputDialog("Nova URL:", selecionado.getUrl());
        String novasAnotacoes = JOptionPane.showInputDialog("Novas anotações:", selecionado.getAnotacoes());

        menuUsuario.atualizarRecurso(selecionado, novoTitulo, novoAutor, novaCategoria, novaUrl, novasAnotacoes);
        atualizarLista();
    }
}
