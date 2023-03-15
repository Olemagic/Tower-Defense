import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level extends World {
    protected Start start = new Start();
    protected Finish finish = new Finish();
    protected Monster_Spawner monsterSpawner;
    protected NextWaveButton nextWaveButton;
    protected Health healthicon;
    protected Money moneyicon;
    
    protected Buy_Fire_Tower firetowericon;
    protected Buy_Tripleshot_Tower tripleshottowericon;
    protected Buy_Sniper_Tower snipertowericon;
    protected Buy_Sprayer_Tower sprayertowericon;
    
    protected int money;
    protected int health;
    
    public Level() {    
        super(1600, 900, 1); 
        Greenfoot.setSpeed(50);
    }
    
    public void prepare() {
        monsterSpawner = new Monster_Spawner(start);
        nextWaveButton = new NextWaveButton();
        healthicon = new Health(this);
        moneyicon = new Money(this);
        
        firetowericon = new Buy_Fire_Tower(this);
        tripleshottowericon = new Buy_Tripleshot_Tower(this);
        sprayertowericon = new Buy_Sprayer_Tower(this);
        snipertowericon = new Buy_Sniper_Tower(this);
        
        addObject(monsterSpawner, 0, 0);
        addObject(nextWaveButton, 1550, 850);
        addObject(healthicon, 80, 25);
        addObject(moneyicon, 210, 25);
        
        addObject(firetowericon, 50, 850);
        addObject(tripleshottowericon, 150, 850);
        addObject(sprayertowericon, 250, 850);
        addObject(snipertowericon, 350, 850);
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
