import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner sc) {
        System.out.println("Enter file path :");
        String path = sc.nextLine();
        Path filePath = Paths.get(path);
        try {
            String content = Files.readString(filePath);
            String[] line_list = content.split("\n");
            for (int line = 0; line < line_list.length; line++) {
                String[] mot = {"","",""};
                int[] maxi_occur = {0,0,0};
                String[] lineSplit = line_list[line].split(" ");
                Arrays.sort(lineSplit);
                int count = 1;
                for (int i = 1; i <= lineSplit.length - 1; i++) {
                    if (lineSplit[i].equals(lineSplit[i - 1]) && i != lineSplit.length - 1) {
                        count += 1;
                    } else {
                        int minimum = maxi_occur[0];
                        int indice = 0;
                        for (int j = 0; j < maxi_occur.length; j++) {
                            if (maxi_occur[j] < minimum) {
                                minimum = maxi_occur[j];
                                indice = j;
                            }
                        }
                        maxi_occur[indice] = count;
                        mot[indice] = lineSplit[i - 1];
                        count = 1;
                    }
                }
                System.out.println("3 mots les plus fréquents à la ligne " + line + " : " + mot[0] + "," + mot[1] + "," + mot[2]);
            }
        }
        catch(IOException e) {
            System.out.println("Unreadable file: " + e);
            return false;
        }
        return true;
    }
}
