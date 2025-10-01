import javax.swing.SwingUtilities;

import interfaces.MenuAdmin;
import interfaces.LoginAdmin;

public class Main {
    public static void main(String[] args) throws Exception {
        // inicia o fluxo de caixas de diálogo
        new LoginAdmin();
        SwingUtilities.invokeLater(() -> {
            new MenuAdmin(); // Cria e exibe a janela
        });
      }
    }
