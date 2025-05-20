package controle;

import dominio.Aluno;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlaAluno {
    private ArrayList<Aluno> alunos;
    private final String arquivoAlunos = "alunos.txt";

    public ControlaAluno() {
        this.alunos = new ArrayList<>();
        carregarAlunos();
    }

    public void adicionarAluno(int matricula, String nome, double cr) {
        Aluno aluno = new Aluno(matricula, nome, cr);
        alunos.add(aluno);
        salvarAlunos();
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : alunos) {
                aluno.listarAluno();
            }
        }
    }

    public void alterarAluno(int matricula) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo nome do aluno: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo coeficiente de rendimento do aluno: ");
            double novoCR = scanner.nextDouble();
            scanner.close();
            
            aluno.setNome(novoNome);
            aluno.setCR(novoCR);
            salvarAlunos();
            System.out.println("Aluno alterado com sucesso!");
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    public void excluirAluno(int matricula) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            salvarAlunos();
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    private Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMaricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    // Método para salvar alunos no arquivo
    private void salvarAlunos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoAlunos))) {
            for (Aluno aluno : alunos) {
                writer.write(aluno.getMaricula() + ";" + aluno.getNome() + ";" + aluno.getCR());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    // Método para carregar alunos do arquivo
    private void carregarAlunos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoAlunos))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int matricula = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double cr = Double.parseDouble(dados[2]);
                alunos.add(new Aluno(matricula, nome, cr));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de alunos não encontrado. Será criado ao salvar novos alunos.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
        }
    }
}