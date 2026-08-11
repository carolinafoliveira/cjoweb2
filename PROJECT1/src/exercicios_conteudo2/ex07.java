
/*Desenvolva um programa em Java que recebe o peso de uma pessoa, calcula e mostra: 
• O novo peso, se a pessoa engordar 15% sobre o peso digitado. 
• O novo peso, se a pessoa emagrece 20% sobre o peso digitado. */

package exercicios_conteudo2; // package organiza o projeto em pastas

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float pesoPessoa, engorda, emagrece;
        System.out.print("Informe o peso (Kg): ");
        pesoPessoa = teclado.nextFloat();
        engorda = pesoPessoa * 1.15f;
        emagrece = pesoPessoa * 0.80f; // 100 - 20;
        System.out.println("Peso da pessoa: " + pesoPessoa);
        System.out.println("Peso + 15%: " + engorda);
        System.out.println("Peso - 20%: " + emagrece);
        teclado.close();
    }
}


