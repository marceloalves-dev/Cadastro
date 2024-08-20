package test;


import dominio.Usuario;
import dominio.UsuarioService;
import excecao.UsuarioInvalidoException;

import java.util.Optional;
import java.util.Scanner;

public class Test01 {

    //classe interna
    static class DadosCliente {
        public void inputs(Scanner sc) {
            System.out.print("nome: ");
            String nome = sc.next();
            System.out.print("email: ");
            String email = sc.next();
            System.out.print("idade: ");
            int idade = sc.nextInt();

            try {
                UsuarioService.adicionarUsuario(nome, email, idade);
            } catch (UsuarioInvalidoException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DadosCliente dadosCliente = new DadosCliente();
        dadosCliente.inputs(sc);
        sc.close();

        Optional<Usuario> nameTeste = UsuarioService.buscarNomeRegex("tiago");
        Optional<Usuario> emailTeste = UsuarioService.buscarEmail("tiago@gmail.com");

        System.out.println(nameTeste);
        System.out.println(emailTeste);
    }
}
