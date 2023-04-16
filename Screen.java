import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Win-/Lose screen
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Screen extends GUI {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
