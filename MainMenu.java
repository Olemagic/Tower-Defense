import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mainmenu zur Auswahl des Levels
 */
public class MainMenu extends World {
    Levelbutton Level1 = new Levelbutton(1); //Button für Level 1
    Levelbutton Level2 = new Levelbutton(2); //Button für Level 2
    
    /**
     * Constructor für Mainmenu
     */
    public MainMenu() {
        super(1600, 900, 1);
        
        addObject(Level1, 427, 600);
        addObject(Level2, 1173, 600);
        
        setImages();
    }
    
    /**
     * Erstellt die Bilder der Levelbuttons
     */
    public void setImages() {
        GreenfootImage Level1_Image = new GreenfootImage(1600, 800);
        Level1_Image.drawImage(new GreenfootImage("Level 1.png") , 0, 0);
        Level1_Image.scale(640, 320);
        
        GreenfootImage Level2_Image = new GreenfootImage(1600, 800);
        Level2_Image.drawImage(new GreenfootImage("Level 2.png") , 0, 0);
        Level2_Image.scale(640, 320);
        
        Level1.setImage(Level1_Image);
        Level2.setImage(Level2_Image);
    }
}
