package HomeTask;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File file = new File("tasks.txt");

        try {
            if (!file.exists()){
                file.createNewFile();
            }
            Scanner scanner = new Scanner(System.in);
            try(BufferedWriter bw =new BufferedWriter(new FileWriter(file,true))){
                while (true) {
                    System.out.println("______TO DO LIST______");
                    System.out.println("Tapsiriq daxil edin");
                    String task= scanner.nextLine();
                    if (task.equalsIgnoreCase("exit")){
                        break;
                    }
                    if (!task.isEmpty()){
                        bw.write(task);
                        bw.newLine();
                        System.out.println("Tapsiriq elave edildi");
                    }else {
                        System.out.println("Bos tapsiriq elave edile bilmez");
                    }
                }
            }
            System.out.println("Butun tapsirirqlar");
            try(BufferedReader br =new BufferedReader(new FileReader(file))){
                String line;

                while ((line= br.readLine())!=null){
                    System.out.println(line+"  ");

                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Fayl əməliyyatında xəta baş verdi: " + e.getMessage());

        }

    }
}
