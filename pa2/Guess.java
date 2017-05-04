// Guess.java
// Quy Lam
// qlam
// pa2
// This program plays an interactive guessing game with the user.
import java.lang.Math; 
import java.util.Scanner;
import java.lang.System;
class Guess{
    public static void main(String [] args){
        int n_guess = (int)(Math.random() * 10 + 1);
	int n_tries = 1;
	Scanner sc = new Scanner(System.in);
        int guess;
	
	System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
	while (n_tries <=3){
	    if(n_tries==1){
		System.out.print("\nEnter your first guess: ");
		guess = sc.nextInt();
		if(guess == n_guess){
		    System.out.println("You win!");
		    break;
		}
		else if(guess > n_guess){
		    System.out.println("Your guess is too high.");
		    n_tries++;
		}
		else if (guess <n_guess) {
		    System.out.println("Your guess is too low.");
		    n_tries++;
		}
	    }
	    else if(n_tries==2){
		System.out.print("\nEnter your second guess: ");
		guess = sc.nextInt();
		if(guess == n_guess){
		    System.out.println("You win!");
		    break;
		}
		else if(guess > n_guess){
		    System.out.println("Your guess is too high.");
		    n_tries++;
		}
		else if (guess <n_guess) {
		    System.out.println("Your guess is too low.");
		    n_tries++;
		}
	    }
	    else if(n_tries==3){
		System.out.print("\nEnter your third guess: ");
		guess = sc.nextInt();
		if(guess == n_guess){
		    System.out.println("You win!");
		    break;
		}
		else if(guess > n_guess){
                    System.out.println("Your guess is too high.");
                    n_tries++;
                }
                else if (guess <n_guess) {
                    System.out.println("Your guess is too low.");
                    n_tries++;
                }
		System.out.println("\nYou lose. The number was " +n_guess+".");
	    }
	}
    }
}
