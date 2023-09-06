
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        ArrayList<String> stats = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String file = scan.nextLine();

        try ( Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                stats.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        int gp = 0;
        System.out.println("Team:");
        String team = scan.nextLine();
        for (String stat : stats) {
            if (stat.contains(team)) {
                gp++;
            }
        }
        System.out.println("Games: " + gp);
    }
}
