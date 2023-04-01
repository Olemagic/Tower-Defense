import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Objekt, dass die Monster in die Welt spawnt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Monster_Spawner extends Actor {
    private int spawnX; //X-Koordinate des Spawnpunkts
    private int spawnY; //Y-Koordinate des Spawnpunkts
    private int spawnRotation; //Drehung für Spawnpunkte, die nicht am linken Rand sind
    
    public boolean waveTimeOut = true;
    private boolean test = false;
    public int currentWave = -1;
    
    private List<List<Map<String, Integer>>> waves = new ArrayList<List<Map<String, Integer>>>();
    
    int numberOfMonsters = 0;
    int numberOfTanks = 0;
    int numberOfSpeeds = 0;
    
    int MonsterTotalDelay = 0;
    int TankTotalDelay = 0;
    int SpeedTotalDelay = 0;
    
    int MonsterSpawnDelay = 0;
    int TankSpawnDelay = 0;
    int SpeedSpawnDelay = 0;
    
    /**
     * Constructor für Monster_Spawner:<br>
     * -Speichert den Spawnpunkt und die Drehung
     * @param start Startpunkt
     */
    public Monster_Spawner(Start start) {
        spawnX = start.getX();
        spawnY = start.getY();
        spawnRotation = start.getRotation() + 90;
        
        for (int i = 0; i < 3; i++) {
            List<Map<String, Integer>> row = new ArrayList<Map<String, Integer>>();
            for (int j = 0; j < 3; j++) {
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
    }
    
    /**
     * Act-Methode von Monster_Spawner:<br>
     * -Wenn Welle aktiv: Spawnt eventuell Monster, siehe {@link #waveGeneration(int)}<br>
     * -Wenn keine Welle aktiv: Setzt das Bild vom Wavebutton zurück
     */
    public void act() {
        if(!waveTimeOut) {
            MonsterGeneration();
            TankGeneration();
            test = false;
            /*SpeedGeneration();*/
        }
        else if (getWorld().getObjects(Enemy.class).isEmpty() && !test){
            getWorld().getObjects(NextWaveButton.class).get(0).resetImage();
            waveTimeOut=true;
            MonsterTotalDelay=0;
            TankTotalDelay=0;
            numberOfMonsters=0;
            numberOfTanks=0;
            test = true;
        }
    }
    
    public void disableTimeOut() {
        waveTimeOut = false;
        currentWave++;
    }
    
    private void MonsterGeneration() {
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
    
    private void TankGeneration() {
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
}
