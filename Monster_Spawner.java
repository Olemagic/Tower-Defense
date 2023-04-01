import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objekt, dass die Monster in die Welt spawnt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Monster_Spawner extends Actor {
    private int spawnX; //X-Koordinate des Spawnpunkts
    private int spawnY; //Y-Koordinate des Spawnpunkts
    private int spawnRotation; //Drehung für Spawnpunkte, die nicht am linken Rand sind
    private int amountOfEnemiesSpawned = 0; //Zähler fürs spawnen
    private int numberOfActs = 0; //Zähler fürs Timing
    private int currentWave = 1; //Die aktuelle Welle
    private boolean waveTimeOut = true; //Speichert, ob aktuell eine Welle aktiv ist
    
    /**
     * Constructor für Monster_Spawner:<br>
     * -Speichert den Spawnpunkt und die Drehung
     * @param start Startpunkt
     */
    public Monster_Spawner(Start start) {
        spawnX = start.getX();
        spawnY = start.getY();
        spawnRotation = start.getRotation() + 90;
    }
    
    /**
     * Act-Methode von Monster_Spawner:<br>
     * -Wenn Welle aktiv: Spawnt eventuell Monster, siehe {@link #waveGeneration(int)}<br>
     * -Wenn keine Welle aktiv: Setzt das Bild vom Wavebutton zurück
     */
    public void act() {
        if (!waveTimeOut) {
            waveGeneration(currentWave);
            numberOfActs++;
        }
        else if (getWorld().getObjects(Enemy.class).isEmpty()){
            getWorld().getObjects(NextWaveButton.class).get(0).resetImage();
        }
    }
    
    /**
     * Deaktiviert den Wellen Timeout
     * @see NextWaveButton#act()
     */
    public void disableTimeOut() {
        waveTimeOut = false;
    }
    
    /**
     * Konfiguriert die Wellen<br>
     * Für mehr Wellen einfach weitere Cases hinzufügen
     * @param waveNumber    Aktuelle Welle
     */
    public void waveGeneration(int waveNumber) {
        switch(waveNumber){
            case 1: spawnSpeed(15, 100); spawnMonster(30, 50); break;
            case 2: spawnMonster(30, 50); break;
            case 3: spawnTank(30, 50); break;
            case 4: spawnMonster(60, 20); break;
            case 5: spawnTank(300, 10); break;
        }
    }
    
    /**
     * Spawnt Monster: Wenn die angegebene Wartezeit gewartet wurde und noch Monster gespawnt werden müssen, wird ein Monster and den Spawnpunkt gesetzt und gedreht<br>
     * Wenn alle Monster gespawnt wurden, wird die Wellennummer erhöht
     * @param amountOfEnemies   Anzahl an Gegnern, die gespawnt werden sollen
     * @param waitTime  Zeit, die zwischen den einzelnen Gegner gewartet wird
     */
    public void spawnMonster(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 0 && amountOfEnemies>amountOfEnemiesSpawned) {
            Enemy newMonster = new Monster();
            getWorld().addObject(newMonster, spawnX, spawnY);
            newMonster.setRotation(spawnRotation);
            amountOfEnemiesSpawned++;
        }
        if(amountOfEnemies==amountOfEnemiesSpawned) {
            amountOfEnemiesSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
    
    /**
     * Spawnt Tanks: Wenn die angegebene Wartezeit gewartet wurde und noch Tanks gespawnt werden müssen, wird ein Monster and den Spawnpunkt gesetzt und gedreht<br>
     * Wenn alle Tanks gespawnt wurden, wird die Wellennummer erhöht
     * @param amountOfEnemies   Anzahl an Gegnern, die gespawnt werden sollen
     * @param waitTime  Zeit, die zwischen den einzelnen Gegner gewartet wird
     */
    public void spawnTank(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 0 && amountOfEnemies>amountOfEnemiesSpawned) {
            Enemy newMonster = new Tank();
            getWorld().addObject(newMonster, spawnX, spawnY);
            newMonster.setRotation(spawnRotation);
            amountOfEnemiesSpawned++;
        }
        if(amountOfEnemies==amountOfEnemiesSpawned) {
            amountOfEnemiesSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
    
    /**
     * Spawnt Tanks: Wenn die angegebene Wartezeit gewartet wurde und noch Tanks gespawnt werden müssen, wird ein Monster and den Spawnpunkt gesetzt und gedreht<br>
     * Wenn alle Tanks gespawnt wurden, wird die Wellennummer erhöht
     * @param amountOfEnemies   Anzahl an Gegnern, die gespawnt werden sollen
     * @param waitTime  Zeit, die zwischen den einzelnen Gegner gewartet wird
     */
    public void spawnSpeed(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 0 && amountOfEnemies>amountOfEnemiesSpawned) {
            Enemy newMonster = new Speed();
            getWorld().addObject(newMonster, spawnX, spawnY);
            newMonster.setRotation(spawnRotation);
            amountOfEnemiesSpawned++;
        }
        if(amountOfEnemies==amountOfEnemiesSpawned) {
            amountOfEnemiesSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
}
