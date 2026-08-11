
/*Faça um programa em Java para receber o valor do quilowatt de energia e a quantidade 
consumida por uma residência em um mês. Com esses dados, o programa deve calcular e mostrar: 
• O valor, em reais, a ser pago por essa residência. 
• O valor, em reais, a ser pago com desconto de 15%. */

package exercicios_conteudo2; // package organiza o projeto em pastas

import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float consumoMes, tarifa, faturaTotal, faturaDesconto;
        System.out.print("Digite o valor do consumo mensal de quilowatt: ");
        consumoMes = teclado.nextFloat();
        System.out.print("Digite a tarifa por quilowatt: ");
        tarifa = teclado.nextFloat();
        faturaTotal = consumoMes * tarifa;
        faturaDesconto = faturaTotal * 0.85f; // 100 - 15 = 85
        System.out.print("Fatura total: " + faturaTotal);
        System.out.println();
        System.out.print("Fatura com desconto (15%): " + faturaDesconto);
        teclado.close();
    }
}


