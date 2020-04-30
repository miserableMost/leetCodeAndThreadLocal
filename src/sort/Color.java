package sort;

/**
 * @author 李聪
 * @date 2020/4/21 22:47
 */
public enum Color {
    RED("红色",1),GREEN("绿色",1);
    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
