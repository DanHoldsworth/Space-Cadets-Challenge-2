import java.io.*;
import java.util.*;

public class BareBonesInterpreter {
    public static void main(String[] args) {
        String currentLine;
        String[] splitLine;

        try {
            File program = new File("program.txt");
            Scanner reader = new Scanner(program);
            while (reader.hasNextLine()) {
                currentLine = reader.nextLine();
                splitLine = currentLine.split(" ");
                for (int i=0; i<splitLine.length; i++) {
                    System.out.println(splitLine[i]);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}