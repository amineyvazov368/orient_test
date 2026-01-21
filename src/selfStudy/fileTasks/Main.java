package selfStudy.fileTasks;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Amin");
        list.add("Bam");
        list.add("Cam");
        list.add("Lam");
        list.add("Yam");
        list.add("Vam");

        String fileName = "C:\\Users\\ASUS\\NewProject\\amin.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));) {
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
            System.out.println("Fayla yazildi ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            System.out.println("Fayldan oxunanan datalar: ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
