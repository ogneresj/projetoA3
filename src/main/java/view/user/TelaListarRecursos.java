package view.user;

import model.Recurso;
import service.MenuUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class TelaListarRecursos extends JFrame {

    private DefaultListModel<Recurso> listModel;
    private JList<Recurso> listaRecursos;
    MenuUsuario menuUsuario = new MenuUsuario();

    public TelaListarRecursos() {

        setTitle("Lista de recursos");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        List<Recurso> recursos = menuUsuario.listarRecursos();

        String[] colunas = {
                "ID", "Título", "Autor", "Categoria", "URL", "Anotações"
        };

        Object[][] dados = new Object[recursos.size()][6];

        for (int i = 0; i < recursos.size(); i++) {
            Recurso r = recursos.get(i);
            dados[i][0] = r.getId();
            dados[i][1] = r.getTitulo();
            dados[i][2] = r.getAutor();
            dados[i][3] = r.getCategoria();
            dados[i][4] = r.getUrl();
            dados[i][5] = r.getAnotacoes();
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll, BorderLayout.CENTER);

        JButton botaoVoltar = new JButton("Voltar");

        botaoVoltar.addActionListener(e ->
                dispose()
        );

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoVoltar);


        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void atualizarLista(){
        listModel.clear();
        List<Recurso> recursos = menuUsuario.listarRecursos();
        for (Recurso r : recursos) listModel.addElement(r);
    }
}
