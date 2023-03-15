import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Levelbutton extends GUI {
    private int levelNumber;
    
    public Levelbutton(int pLevelNumber) {
        levelNumber = pLevelNumber;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch (levelNumber) {
                case 1: Greenfoot.setWorld(new Level_1()); break;
                case 2: Greenfoot.setWorld(new Level_2()); break;
            }
        }
    }
}
