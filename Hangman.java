
//Name: Jessie

import java.util.Scanner;

public class Hangman {
	private String wordToGuess = "test", wordSoFar = "";
	private String guessedAlready = "", wrongGuesses = "";
	private int manCounter = 0;
	private String game;
	private boolean win;

	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.game();
	}
	public void game() {
		intro();
		guessLetters();
	}

	public void intro() {
//		banner
		System.out.println("welcome to...");
		System.out.println("\n" + "                                                     \n"
				+ "  /\\  /\\ __ _  _ __    __ _  _ __ ___    __ _  _ __  \n"
				+ " / /_/ // _` || '_ \\  / _` || '_ ` _ \\  / _` || '_ \\ \n"
				+ "/ __  /| (_| || | | || (_| || | | | | || (_| || | | |\n"
				+ "\\/ /_/  \\__,_||_| |_| \\__, ||_| |_| |_| \\__,_||_| |_|\n"
				+ "                      |___/                          \n" + "");
		
//enters wordToGuess, resets variables		
		Scanner scan = new Scanner(System.in);
		System.out.println("There are two players.\nPlayer 1 sets the word for Player 2 to guess.\nPlayer 1, enter the word: ");
		wordToGuess = scan.nextLine().toLowerCase();
		wordSoFar = "";
		guessedAlready = "";
		wrongGuesses = "";
		manCounter = 0;
		
//actually starts		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPlayer 2, time to play!");
		theMan();
		System.out.println("~each dash represents a letter~\n");
		System.out.println("word so far: " + makeDashes() + "\n");

	}

	public String makeDashes() {

		for (int i = 0; i < wordToGuess.length(); i++) {
			wordSoFar += "-";

		}

		return wordSoFar;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void guessLetters() {
		Scanner scan = new Scanner(System.in);
//guessing word part
		while (!wordSoFar.equals(wordToGuess)) {
			System.out.print("guess a letter: ");

			String letter = scan.next().charAt(0) + "";
			letter = letter.toLowerCase();

			int i = wordToGuess.indexOf(letter);
			String checkmultiple = wordToGuess;
			boolean hasletter = checkmultiple.contains(letter);
		
			
			// checking if you've guessed that letter already
			if (guessedAlready.contains(letter)) {
				System.out.println("you've guessed that already!");
			} else {
				if (hasletter == false) {
					wrongGuesses += letter;
					manCounter++;
					theMan();
					System.out.println(letter + " is incorrect :(");

				}

				for (; hasletter == true; hasletter = checkmultiple.contains(letter)) {
					if (i > -1) {
						wordSoFar = wordSoFar.substring(0, i) + letter + wordSoFar.substring(i + 1);
						checkmultiple = wordToGuess.substring(i + 1);
						i = wordSoFar.lastIndexOf(letter) + checkmultiple.indexOf(letter) + 1;
						guessedAlready += letter;
					}
				
				}
				
				System.out.println("\nword so far: " + wordSoFar + "\n\nwrong guesses: " + wrongGuesses);

			}
		}
		if (wordSoFar.equals(wordToGuess)) {
		win = true;
		}

// 		game over process:
		gameOver();
		
		scan.close();

	}

	public void theMan() {
		switch (manCounter) {
		case 0: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|       	    \n" +
				"		|     			\n" +
				"		|      			\n" +
				"		|       		\n" +
				"		|   			\n" +
				"		|       		\n" +
				"		|      			\n" +
				"		|     			\n" +
				"		|     			\n" +
				"		|				\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"

			);

						break;
		case 1: System.out.println(
			"		---------		\n" +
			"		|       |		\n" +
			"		|      .-. 	    \n" +
			"		|     |   |		\n" +
			"		|      '-'		\n" +
			"		|       		\n" +
			"		|   			\n" +
			"		|       		\n" +
			"		|  	    		\n" +
			"		|  			   	\n" +
			"		|  		   		\n" +
			"		|				\n" +
			"		|				\n" +
			"		|				\n" +
			"	   -----------		\n"
	
			);

			break;
		case 2: System.out.println(
			"		---------		\n" +
			"		|       |		\n" +
			"		|      .-. 	    \n" +
			"		|     |   |		\n" +
			"		|      '-'		\n" +
			"		|       |		\n" +
			"		|   	|		\n" +
			"		|       |		\n" +
			"		|       		\n" +
			"		|     	   		\n" +
			"		|        		\n" +
			"		|				\n" +
			"		|				\n" +
			"		|				\n" +
			"	   -----------		\n"
		
				);

				break;		
			
		case 3: System.out.println(
			"		---------		\n" +
			"		|       |		\n" +
			"		|      .-. 	    \n" +
			"		|     |   |		\n" +
			"		|      '-'		\n" +
			"		|       |		\n" +
			"		|   ----|		\n" +
			"		|       |		\n" +
			"		|       		\n" +
			"		|        		\n" +
			"		|        		\n" +
			"		|				\n" +
			"		|				\n" +
			"		|				\n" +
			"	   -----------		\n"
		
				);

				break;
		case 4: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|   ----|----	\n" +
				"		|       |		\n" +
				"		|       		\n" +
				"		|         		\n" +
				"		|        		\n" +
				"		|				\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);
			break ;
		case 5: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|  o----|----	\n" +
				"		|       |		\n" +
				"		|       		\n" +
				"		|         		\n" +
				"		|        		\n" +
				"		|				\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);
				break;
		case 6: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|  o----|----o	\n" +
				"		|       |		\n" +
				"		|       		\n" +
				"		|         		\n" +
				"		|        		\n" +
				"		|				\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);
				break;		
		case 7: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|  o----|----o	\n" +
				"		|       |		\n" +
				"		|      / 		\n" +
				"		|     /   		\n" +
				"		|     |   		\n" +
				"		|				\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);

				break;
		case 8: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|  o----|----o	\n" +
				"		|       |		\n" +
				"		|      / \\		\n" +
				"		|     /   \\	\n" +
				"		|     |   |		\n" +
				"		|    			\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);
			break;
		case 9: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|  o----|----o	\n" +
				"		|       |		\n" +
				"		|      / \\		\n" +
				"		|     /   \\	\n" +
				"		|     |   |		\n" +
				"		|    ==			\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);

				break;

		default: System.out.println(
				"		---------		\n" +
				"		|       |		\n" +
				"		|      .-. 	    \n" +
				"		|     |   |		\n" +
				"		|      '-'		\n" +
				"		|       |		\n" +
				"		|  o----|----o	\n" +
				"		|       |		\n" +
				"		|      / \\		\n" +
				"		|     /   \\	\n" +
				"		|     |   |		\n" +
				"		|    ==	  ==	\n" +
				"		|				\n" +
				"		|				\n" +
				"	   -----------		\n"
		
				);
		win = false;	
		gameOver();
			
		}

	}
	
	public void yesNo() {
		Scanner scan2 = new Scanner(System.in);
		System.out.println("play again? [y/n]: ");
		game = scan2.nextLine();
		if (game.equals("y")) {
			game();
		}
		if (game.equals("n")) {
			System.out.println("thanks for playing!");
			System.exit(0);
		}
		
	}
	
	public void gameOver() {
		if (win) {
			System.out.println("\nyou've got it! The word is "+ wordToGuess +"!\n");
		}
		if (win == false) {
			System.out.println("the man has been hanged. funeral will take place next wednesday.\n");
		}
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("GAME OVER\n");
		System.out.println("play again? [y/n]: ");
		game = scan2.nextLine();
		
		if (game.equals("y")) {
			game();
		}
		if (game.equals("n")) {
			System.out.println("thanks for playing!");
			System.exit(0);
		}
		else {
			yesNo();
		}
		scan2.close();
	}
	
}
