import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent-class für alle Level, gemeinsame Methoden und Attribute
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Level extends World {
    protected Start start = new Start(); //Spawnpunkt
    protected Finish finish = new Finish(); //Ziel
    protected Monster_Spawner monsterSpawner; //Klasse zum spawnen von Monstern
    protected NextWaveButton nextWaveButton = new NextWaveButton(); //Button zum Starten
    protected Health healthicon; //Lebensanzeige
    protected Money moneyicon; //Geldanzeige
    
    //Buttons zum Tower-Kaufen
    protected Buy_Fire_Tower firetowericon;
    protected Buy_Tripleshot_Tower tripleshottowericon;
    protected Buy_Sniper_Tower snipertowericon;
    protected Buy_Sprayer_Tower sprayertowericon;
    protected Buy_Ninja_Tower ninjatowericon;
    
    protected int money; //Aktuelles Geld
    protected int health; //Aktuelle Leben
    
    /**
     * Constructor für Level:<br>
     * -Setzt Weltgröße auf 1600x900<br>
     * -Setzt Speed auf 50
     */
    public Level() {    
        super(1600, 900, 1); 
        Greenfoot.setSpeed(50);
    }
    
    /**
     * Prepare-Methode für Levelaufbau, der erst aufgerufen werden kann, nachdem der Weg aufgebaut ist
     */
    public void prepare() {
        monsterSpawner = new Monster_Spawner(start);
        healthicon = new Health(this);
        moneyicon = new Money(this);
        
        firetowericon = new Buy_Fire_Tower(this);
        tripleshottowericon = new Buy_Tripleshot_Tower(this);
        sprayertowericon = new Buy_Sprayer_Tower(this);
        snipertowericon = new Buy_Sniper_Tower(this);
        ninjatowericon = new Buy_Ninja_Tower(this);
        
        addObject(monsterSpawner, 0, 0);
        addObject(nextWaveButton, 1550, 850);
        addObject(healthicon, 80, 25);
        addObject(moneyicon, 210, 25);
        
        addObject(firetowericon, 50, 850);
        addObject(tripleshottowericon, 150, 850);
        addObject(sprayertowericon, 250, 850);
        addObject(snipertowericon, 350, 850);
        addObject(ninjatowericon, 450, 850);
        
        for(int i = 0; i<1; i++) {
            addObject(new Fire_Tower(), 700, 500);
        }
    }
    
    /**
     * Act-Methode:<br>
     * -Überprüft, ob noch Leben vorhanden sind und ruft sonst lose-Methode auf
     */
    public void act() {
        if (health < 1) {
            lose();
        }
    }
    
    /**
     * Wird bei Sieg aufgerufen
     */
    public void win() {
        
    }
    
    /**
     * Wird aufgerufen, wenn alle Leben abgezogen wurden
     */
    public void lose() {
        
    }
    
    /**
     * Gibt aktuelles Geld zurücck
     * @return aktuelles Geld
     */
    public int getMoney() {return money;}
    
    /**
     * Setzt aktuelles Geld
     * @param pMoney    Neuer Wert
     */
    public void setMoney(int pMoney) {money = pMoney;}
    
    /**
     * Fügt Geld hinzu
     * @param pMoney    Geld, dass hinzugefügt wird
     */
    public void addMoney(int pMoney) {money += pMoney;}
    
    /**
     * Entfernt Geld
     * @param pMoney    Geld, dass entfernt wird
     */
    public void removeMoney(int pMoney) {money -= pMoney;}
    
    /**
     * Gibt aktuelle Leben zurück
     * @return aktuelle Leben
     */
    public int getHealth() {return health;}
    
    /**
     * Setzt Leben
     * @param pHealth   Neuer Wert
     */
    public void setHealth(int pHealth) {health = pHealth;}
    
    /**
     * Fügt Leben hinzu
     * @param pHealth   Leben, dass hinzugefügt wird
     */
    public void addHealth(int pHealth) {health += pHealth;}
    
    /**
     * Entfernt Leben
     * @param phealth   Leben, dass entfernt wird
     */
    public void removeHealth(int pHealth) {health -= pHealth;}
}
