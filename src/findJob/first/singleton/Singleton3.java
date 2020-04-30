package findJob.first.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式：不存在线程安全
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;
    static {
        try {
            Properties pro = new Properties();
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private Singleton3(String info) {
        this.info = info;
    }

    public static Singleton3 getINSTANCE() {
        return INSTANCE;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
