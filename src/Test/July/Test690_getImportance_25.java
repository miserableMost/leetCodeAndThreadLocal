package Test.July;

import Test.July.util.Employee;

import java.util.ArrayList;
import java.util.List;

public class Test690_getImportance_25 {
    int importance = 0;
    public static void main(String[] args) {

    }

    public  int getImportance(List<Employee> employees, int id) {

        setImportance(employees,id);


        return importance;
    }

    public void setImportance(List<Employee> employees, int id){
        //记录重要度

        //记录下属
        List<Integer> sub = new ArrayList<>();
        for (Employee e : employees) {
            if(e.id == id){
                sub = e.subordinates;
                importance += e.importance;
                break;
            }
        }
       /* for (Integer su : sub) {
            for (Employee e : employees) {
                if(su == e.id){
                    importance += e.importance;
                }
            }
        }*/
       //递归的求下属的重要度
        for (Integer su : sub) {
            getImportance(employees,su);
        }

    }

}
