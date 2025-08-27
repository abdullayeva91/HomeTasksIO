package HomeTask;

import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File file= new File("contracts.csv");
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            Scanner scanner= new Scanner(System.in);
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
                while (true){
                    System.out.print("Ad daxil edin: ");
                    String name=scanner.nextLine();
                    if (name.equalsIgnoreCase("exit")){
                        break;
                    }
                    System.out.print("Telefon daxil edin: ");
                    String phone= scanner.nextLine();
                    bw.write(name+" , "+phone);
                    bw.newLine();
                    System.out.println(" Elave edildi");
                }
            }
            System.out.println("Elageler");
            try(BufferedReader br=new BufferedReader(new FileReader(file))){
                String line;
                while ((line= br.readLine())!=null){
                    if (line.isEmpty()){
                        continue;
                    }
                    String[] parts = line.split(",");
                    if (parts.length== 2){
                        String name =parts[0];
                        String phone = parts[1];
                        System.out.println("Name: "+ name +"Phone: " + phone);
                    }

                }
                scanner.close();
            }
        }catch (IOException e){
            System.out.println("Fayl əməliyyatında xəta baş verdi: " + e.getMessage());

        }

    }
}
