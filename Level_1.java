import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level #1 of the game
 * 
 * @author (your name) 
 * @version 0.1
 */
public class Level_1 extends Level {
    private Path paths[] = new Path[30];
    
    public Level_1() {
        generateLevel();
    }
    
    public void generateLevel() {
        for (int i = 0; i < 3; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], i+1, 4);
        }
        
        for (int i = 3; i < 5; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 3, i+2);
        }
        
        for (int i = 5; i < 7; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], i-1, 6);
        }
        
        for (int i = 7; i < 11; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 5, 12-i);
        }
        
        for (int i = 11; i < 14; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], i-5, 2);
        }
        
        for (int i = 14; i < 17; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 8, i-11);
        }
        
        for (int i = 17; i < 23; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], i-8, 5);
        }
        
        for (int i = 23; i < 26; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 14, 27-i);
        }
        
        for (int i = 26; i < 28; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 39-i, 2);
        }
        
        for (int i = 28; i < 30; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 12, 29-i);
        }
    }
}
