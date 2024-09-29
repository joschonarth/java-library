package org.example;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private Boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(int id, String titulo, Autor autor, LocalDate dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataCadastro;
    }

    public void emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
            this.dataAtualizacao = LocalDate.now();
        } else {
            System.out.println("O livro já foi emprestado.");
        }
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }
}
