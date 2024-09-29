# 📚 Sistema de Biblioteca

Este projeto é um sistema simples de gerenciamento de uma biblioteca, permitindo o cadastro de livros, clientes e a realização de empréstimos. Além disso, é possível consultar o histórico de empréstimos de clientes e livros.

## Funcionalidades

1. **Adicionar novo livro**: Permite cadastrar um novo livro no sistema.
2. **Ver livros disponíveis**: Lista todos os livros disponíveis para empréstimo.
3. **Fazer empréstimo de livro**: Realiza o empréstimo de um livro disponível para um cliente cadastrado.
4. **Consultar histórico de empréstimos por cliente**: Exibe todos os empréstimos feitos por um cliente específico.
5. **Consultar histórico de empréstimos por livro**: Exibe todos os clientes que emprestaram um determinado livro.
6. **Sair**: Encerra o sistema.

## Estrutura do Projeto

- **Biblioteca**: Classe principal responsável por gerenciar os livros, autores, clientes e empréstimos. Possui métodos para adicionar livros, listar livros disponíveis, realizar empréstimos e consultar o histórico de empréstimos.
- **Livro**: Representa um livro na biblioteca com atributos como título, autor e status de disponibilidade.
- **Autor**: Representa o autor de um livro.
- **Cliente**: Representa os clientes da biblioteca, com atributos como nome, e-mail e ID.
- **Empréstimo**: Classe que guarda as informações sobre um empréstimo, como o livro emprestado, o cliente e a data do empréstimo.

## Como Executar

1. Clone este repositório:
```bash
git clone https://github.com/joschonarth/java-library.git
```

2. Compile o projeto no IntelliJ IDEA ou em outro ambiente de desenvolvimento Java.

3. Execute a classe principal Main para iniciar o sistema.

## Regras de Negócio

Apenas livros marcados como disponíveis podem ser emprestados.
Cada cliente pode realizar empréstimos desde que esteja cadastrado no sistema.
Um livro emprestado será marcado como indisponível e não poderá ser emprestado até ser devolvido (função de devolução não implementada).
O sistema mantém um registro de todos os empréstimos, permitindo consultas futuras.