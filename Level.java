import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level extends World {
    private Monster_Spawner monsterSpawner;
    private NextWaveButton nextWaveButton;
    private int money;
    private int health;
    
    public Level() {    
        super(1600, 800, 1); 
        Greenfoot.setSpeed(50);
        
        monsterSpawner = new Monster_Spawner();
        nextWaveButton = new NextWaveButton();
        
        addObject(monsterSpawner, 0, 0);
        addObject(nextWaveButton, 1550, 750);
    }
    
    public void act() {
        if (health < 1) {
            lose();
        }
    }
    
    //public void
    
    public void win() {
        
    }
    
    public void lose() {
        
    }
    
    public int getMoney() {return money;}
    public void setMoney(int pMoney) {money = pMoney;}
    public void addMoney(int pMoney) {money += pMoney;}
    public void removeMoney(int pMoney) {money -= pMoney;}
    
    public int getHealth() {return health;}
    public void setHealth(int pHealth) {health = pHealth;}
    public void addHealth(int pHealth) {health += pHealth;}
    public void removeHealth(int pHealth) {health -= pHealth;}
}
