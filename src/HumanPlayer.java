import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HumanPlayer extends Player implements InteractionUtilisateur {

    public HumanPlayer(String name, String representation) {
        super(name, representation);
    }

    @Override
    public int[] makeMove(Menu menu,Cell[][] grid) {
        int[] coordonnees = new int[2];
        boolean validInput = false;
        String regex = "[1-3] [1-3]";
        while (!validInput) {

            menu.howtoPlay();
            String input = getInput();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                String[] parts = input.split(" ");
                coordonnees[0] = Integer.parseInt(parts[0]) - 1;
                coordonnees[1] = Integer.parseInt(parts[1]) - 1;
                validInput = true;
            } else {
                menu.invalide();
            }
        }
        return coordonnees;
    }
}
