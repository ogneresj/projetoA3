import view.admin.InterfaceAdmin;
import view.admin.TelaCriarUsuario;
import view.user.InterfaceUsuario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // inicia o fluxo de caixas de diálogo]
        // invokeLater é o metodo responsável por não travar a aplicação
        SwingUtilities.invokeLater(InterfaceAdmin::new);
      }
    }
