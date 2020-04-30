package designPattern.factory;
//生产AK和AK子弹的工厂
public class AK_Factory implements Factory2{
    @Override
    public Gun prodeceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AK_Bullet();
    }
}
