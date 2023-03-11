import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monster_Spawner extends Actor {
    private int amountOfMonstersSpawned = 0;
    private int numberOfActs = 0;
    private int currentWave = 1;
    private boolean waveTimeOut = true;
    
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
            case 1: spawnMonster(10, 100); break;
            case 2: spawnMonster(8, 500); break;
            case 3: spawnMonster(5, 100); break;
        }
    }
    
    public void spawnMonster(int amountOfMonsters, int waitTime) {
        if(numberOfActs%waitTime == 1 && amountOfMonsters>amountOfMonstersSpawned) {
            Enemy newMonster = new Tank();
            getWorld().addObject(newMonster, 0, 450);
            amountOfMonstersSpawned++;
        }
        if(amountOfMonsters==amountOfMonstersSpawned) {
            amountOfMonstersSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
}
