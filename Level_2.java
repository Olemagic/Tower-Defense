import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level_2 extends Level {
    private Path[] paths = new Path[41];

    public Level_2() {
        super();

        //config
        money = 1000;
        health = 150;

        //generate level
        generateLevel();
        prepare();
    }

    public void generateLevel() {
        for (int i = 0; i < 2; i++) {
            paths[i] = new Path();
            addObject(paths[i], i*100+50, 150);
        }
        
        for (int i = 2; i < 7; i++) {
            paths[i] = new Path();
            addObject(paths[i], 150, i*100+50);
        }
        
        for (int i = 7; i < 11; i++) {
            paths[i] = new Path();
            addObject(paths[i], (i-5)*100+50, 650);
        }
        
        for (int i = 11; i < 16; i++) {
            paths[i] = new Path();
            addObject(paths[i], 550, (16-i)*100+50);
        }
        
        for (int i = 16; i < 24; i++) {
            paths[i] = new Path();
            addObject(paths[i], (i-9)*100-50, 150);
        }
        
        for (int i = 24; i < 27; i++) {
            paths[i] = new Path();
            addObject(paths[i], 1350, (i-22)*100+50);
        }
        
        for (int i = 27; i < 32; i++) {
            paths[i] = new Path();
            addObject(paths[i], (39-i)*100+50, 450);
        }
        
        for (int i = 32; i < 34; i++) {
            paths[i] = new Path();
            addObject(paths[i], 850, (i-27)*100+50);
        }
        
        for (int i = 34; i < 41; i++) {
            paths[i] = new Path();
            addObject(paths[i], (i-25)*100+50, 650);
        }
        
        addObject(start, 0, 150);
        start.setRotation(90);
        
        addObject(finish, 1599, 650);
        finish.setRotation(90);
    }
}
