# Livraria Online em Java utilizando Map

Este projeto implementa uma **livraria online** simples em Java, onde livros são armazenados em um `Map` com o **link do livro na Amazon Marketplace** como chave e um objeto da classe `Livro` como valor. A classe `Livro` contém informações sobre o título, autor e preço do livro.

A classe **LivrariaOnline** oferece operações para adicionar, remover, listar e pesquisar livros. Além disso, é possível exibir os livros ordenados por preço, pesquisar livros por autor e encontrar o livro mais caro ou mais barato da livraria.

## Funcionalidades

A classe `LivrariaOnline` oferece os seguintes métodos:

- **adicionarLivro(String link, String titulo, String autor, double preco):** Adiciona um livro à livraria, utilizando o link (ISBN) como chave e o objeto `Livro` como valor.
- **removerLivro(String titulo):** Remove um livro da livraria, dado o título.
- **exibirLivrosOrdenadosPorPreco():** Exibe os livros da livraria ordenados de forma crescente pelo preço.
- **pesquisarLivrosPorAutor(String autor):** Retorna uma lista de todos os livros de um determinado autor.
- **obterLivroMaisCaro():** Retorna o livro mais caro da livraria.
- **exibirLivroMaisBarato():** Exibe o livro mais barato da livraria.

## Tecnologias Utilizadas
- Java (JDK 8 ou superior)
- HashMap para implementação de Map
- List e ArrayList para gerenciar coleções de livros
- Interface Comparator para ordenar os livros com base no preço. 
