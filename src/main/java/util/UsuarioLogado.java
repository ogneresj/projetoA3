package util;

public class UsuarioLogado {

    public class Sessao {
        public static int usuarioLogadoId;
    }

    private static String idUsuario;

    public static void setIdUsuario(String id) {
        idUsuario = id;
    }

    public static String getIdUsuario() {
        return idUsuario;
    }
}
