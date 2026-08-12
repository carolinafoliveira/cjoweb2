import java.util.Random;

import javax.swing.JOptionPane;

public class Jogodados {
    public static void main(String[] args) throws Exception {
        Random numberGenerator = new Random();
        
        int die1, die2, sum, attempts, option, guess;
        boolean isCorrect;

        // laço principal do jogo
        do {
            // inicialização do jogo
            die1 = numberGenerator.nextInt(6) + 1;
            die2 = numberGenerator.nextInt(6) + 1;
            sum = die1 + die2;
            attempts = 3;

            System.out.println("Dado 1: " + die1 + " - Dado 2: " + die2 + " - Soma: " + sum);

            isCorrect = false;
            while(!isCorrect && attempts > 0){
                attempts--;
                guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua aposta:"));

                if (guess == sum){
                    isCorrect = true;
                } else{
                    JOptionPane.showConfirmDialog(null, "Você errou! Você tem " + attempts + " tentativa(s)."); 
                }

            } 
            if (isCorrect){
                JOptionPane.showConfirmDialog(null, "Parabéns! Você ganhou!");
            } else{
                JOptionPane.showConfirmDialog(null, "Infelizmente você perdeu!");
            }
            
            option = JOptionPane.showConfirmDialog(null, "Deseja joagar novamente? ");
        } while(option == 0);
    }
}
