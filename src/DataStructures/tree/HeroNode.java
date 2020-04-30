package DataStructures.tree;

//先创建HeroNode节点
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //说明
    //1.如果leftType==0便是指向的是左子树，如果1则便是指向前驱节点
    //2.如果rightType==0表示得是右子树，如果1则便是指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //递归删除节点
    //1.如果删除的节点是叶子结点，则删除节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        //思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */
        //2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //4.我们需要向左子树进行递归
        if(this.left != null){
            this.left.delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if(this.right != null){
            this.right.delNode(no);
        }
    }


    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树遍历
        if(this.left != null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树遍历
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        //递归向左子树遍历
        if(this.left != null){
            this.left.postOrder();
        }
        //递归向右子树遍历
        if(this.right != null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }
    //前序遍历查找

    /**
     *
     * @param no  查找no
     * @return   没有则返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        //比较当前节点
        if(this.no == no) {
            return this;
        }
        //则判断当前节点的左子节点是否为空，不为空，则递归前序查找
        //2.左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            //说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到节点，否则继续判断，当前的节点的右子节点是否为空
        //2.如果不空，则继续向右递归前序查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    ///中序查找
    public HeroNode infixOrderSearch(int no) {
        //判断当前节点的左子节点是否为空，不为空则递归中序查找
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("进入中序查找");
        //如果找到则返回，没有就和当前节点比较
        if(this.no == no){
            return this;
        }
        //否则继续进行右递归的中序查找
        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        //判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前节点是不是
        if(this.no == no){
            return this;
        }
        return resNode;
    }

}
