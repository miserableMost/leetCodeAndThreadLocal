package hard.ByteDance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/2 20:28
 * 存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到房间pi(1<=pi<=i),现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
 *     A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
 *     B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
 * 现在路人甲想知道移动到房间n+1一共需要多少次移动；
 */
public class T4 {

    static class Node {
        int x;
        int y;
        int key;
        int step;

        public Node(int x, int y, int key, int step) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.step = step;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        char[][] map = new char[M][N];
        for(int i = 0;i < M;i ++) {
            map[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '2') {
                    System.out.println(bfs(map, i, j, M, N));
                    return;
               }
            }
        }



    }

    private static int bfs(char[][] map, int i, int j,int M,int N) {
        //定义一个位移数组
        int[][] next = {{-1,0},{0,-1},{1,0},{0,1}};
        //定义一个队列
        Queue<Node> queue = new LinkedList<>();
        //定义一个三维数组
        //所以mp[x][y][key]的意义就是 横坐标为x,纵坐标为y,钥匙状态为key的点是否访问过
        //钥匙的状态 就用二进制数表示 最多10 把钥匙 那就是1024
        //
        //看懂代码，因为钥匙是一种状态所以即使遇到门了，当继续广度搜索到钥匙的时候，有可能会再次遇到该门的，只因book[x][y][0]访问过了，但是book[x][y][1]没有访问过，这时候会将门所在位置入队列的，因为钥匙开了此门。主要是理解出book[][][]的意思
        boolean[][][] mp = new boolean[101][101][1025];//mp[x][y][key] 的判断，让(x,y,key)唯一的路径上，只走一次，很好地减小了时间复杂度
        queue.offer(new Node(i,j,0,0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0;k < 4;k++) {
                int x = node.x + next[k][0];
                int y = node.y + next[k][1];
                int key = node.key;
                //如果超出边界
                if(x < 0 || x >= M || y < 0 || y >= N || map[x][y] == '0')
                    continue;
                else if(map[x][y] == '3')
                    return node.step + 1;
                else if(map[x][y] <= 'z' && map[x][y] >= 'a')
                    key = key | (1 << (map[x][y] - 'a'));
                else if(map[x][y] <= 'Z' && map[x][y] >= 'A' && (key&(1<<(map[x][y] - 'A')))==0)
                    continue;
                if(!mp[x][y][key]) {
                    mp[x][y][key] = true;
                    queue.offer(new Node(x,y,key,node.step + 1));
                }
            }
        }
        return -1;
    }
}
