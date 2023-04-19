import greenfoot.GreenfootImage;

/**
 * Objekt, dass erstellt wird, um zu prüfen, ob ein Turm platziert werden kann
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Tower_Hitbox extends GUI {

    /**
     * Constructor für Tower_Hitbox:<br>
     * -Setzt das Bild auf die Größe des Turms
     * @param size Größe des Turms
     */
    public Tower_Hitbox(int size) {
        GreenfootImage image = new GreenfootImage(size, size);
        setImage(image);
    }

    /**
     * Prüft, ob der Turm platziert werden kann
     * @return true, wenn der Turm platziert werden kann
     */
    public boolean isNotColliding() {
        return getOneIntersectingObject(Tower_Menu_Placeholder.class) == null
                && getOneIntersectingObject(Path.class) == null
                && getOneIntersectingObject(Towers.class) == null
                && getOneIntersectingObject(Obstacle.class) == null;
    }
}
