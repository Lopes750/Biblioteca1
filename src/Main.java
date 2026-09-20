import java.util.Scanner;

public class Biblioteca {

    // Definição das capacidades máximas das estruturas simuladas em memória
    static final int MAX_LIVROS = 100;
    static final int MAX_UTILIZADORES = 50;
    static final int MAX_EMPRESTIMOS = 100;

    // Estruturas de dados (Arrays paralelos para livros)
    static String[] idsLivros = new String[MAX_LIVROS];
    static String[] titulosLivros = new String[MAX_LIVROS];
    static String[] autoresLivros = new String[MAX_LIVROS];
    static int[] anosLivros = new int[MAX_LIVROS];
    static int[] qtdLivros = new int[MAX_LIVROS];
    static int totalLivros = 0;

    // Estruturas de dados para Utilizadores
    static String[] idsUtilizadores = new String[MAX_UTILIZADORES];
    static String[] nomesUtilizadores = new String[MAX_UTILIZADORES];
    static int totalUtilizadores = 0;

    // Matriz de Empréstimos: [indice][0]: idLivro, [indice][1]: idUtilizador, [indice][2]: estado ("Ativo" ou "Devolvido")
    static String[][] matrizEmprestimos = new String[MAX_EMPRESTIMOS][3];
    static int totalEmprestimos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Dados de exemplo para facilitar os testes
        inicializarDadosExemplo();

        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE GESTÃO - BIBLIOTECA MUNICIPAL");
            System.out.println("========================================");
            System.out.println("1. Registar Novo Livro");
            System.out.println("2. Registar Novo Utilizador");
            System.out.println("3. Consultar Catálogo de Livros");
            System.out.println("4. Pesquisar Livro (Título ou Autor)");
            System.out.println("5. Efetuar Empréstimo de Livro");
            System.out.println("6. Efetuar Devolução de Livro");
            System.out.println("7. Apresentar Estatísticas");
            System.out.println("0. Sair");
            System.out.print("\n Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limvar o buffer

                switch (opcao) {
                    case 1:
                        registarLivro(scanner);
                        break;
                    case 2:
                        registarUtilizador(scanner);
                        break;
                    case 3:
                        consultarCatalogo();
                        break;
                    case 4:
                        pesquisarLivro(scanner);
                        break;
                    case 5:
                        efetuarEmprestimo(scanner);
                        break;
                    case 6:
                        efetuardevolverLivro(scanner);
                        break;
                    case 7:
                        apresentarEstatisticas();
                        break;
                    case 0:
                        System.out.println("A encerrar o sistema. Até breve!");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                System.out.println("Erro: Por favor, introduza um número válido.");
                scanner.nextLine(); // Limpar entrada inválida
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void inicializarDadosExemplo() {
        idsLivros[0] = "L01"; titulosLivros[0] = "Algoritmos em Java"; autoresLivros[0] = "Guilherme Silveira"; anosLivros[0] = 2021; qtdLivros[0] = 3;
        idsLivros[1] = "L02"; titulosLivros[1] = "Redes de Computadores"; autoresLivros[1] = "Andrew Tanenbaum"; anosLivros[1] = 2019; qtdLivros[1] = 2;
        totalLivros = 2;

        idsUtilizadores[0] = "U01"; nomesUtilizadores[0] = "Lopes Paulo Tchauque";
        totalUtilizadores = 1;
    }

    public static void registarLivro(Scanner scanner) {
        if (totalLivros >= MAX_LIVROS) {
            System.out.println("Erro: Catálogo cheio!");
            return;
        }
        System.out.print("ID do Livro (ex: L03): ");
        idsLivros[totalLivros] = scanner.nextLine();
        System.out.print("Título: ");
        titulosLivros[totalLivros] = scanner.nextLine();
        System.out.print("Autor: ");
        autoresLivros[totalLivros] = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        anosLivros[totalLivros] = scanner.nextInt();
        System.out.print("Quantidade Disponível: ");
        qtdLivros[totalLivros] = scanner.nextInt();
        scanner.nextLine();

        totalLivros++;
        System.out.println("Livro registado com sucesso!");
    }

    public static void registarUtilizador(Scanner scanner) {
        if (totalUtilizadores >= MAX_UTILIZADORES) {
            System.out.println("Erro: Limite de utilizadores atingido!");
            return;
        }
        System.out.print("ID do Utilizador (ex: U02): ");
        idsUtilizadores[totalUtilizadores] = scanner.nextLine();
        System.out.print("Nome Completo: ");
        nomesUtilizadores[totalUtilizadores] = scanner.nextLine();

        totalUtilizadores++;
        System.out.println("Utilizador registado com sucesso!");
    }

    public static void consultarCatalogo() {
        System.out.println("\n--- CATÁLOGO DE LIVROS ---");
        if (totalLivros == 0) {
            System.out.println("Nenhum livro registado.");
            return;
        }
        for (int i = 0; i < totalLivros; i++) {
            System.out.println("ID: " + idsLivros[i] + " | Título: " + titulosLivros[i] + 
                               " | Autor: " + autoresLivros[i] + " | Ano: " + anosLivros[i] + 
                               " | Disponíveis: " + qtdLivros[i]);
        }
    }

    public static void pesquisarLivro(Scanner scanner) {
        System.out.print("Digite o termo de pesquisa (Título ou Autor): ");
        String termo = scanner.nextLine().toLowerCase();
        boolean encontrado = false;

        System.out.println("\n--- RESULTADOS DA PESQUISA ---");
        for (int i = 0; i < totalLivros; i++) {
            if (titulosLivros[i].toLowerCase().contains(termo) || autoresLivros[i].toLowerCase().contains(termo)) {
                System.out.println("ID: " + idsLivros[i] + " | Título: " + titulosLivros[i] + 
                                   " | Autor: " + autoresLivros[i] + " | Qtd: " + qtdLivros[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o termo especificado.");
        }
    }

    public static void efetuarEmprestimo(Scanner scanner) {
        if (totalEmprestimos >= MAX_EMPRESTIMOS) {
            System.out.println("Erro: Capacidade máxima de empréstimos atingida.");
            return;
        }
        consultarCatalogo();
        System.out.print("Digite o ID do Livro a emprestar: ");
        String idL = scanner.nextLine();
        
        int indiceLivro = -1;
        for (int i = 0; i < totalLivros; i++) {
            if (idsLivros[i].equalsIgnoreCase(idL)) {
                indiceLivro = i;
                break;
            }
        }

        if (indiceLivro == -1) {
            System.out.println("Erro: Livro não encontrado.");
            return;
        }

        if (qtdLivros[indiceLivro] <= 0) {
            System.out.println("Erro: Livro indisponível no momento (stock esgotado).");
            return;
        }

        // Listar utilizadores
        System.out.println("\n--- UTILIZADORES ---");
        for (int i = 0; i < totalUtilizadores; i++) {
            System.out.println("ID: " + idsUtilizadores[i] + " | Nome: " + nomesUtilizadores[i]);
        }

        System.out.print("Digite o ID do Utilizador: ");
        String idU = scanner.nextLine();
        boolean utilizadorExiste = false;
        for (int i = 0; i < totalUtilizadores; i++) {
            if (idsUtilizadores[i].equalsIgnoreCase(idU)) {
                utilizadorExiste = true;
                break;
            }
        }

        if (!utilizadorExiste) {
            System.out.println("Erro: Utilizador não encontrado.");
            return;
        }

        // Realizar empréstimo
        qtdLivros[indiceLivro]--;
        matrizEmprestimos[totalEmprestimos][0] = idL;
        matrizEmprestimos[totalEmprestimos][1] = idU;
        matrizEmprestimos[totalEmprestimos][2] = "Ativo";
        totalEmprestimos++;

        System.out.println("Empréstimo efetuado com sucesso!");
    }

    public static void efetuardevolverLivro(Scanner scanner) {
        System.out.println("\n--- EMPRÉSTIMOS ATIVOS ---");
        boolean temAtivos = false;
        for (int i = 0; i < totalEmprestimos; i++) {
            if (matrizEmprestimos[i][2].equals("Ativo")) {
                System.out.println("Registo [" + i + "] - Livro ID: " + matrizEmprestimos[i][0] + 
                                   " | Utilizador ID: " + matrizEmprestimos[i][1]);
                temAtivos = true;
            }
        }

        if (!temAtivos) {
            System.out.println("Não existem empréstimos ativos de momento.");
            return;
        }

        System.out.print("Digite o índice (número do registo) do empréstimo a devolver: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 0 && indice < totalEmprestimos && matrizEmprestimos[indice][2].equals("Ativo")) {
            matrizEmprestimos[indice][2] = "Devolvido";
            String idL = matrizEmprestimos[indice][0];

            // Devolver quantidade ao stock do livro
            for (int i = 0; i < totalLivros; i++) {
                if (idsLivros[i].equalsIgnoreCase(idL)) {
                    qtdLivros[i]++;
                    break;
                }
            }
            System.out.println("Devolução registada com sucesso!");
        } else {
            System.out.println("Erro: Índice inválido ou empréstimo já devolvido.");
        }
    }

    public static void apresentarEstatisticas() {
        System.out.println("\n--- ESTATÍSTICAS DA BIBLIOTECA ---");
        System.out.println("Total de títulos cadastrados: " + totalLivros);
        System.out.println("Total de utilizadores registados: " + totalUtilizadores);
        System.out.println("Número total de empréstimos efetuados (histórico): " + totalEmprestimos);
        
        int ativos = 0;
        for (int i = 0; i < totalEmprestimos; i++) {
            if (matrizEmprestimos[i][2].equals("Ativo")) {
                ativos++;
            }
        }
        System.out.println("Empréstimos atualmente ativos por regularizar: " + ativos);
    }
