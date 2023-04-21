import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;
import greenfoot.World;

/**
 * Parent-class für alle Level, gemeinsame Methoden und Attribute
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Level extends World {
    protected Start start = new Start(); //Spawnpunkt
    protected Finish finish = new Finish(); //Ziel
    protected Monster_Spawner monsterSpawner; //Klasse zum Spawnen von Monstern
    protected NextWaveButton nextWaveButton = new NextWaveButton(); //Button zum Starten
    protected SoundButton soundButton = new SoundButton(); //Button zum Ein-/Ausschalten der Musik
    protected Health healthicon; //Lebensanzeige
    protected Money moneyicon; //Geldanzeige
    protected GreenfootSound music; //Hintergrundmusik
    protected Tower_Menu_Placeholder towermenuplaceholder; //Leerer Block über dem Menü
    
    protected Buy_Tower[] towericons = {new Buy_Tower("Fire"), new Buy_Tower("Tripleshot"), new Buy_Tower("Sprayer"), new Buy_Tower("Sniper"), new Buy_Tower("Ninja"), new Buy_Tower("Ice")}; //Array mit allen Towericons
    
    protected int money; //Aktuelles Geld
    protected int health; //Aktuelle Leben
    protected boolean gameOver = false; //Spielzustand
    
    /**
     * Constructor für Level:<br>
     * -Setzt Weltgröße auf 1600x900<br>
     * -Setzt Speed auf 50<br>
     * -Legt die Reihenfolge der Objekte fest
     */
    public Level() {    
        super(1600, 900, 1); 
        Greenfoot.setSpeed(50);
        setPaintOrder(GUI.class, Pseudo_Tower.class, Buy_Tower.class, NextWaveButton.class, Tower_Menu_Placeholder.class);
    }
    
    /**
     * Prepare-Methode für Levelaufbau, der erst aufgerufen werden kann, nachdem der Weg aufgebaut ist
     */
    public void prepare() {
        music = new GreenfootSound("Background.mp3");
        music.setVolume(40);
        music.playLoop();

        monsterSpawner = new Monster_Spawner(start);
        healthicon = new Health(this);
        moneyicon = new Money(this);
        towermenuplaceholder = new Tower_Menu_Placeholder();
        
        addObject(monsterSpawner, 0, 0);
        addObject(nextWaveButton, 1550, 850);
        addObject(soundButton, 1450, 850);
        addObject(healthicon, 80, 25);
        addObject(moneyicon, 260, 25);
        addObject(towermenuplaceholder, 800, 850);

        for (int i = 0; i < towericons.length; i++) {
            addObject(towericons[i], i*100+50, 850);
        }

        nextWaveButton.resetImage();
        soundButton.resetImage();
    }
    
    /**
     * Act-Methode:<br>
     * -Überprüft, ob noch Leben vorhanden sind und ruft lose-Methode auf
     */
    public void act() {
        if (!gameOver && health < 1) {
            health = 0;
            healthicon.update();
            gameOver = true;
            lose();
        }
    }
    
    /**
     * Wird bei Sieg aufgerufen
     */
    public void win() {
        Screen screen = new Screen();
        addObject(screen, 800, 450);
        
        screen.setImage(new GreenfootImage("Win.png"));

        nextWaveButton.setGameOver();
        soundButton.setGameOver();
        for(Buy_Tower currentIcon : towericons) {
            currentIcon.setGameOver();
        }

        for (int i = 29; i > 0; i--) {
            music.setVolume(i);
            Greenfoot.delay(5);
        }
        music.stop();
    }
    
    /**
     * Wird aufgerufen, wenn alle Leben abgezogen wurden
     */
    public void lose() {
        monsterSpawner.enableTimeout();
        
        for (Enemy enemy : getObjects(Enemy.class)) {
            removeObject(enemy);
        }
        
        Screen screen = new Screen();
        addObject(screen, 800, 450);
        
        screen.setImage(new GreenfootImage("Lose.png"));

        for(Buy_Tower currentIcon : towericons) {
            currentIcon.setGameOver();
        }

        for (int i = 29; i > 0; i--) {
            music.setVolume(i);
            Greenfoot.delay(5);
        }
        music.stop();
    }
    
    /**
     * Gibt aktuelles Geld zurück
     * @return aktuelles Geld
     */
    public int getMoney() {return money;}

    /**
     * Fügt Geld hinzu
     * @param pMoney Geld, dass hinzugefügt wird
     */
    public void addMoney(int pMoney) {money += pMoney;}
    
    /**
     * Entfernt Geld
     * @param pMoney Geld, dass entfernt wird
     */
    public void removeMoney(int pMoney) {money -= pMoney;}
    
    /**
     * Gibt aktuelle Leben zurück
     * @return aktuelle Leben
     */
    public int getHealth() {return health;}

    /**
     * Entfernt Leben
     * @param pHealth Leben, dass entfernt wird
     */
    public void removeHealth(int pHealth) {health -= pHealth;}

    /**
     * Gibt die Hintergrundmusik zurück
     * @return Hintergrundmusik
     */
    public GreenfootSound getMusic() {return music;}
}
