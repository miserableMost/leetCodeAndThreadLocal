package DataStructures.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
         //先创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");
        //说明：我们先创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //测试
     /*   System.out.println("前序遍历");  //1,2,3,5,4
        binaryTree.preOrder();
        //测试
        System.out.println("中序遍历");  //2,1,5,3,4
        binaryTree.infixOrder();
        //测试
        System.out.println("后序遍历");  //2,5,4,3,1
        binaryTree.postOrder();*/

        //前序遍历
        //前序遍历的次数:4
        System.out.println("前序遍历方式");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了,信息为no=%d name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找打no=%d的英雄",5);
        }
        //中序遍历
        //中序遍历次数：3
      /*  System.out.println("中序遍历方式");
        HeroNode resNode = binaryTree.infixOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了,信息为no=%d name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找打no=%d的英雄",5);
        }*/
        //后序遍历查找
        //后序遍历次数： 2
      /*  System.out.println("后序遍历方式");
        HeroNode resNode = binaryTree.postOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了,信息为no=%d name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找打no=%d的英雄",5);
        }*/

     /*   System.out.println("删除前,前序遍历");
        binaryTree.preOrder(); //  1,2,3,5,4
        binaryTree.delNode(5);
        //binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); // 1,2,3,4*/
    }
}




