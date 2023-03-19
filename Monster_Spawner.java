import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monster_Spawner extends Actor {
    private int spawnX;
    private int spawnY;
    private int spawnRotation;
    private int amountOfEnemiesSpawned = 0;
    private int numberOfActs = 0;
    private int currentWave = 1;
    private boolean waveTimeOut = true;
    
    public Monster_Spawner(Start start) {
        spawnX = start.getX();
        spawnY = start.getY();
        spawnRotation = start.getRotation() + 90;
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
            case 1: spawnTank(500, 10); break;
        }
    }
    
    public void spawnMonster(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 1 && amountOfEnemies>amountOfEnemiesSpawned) {
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
    
    public void spawnTank(int amountOfEnemies, int waitTime) {
        if(numberOfActs%waitTime == 1 && amountOfEnemies>amountOfEnemiesSpawned) {
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
}
