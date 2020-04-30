package hard.ByteDance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/4 17:34
 *  有一个推箱子的游戏, 一开始的情况如下图:
 *
 * 上图中, '.' 表示可到达的位置, '#' 表示不可到达的位置，其中 S 表示你起始的位置, 0表示初始箱子的位置, E表示预期箱子的位置，你可以走到箱子的上下左右任意一侧, 将箱子向另一侧推动。如下图将箱子向右推动一格;
 *
 * ..S0.. -> ...S0.
 *
 * 注意不能将箱子推动到'#'上, 也不能将箱子推出边界;
 *
 * 现在, 给你游戏的初始样子, 你需要输出最少几步能够完成游戏, 如果不能完成, 则输出-1。
 */
public class T7_推箱子 {

    public static class Node{
        int x;
        int y;
        int bx;
        int by;
        int step;
        public Node(int x,int y,int bx,int by){
            this.x=x;
            this.y=y;
            this.bx=bx;
            this.by=by;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().toCharArray();
        }
        int startX = 0,startY = 0,boxX = 0,boxY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(chars[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if(chars[i][j] == '0') {
                    boxX = i;
                    boxY = j;
                }
            }
        }
        System.out.println(bfs(chars,startX,startY,boxX,boxY));

    }


    private static int bfs(char[][] chas,int startX, int startY,int boxX,int boxY) {
        Node start=new Node(startX, startY,boxX,boxY);
        int n=chas.length;
        int m=chas[0].length;
        boolean[][][][] isVisted=new boolean[n][m][n][m];

        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Node> queue=new LinkedList<>();
        start.step=0;
        queue.add(start);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            int newBx=cur.bx;
            int newBy=cur.by;
            for(int i=0;i<4;i++){
                //在箱子上面或下面----newBx,newBy表示此时箱子的位置
                if(cur.y==cur.by){   //首先确定在同一列
                    newBx=cur.x+dir[i][0]==cur.bx?cur.bx+dir[i][0]:cur.bx;
                }
                //在箱子左边或右边
                if(cur.x==cur.bx){   //首先确定在同一行
                    newBy=cur.y+dir[i][1]==cur.by?cur.by+dir[i][1]:cur.by;
                }
                Node next=new Node(cur.x+dir[i][0], cur.y+dir[i][1],newBx,newBy);
                if(next.x<0||next.x>=n||next.y<0||next.y>=m||chas[next.x][next.y]=='#'
                        ||next.bx<0||next.bx>=n||next.by<0||next.by>=m
                        ||chas[next.bx][next.by]=='#'){   //箱子或自己遇到阻碍
                    continue;
                }
                if(!isVisted[next.x][next.y][next.bx][next.by]){
                    isVisted[next.x][next.y][next.bx][next.by]=true;
                    next.step=cur.step+1;
                    if(chas[next.bx][next.by]=='E'){
                        return next.step;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
