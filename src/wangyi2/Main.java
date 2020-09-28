package wangyi2;

/**
 * @author 李聪
 * @date 2020/9/11 16:42
 */
/*
public class Main {
    List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        String A = sc.nextLine();
        String B = sc.nextLine();
        boolean[] vistied = new boolean[N];
        char[] bArray = B.toCharArray();
        int[] num = new int[N];

        for (int i = 0; i < bArray.length; i++) {
            num[i] = Integer.valueOf(bArray[i] - '0');
        }
        Arrays.sort(num);
        dfs(num,0,new Stack<Integer>(),vistied);

    }

    private static void dfs(int[] nums, int index, Stack<Integer> stack,boolean[] vistied) {
        if(sb.length() == arr.length){
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(vistied[i])
                continue;
            if(i > 0 && arr[i] == arr[i - 1]  && !vistied[i - 1]){
                continue;
            }

            sb.append(arr[i]);
            vistied[i] = true;
            dfs(ans,arr,sb,vistied);
            vistied[i] = false;
            sb = new StringBuilder(sb.substring(0,sb.length() - 1));


        }
    }
}
*/
