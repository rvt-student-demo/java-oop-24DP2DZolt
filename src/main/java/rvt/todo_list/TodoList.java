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

    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add("read the course material");
        list.add("watch the latest fool us");
        list.add("take it easy");
        list.print();
        list.remove(2);
        list.print();
        list.add("buy raisins");
        list.print();
        list.remove(1);
        list.remove(1);
        list.print();
            }


}
