import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String titulo;
    private String descricao;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Descrição: " + descricao;
    }
}

public class GerenciadorDeTarefas {
    private ArrayList<Tarefa> tarefas;
    private Scanner scanner;

    public GerenciadorDeTarefas() {
        tarefas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarTarefa() {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa tarefa = new Tarefa(titulo, descricao);
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nGerenciador de Tarefas");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        gerenciador.exibirMenu();
    }
}
