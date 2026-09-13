/* Escreva uma classe que represente datas, compostas por dia, mês e ano. Para que uma data seja instanciada, é necessário que se definam valores para o dia (1-30), 
mês (1-12) e ano (>= 1900). Uma vez instanciada, uma data pode ser modificada a qualquer momento. Observe que, em nenhum momento, uma data poderá assumir algum 
valor inválido para o dia, mês ou ano. Crie uma classe que efetue as seguintes tarefas: a. Instancie uma data com base em valores predefinidos para dia, mês e 
ano. b. Modifique a data instanciada a partir de dados lidos do usuário para dia, mês e ano. Após a modificação, imprima a nova data no formato “dd/mm/aaaa”. 
Observe que a impressão da data nesse formato requer que a classe de datas forneça a string necessária. Use a classe JOptionPane para efetuar a leitura.*/

// criando a classe com encapsulamento 

import javax.swing.JOptionPane;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    // construtor com regras de validação
    public Data(int dia, int mes, int ano) {
        while (dia < 1 || dia > 30) {
            dia = Integer.parseInt(JOptionPane.showInputDialog
                (null, "Dia invalido! Digite outro dia (1-30): "));
        }
        this.dia = dia;

        // if (dia >= 1 && dia <= 30) {
        //     this.dia = dia;
        // }

        while (mes < 1 || mes > 12) {
            mes = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Mes invalido! Digite outro mes (1-12):"));
        }
        this.mes = mes;

        // if (mes >= 1 && mes <= 12) {
        //     this.mes = mes;
        // }

        while (ano < 1990) {
            ano = Integer.parseInt(JOptionPane.showInputDialog(
                null, "Ano Invalido! Digite outro ano (>= 1990)"));
        }
        this.ano = ano;

        // if (ano >= 1900) {
        //     this.ano = ano;
        // }
    }

    // setter do dia
    public void setDia(int dia) {

        while (dia < 1 || dia > 30) {

            dia = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Dia inválido! Digite outro dia (1-30):"));
    }
    this.dia = dia;
}

    // getter do dia
    public int getDia() {
        return dia;
    }

    // setter do mes
    public  void setMes(int mes){
        while (mes < 1 || mes > 12) {
            mes = Integer.parseInt(JOptionPane.showInputDialog(
                null, "Mes invalidoo! Digite outro mes (1-12)"));
        }
        this.mes = mes;
    }    

    // getter do mes
    public int getMes() {
        return mes;
    }

    // setter do ano
    public void setAno(int ano) {
        while (ano < 1990) {
            ano = Integer.parseInt(JOptionPane.showInputDialog(
                null, "Ano Invalido! Digite outro ano (>= 1990)"));
        }
        this.ano = ano;
        
        // if (ano >= 1900) {
        //     this.ano = ano;
        // }
    }

    // getter do ano
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}