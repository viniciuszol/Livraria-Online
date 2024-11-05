import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livros;


    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livros.put(link, livro);
    }

    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>();

        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chavesRemover.add(entry.getKey());
            }
        }
        for (String chave : chavesRemover) {
            livros.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());
    
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
    
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();
    
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
          livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }
    
        return livrosOrdenadosPorPreco;
      }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());
    
        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());
    
        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();
    
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
          livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }
    
        return livrosOrdenadosPorAutor;
      }

      public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
          Livro livro = entry.getValue();
          if (livro.getAutor().equals(autor)) {
            livrosPorAutor.put(entry.getKey(), livro);
          }
        }
        return livrosPorAutor;
      }

      public List<Livro> exibirLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;
    
        if (!livros.isEmpty()) {
          for (Livro livro : livros.values()) {
            if (livro.getPreco() > precoMaisAlto) {
              precoMaisAlto = livro.getPreco();
            }
          }
        } else {
          throw new NoSuchElementException("A livraria está sem livros");
        }
    
        for(Map.Entry<String, Livro> entry: livros.entrySet()) {
          if(entry.getValue().getPreco() == precoMaisAlto) {
            Livro livroMaisCaro = livros.get(entry.getKey());
            livrosMaisCaros.add(livroMaisCaro);
          }
        }
        return livrosMaisCaros;
      }
    
      public List<Livro> exibirLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;
    
        if (!livros.isEmpty()) {
          for (Livro livro : livros.values()) {
            if (livro.getPreco() < precoMaisBaixo) {
              precoMaisBaixo = livro.getPreco();
            }
          }
        } else {
          throw new NoSuchElementException("A livraria está sem livros");
        }
    
        for(Map.Entry<String, Livro> entry: livros.entrySet()) {
          if(entry.getValue().getPreco() == precoMaisBaixo) {
            Livro livroMaisBarato = livros.get(entry.getKey());
            livrosMaisBaratos.add(livroMaisBarato);
          }
        }
        return livrosMaisBaratos;
      }

      public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        //adicionando livros
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Duna-Frank-Herbert/dp/857657313X/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&dib=eyJ2IjoiMSJ9.KktxiTShNNUNSVgX2-feNxspnxwPzG2QvcJgMxEK34balF3oGzz0MhBJn1atNBcWl5M9FT2IGkDj24tyma-unXEgEbVrUuCmiJI2m79g1Dxlh2VoS-2pX-UzNtn-VWAIwsUo2OL1-B-FoANTk4rwPypUG7o9Ci3ZtqnaY8NVoOk4oLA-nD0016k-00hT8AwMZoolT4jjeMUUcMT1iEqUf-S-EyduNsJf3W5kDbTLX1w.EcZ1qcdeLgJwtweKUVvksCbzv5MvfH4OT6w8M0Z_okg&dib_tag=se&keywords=duna+livro&qid=1730833976&s=books&sr=1-1-catcorr", new Livro("Duna", "Frank Herbert", 99.90));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Messias-Duna-Frank-Herbert/dp/8576573822/ref=sr_1_5?__mk_pt_BR=ÅMÅŽÕÑ&crid=3QM0J8BUYWX8L&dib=eyJ2IjoiMSJ9.W8yC5GvijSEbd-zGZ0hTXxzyyjyOmGghVK3b2urTrBMaJt4f0kBqv2U0M6P7Ttf8lQl2heXEnGLWO2MEN9yMzGGVgCeUvpd0j85sUKGAcE7hLwH0L2M6Z75BMyEg4fbquZVXIF7HGJHrh-poNBJ8pLht4-EfEHab2Rt5jAaE5398XQUYEnbxupLzXqOZcY-DmwQfyOFx-yCCD61BLc-NoNccz5ZuNWluCm-wpI2wJb8.U_wOQYia_UEmt3CVktFjBrnlrw3FkukVVCfjAoal2mA&dib_tag=se&keywords=duna+%27-+frank+herbert&qid=1730834213&s=books&sprefix=duna\"+-+frank+herbert%2Cstripbooks%2C198&sr=1-5", new Livro("Messias de Duna", "Frank Herbet", 99.90));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Filhos-Duna-Frank-Herbert/dp/8576573148/ref=sr_1_6?__mk_pt_BR=ÅMÅŽÕÑ&crid=3QM0J8BUYWX8L&dib=eyJ2IjoiMSJ9.W8yC5GvijSEbd-zGZ0hTXxzyyjyOmGghVK3b2urTrBMaJt4f0kBqv2U0M6P7Ttf8lQl2heXEnGLWO2MEN9yMzGGVgCeUvpd0j85sUKGAcE7hLwH0L2M6Z75BMyEg4fbquZVXIF7HGJHrh-poNBJ8pLht4-EfEHab2Rt5jAaE5398XQUYEnbxupLzXqOZcY-DmwQfyOFx-yCCD61BLc-NoNccz5ZuNWluCm-wpI2wJb8.U_wOQYia_UEmt3CVktFjBrnlrw3FkukVVCfjAoal2mA&dib_tag=se&keywords=duna+%27-+frank+herbert&qid=1730834213&s=books&sprefix=duna\"+-+frank+herbert%2Cstripbooks%2C198&sr=1-6", new Livro("Filhos de Duna", "Frank Herbet", 119.90));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/nome-do-vento-Patrick-Rothfuss/dp/8599296493/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&crid=RS5JN6T5CL48&dib=eyJ2IjoiMSJ9.VOo0_opG9JWRW9FcPWHGkCARO6FQxrUhlEljZHyo_dl-7Ybo7kyaU8GUJmqgXQI9vgdiTJKX6j_Y0LL3LspwENvsL_EMzbfpPYpQtr5rMMfNFtm6NgEvAk9U8Al6Vz3w-IPDiMw_2w9WP115y44Khzdya_F-mce26vEpaxjYdRQWi3bJYMtUmepketUEdzkkpVxHFG-ILDaMh5OjgfTdTzzHB9tWwaiAkvNA6yRE4Zc.pv24MeM-Ae1HSZxv_iVI1Z3Nw3BvP07yDDDFooaXp5k&dib_tag=se&keywords=o+nome+do+vento&qid=1730834465&s=books&sprefix=o+nome+do+vent%2Cstripbooks%2C315&sr=1-1", new Livro ("O Nome do Vento", "Patrick Rothfuss", 79.90));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Eragon-Ciclo-Herança-Livro-1-ebook/dp/B00A3D9FEG/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&crid=3FPX3D90771RT&dib=eyJ2IjoiMSJ9.8W89gVoCg2jj3_NRkH7Y9U4mqjxBhgzQuRUkpe6_m9lg747ZFdLQ4AQLdOOegiKpVAxeIrLuzjzq7YmoR82kDOjsrJ3SPArQzn7D_2txoFNR8F_htAMs2Ui7DthdiblUXJvQkIxmxppvWlqGv70unJQcd2zVJGhmH8jWsNgQB8efirPQad4sCC_a2uDBS2unVzT8PN2ZeDkxqwqrh6JQZXs2J4Jndz37hgverLjKfDM.NedOPUHRJ3MHtPadkiOJSCcXW1rKw_i2XOTDT5wrxdM&dib_tag=se&keywords=o+ciclo+da+herança&qid=1730834606&s=books&sprefix=o+ciclo+da+heranç%2Cstripbooks%2C204&sr=1-1", new Livro("Eragon", "Chrstopher Paolini", 84.90));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Guerra-dos-Tronos-Crônicas-Gelo/dp/8556510787/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&dib=eyJ2IjoiMSJ9.uqs1nHIpTjTu0TddyXAkOX9-afm6vRKNfLxnDM9KXT7TPO7-F_PE6DwYaH0nYFHmMhKPzaRwJYMDs0VG_CpoldsfNfYjIZv28LF08BKbfY8vYY5AqgKcDAox4IuN3D41abA7uXY2J2fkeOPNxAjuc0eqVA9IUApECReZSORYM414vEeBVUkQiIv5rtXJC4OD_Hn-hqYAIgUTUAbTye6ItzQ58wAQFMkbqB2TGW13gZY.9u6Ao77o2DjxPUDmoejSF-49uqvO4GdhPl3NPZ2igP4&dib_tag=se&keywords=as+cronicas+de+gelo+e+fogo&qid=1730834751&s=books&sr=1-1-catcorr", new Livro("As Crônicas de Gelo e Fogo: A Guerra Dos Tronos", "George R.R. Martin", 79.90));

        //exibindo os livros por ordem de preço
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //exibindo os livros por ordem de autor
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorAutor());

        //pesquisando por livros baseado no autor
        String autorPesquisa = "Frank Herbet";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        //exibindo o livro mais caro da livraria
        System.out.println("O livro mais caro da livraria: " + livrariaOnline.exibirLivroMaisCaro());

        //exibindo o livro nais barato da livraria
        System.out.println("O livro mais barato da livraria: " + livrariaOnline.exibirLivroMaisBarato());

        //removendo um livro baseado no titulo
        livrariaOnline.removerLivro("Eragon");
        System.out.println(livrariaOnline.livros);
      }
}
