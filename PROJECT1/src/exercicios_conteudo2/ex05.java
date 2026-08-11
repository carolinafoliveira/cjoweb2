
/*Faça um programa em Java que calcule o valor em reais, correspondente aos dólares 
que um turista possui no cofre do hotel. O programa deve receber a quantidade de dólares 
guardados no cofre e a cotação do dólar naquele dia.*/

package exercicios_conteudo2; // package organiza o projeto em pastas

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float dolar, reais, cotacaoDia;
        System.out.print("Informe o valor em dolar (USD): ");
        dolar = teclado.nextFloat();
        System.out.print("Informe a cotação do dia (R$): ");
        cotacaoDia = teclado.nextFloat();
        reais = dolar * cotacaoDia;
        System.out.print("Total em reais (R$): " + reais);
        teclado.close();
        
    }
}


