package findJob.second;

/**
 * @author 李聪
 * @date 2020/4/17 22:08
 */
public class Sing {
    private static volatile  Sing sing;

    public static Sing getInstance() {
        if(sing == null) {
            synchronized (Sing.class) {
                if(sing == null) {
                    sing = new Sing();
                }
            }
        }
        return sing;
    }
}
