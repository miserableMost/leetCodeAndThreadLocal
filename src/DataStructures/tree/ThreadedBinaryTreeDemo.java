package DataStructures.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "mike");
        HeroNode node6 = new HeroNode(14, "jerry");
        //二叉树---手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试线索化
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadedNodes();
        //测试：以10号节点测试
        HeroNode leftNode = node5.getLeft();
        System.out.println("10号节点的前驱节点是： "+leftNode);
        System.out.println("10号节点的后继节点是： "+node5.getRight());

        //当线索化二叉树后
        System.out.println("使用线索化的方式遍历线索化二叉树");
        binaryTree.threadedList(); //8,3,10,1,14,6
    }
}

