package Test.August;

public class D2_lengthOfLastWord_58 {

    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {

        if(s.trim() == null)
            return 0;
        String[] s1 = s.split(" ");
        int len = s1.length;
        if(len < 1)
            return 0;
        return s1[len - 1].length();
    }
}
