package DataStructures.linkedList;

import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode hero4 = new HeroNode(4, "李聪", "牛");
        SingleLinkedListDemo single = new SingleLinkedListDemo();
        //加入
        single.addByOrder(hero1);
        single.addByOrder(hero4);
        single.addByOrder(hero3);
        single.addByOrder(hero2);

        //显示
        single.list();
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小路", "玉麒麟");
        single.update(newHeroNode);
        System.out.println("修改之后");
        single.list();
        //测试删除
        single.del(1);
        System.out.println("删除后....");
        single.list();
        //测试一下
        System.out.println("有效节点的个数："+getLength(single.getHead()));
        //测试一下看看是否得到了倒数第k个节点
        HeroNode res = findLastIndexNode(single.getHead(), 1);
        System.out.println(res);
        //测试一下单链表的反转功能
        System.out.println("原来链表的情况");
        single.list();
        System.out.println("反转单链表~");
        reversetList(single.getHead());
        single.list();
        //测试一下逆序打印单链表
        System.out.println("测试逆序打印单链表...没有改变链表本身的结构");
        reversePrint(single.getHead());
    }
    //思路：
    //1.方式一：先将单链表进行反转，再遍历，这样做的问题是会破坏原来的单链表的结构，不建议
    //2.方式二：可以利用栈数据结构，将各个节点压入栈中，利用栈先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;   //空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while(cur != null){
            stack.push(cur);
            cur = cur.next; // 让cur后移
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0){
            System.out.println(stack.pop()); //stack的特点是先进后出
        }
    }



    //腾讯面试题：单链表反转
    //思路:
    //1.先定义一个节点 reverseHead = new HeroNode();
    //2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的前端
    //3.原来的链表的head.next = reverseHead.next;
    public static void reversetList(HeroNode head){
        //如当前链表为空，或者只有一个节点,直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点的下一个节点
        HeroNode reversrHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出
        //动脑筋
        while (cur != null){
            next = cur.next;   //先暂时保存当前节点的下一个节点，因为后面需要使用
            //这里相当于一个插入的操作
            cur.next = reversrHead.next;  //将cur的下一个节点指向新的链表的最前端
            reversrHead.next = cur; //将cur连接到新的链表上
            cur = next; //让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reversrHead.next;
    }





    //新浪面试题：查询单链表的倒数第k个结点
    //思路
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index表示是倒数第index的结点
    //3.先把链表从头到尾遍历，获得总的长度
    //4.得到size后，我们从链表的第一个开始遍历(size-index)个，就可以得到
    //5.如果找到了，则返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if(head.next == null){
            return null;
        }
        //第一次遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历 size-index位置，就是我们倒数的第k个节点
        //先做一个index的校验
        if(index <= 0 || index > size){
            return null;
        }
        //定义一个辅助变量,for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }




    //方法: 获取单链表的节点的个数（如果是带头节点的链表，要求不统计头节点）
    //head 链表的头节点，返回的就是有效节点的个数
    public static int getLength(HeroNode head){
        if(head.next == null){
            //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量
        HeroNode cur = head.next;  //没有统计头节点
        while(cur != null){
            length ++;
            cur = cur.next;  //遍历
        }
        return length;
    }

}

//定义一个singleLinkedList 管理我们的英雄
class  SingleLinkedListDemo{
    //先初始化有个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");
    //返回头节点
    public HeroNode getHead(){
        return  head;
    }
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            temp = temp.next;

        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后的这个节点的next指向新的节点
        temp.next = heroNode;
    }
    //第二种添加英雄时，根据编号插入
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，仍然需要一个辅助指针
        //temp位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;   //标志添加的编号是否存在，默认为false
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){ //位置找到，就在temp后面插入
                break;

            }else if(temp.next.no == heroNode.no){//说明希望添加的编号已经存在
                flag = true;
                break;

            }
            temp = temp.next;  //后移，遍历当前链表
        }
        //判断flag的值
        if(flag){  //不能添加，说明编号存在
            System.out.println("准备添加的英雄的编号已经存在");
        }else{
            //添加到temp后边
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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

    //删除节点的代码
    //1.思路
    //1.Head不能动，因此我们需要一个temp辅助节点找到待删除的前一个节点
    //2.说明我们在比较时，时temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                //已经到链表的最后
                break;
            }
            if(temp.next.no == no){
                //找到的待删除的节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;   //temp后移，遍历
        }
        //判断flag
        if(flag){//找到
            //可以删除
            temp.next = temp.next.next;
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
        HeroNode temp = head.next;
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

//定义heroNode,每个heroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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
