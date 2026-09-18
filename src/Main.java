import java.util.Scanner;

public class Biblioteca {
    static final int MAX_LIVROS = 100;
    static final int MAX_UTILIZADORES = 50;
    static final int MAX_EMPRESTIMOS = 100;
    static String[] idsLivros = new String[100];
    static String[] titulosLivros = new String[100];
    static String[] autoresLivros = new String[100];
    static int[] anosLivros = new int[100];
    static int[] qtdLivros = new int[100];
    static int totalLivros = 0;
    static String[] idsUtilizadores = new String[50];
    static String[] nomesUtilizadores = new String[50];
    static int totalUtilizadores = 0;
    static String[][] matrizEmprestimos = new String[100][3];
    static int totalEmprestimos = 0;

    public Biblioteca() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        int var2 = 0;
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
            System.out.print("Escolha uma opção: ");
            if (var1.hasNextInt()) {
                var2 = var1.nextInt();
                var1.nextLine();
                switch (var2) {
                    case 0:
                        System.out.println("A encerrar o sistema. Até breve!");
                        break;
                    case 1:
                        registarLivro(var1);
                        break;
                    case 2:
                        registarUtilizador(var1);
                        break;
                    case 3:
                        consultarCatalogo();
                        break;
                    case 4:
                        pesquisarLivro(var1);
                        break;
                    case 5:
                        efetuarEmprestimo(var1);
                        break;
                    case 6:
                        efetuardevolverLivro(var1);
                        break;
                    case 7:
                        apresentarEstatisticas();
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                System.out.println("Erro: Por favor, introduza um número válido.");
                var1.nextLine();
            }
        } while(var2 != 0);

        var1.close();
    }

    public static void inicializarDadosExemplo() {
        idsLivros[0] = "L01";
        titulosLivros[0] = "Algoritmos em Java";
        autoresLivros[0] = "José Silva";
        anosLivros[0] = 2021;
        qtdLivros[0] = 3;
        idsLivros[1] = "L02";
        titulosLivros[1] = "Redes de Computadores";
        autoresLivros[1] = "Andrew Tanenbaum";
        anosLivros[1] = 2019;
        qtdLivros[1] = 2;
        totalLivros = 2;
        idsUtilizadores[0] = "U01";
        nomesUtilizadores[0] = "Eunésio Nhatuve";
        totalUtilizadores = 1;
    }

    public static void registarLivro(Scanner var0) {
        if (totalLivros >= 100) {
            System.out.println("Erro: Catálogo cheio!");
        } else {
            System.out.print("ID do Livro (ex: L03): ");
            idsLivros[totalLivros] = var0.nextLine();
            System.out.print("Título: ");
            titulosLivros[totalLivros] = var0.nextLine();
            System.out.print("Autor: ");
            autoresLivros[totalLivros] = var0.nextLine();
            System.out.print("Ano de Publicação: ");
            anosLivros[totalLivros] = var0.nextInt();
            System.out.print("Quantidade Disponível: ");
            qtdLivros[totalLivros] = var0.nextInt();
            var0.nextLine();
            ++totalLivros;
            System.out.println("Livro registado com sucesso!");
        }
    }

    public static void registarUtilizador(Scanner var0) {
        if (totalUtilizadores >= 50) {
            System.out.println("Erro: Limite de utilizadores atingido!");
        } else {
            System.out.print("ID do Utilizador (ex: U02): ");
            idsUtilizadores[totalUtilizadores] = var0.nextLine();
            System.out.print("Nome Completo: ");
            nomesUtilizadores[totalUtilizadores] = var0.nextLine();
            ++totalUtilizadores;
            System.out.println("Utilizador registado com sucesso!");
        }
    }

    public static void consultarCatalogo() {
        System.out.println("\n--- CATÁLOGO DE LIVROS ---");
        if (totalLivros == 0) {
            System.out.println("Nenhum livro registado.");
        } else {
            for(int var0 = 0; var0 < totalLivros; ++var0) {
                String var10001 = idsLivros[var0];
                System.out.println("ID: " + var10001 + " | Título: " + titulosLivros[var0] + " | Autor: " + autoresLivros[var0] + " | Ano: " + anosLivros[var0] + " | Disponíveis: " + qtdLivros[var0]);
            }

        }
    }

    public static void pesquisarLivro(Scanner var0) {
        System.out.print("Digite o termo de pesquisa (Título ou Autor): ");
        String var1 = var0.nextLine().toLowerCase();
        boolean var2 = false;
        System.out.println("\n--- RESULTADOS DA PESQUISA ---");

        for(int var3 = 0; var3 < totalLivros; ++var3) {
            if (titulosLivros[var3].toLowerCase().contains(var1) || autoresLivros[var3].toLowerCase().contains(var1)) {
                String var10001 = idsLivros[var3];
                System.out.println("ID: " + var10001 + " | Título: " + titulosLivros[var3] + " | Autor: " + autoresLivros[var3] + " | Qtd: " + qtdLivros[var3]);
                var2 = true;
            }
        }

        if (!var2) {
            System.out.println("Nenhum livro encontrado com o termo especificado.");
        }

    }

    public static void efetuarEmprestimo(Scanner var0) {
        if (totalEmprestimos >= 100) {
            System.out.println("Erro: Capacidade máxima de empréstimos atingida.");
        } else {
            consultarCatalogo();
            System.out.print("Digite o ID do Livro a emprestar: ");
            String var1 = var0.nextLine();
            int var2 = -1;

            for(int var3 = 0; var3 < totalLivros; ++var3) {
                if (idsLivros[var3].equalsIgnoreCase(var1)) {
                    var2 = var3;
                    break;
                }
            }

            if (var2 == -1) {
                System.out.println("Erro: Livro não encontrado.");
            } else if (qtdLivros[var2] <= 0) {
                System.out.println("Erro: Livro indisponível no momento (stock esgotado).");
            } else {
                System.out.println("\n--- UTILIZADORES ---");

                for(int var6 = 0; var6 < totalUtilizadores; ++var6) {
                    String var10001 = idsUtilizadores[var6];
                    System.out.println("ID: " + var10001 + " | Nome: " + nomesUtilizadores[var6]);
                }

                System.out.print("Digite o ID do Utilizador: ");
                String var7 = var0.nextLine();
                boolean var4 = false;

                for(int var5 = 0; var5 < totalUtilizadores; ++var5) {
                    if (idsUtilizadores[var5].equalsIgnoreCase(var7)) {
                        var4 = true;
                        break;
                    }
                }

                if (!var4) {
                    System.out.println("Erro: Utilizador não encontrado.");
                } else {
                    int var10002 = qtdLivros[var2]--;
                    matrizEmprestimos[totalEmprestimos][0] = var1;
                    matrizEmprestimos[totalEmprestimos][1] = var7;
                    matrizEmprestimos[totalEmprestimos][2] = "Ativo";
                    ++totalEmprestimos;
                    System.out.println("Empréstimo efetuado com sucesso!");
                }
            }
        }
    }

    public static void efetuardevolverLivro(Scanner var0) {
        System.out.println("\n--- EMPRÉSTIMOS ATIVOS ---");
        boolean var1 = false;

        for(int var2 = 0; var2 < totalEmprestimos; ++var2) {
            if (matrizEmprestimos[var2][2].equals("Ativo")) {
                System.out.println("Registo [" + var2 + "] - Livro ID: " + matrizEmprestimos[var2][0] + " | Utilizador ID: " + matrizEmprestimos[var2][1]);
                var1 = true;
            }
        }

        if (!var1) {
            System.out.println("Não existem empréstimos ativos de momento.");
        } else {
            System.out.print("Digite o índice (número do registo) do empréstimo a devolver: ");
            int var5 = var0.nextInt();
            var0.nextLine();
            if (var5 >= 0 && var5 < totalEmprestimos && matrizEmprestimos[var5][2].equals("Ativo")) {
                matrizEmprestimos[var5][2] = "Devolvido";
                String var3 = matrizEmprestimos[var5][0];

                for(int var4 = 0; var4 < totalLivros; ++var4) {
                    if (idsLivros[var4].equalsIgnoreCase(var3)) {
                        int var10002 = qtdLivros[var4]++;
                        break;
                    }
                }

                System.out.println("Devolução registada com sucesso!");
            } else {
                System.out.println("Erro: Índice inválido ou empréstimo já devolvido.");
            }

        }
    }

    public static void apresentarEstatisticas() {
        System.out.println("\n--- ESTATÍSTICAS DA BIBLIOTECA ---");
        System.out.println("Total de títulos cadastrados: " + totalLivros);
        System.out.println("Total de utilizadores registados: " + totalUtilizadores);
        System.out.println("Número total de empréstimos efetuados (histórico): " + totalEmprestimos);
        int var0 = 0;

        for(int var1 = 0; var1 < totalEmprestimos; ++var1) {
            if (matrizEmprestimos[var1][2].equals("Ativo")) {
                ++var0;
            }
        }

        System.out.println("Empréstimos atualmente ativos por regularizar: " + var0);
    }
}

  }
}
