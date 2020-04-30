package designPattern.factory;
//生产M4A1和M4A1子弹的工厂
public class M4A1_Factory implements Factory2 {
    @Override
    public Gun prodeceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new M4A1_Bullet();
    }
}
