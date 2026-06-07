package rvt.StudentuRegistracija;

import java.util.Scanner;

public class UserInterface {
     private final Registrate registrate = new Registrate();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(

        );
        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();
            if (command.equals("register")) {
                registrate.register();
                continue;
            } else if (command.equals("show")) {
                registrate.show();
                continue;
            } else if (command.equals("remove")) {
                registrate.remove();
                continue;
            } else if (command.equals("edit")) {
                registrate.edit();
                continue;
            } else if (command.equals("exit")) {
                break;
            } 
                else {
                System.out.println("Invalid command.");
            }
        }
    }
}
