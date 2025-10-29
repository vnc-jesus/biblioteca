import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner leitura = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("""
                    |--------------------------------|
                    |    ESCOLHA A OPÇÃO DESEJADA    |
                    |--------------------------------|
                    | 1- ADICIONAR LIVRO             |
                    | 2- PROCURAR LIVRO              |
                    | 3- VER TODOS                   |
                    | 4- APAGAR LIVRO                |
                    | 0- SAIR                        |
                    |--------------------------------|
                    """);

            System.out.print("Digite sua escolha: ");
            escolha = Integer.parseInt(leitura.nextLine());

            switch (escolha) {
                case 1 -> {
                    while (true) {
                        System.out.println("Digite o título do livro (ou deixe vazio para sair):");
                        String titulo = leitura.nextLine();
                        if (titulo.isBlank()) {
                            break;  // sai do loop se o título estiver vazio
                        }

                        System.out.println("Digite o autor do livro:");
                        String autor = leitura.nextLine();

                        System.out.println("Digite o ano de publicação:");
                        int anoPublicacao = Integer.parseInt(leitura.nextLine());

                        Livro livro = new Livro(titulo, autor, anoPublicacao);
                        biblioteca.novoLivro(livro);

                        System.out.println("📚 Livro adicionado com sucesso!\n");
                    }

                    System.out.println("Cadastro finalizado.");

                }

                case 2 -> {
                    System.out.println("Digite o nome do livro que deseja procurar:");
                    String nomeBusca = leitura.nextLine();
                    List<Livro> resultados = biblioteca.buscarLivro(nomeBusca);

                    if (resultados.isEmpty()) {
                        System.out.println("Nenhum livro encontrado.\n");
                    } else {
                        System.out.println("Livros encontrados:");
                        resultados.forEach(Livro::exibirLivro);
                    }
                }

                case 3 -> biblioteca.exibiLivro();

                case 4 -> {
                    System.out.println("Digite o título do livro que deseja remover:");
                    String tituloRemover = leitura.nextLine();
                    boolean removido = biblioteca.removerLivro(tituloRemover);

                    if (removido) {
                        System.out.println("📕 Livro removido com sucesso!\n");
                    } else {
                        System.out.println("Livro não encontrado.\n");
                    }
                }

                case 0 -> System.out.println("Encerrando programa...");

                default -> System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (escolha != 0);

        leitura.close();


    }
}