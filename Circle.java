import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Class, die verwendet werden kann, um einen Kreis in die Welt zu zeichnen
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Circle extends GUI {
    /**
     * Constructor von Circle:<br>
     * -Zeichnet einen Kreis mit der angegebenen Größe
     * @param size Größe des Kreises (Durchmesser)
     */
    public Circle(int size) {
        GreenfootImage image = new GreenfootImage(size, size);
        
        image.setColor(new Color(50, 50, 50, 125));
        image.fillOval(0, 0, size, size);
        
        setImage(image);
    }
}
