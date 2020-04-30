package DataStructures.tree;

 //定义BinaryTree二叉树
public class BinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建指向当前节点的前驱节点的指针
    //在递归进行线索化是，pre总是保留前一个节点
     private HeroNode pre = null;
    public void setRoot(HeroNode root){
        this.root = root;
    }
    //遍历线索化二叉树的方法
     public void threadedList(){
        //定义一个变量，存储当前遍历的节点，从root开始
         HeroNode node = root;
         while(node != null){
             //循环找到leftType=1的节点,第一个就是8节点
             //后面随着遍历而变化，当leftType==1时，说明该节点是按照线索化处理后的有效节点
             while(node.getLeftType() == 0){
                 node = node.getLeft();
             }
             //打印当前节点
             System.out.println(node);
             //如果当前节点的右指针指向的是后继节点，就一直输出
             while(node.getRightType() == 1){
                 //获取当前节点的后继节点
                 node = node.getRight();
                 System.out.println(node);
             }
             //替换这个遍历的节点
             node = node.getRight();

         }
     }





    //重载一把threadedNodes方法
     public void threadedNodes(){
        this.threadedNodes(root);
     }
    //编写对二叉树中序线索化的方法

     /**
      *
      * @param node 就是当前线索化的节点
      */
     public void threadedNodes(HeroNode node){
         //如果node==null,不能线索化
         if(node == null){
             return;
         }
         //先线索化左子树
         threadedNodes(node.getLeft());
         //线索化当前节点(有点难度)
         //先处理当前节点的前驱节点
         if(node.getLeft() == null){
             //让当前节点的左子针指向前驱节点
             node.setLeft(pre);
             //修改当前几点的左子针的类型，指向前驱节点
             node.setLeftType(1);
         }
         //再处理后继节点
         if(pre!=null && pre.getRight() == null){
             //让前驱节点的右指针指向当前节点
             pre.setRight(node);
             //修改当前节点的右指针类型
             pre.setRightType(1);
         }
         //每处理一个节点，让前驱节点是下一个节点的前驱节点
         pre = node;
         //线索化右子树
         threadedNodes(node.getRight());
     }
    //删除节点
    public void delNode(int no){
        if(root != null){
            //如果只有一个root，这里立即判断root是否就是要删除的节点
            if(root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else{
            System.out.println("空树无法删除");
        }

    }
    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序遍历
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    //中序遍历
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    //后序遍历
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return this.root.postOrderSearch(no);
        }else{
            return null;
        }
    }
}
