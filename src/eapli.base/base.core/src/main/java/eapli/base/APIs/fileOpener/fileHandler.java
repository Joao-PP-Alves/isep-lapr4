package eapli.base.APIs.fileOpener;

import eapli.base.grammars.FormValidator;

import java.io.*;

public class fileHandler {

    public static String fileReader(String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            System.out.println("File Found");
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println("Closing File");
            reader.close();

            return stringBuilder.toString();
        } catch (IOException io){
            System.out.println(io);
        }
        return "FILE NOT FOUND";
    }

    public static void fileWriter(String path, String text){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);
            writer.close();
        } catch (IOException io){
            System.out.println(io);
        }
    }
}
