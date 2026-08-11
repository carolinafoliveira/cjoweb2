
/*Uma loja de informática está vendendo seus produtos em 5 (cinco) prestações sem juros. 
Faça um programa em Java que recebe o valor de uma compra, calcule e mostre o valor das prestações.*/

package exercicios_conteudo2; // package organiza o projeto em pastas

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float valorVista, valorPrestacao;
        System.out.print("Digite o valor da compra: ");
        valorVista = teclado.nextFloat();
        valorPrestacao = valorVista / 5;
        System.out.print("Valor da prestação: " + valorPrestacao);
        teclado.close();
    }
}


