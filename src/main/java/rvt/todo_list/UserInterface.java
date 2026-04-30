package rvt.todo_list;

import java.util.*;

public class UserInterface {

    private TodoList list;
    private Scanner scanner;
    public UserInterface(TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }

    public void start(){
        while(true){
            System.out.println("Choose operation: ");
            System.out.println("1. ");
        }
    }
}
