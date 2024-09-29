package org.example;

import org.example.Autor;
import org.example.Biblioteca;
import org.example.Cliente;
import org.example.Livro;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Autor autor1 = new Autor(1, "Charles Duhigg", LocalDate.of(1974, 6, 4));
        Autor autor2 = new Autor(2, "Aluísio Azevedo", LocalDate.of(1857, 4, 14));

        Livro livro1 = new Livro(1, "O Poder do Hábito", autor1, LocalDate.now());
        Livro livro2 = new Livro(2, "O Cortiço", autor2, LocalDate.now());

        Cliente cliente1 = new Cliente(1, "João", LocalDate.of(2004, 4, 19), "joao@gmail.com");
        Cliente cliente2 = new Cliente(2, "Maria", LocalDate.of(2005, 5, 20), "maria@gmail.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarCliente(cliente1);
        biblioteca.adicionarCliente(cliente2);

        while (true) {
            System.out.println("\n===== Sistema de Livraria =====");
            System.out.println("1. Adicionar novo livro");
            System.out.println("2. Ver livros disponíveis");
            System.out.println("3. Fazer empréstimo de livro");
            System.out.println("4. Consultar histórico de empréstimos por cliente");
            System.out.println("5. Consultar histórico de empréstimos por livro");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarNovoLivro(biblioteca, scanner);
                    break;
                case 2:
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 3:
                    System.out.println("Livros disponíveis para empréstimo:");
                    biblioteca.listarLivrosDisponiveis();

                    System.out.println("Digite o ID do livro:");
                    int idLivro = scanner.nextInt();
                    System.out.println("Digite o ID do cliente:");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente cliente = null;
                    for (Cliente c : biblioteca.getClientes()) {
                        if (c.getId() == idCliente) {
                            cliente = c;
                            break;
                        }
                    }

                    if (cliente != null) {
                        biblioteca.emprestarLivro(idLivro, cliente);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o ID do cliente:");
                    idCliente = scanner.nextInt();
                    biblioteca.consultarEmprestimoPorCliente(idCliente);
                    break;
                case 5:
                    System.out.println("Digite o ID do livro:");
                    idLivro = scanner.nextInt();
                    biblioteca.consultarEmprestimoPorLivro(idLivro);
                    break;
                case 6:
                    biblioteca.sair();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarNovoLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o nome do autor:");
        String nomeAutor = scanner.nextLine();

        System.out.println("Digite a data de nascimento do autor (formato: YYYY-MM-DD):");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        Autor novoAutor = new Autor(biblioteca.getProximoIdAutor(), nomeAutor, dataNascimento);

        biblioteca.adicionarAutor(novoAutor);

        Livro novoLivro = new Livro(biblioteca.getProximoIdLivro(), titulo, novoAutor, LocalDate.now());

        biblioteca.adicionarLivro(novoLivro);

        System.out.println("Livro adicionado com sucesso!");
    }

}
