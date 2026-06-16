import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    executarExercicio01();
                    break;
                case 2:
                    executarExercicio02();
                    break;
                case 3:
                    executarExercicio03(scanner);
                    break;
                case 4:
                    executarExercicio04(scanner);
                    break;
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 6:
                    executarExercicio06(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Pilha ===");
        System.out.println("1 - Pilha com valores fixos");
        System.out.println("2 - Pilha de nomes");
        System.out.println("3 - Remover 10 numeros da pilha");
        System.out.println("4 - Menu interativo de pilha");
        System.out.println("5 - Inverter palavra com pilha");
        System.out.println("6 - Historico de navegacao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada invalida. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

    private static void executarExercicio01() {
        Stack<Integer> pilha = criarPilhaValoresFixos();

        System.out.println("Pilha: " + pilha);

        pilha.pop();

        System.out.println("Pilha apos a remocao do elemento: " + pilha);
    }

    private static void executarExercicio02() {
        Stack<String> pilha = criarPilhaNomes();

        System.out.println("Topo: " + pilha.peek());
        System.out.println("Qntd de elementos: " + pilha.size());
    }

    private static void executarExercicio03(Scanner scanner) {
        Stack<Integer> pilha = new Stack<>();

        for (int i = 1; i <= 10; i++) {
            pilha.push(i);
        }

        List<Integer> removidos = removerTodosElementos(pilha);

        System.out.println("Elementos removidos:");
        for (Integer numero : removidos) {
            System.out.println(numero);
        }
    }

    private static void executarExercicio04(Scanner scanner) {
        Stack<Integer> pilha = new Stack<>();
        int opcao;

        do {
            System.out.println("\n== MENU ==");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Mostrar topo");
            System.out.println("4 - Mostrar pilha");
            System.out.println("5 - Sair");

            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    int valor = lerInteiro(scanner, "Digite um valor: ");
                    pilha.push(valor);
                    break;

                case 2:
                    if (!pilha.isEmpty()) {
                        System.out.println("Removido: " + pilha.pop());
                    } else {
                        System.out.println("Pilha vazia.");
                    }
                    break;

                case 3:
                    if (!pilha.isEmpty()) {
                        System.out.println("Topo: " + pilha.peek());
                    } else {
                        System.out.println("Pilha vazia.");
                    }
                    break;

                case 4:
                    System.out.println("Pilha: " + pilha);
                    break;

                case 5:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);
    }

    private static void executarExercicio05(Scanner scanner) {
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        String invertida = inverterPalavra(palavra);

        System.out.println("Palavra invertida: " + invertida);
    }

    private static void executarExercicio06(Scanner scanner) {
        Stack<String> historico = new Stack<>();
        int opcao;

        do {
            System.out.println("\n== HISTORICO NAVEGACAO ==");
            System.out.println("1 - Visitar pagina");
            System.out.println("2 - Voltar pagina");
            System.out.println("3 - Mostrar pagina atual");
            System.out.println("4 - Exibir historico");
            System.out.println("5 - Sair");

            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    System.out.print("Digite a pagina: ");
                    String pagina = scanner.nextLine();
                    visitarPagina(historico, pagina);
                    break;

                case 2:
                    String removida = voltarPagina(historico);

                    if (removida != null) {
                        System.out.println("Voltou de: " + removida);
                    } else {
                        System.out.println("Historico vazio.");
                    }
                    break;

                case 3:
                    String atual = paginaAtual(historico);

                    if (atual != null) {
                        System.out.println("Pagina atual: " + atual);
                    } else {
                        System.out.println("Historico vazio.");
                    }
                    break;

                case 4:
                    System.out.println("Historico: " + historico);
                    break;

                case 5:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);
    }

    // Metodos

    public static Stack<Integer> criarPilhaValoresFixos() {
        Stack<Integer> pilha = new Stack<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);

        return pilha;
    }

    public static Stack<String> criarPilhaNomes() {
        Stack<String> pilha = new Stack<>();

        pilha.push("Ana");
        pilha.push("Carlos");
        pilha.push("Pedro");
        pilha.push("Juliana");

        return pilha;
    }

    public static List<Integer> removerTodosElementos(Stack<Integer> pilha) {
        List<Integer> removidos = new ArrayList<>();

        while (!pilha.isEmpty()) {
            removidos.add(pilha.pop());
        }

        return removidos;
    }

    public static String inverterPalavra(String palavra) {
    Stack<Character> pilha = new Stack<>();

    for (int i = 0; i < palavra.length(); i++) {
        pilha.push(palavra.charAt(i));
    }

    String invertida = "";

    while (!pilha.isEmpty()) {
        invertida += pilha.pop();
    }

    return invertida;
    }

    public static void visitarPagina(Stack<String> historico, String pagina) {
        historico.push(pagina);
    }

    public static String voltarPagina(Stack<String> historico) {
        if (historico.isEmpty()) {
            return null;
        }

        return historico.pop();
    }

    public static String paginaAtual(Stack<String> historico) {
        if (historico.isEmpty()) {
            return null;
        }

        return historico.peek();
    }
}