import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monster_Spawner extends Actor {
    private int spawnX;
    private int spawnY;
    private int amountOfEnemiesSpawned = 0;
    private int numberOfActs = 0;
    private int currentWave = 1;
    private boolean waveTimeOut = true;
    
    public Monster_Spawner(Start start) {
        spawnX = start.getX();
        spawnY = start.getY();
    }
    
    public void act() {
        if(!waveTimeOut) {
            waveGeneration(currentWave);
            numberOfActs++;
        }
        else {
            if(getWorld().getObjects(Enemy.class).size() == 0) {
            getWorld().getObjects(NextWaveButton.class).get(0).resetImage();
            }
        }
    }
    
    public void disableTimeOut() {
        waveTimeOut = false;
    }
    
    public void waveGeneration(int waveNumber) {
        switch(waveNumber){
            case 1: spawnMonster(20, 50); break;
            case 2: spawnTank(10, 100); break;
            case 3: spawnMonster(40, 25); break;
        }
    }
    
    public void spawnMonster(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 1 && amountOfEnemies>amountOfEnemiesSpawned) {
            Enemy newMonster = new Monster();
            getWorld().addObject(newMonster, spawnX, spawnY);
            amountOfEnemiesSpawned++;
        }
        if(amountOfEnemies==amountOfEnemiesSpawned) {
            amountOfEnemiesSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
    
    public void spawnTank(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 1 && amountOfEnemies>amountOfEnemiesSpawned) {
            Enemy newMonster = new Tank();
            getWorld().addObject(newMonster, spawnX, spawnY);
            amountOfEnemiesSpawned++;
        }
        if(amountOfEnemies==amountOfEnemiesSpawned) {
            amountOfEnemiesSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
}
