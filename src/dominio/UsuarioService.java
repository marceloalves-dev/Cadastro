package dominio;

import excecao.UsuarioInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioService {
    static List<Usuario> usuarios = new ArrayList<>();

    public static void adicionarUsuario(String name, String email, int idade) throws UsuarioInvalidoException {

        if (name == null) {
            throw new UsuarioInvalidoException("Nome não pode ser vazio.");
        }
        if (email == null || !email.contains("@")) {
            throw new UsuarioInvalidoException("Email inválido.");
        }
        if (idade < 0 || idade > 120) {
            throw new UsuarioInvalidoException("Idade inválida.");
        }
        Usuario usuario = new Usuario(usuarios.size(), name, email, idade);
        usuarios.add(usuario);
        System.out.println("usuario adicionado a lista");

    }

    public static Optional<Usuario> buscarNomeRegex(String name) {
        Pattern pattern = Pattern.compile(name);

        for (Usuario usuario : usuarios) {
            Matcher matcher = pattern.matcher(usuario.getName());
            if (matcher.matches()) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();

    }

    public static Optional<Usuario> buscarEmail(String email) {
        return buscar(usuario -> usuario.getEmail().equals(email));
    }

    public static Optional<Usuario> buscar(Predicate<Usuario> predicate) {
        Usuario found = null;
        for (Usuario usuario : usuarios) {
            if (predicate.test(usuario)) {
                found = usuario;
            }
        }
        return Optional.ofNullable(found);
    }

}
