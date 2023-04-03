import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)
import java.util.Map;   // (Map)
import java.util.ArrayList; // (ArrayList)
import java.util.HashMap;   // (HashMap)

/**
 * Objekt, dass die Monster in die Welt spawnt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Monster_Spawner extends Actor {
    private int spawnX; //X-Koordinate des Spawnpunkts
    private int spawnY; //Y-Koordinate des Spawnpunkts
    private int spawnRotation; //Drehung für Spawnpunkte, die nicht am linken Rand sind
    private boolean gameOver = false; //Spielzustand
    
    private boolean waveTimeOut = true; //Welle aktiv
    private int currentWave = -1; //Aktuelle Welle
    private int numberOfWaves;
    
    private List<List<Map<String, Integer>>> waves = new ArrayList<List<Map<String, Integer>>>(); //Zweidimensionale Liste mit Hashmaps
    
    //Anzahl an gespawnten Monstern
    private int numberOfMonsters = 0;
    private int numberOfTanks = 0;
    private int numberOfSpeeds = 0;
    
    //Zeitabstand bis zum ersten Spawn
    private int MonsterTotalDelay = 0;
    private int TankTotalDelay = 0;
    private int SpeedTotalDelay = 0;
    
    //Zeitabstand zwischen Spawns
    private int MonsterSpawnDelay = 0;
    private int TankSpawnDelay = 0;
    private int SpeedSpawnDelay = 0;
    
    /**
     * Constructor für Monster_Spawner:<br>
     * -Speichert den Spawnpunkt und die Drehung<br>
     * -Ruft die Waveconfig auf
     * @param start Startpunkt
     */
    public Monster_Spawner(Start start) {
        spawnX = start.getX();
        spawnY = start.getY();
        spawnRotation = start.getRotation() + 90;
        
        waveconfig();
    }
    
    /**
     * Act-Methode von Monster_Spawner:<br>
     * -Wenn Welle aktiv: Spawnt eventuell Monster, siehe {@link #waveGeneration(int)}<br>
     * -Wenn keine Welle aktiv: Setzt das Bild vom Wavebutton zurück
     */
    public void act() {
        if(!waveTimeOut && !gameOver) {
            if (numberOfMonsters >= waves.get(currentWave).get(0).get("number") && numberOfTanks >= waves.get(currentWave).get(1).get("number") && numberOfSpeeds >= waves.get(currentWave).get(2).get("number")) {                
                waveTimeOut = true;
                return;
            }
            
            MonsterGeneration();
            TankGeneration();
            SpeedGeneration();
        }
        else if (getWorld().getObjects(Enemy.class).isEmpty() && !gameOver){
            if (currentWave == numberOfWaves - 1) {
                ((Level) getWorld()).win();
                gameOver = true;
            }
            
            getWorld().getObjects(NextWaveButton.class).get(0).resetImage();
            MonsterTotalDelay = 0;
            TankTotalDelay = 0;
            SpeedTotalDelay = 0;
            numberOfMonsters = 0;
            numberOfTanks = 0;
            numberOfSpeeds = 0;
        }
    }
    
    /**
     * Config für die Wellen
     */
    public void waveconfig() {
        numberOfWaves = 3;
        
        for (int i = 0; i < numberOfWaves; i++) {
            List<Map<String, Integer>> row = new ArrayList<Map<String, Integer>>();
            for (int j = 0; j < numberOfWaves; j++) {
                row.add(new HashMap<String, Integer>());
            }
            waves.add(row);
        }
        
        waves.get(0).get(0).put("totalDelay", 0);
        waves.get(0).get(0).put("number", 200);
        waves.get(0).get(0).put("spawnDelay", 10);
        
        waves.get(0).get(1).put("totalDelay", 700);
        waves.get(0).get(1).put("number", 200);
        waves.get(0).get(1).put("spawnDelay", 20);
    
        waves.get(0).get(2).put("totalDelay", 6000);
        waves.get(0).get(2).put("number", 10);
        waves.get(0).get(2).put("spawnDelay", 5);
        
        waves.get(1).get(0).put("totalDelay", 0);
        waves.get(1).get(0).put("number", 200);
        waves.get(1).get(0).put("spawnDelay", 10);

        waves.get(1).get(1).put("totalDelay", 700);
        waves.get(1).get(1).put("number", 200);
        waves.get(1).get(1).put("spawnDelay", 20);

        waves.get(1).get(2).put("totalDelay", 6000);
        waves.get(1).get(2).put("number", 10);
        waves.get(1).get(2).put("spawnDelay", 5);

        waves.get(2).get(0).put("totalDelay", 0);
        waves.get(2).get(0).put("number", 200);
        waves.get(2).get(0).put("spawnDelay", 10);

        waves.get(2).get(1).put("totalDelay", 700);
        waves.get(2).get(1).put("number", 200);
        waves.get(2).get(1).put("spawnDelay", 20);
    
        waves.get(2).get(2).put("totalDelay", 6000);
        waves.get(2).get(2).put("number", 10);
        waves.get(2).get(2).put("spawnDelay", 5);
    }
    
    /**
     * Startet eine neue Welle
     */
    public void disableTimeOut() {
        waveTimeOut = false;
        if (currentWave < numberOfWaves - 1) currentWave++;
    }
    
    /**
     * Stoppt das Spawning
     */
    public void enableTimeout() {
        waveTimeOut = true;
    }
    
    /**
     * Spawnt Monster
     */
    public void MonsterGeneration() {
        MonsterTotalDelay++;
        if(MonsterTotalDelay >= waves.get(currentWave).get(0).get("totalDelay")) {
            MonsterSpawnDelay++;
            if(MonsterSpawnDelay >= waves.get(currentWave).get(0).get("spawnDelay")&& numberOfMonsters < waves.get(currentWave).get(0).get("number")) {
                MonsterSpawnDelay=0;
                Enemy newMonster = new Monster();
                getWorld().addObject(newMonster, spawnX, spawnY);
                newMonster.setRotation(spawnRotation);
                numberOfMonsters++;
            }
        }
    }
    
    /**
     * Spawnt Tanks
     */
    public void TankGeneration() {
        TankTotalDelay++;
        if(TankTotalDelay >= waves.get(currentWave).get(1).get("totalDelay")) {
            TankSpawnDelay++;
            if(TankSpawnDelay >= waves.get(currentWave).get(1).get("spawnDelay") && numberOfTanks < waves.get(currentWave).get(1).get("number")) {
                TankSpawnDelay=0;
                Enemy newTank = new Tank();
                getWorld().addObject(newTank, spawnX, spawnY);
                newTank.setRotation(spawnRotation);
                numberOfTanks++;
            }
        }
    }
    
    /**
     * Spawnt Speeds
     */
    public void SpeedGeneration() {
        SpeedTotalDelay++;
        if(SpeedTotalDelay >= waves.get(currentWave).get(2).get("totalDelay")) {
            SpeedSpawnDelay++;
            if(SpeedSpawnDelay >= waves.get(currentWave).get(2).get("spawnDelay") && numberOfSpeeds < waves.get(currentWave).get(2).get("number")) {
                SpeedSpawnDelay=0;
                Enemy newSpeed = new Speed();
                getWorld().addObject(newSpeed, spawnX, spawnY);
                newSpeed.setRotation(spawnRotation);
                numberOfSpeeds++;
            }
        }
    }
}
