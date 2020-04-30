package Test.July;

public class Test1009_bitwiseComplement_7_23 {

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(10));
    }
    public static int bitwiseComplement(int N) {
        String n = Integer.toBinaryString(N);
       /* StringBuilder sb = new StringBuilder(n);
        //逐位进行反转
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == '1') {
                sb.replace(i,i + 1,'0'+"");
            }
            if(n.charAt(i) == '0') {
                sb.replace(i,i + 1,'1'+"");
            }
        }
        String s = sb.toString();
        Integer integer = Integer.valueOf(s, 2);
        return integer;*/
        int length = n.length();
        return (int) (Math.pow(2,Integer.toBinaryString(N).length()) - 1 - N);
    }
}
