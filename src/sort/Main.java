package sort;

/**
 * @author 李聪
 * @date 2020/4/1 12:46
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {7,8,9,1,2,3};
        int ans = 0, anchor = 0;
        /*for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }*/

        int left = 0,right = 0;
        while(right < nums.length) {
            right ++;
            while(right < nums.length && nums[right] > nums[right - 1]) {
                right ++;
            }
            ans = Math.max(ans,right - left);
            left = right;

        }
        System.out.println(ans);


        /*ArrayList<String> arrayList = new ArrayList<>();
        String name = "\\data\\test_data.txt";
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : arrayList) {
            System.out.println(s);
        }*/
    }
}
