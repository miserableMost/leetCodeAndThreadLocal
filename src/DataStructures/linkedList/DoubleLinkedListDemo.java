package DataStructures.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
         //测试
        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2= new HeroNode2(2, "吴用", "智多星");
        HeroNode2 hero3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 hero4 = new HeroNode2(4, "李聪", "牛");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","我的");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表
class DoubleLinkedList {
    //初始化一个头节点
    private HeroNode2 head = new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }
    //添加
    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            temp = temp.next;

        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改链表，可以看到双向链表的修改跟单向链表一样
    public void update(HeroNode2 newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;  //已经遍历完链表
            }
            if(temp.no == newHeroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据falg判断是否与找到需要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{//没有找到
            System.out.println("没有找到编号节点");
        }
    }
    //从双向链表删除一个节点
    //对于双向链表，可以直接找到要删除的这个节点
    public void del(int no){
        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                //已经到链表的最后
                break;
            }
            if(temp.no == no){
                //找到的待删除的节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;   //temp后移，遍历
        }
        //判断flag
        if(flag){//找到
            //可以删除
            //temp.next = temp.next.next; 单向的
            temp.pre.next = temp.next;
            //这里我们的代码有问题
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.println("要删除的节点没找到，删除失败");
        }
    }

    //显示链表【遍历】
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我么需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while(true){
            //判断列表是否到链表最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;  //指向前一个节点,默认为null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
