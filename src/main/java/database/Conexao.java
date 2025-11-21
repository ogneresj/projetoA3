package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    String url = "jdbc:mysql://localhost:3306/db_projeto?useSSL=false&serverTimezone=America/Sao_Paulo";
    String user = "admin";
    String password = "USJT130903";

    public Connection obtemConexao () {
        try {
            Connection c = DriverManager.getConnection(url, user, password);
            return c;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
