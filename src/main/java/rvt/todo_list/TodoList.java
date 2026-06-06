package rvt.todo_list;

import java.util.*;

public class TodoList {
    private ArrayList<String> todoList = new ArrayList<>();

    public void add(String item) {
        todoList.add(item);
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(todoList.get(i));
        }
    }

    public void remove(int index) {
        todoList.remove(index - 1);
    }

    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        UserInterface UI = new UserInterface(list, scanner);
        UI.start();
    }
}