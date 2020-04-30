package Algorithm.kmp;

public class kmp {
    public static void main(String[] args) {
        //测试暴力匹配算法
        String s1 = "火影忍者火影火影";
        String s2 = "忍者";
        int index = violenceMath(s1,s2);
        System.out.println("索引是： "+index);
    }

    //暴力匹配算法实现
    public static int violenceMath(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;  //i索引指向s1
        int j = 0;  //j索引指向s2
        while(i < s1Len && j < s2Len){
            //保证检索时不越界
            if(s1[i] == s2[j]){
                //匹配成功
                i ++;
                j ++;
            }else{
                //没有匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if(j == s2Len){
            return i - j;
        }else{
            return -1;
        }
    }
}
