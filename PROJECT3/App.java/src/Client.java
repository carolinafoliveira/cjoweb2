public class Client {

    // atributos da classe
    private int id;
    private String name;
    private String cpf;

    // metodo construtor
    public Client(int id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    } 

    // metodos acessadores
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getcpf() {
        return cpf;
    }
    
    @Override
    public String toString() {
        return
            "Dados do cliente:" + 
            "\nCódigo: " + id +
            "\nNome: " + name +
            "\nCPF: " + cpf;
    }

}
