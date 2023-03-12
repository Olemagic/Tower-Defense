import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level extends World {
    protected Monster_Spawner monsterSpawner;
    protected NextWaveButton nextWaveButton;
    protected Health healthicon;
    
    protected int money;
    protected int health;
    
    public Level() {    
        super(1600, 800, 1); 
        Greenfoot.setSpeed(50);
    }
    
    public void prepare() {
        monsterSpawner = new Monster_Spawner();
        nextWaveButton = new NextWaveButton();
        healthicon = new Health(this);
        
        addObject(monsterSpawner, 0, 0);
        addObject(nextWaveButton, 1550, 750);
        addObject(healthicon, 80, 25);
    }
    
    public void act() {
        if (health < 1) {
            lose();
        }
    }
    
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
