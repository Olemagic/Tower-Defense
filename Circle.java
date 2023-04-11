import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent-class für das GUI
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Circle extends GUI {
    public Circle(int size) {
        GreenfootImage image = new GreenfootImage(size, size);
        
        image.setColor(new Color(50, 50, 50, 125));
        image.fillOval(0, 0, size, size);
        
        setImage(image);
    }
}
