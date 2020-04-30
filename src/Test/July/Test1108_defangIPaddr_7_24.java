package Test.July;

/**
 * leetCode 1108:IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class Test1108_defangIPaddr_7_24 {

    public static void main(String[] args) {
        String s = defangIPaddr("1.1.1.1");
        System.out.println(s);
    }
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.')
                sb.append("[.]");
            else
                sb.append(address.charAt(i));
        }
        return sb.toString();
    }
}
