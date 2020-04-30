package designPattern.factory;
//M4A1子弹类
public class M4A1_Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("Load bullets with M4A1");
    }
}
