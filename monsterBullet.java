import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class monsterBullet extends Bullets {
    public monsterBullet(int rotation, int pDamage) {
        setRotation(rotation);
        damage = pDamage;
        pierce = 3;
        hitEnemies = new Enemy[pierce];
    }
}
