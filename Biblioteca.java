import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private ArrayList<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void novoLivro(Livro livro) {
        livros.add(livro);
    }

    public void exibiLivro() {
        System.out.println("---- Lista de livros ------");
        for (Livro a : livros) {
            a.exibirLivro();

        }
    }
    public List<Livro> buscarLivro(String titulo) {
        List<Livro> livrosEncontrados = livros.stream()
                .filter(l -> l.getTitulo().contains(titulo))
                .collect(Collectors.toList());
        return livrosEncontrados;

    }
    public boolean removerLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                return true; // Livro removido com sucesso
            }
        }
        return false; // Nenhum livro com esse título encontrado
    }


}