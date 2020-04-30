package designPattern.factory;

public class Test4 {
    public static void main(String[] args) {
        Factory2 factory;
        Gun gun;
        Bullet bullet;

        factory = new AK_Factory();
        bullet = factory.produceBullet();
        bullet.load();
        gun = factory.prodeceGun();
        gun.shooting();
    }
}
