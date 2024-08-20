package excecao;

public class UsuarioInvalidoException extends Exception{
    public UsuarioInvalidoException() {
        super("dados invalidos");
    }

    public UsuarioInvalidoException(String message) {
        super(message);
    }
}
