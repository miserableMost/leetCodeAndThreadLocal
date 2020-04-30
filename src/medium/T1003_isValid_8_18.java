package medium;

public class T1003_isValid_8_18 {
    public static void main(String[] args) {

    }
    public boolean isValid(String S) {
        while(S.contains("abc")){
            S = S.replace("abc","");
        }
        return S.equals("");
    }
}
