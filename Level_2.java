import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 2
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Level_2 extends Level {
    private Path[] paths = new Path[37]; //Wegobjekte

    /**
     * Constructor für Level_2:<br>
     * -Setzt Leben und Geld<br>
     * -Baut das Level auf
     */
    public Level_2() {
        super();

        //config
        health = 150;
        money = 1000;

        //generate level
        generateLevel();
        prepare();
    }

    /**
     * Generiert Pfad
     * Generiert Start- und Endpunkt
     */
    public void generateLevel() {
        for (int i = 0; i < 4; i++) {
            paths[i] = new Path();
            addObject(paths[i], 550, i*100+50);
        }
        
        for (int i = 4; i < 8; i++) {
            paths[i] = new Path();
            addObject(paths[i], (8-i)*100+50, 350);
        }
        
        for (int i = 8; i < 10; i++) {
            paths[i] = new Path();
            addObject(paths[i], 150, (i-7)*100+50);
        }
        
        for (int i = 10; i < 13; i++) {
            paths[i] = new Path();
            addObject(paths[i], (i-8)*100+50, 150);
        }
        
        for (int i = 13; i < 20; i++) {
            paths[i] = new Path();
            addObject(paths[i], (i-7)*100+50, 150);
        }
        
        for (int i = 20; i < 24; i++) {
            paths[i] = new Path();
            addObject(paths[i], 1250, (i-18)*100+50);
        }
        
        for (int i = 24; i < 28; i++) {
            paths[i] = new Path();
            addObject(paths[i], (35-i)*100+50, 550);
        }
        
        for (int i = 28; i < 37; i++) {
            paths[i] = new Path();
            addObject(paths[i], (36-i)*100+50, 650);
        }
        
        addObject(start, 550, 0);
        
        addObject(finish, 0, 650);
        finish.setRotation(90);
    }
}
