import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level #1 of the game
 * 
 * @author (your name) 
 * @version 0.1
 */
public class Level_1 extends Level {
    private Path[] paths = new Path[31];
    private Monster_Spawner monsterSpawner;
    private Towers tower;
    //private Towers[] tripleshottower = new Tripleshot_Tower[100];
    private NextWaveButton nextWaveButton;
    private int money = 1000;
    
    public Level_1() {
        super();
        generateLevel();
        monsterSpawner = new Monster_Spawner();
        tower = new Fire_Tower();
        //tripleshottower = new Tripleshot_Tower();
        nextWaveButton = new NextWaveButton();
        this.addObject(nextWaveButton, 1550, 750);
        this.addObject(tower, 250, 350);
        //this.addObject(tripleshottower, 250, 350);
        this.addObject(monsterSpawner, 0, 0);
        
        //for (int i = 0; i < tripleshottower.length; i++) {
        //    tripleshottower[i] = new Tripleshot_Tower();
        //    this.addObject(tripleshottower[i], 450, 400+i);
        //}
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("space")){
            monsterSpawner.disableTimeOut();
        }
    }
    
    public void generateLevel() {
        for (int i = 0; i < 4; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], (i)*100+50, 450);
        }
        
        for (int i = 4; i < 6; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 350, (i+1)*100+50);
        }
        
        for (int i = 6; i < 8; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], (i-2)*100+50, 650);
        }
        
        for (int i = 8; i < 12; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 550, (13-i)*100+50);
        }
        
        for (int i = 12; i < 15; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], (i-6)*100+50, 250);
        }
        
        for (int i = 15; i < 18; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 850, (i-12)*100+50);
        }
        
        for (int i = 18; i < 24; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], (i-9)*100+50, 550);
        }
        
        for (int i = 24; i < 27; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 1450, (28-i)*100+50);
        }
        
        for (int i = 27; i < 29; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], (40-i)*100+50, 250);
        }
        
        for (int i = 29; i < 31; i++) {
            paths[i] = new Path();
            this.addObject(paths[i], 1250, (30-i)*100+50);
        }
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int pMoney) {
        money = pMoney;
    }
    
    public void addMoney(int pMoney) {
        money += pMoney;
    }
    
    public void removeMoney(int pMoney) {
        money -= pMoney;
    }
}
