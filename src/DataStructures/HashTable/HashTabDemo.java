package DataStructures.HashTable;

import java.util.Scanner;

/**
 * 谷歌上机题 新的员工来报道
 */
public class HashTabDemo {
    public static void main(String[] args) {
         //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找用户");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpByTd(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                 default:
                     break;
            }
        }
    }
}
//创建HashTable 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size; //便是公有多少条链表
    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //?留一个坑,这是不要忘了初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp) {
        //根据员工的id,得到该员工添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);

    }
    //遍历所有的链表，遍历hashTable
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    //根据输入的id，查找雇员
    public void findEmpByTd(int id){
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null){
            //找到
            System.out.printf("在第%d条链表中找到雇员id=%d\n",(empLinkedListNO+1),id);
        }else{
            System.out.println("没有找到");
        }

    }
    //编写散列函数
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;  //next默认为null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//创建EmpLinkedList,表示链表
class EmpLinkedList {
    //头指针，我们第一个Emp,因此我们这个链表的head是直接指向第一个Emp
    private Emp head;  //默认为空
    //添加员工到雇员
    //说明
    //1.假定，当添加雇员时，id时自增长，即id的分配总是从小到大
    //因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if(head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                //说明到链表最后
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将temp加入链表
        curEmp.next = emp;
    }
    //遍历链表的雇员信息
    public void list(int no){
        if(head == null){
            //说明链表为空
            System.out.println("第"+(no+1)+"当前链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"链表的信息为:");
        Emp curEmp = head;   //辅助指针
        while(true){
            System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null){
                //说明curEmp已经是最后的节点
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    //根据id查找雇员
    //如果查找到，就返回Emp,如果没有找到，就返回null
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
       }
        //辅助指针
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                //找到
                break;
            }
            //退出
            if(curEmp.next == null){
                //说明遍历当前链表没有找到该雇员
                return null;
            }
            curEmp = curEmp.next; //以后
        }
        return curEmp;
    }


}





