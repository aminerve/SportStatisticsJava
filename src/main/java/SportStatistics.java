
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        ArrayList<String> stats = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String file = scan.nextLine();
        System.out.println("Team:");
        String team = scan.nextLine();
        int gp = 0;
        int wins = 0;
        int losses = 0;

        try ( Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                String[] parts = line.split(",");
                String teamName = parts[0];
                String oppName = parts[1];
                int teamScore = Integer.valueOf(parts[2]);
                int oppScore = Integer.valueOf(parts[3]);

                if (teamName.equals(team)) {
                    gp++;
                    if (teamScore > oppScore) {
                        wins++;
                    }else{
                        losses++;
                    }
                }
                if (oppName.equals(team)){
                    gp++;
                    if (oppScore > teamScore){
                        wins++;
                    }else{
                        losses++;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Games: " + gp);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
