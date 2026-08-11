
/*Juliana recebeu seu salário e precisa pagar duas contas atrasadas. Em razão do atraso, ela 
pagará multa de 2% sobre cada conta. Desenvolva um programa em Java que recebe o valor 
do salário e das duas contas, calcule e apresente quanto sobrará do salário de Juliana.*/

package exercicios_conteudo2; // package organiza o projeto em pastas

import java.util.Scanner;

public class ex09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float salarioBruto, salarioLiquido, conta1, conta2, totalConta1, totalConta2;
        System.out.print("Informe o salário bruto (R$): ");
        salarioBruto = teclado.nextFloat();
        System.out.print("Informe valor da primeira conta (R$): ");
        conta1 = teclado.nextFloat();
        System.out.print("informe valor da segunda conta (R$): ");
        conta2 = teclado.nextFloat();
        totalConta1 = conta1 * 1.02f;
        totalConta2 = conta2 * 1.02f;
        salarioLiquido = salarioBruto - totalConta1 - totalConta2;
        System.out.println("Salario Bruto (R$): " + salarioBruto);
        System.out.println("Primeira conta com multa (R$): " + totalConta1);
        System.out.println("Segunda conta com multa (R$): " + totalConta2);
        System.out.println("Salário Liquido (R$): " + salarioLiquido);
        teclado.close();
    }
}


