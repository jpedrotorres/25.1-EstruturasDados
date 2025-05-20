package dominio;


public class Aluno {
    private int matricula;
    private String nome;
    private double cr;

    public Aluno(int matricula, String nome, double cr) {
        this.matricula = matricula;
        this.nome = nome;
        this.cr = cr;
    }

    // Getters
    public int getMaricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getCR() {
        return cr;
    }

    // Setters
    public void setMatricul(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCR(double cr) {
        this.cr = cr;
    }

    public void listarProduto() {
        System.out.println("Matrícula: " + matricula + ", Nome: " + nome + ", Coeficiente de Rendimento: " + cr);
    }
}