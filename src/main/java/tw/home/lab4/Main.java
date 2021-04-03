import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        game.enter_player_one(scanner.next());
        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        game.enter_player_two(scanner.next());

        System.out.println(game.get_result());
    }
}
