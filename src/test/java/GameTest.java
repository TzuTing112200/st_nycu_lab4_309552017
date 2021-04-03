import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

public class GameTest {
    public static Stream<Arguments> valid_parameters(){
        return Stream.of(
                arguments("rock", "rock", "Draw!"),
                arguments("rock", "scissors", "Player 1 win!"),
                arguments("rock", "paper", "Player 2 win!"),
                arguments("scissors", "rock", "Player 2 win!"),
                arguments("scissors", "scissors", "Draw!"),
                arguments("scissors", "paper", "Player 1 win!"),
                arguments("paper", "rock", "Player 1 win!"),
                arguments("paper", "scissors", "Player 2 win!"),
                arguments("paper", "paper", "Draw!")
        );
    }
    public static Stream<Arguments> invalid_parameters(){
        return Stream.of(
                arguments("invalid", "rock"),
                arguments("rock", "invalid"),
                arguments("invalid", "invalid"),
                arguments("", "rock"),
                arguments("rock", ""),
                arguments("", "")
        );
    }

    @ParameterizedTest
    @MethodSource("valid_parameters")
    public void game_test(String input_one, String input_two, String expected){
        Game game = new Game();
        game.enter_player_one(input_one);
        game.enter_player_two(input_two);
        assertEquals(expected, game.get_result());
    }

    @ParameterizedTest
    @MethodSource("invalid_parameters")
    public void InitialCapacityTest(String input_one, String input_two){
        assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.enter_player_one(input_one);
            game.enter_player_two(input_two);
        });
    }
}
