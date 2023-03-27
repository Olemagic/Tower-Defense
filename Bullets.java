import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Parent-class aller von Türmen geschossenen Projektile
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Bullets extends SmoothMover {
    protected int damage; //Schaden des Projektils
    protected int pierce; //Anzahl an Gegnern, die das Projektil treffen kann
    protected Enemy[] hitEnemies; //Bereits getroffene Gegner, damit Gegner nicht mehrmals getroffen werden
    protected int currentIndex = 0; //Zähler für das Array oben
    
    /**
     * Act-Methode von Bullets:<br>
     * -Bewegt das Bullet<br>
     * -Falls ein Obstacle berührt wird oder das Bullet am Rand der Welt ist, wird das Bullet entfernt(Wichtig wegen Tripleshottower)<br>
     * -Wenn ein Gegner berührt wird, wird diesem der Schaden des Bullets vom Leben abgezogen und er wird im Array gespeichert. Wenn pierce=0, wird das Bullet entfernt
     */
    public void act() {
        move(5);
        if(isTouching(Obstacle.class) || isAtEdge()) {
            getWorld().removeObject(this);
        }
        else if(isTouching(Enemy.class)) {
            Enemy hitEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
            for(int i=0; i<hitEnemies.length; i++) {
                if(hitEnemies[i] == hitEnemy) {
                    return;
                }
            }
            hitEnemies[currentIndex]=hitEnemy;
            currentIndex++;
            hitEnemy.removeHealth(damage);
            pierce--;
            if(pierce==0) {
                getWorld().removeObject(this);
            }
        }
    }
}
