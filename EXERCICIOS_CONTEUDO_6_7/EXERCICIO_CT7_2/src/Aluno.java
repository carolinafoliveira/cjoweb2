public class Aluno {

    // atributos
    private String prontuario;
    private String nome;
    private double nota;

    // construtor
    public Aluno(String prontuario, String nome, double nota) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.nota = nota;
    }

    // getters e setters

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Prontuário: " + prontuario +
               " | Nome: " + nome +
               " | Nota: " + nota;
    }
}