import javax.swing.SwingUtilities;

import interfaces.Dashboard;
import interfaces.Login;

public class Main {
    public static void main(String[] args) throws Exception {
        // inicia o fluxo de caixas de diálogo
        new Login();
        SwingUtilities.invokeLater(() -> {
            new Dashboard(); // Cria e exibe a janela
        });
      }
    }
