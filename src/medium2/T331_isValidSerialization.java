package medium2;

/**
 * @author 李聪
 * @date 2019/12/13 18:12
 * leetCode 331:验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 *
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 */
public class T331_isValidSerialization {
    public static void main(String[] args) {

    }
    public boolean isValidSerialization(String preorder) {
        String[]temp = preorder.split(",");
        if(temp[0].equals("#")&&temp.length==1) return true;
        if(temp[0].equals("#")||temp.length%2==0) return false;
        int count = 1;
        for(int i =0;i<temp.length;i++) {
            //只要保证初度和入度相等即可，读一个不管是否为数字就应该-1，如果为数字就表示可以有两个孩子+2
            count--;
            if(count<0) return false;
            if(!temp[i].equals("#"))
                count+=2;
        }
        return count == 0;
    }
}
