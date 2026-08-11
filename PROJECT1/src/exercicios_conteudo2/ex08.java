
/*Cada degrau de uma escada tem X de altura. Desenvolva um programa em Java que receba essa 
altura e a altura que o usuário deseja subir. Mostre quantos degraus o usuário deverá subir 
para atingir seu objetivo. Todas as medias estão em metros.  */

package exercicios_conteudo2; // package organiza o projeto em pastas

import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float alturaDegrau, desejaSubir, totalDegrau;
        System.out.print("Informe a altura do degrau (MT): ");
        alturaDegrau = teclado.nextFloat();
        System.out.print("Quantos metros deseja subir? ");
        desejaSubir = teclado.nextFloat();
        totalDegrau = desejaSubir / alturaDegrau;
        System.out.print("Total de degraus que deverá subir: " + totalDegrau);
        teclado.close();
    }
}


