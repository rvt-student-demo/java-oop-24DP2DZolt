package rvt.StudentuRegistracija;

import java.io.*;
import java.util.*;
import java.time.*;

public class Registrate {
    private Table printer = new Table();
    private ArrayList<String> intermed = new ArrayList<>();
    private final String columnnames = "vards,uzvards,epasts,perskods,timestamp";
    private final Scanner scanner = new Scanner(System.in); //scanner inside the class
    private final String path = "src/main/java/streg/regdata.csv"; //path to csv
    private final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private final String perscodRegex = "^\\d{6}-\\d{5}$";
    

    public Registrate() {
     
        loadFromFile();
    }

    public void register() {
    
        System.out.println("Ievadi studenta vardu: ");
        String vards = scanner.nextLine();
        System.out.println("Ievadi studenta uzvardu: ");
        String uzvards = scanner.nextLine();
        System.out.println("Ievadi studenta e-pastu: ");
        String epasts = scanner.nextLine();
        while (!epasts.matches(emailRegex)) {
            System.out.println("Ludzu, ievadi derigo epastu!");
            epasts = scanner.nextLine();
        }
        System.out.println("Ievadi studenta personalo kodu: ");
        String perskod = scanner.nextLine();
        while (!perskod.matches(perscodRegex)) {
            System.out.println("Ludzu, ievadi derigo personalo kodu!");
            perskod = scanner.nextLine();
        }
        LocalDateTime stamp = LocalDateTime.now();
        new Student(vards, uzvards, epasts, perskod, stamp);
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println(vards + "," + uzvards + "," + epasts + "," + perskod + "," + stamp);
        }
        catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void show() {
  
        try {
            printer.printTable(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarray() {
     
        for (int i = 0; i < intermed.size(); i++) {
            System.out.println(intermed.get(i));
        }
    }

    public void remove() {

        int id = -1;
        System.out.print("Ievadi studenta personalo kodu: ");
        String perskod = scanner.nextLine();
        for (int i = 0; i < intermed.size(); i++) {
            String[] parts = intermed.get(i).split(",");
        
            if (parts.length > 3 && parts[3].trim().equals(perskod)) {
               id = i;
               break;
            }
        }
        if (id == -1) {
            System.out.println("Students neatrasts.");
            return;
        }

        System.out.println("Dzest studentu? Y/n");
        String YorN = scanner.nextLine();
        if (YorN.equals("y") || YorN.equals("Y")) {
            intermed.remove(id);
            uploadToFile();
            System.out.println("Students dzēsts");
        } else if (YorN.equals("n") || YorN.equals("N")) {
            System.out.println("Dzēšanas operācija atcelta");
        } else {
            System.out.println("Nepareiza izvele");
        }
    }

    public void edit() {
        
        int id = -1;
        System.out.print("Ievadi studenta personalo kodu: ");
        String perskod = scanner.nextLine();
        for (int i = 0; i < intermed.size(); i++) {
            String[] parts = intermed.get(i).split(",");
        
            
            if (parts.length > 3 && parts[3].trim().equals(perskod)) {
               id = i;
               break;
            }
        }
        if (id == -1) {
            System.out.println("Students neatrasts.");
            return;
        }
        
        System.out.println("Vai esat parliecinati? Y/n");
        String YorN = scanner.nextLine();
        if (YorN.equals("y") || YorN.equals("Y")) {
            intermed.remove(id);
            uploadToFile();
            System.out.println("Ievadi jaunus datus");
            register();
        } else if (YorN.equals("n") || YorN.equals("N")) {
            System.out.println("Rediģēšanas operācija atcelta");
        } else {
            System.out.println("Nepareiza izvele");
        }
    }

    private void loadFromFile() {
      
        String line;
        boolean isHeader = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                if (!line.trim().isEmpty()) {
                    intermed.add(line.trim());
                }
            }
            br.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    private void uploadToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {

            pw.println(columnnames);

            for (String line : intermed) {
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}