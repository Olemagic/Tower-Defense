/**
 * Vierter Gegner, spawnt zwei Monster beim Tod
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class BigTank extends OnDeathEnemy {
    /**
     * Constructor für BigTank:<br>
     * -Setzt Leben, Schaden, Geschwindigkeit, Todesgeld und Namen
     */
    public BigTank() {
        //config
        health = 20;
        damage = 10;
        speed = 1;
        moneyOnDeath = 10;
        enemyName = "Enemy-4";
    }
    
    /**
     * Spawnt zwei Monster an der Todesstelle und lässt sie Rotation und die zurückgelegte Distanz übernehmen (damit sie den Weg finden)
     */
    public void onDeath() {
        Monster monster1 = new Monster();
        Monster monster2 = new Monster();
        
        getWorld().addObject(monster1, getX(), getY());
        getWorld().addObject(monster2, getX(), getY());
        
        monster1.setRotation(getRotation());
        monster2.setRotation(getRotation());
        
        monster1.setDistanceMoved(distanceMoved);
        monster2.setDistanceMoved(distanceMoved);
        
        for (int i = 0; i < 20; i++) {
            monster2.act();
        }
    }
}
