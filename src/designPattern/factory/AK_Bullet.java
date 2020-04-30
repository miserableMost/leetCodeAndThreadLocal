package designPattern.factory;
//AK子弹类
public class AK_Bullet implements  Bullet {
    @Override
    public void load() {
        System.out.println("Load bullets with Ak");
    }
}
