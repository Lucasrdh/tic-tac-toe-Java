import java.util.Scanner;

public interface InteractionUtilisateur {
    Scanner sc = new Scanner(System.in);

    default String getInput() {
        return sc.nextLine();
    }


}
