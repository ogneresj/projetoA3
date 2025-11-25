import javax.swing.SwingUtilities;

import view.InterfaceLogin;

public class Main {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(InterfaceLogin::new);
      }
    }
