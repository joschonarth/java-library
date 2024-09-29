package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public int getProximoIdLivro() {
        return livros.size() + 1;
    }

    public int getProximoIdAutor() {
        return autores.size() + 1;
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.getDisponivel()) {
                System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor().getNome());
            }
        }
    }

    public void emprestarLivro(int idLivro, Cliente cliente) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro && livro.getDisponivel()) {
                Emprestimo emprestimo = new Emprestimo(livro, cliente);
                emprestimos.add(emprestimo);
                System.out.println("Livro " + livro.getTitulo() + " foi emprestado para " + cliente.getNome());
                return;
            }
        }
        System.out.println("O livro não está disponível para empréstimo.");
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
        }
    }

    public void consultarEmprestimoPorCliente(int idCliente) {
        boolean encontrouEmprestimo = false;
        Cliente cliente = null;

        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            System.out.println("Empréstimos do(a) Cliente: " + cliente.getNome());
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getCliente().getId() == idCliente) {
                    System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                    System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                    System.out.println("-------------------------------");
                    encontrouEmprestimo = true;
                }
            }

            if (!encontrouEmprestimo) {
                System.out.println("Nenhum empréstimo encontrado para este cliente.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void consultarEmprestimoPorLivro(int idLivro) {
        boolean encontrouEmprestimo = false;
        Livro livro = null;

        for (Livro l : livros) {
            if (l.getId() == idLivro) {
                livro = l;
                break;
            }
        }

        if (livro != null) {
            System.out.println("Empréstimos do Livro: " + livro.getTitulo());
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getLivro().getId() == idLivro) {
                    System.out.println("Cliente: " + emprestimo.getCliente().getNome());
                    System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                    System.out.println("-------------------------------");
                    encontrouEmprestimo = true;
                }
            }

            if (!encontrouEmprestimo) {
                System.out.println("Nenhum empréstimo encontrado para este livro.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }


    public void sair() {
        System.out.println("Saindo da aplicação...");
        System.exit(0);
    }
}
