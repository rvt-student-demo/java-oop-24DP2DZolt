package rvt.todo_list;
import java.util.ArrayList;
public class TodoList {
    
    ArrayList<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }
    
    public void add(String add){
        tasks.add(add);
    }

    public void print(){
        for (String task : tasks) {
            System.out.println((tasks.indexOf(task) + 1) + ": " + task);
        }
    }

    public void remove(int number){
        try {
            tasks.remove(number - 1); 
        } catch (Exception e) {
            System.out.println("Number is out of range or is invalid.");
        }
        
    }


}
