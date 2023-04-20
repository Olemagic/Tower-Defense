import greenfoot.Actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Objekt, dass die Monster in die Welt spawnt<br>
 * Man sollte statt der Hashmap einfach das Array verwenden, wäre einfacher
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Monster_Spawner extends Actor {
    private final int spawnX; //X-Koordinate des Spawnpunkts
    private final int spawnY; //Y-Koordinate des Spawnpunkts
    private final int spawnRotation; //Drehung für Spawnpunkte, die nicht am linken Rand sind
    private boolean gameOver = false; //Spielzustand
    private boolean endOfRoundMoney = true; //Geld am Ende der Runde
    
    private boolean waveTimeOut = true; //Welle aktiv
    private int currentWave = -1; //Aktuelle Welle
    
    /**
     * Waveconfig im Format: {<br>
     * Welle 1: {{totaldelay, number, spawndelay}(Monster), {totaldelay, number, spawndelay}(Tank), {totaldelay, number, spawndelay}(Speed), {totaldelay, number, spawndelay}(BigTank)},<br>
     * Welle 2: {{totaldelay, number, spawndelay}(Monster), {totaldelay, number, spawndelay}(Tank), {totaldelay, number, spawndelay}(Speed), {totaldelay, number, spawndelay}(BigTank)},<br>
     * Welle 3: {{totaldelay, number, spawndelay}(Monster), {totaldelay, number, spawndelay}(Tank), {totaldelay, number, spawndelay}(Speed), {totaldelay, number, spawndelay}(BigTank)}}<br>
     * ...
     */
    private final int[][][] waveConfig = {
    {{2000, 20, 200}, {4000, 40, 100}, {8000, 200, 20}, {0, 20, 200}},
    {{2000, 200, 10}, {700, 200, 20}, {6000, 10, 5}, {0, 150, 40}},
    {{2000, 200, 10}, {700, 200, 20}, {6000, 10, 5}, {0, 20, 200}},
    {{2000, 40, 200}, {4000, 40, 100}, {8000, 200, 20}, {0, 20, 200}},
    {{2000, 200, 10}, {700, 200, 20}, {6000, 10, 5}, {0, 100, 40}},
    {{2000, 200, 10}, {700, 200, 20}, {6000, 10, 5}, {0, 20, 200}},
    {{2000, 20, 200}, {4000, 40, 100}, {8000, 200, 20}, {0, 20, 200}},
    {{2000, 200, 10}, {700, 600, 20}, {6000, 10, 5}, {0, 100, 40}},
    {{2000, 200, 10}, {700, 200, 20}, {6000, 10, 5}, {0, 20, 200}},
    {{2000, 200, 10}, {700, 400, 20}, {6000, 10, 5}, {0, 20, 200}}};
    
    private final int numberOfWaves = waveConfig.length; //Anzahl der Wellen
    
    
    private final List<List<Map<String, Integer>>> waves = new ArrayList<>(); //Zweidimensionale Liste mit Hashmaps
    
    //Anzahl an gespawnten Monstern
    private int numberOfMonsters = 0;
    private int numberOfTanks = 0;
    private int numberOfSpeeds = 0;
    private int numberOfBigTanks = 0;
    
    //Zeitabstand bis zum ersten Spawn
    private int MonsterTotalDelay = 0;
    private int TankTotalDelay = 0;
    private int SpeedTotalDelay = 0;
    private int BigTankTotalDelay = 0;
    
    //Zeitabstand zwischen Spawns
    private int MonsterSpawnDelay = 0;
    private int TankSpawnDelay = 0;
    private int SpeedSpawnDelay = 0;
    private int BigTankSpawnDelay = 0;
    
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
     * -Wenn Welle aktiv: Spawnt eventuell Monster<br>
     * -Wenn keine Welle aktiv: Setzt das Bild vom Wavebutton zurück und gibt Geld am Ende der Runde
     */
    public void act() {
        if(!waveTimeOut && !gameOver) {
            if (numberOfMonsters >= waves.get(currentWave).get(0).get("number")
            && numberOfTanks >= waves.get(currentWave).get(1).get("number")
            && numberOfSpeeds >= waves.get(currentWave).get(2).get("number")) {                
                waveTimeOut = true;
                return;
            }
            
            MonsterGeneration();
            TankGeneration();
            SpeedGeneration();
            BigTankGeneration();
        }
        else if (getWorld().getObjects(Enemy.class).isEmpty() && !gameOver){
            if (currentWave == numberOfWaves - 1) {
                ((Level) getWorld()).win();
                gameOver = true;
            }
            if(endOfRoundMoney && currentWave !=-1) {
                ((Level) getWorld()).addMoney(500);
                endOfRoundMoney = false;
            }
            getWorld().getObjects(NextWaveButton.class).get(0).resetImage();
            MonsterTotalDelay = 0;
            TankTotalDelay = 0;
            SpeedTotalDelay = 0;
            BigTankTotalDelay = 0;
            numberOfMonsters = 0;
            numberOfTanks = 0;
            numberOfSpeeds = 0;
            numberOfBigTanks = 0;
        }
    }
    
    /**
     * Macht aus dem Wave Array eine zweidimensionale Liste mit Hashmaps
     */
    public void waveconfig() {
        
        for (int i = 0; i < numberOfWaves; i++) {
            List<Map<String, Integer>> row = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                row.add(new HashMap<>());
            }
            waves.add(row);
        }
        
        for(int i=0; i<numberOfWaves; i++) {
            waves.get(i).get(0).put("totalDelay", waveConfig[i][0][0]);
            waves.get(i).get(0).put("number", waveConfig[i][0][1]);
            waves.get(i).get(0).put("spawnDelay", waveConfig[i][0][2]);
            
            waves.get(i).get(1).put("totalDelay", waveConfig[i][1][0]);
            waves.get(i).get(1).put("number", waveConfig[i][1][1]);
            waves.get(i).get(1).put("spawnDelay", waveConfig[i][1][2]);
        
            waves.get(i).get(2).put("totalDelay", waveConfig[i][2][0]);
            waves.get(i).get(2).put("number", waveConfig[i][2][1]);
            waves.get(i).get(2).put("spawnDelay", waveConfig[i][2][2]);
            
            waves.get(i).get(3).put("totalDelay", waveConfig[i][3][0]);
            waves.get(i).get(3).put("number", waveConfig[i][3][1]);
            waves.get(i).get(3).put("spawnDelay", waveConfig[i][3][2]);
        }
    }
    
    /**
     * Startet eine neue Welle
     */
    public void disableTimeOut() {
        waveTimeOut = false;
        endOfRoundMoney = true;
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
            if(MonsterSpawnDelay >= waves.get(currentWave).get(0).get("spawnDelay")
            && numberOfMonsters < waves.get(currentWave).get(0).get("number")) {
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
            if(TankSpawnDelay >= waves.get(currentWave).get(1).get("spawnDelay")
            && numberOfTanks < waves.get(currentWave).get(1).get("number")) {
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
            if(SpeedSpawnDelay >= waves.get(currentWave).get(2).get("spawnDelay")
            && numberOfSpeeds < waves.get(currentWave).get(2).get("number")) {
                SpeedSpawnDelay=0;
                Enemy newSpeed = new Speed();
                getWorld().addObject(newSpeed, spawnX, spawnY);
                newSpeed.setRotation(spawnRotation);
                numberOfSpeeds++;
            }
        }
    }
    
    /**
     * Spawnt BigTanks
     */
    public void BigTankGeneration() {
        BigTankTotalDelay++;
        if(BigTankTotalDelay >= waves.get(currentWave).get(3).get("totalDelay")) {
            BigTankSpawnDelay++;
            if(BigTankSpawnDelay >= waves.get(currentWave).get(3).get("spawnDelay")
            && numberOfBigTanks < waves.get(currentWave).get(3).get("number")) {
                BigTankSpawnDelay=0;
                Enemy newBigTank = new BigTank();
                getWorld().addObject(newBigTank, spawnX, spawnY);
                newBigTank.setRotation(spawnRotation);
                numberOfBigTanks++;
            }
        }
    }
}
