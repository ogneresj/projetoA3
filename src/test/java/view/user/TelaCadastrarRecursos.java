package view.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCadastrarRecursos extends JFrame {


    public TelaCadastrarRecursos () {

        JFrame telaCadastrarRecursos = new JFrame("Cadastro de Recursos");

        JLabel tituloLabel = new JLabel("Titúlo: ");
        JTextField campoTitulo = new JTextField(15);

        JLabel autorLabel = new JLabel("Autor: ");
        JTextField campoAutor = new JTextField(15);

        JLabel categoriaLabel = new JLabel("Categoria: ");
        categoriaLabel.setBounds(120, 150, 300,30);
        String[] categoria = {"IA Responsável", "Cibersegurança", "Privacidade & Ética Digital"};
        JComboBox<String> categoriaList = new JComboBox<>(categoria);
        categoriaList.setBounds(120, 177,200,20);


        JButton botaoCadastrarRecurso = new JButton("Cadastrar Recursos");
        JButton botaoDesconectar = new JButton("Desconectar");

        Container painel = telaCadastrarRecursos.getContentPane();
        painel.setLayout(new GridLayout(5,2,5,5) {
        });
        //painel.add(textTitle);

        painel.add(tituloLabel);
        painel.add(campoTitulo);

        painel.add(autorLabel);
        painel.add(campoAutor);

        painel.add(categoriaLabel);
        painel.add(categoriaList);

        painel.add(botaoCadastrarRecurso);
        painel.add(botaoDesconectar);

        // Execução dos botões e lógica de campos
        botaoCadastrarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){

            }
        });

        botaoDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                telaCadastrarRecursos.dispose();
                JOptionPane.showMessageDialog(null, "Você foi desconectado");
            }
        });

        telaCadastrarRecursos.pack();
        telaCadastrarRecursos.setLocationRelativeTo(null);
        telaCadastrarRecursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCadastrarRecursos.setVisible(true);
    }

}



