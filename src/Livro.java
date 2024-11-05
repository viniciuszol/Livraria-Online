import java.util.Comparator;
import java.util.Map;

public class Livro {
    private String titulo;
    private String autor;
    private Double preco;

public Livro(String livro, String autor, Double preco) {
    this.titulo = livro;
    this.autor = autor;
    this. preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
      return "Livro{" +
          "titulo='" + titulo + '\'' +
          ", autor='" + autor + '\'' +
          ", preco=" + preco +
          '}';
    }
}

class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
      return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
    }
  }
  
  class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
      return l1.getValue().getAutor().compareToIgnoreCase(l2.getValue().getAutor());
    }
  }