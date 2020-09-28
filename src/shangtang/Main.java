package shangtang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/18 18:51
 */
public class Main {
    public static int n,m;
    static class Node {
        int x;
        int y;
        int key;

        public Node(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String cur = sc.nextLine();

            if(cur.equals("0 0")){
                return;
            }else {
                n = Integer.parseInt(cur.split(" ")[0]);
                m = Integer.parseInt(cur.split(" ")[1]);
            }

            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine().toCharArray();
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == 'S'){
                        if(dfs(arr,i,j,n,m)){
                            System.out.println("YES");
                        }else {
                            System.out.println("NO");
                        }
                        break;
                    }
                }
            }
        }


    }

    private static boolean dfs(char[][] map, int i, int j, int N, int M) {
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
        queue.offer(new Node(i,j,0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0;k < 4;k++) {
                int x = node.x + next[k][0];
                int y = node.y + next[k][1];
                int key = node.key;

                //如果超出边界
                if(x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 'X')
                    continue;
                //到达了
                if(map[x][y] == 'G')
                    return true;
                else if(map[x][y] <= 'z' && map[x][y] >= 'a')   //获取钥匙
                    key = key | (1 << (map[x][y] - 'a'));
                else if(map[x][y] <= 'Z' && map[x][y] >= 'A' && (key&(1<<(map[x][y] - 'A')))==0)  //没有钥匙
                    continue;
                if(!mp[x][y][key]) {
                    mp[x][y][key] = true;
                    queue.offer(new Node(x,y,key));
                }
            }
        }
        return false;

    }
}
