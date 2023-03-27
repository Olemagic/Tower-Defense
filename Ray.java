import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objekt, dass erstellt wird, um zu überprüfen, ob ein Turm einen Gegner sehen kann
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Ray extends Actor
{
    private Enemy enemy; //Der Gegner
    private Towers tower; //Der Turm
    
    /**
     * Constructor von Ray:
     * -Setzt den Gegner
     * -Setzt den Turm
     */
    public Ray(Enemy pEnemy, Towers pTower) {
        enemy = pEnemy;
        tower = pTower;
    }
    
    /**
     * Gibt zurück, ob der Gegner der Turm sehen kann
     * Funktionsweise:
     * -Berechnet die Länge des Rays (Entfernung zwischen Gegner und Turm)
     * -Berechnet den Winkel in welchem die beiden zueinander sind über Arctan
     * -Platziert den Ray in der Mitte und setzt die Rotation
     * -Erstellt das Bild passender Länge
     * -Überprüft, ob der Ray ein Obstacle berührt
     * @return true, wenn ein Obstacle zwischen Gegner und Turm sind
     * @return false, wenn kein Obstacle zwischen Gegner und Turm sind
     */
    public boolean HasLOS() {
        boolean hasLOS = false;
        int towerX = tower.getX();
        int towerY = tower.getY();
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
        
        int distanceX = enemyX-towerX;
        int distanceY = enemyY-towerY;
        int distance = (int) Math.hypot(distanceX, distanceY);
        int rotation = (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
        
        setLocation(distanceX/2+towerX, distanceY/2+towerY);
        createImage(distance);
        setRotation(rotation);
        if(getOneIntersectingObject(Obstacle.class) == null) {
            hasLOS = true;
        }
        return hasLOS;
    }
    
    /**
     * Erstellt das Bild
     */
    public void createImage(int distance) {
        setImage(new GreenfootImage(distance, 50));
    }
}
