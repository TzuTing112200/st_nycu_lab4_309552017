public class Game {
    // rock is 0, scissors is 2, paper is 5
    private int player_one;
    private int player_two;

    public Game() {}

    public int map_choice(String choice)
    {
        if(choice.equals("rock"))
            return 0;
        if(choice.equals("scissors"))
            return 2;
        if(choice.equals("paper"))
            return 5;

        throw new IllegalArgumentException("Bad Choice!");
    }

    public void enter_player_one(String choice)
    {
        player_one = map_choice(choice);
    }

    public void enter_player_two(String choice)
    {
        player_two = map_choice(choice);
    }

    public String get_result()
    {
        if(player_one == 0)
        {
            if(player_two == 0)
                return "Draw!";
            if(player_two == 2)
                return "Player 1 win!";
            if(player_two == 5)
                return "Player 2 win!";
        }

        if(player_one == 2)
        {
            if(player_two == 0)
                return "Player 2 win!";
            if(player_two == 2)
                return "Draw!";
            if(player_two == 5)
                return "Player 1 win!";
        }

        if(player_one == 5)
        {
            if(player_two == 0)
                return "Player 1 win!";
            if(player_two == 2)
                return "Player 2 win!";
            if(player_two == 5)
                return "Draw!";
        }

        return "Error";
    }
}
