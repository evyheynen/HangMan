import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //How do we play the game
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to hangman! I will pick a word "
                + "and you will try to guess it character by character. "
                + "\nIf you guess wrong 6 times then I win, if you guess it before then, you win.");
        System.out.println();

        //Allows for multiple games
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay){
            //setting up the game
            System.out.println();
            System.out.println("Alright! Let's play!");
            HangMan game = new HangMan();

            do{
                //Draw the things
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                //System.out.println(game.mysteryWord);

                //get the guess
                System.out.println("Enter a character that is in the word");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();

                //check if the character is guessed already
                while (game.isGuessedAlready(guess)){
                    System.out.println("Try again! You've already guessed that character.");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }
                //play te guess
                if (game.playGuess(guess)){
                    System.out.println("Great guess! That character is in the word.");
                } else{
                    System.out.println("Unfortunately that character isn't in the word.");

                }

            }

            while(!game.gameOver());// Keep playing until the game is over


            //play again or no?
            System.out.println();
            System.out.println("Do you want to play another game?"
            + "\nEnter Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
        }


    }
}


