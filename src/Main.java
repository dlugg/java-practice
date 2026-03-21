import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game.game();
    }
}

class Human {
    int score = 0;
    int choice;

    void winRound() {
        score++;
    }
}

class Computer {
    int score = 0;
    int choice;
    Random random = new Random();

    void winRound() {
        score++;
    }

    void computerChoice() {
        choice = random.nextInt(3) + 1;
    }
}

class Translator {
    static String getWord(int choice) {
        if (choice == 1) return "rock";
        if (choice == 2) return "paper";
        if (choice == 3) return "scissors";
        return "unknown";
    }
}

class Game {
    static void game() {

        Scanner sc = new Scanner(System.in);
        Human human = new Human();
        Computer computer = new Computer();
        System.out.println("Lets play a game of rock-paper-scissors");
        while (human.score < 3 && computer.score < 3) {
            System.out.print("Choose 1 for rock, 2 for paper, 3 for scissors ");
            human.choice = sc.nextInt();
            computer.computerChoice();
            System.out.println("Computer chose: " + Translator.getWord(computer.choice));
            System.out.println("Human chose: " + Translator.getWord(human.choice));
            if (human.choice == computer.choice) {
                System.out.println("Tie! Score: " + human.score + " : " + computer.score);
            } else if ((human.choice == 1 && computer.choice == 3) ||
                    (human.choice == 2 && computer.choice == 1) ||
                    (human.choice == 3 && computer.choice == 2)) {
                human.winRound();
                System.out.println("Human wins! Score: " + human.score + " : " + computer.score);
            } else {
                computer.winRound();
                System.out.println("Computer wins! Score: " + human.score + " : " + computer.score);
            }
        }
        if (computer.score == 3) {
            System.out.println("Computer wins the game! Score: " + human.score + ":" + computer.score);
        } else {
            System.out.println("Human wins the game! Score: " + human.score + ":" + computer.score);
        }


    }
}