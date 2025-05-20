import controle.ControlaAluno;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ControlaAluno controle = new ControlaAluno();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Alterar Aluno");
            System.out.println("4. Excluir Aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Matricula do Aluno: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do Aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Coeficiente de Rendimento do Aluno: ");
                    double cr = scanner.nextDouble();
                    controle.adicionarAluno(matricula, nome, cr);
                    break;
                case 2:
                    controle.listarAlunos();
                    break;
                case 3:
                    System.out.print("ID do Aluno a alterar: ");
                    int matriculaAlterar = scanner.nextInt();
                    scanner.nextLine();
                    controle.alterarAluno(matriculaAlterar);
                    break;
                case 4:
                    System.out.print("ID do Aluno a excluir: ");
                    int matriculaExcluir = scanner.nextInt();
                    controle.excluirAluno(matriculaExcluir);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
