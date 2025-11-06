package service;

import model.Usuario;

import javax.swing.*;
import java.util.Set;

// JFrame é a janela principol
public class MenuAdmin {

    public void cadastrarUsuarios(String usuario, int idade, String senha, boolean tipoUsuario, Set<String> interesses) {
        Usuario usuario1 = new Usuario(usuario, idade, tipoUsuario, interesses);
        System.out.println(usuario1.toString());
    }

    public void editarUsuario() {
        System.out.println("Editando Usuário");
    }

    public void deletarUsuario(int id) {
        System.out.printf("Usuário com id=%d foi deletado com sucesso \n", id);
    }
}