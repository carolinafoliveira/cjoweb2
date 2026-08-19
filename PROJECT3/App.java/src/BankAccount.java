public class BankAccount {

    // declaração de atribuitos / variáveis de instância
    int id;
    String clientName;
    double balance;

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
    }

    public void displayDetails(){
        System.out.println("Dados da conta:");
        System.out.println("Código: " + id);
        System.out.println("Nome do Cliente: " + clientName);
        System.out.println("Saldo: R$ " + balance);
    }
}