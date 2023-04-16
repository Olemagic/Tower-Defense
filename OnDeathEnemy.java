/**
 * Parent class für alle Gegner, die beim Tod etwas ausführen
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class OnDeathEnemy extends Enemy
{
    /**
     * Act-Methode von OnDeathEnemy:<br>
     * -Überprüft, ob der Gegner keine Leben mehr hat, entfernt ihn und ruft die OnDeath-Methode auf<br>
     * -Animation<br>
     * -Timing fürs Weg-finden<br>
     * -Bewegung der Gegner
     * @see Enemy#act()
     */
    public void act() {
        if (health <= 0) {
            onDeath();
            ((Level) getWorld()).addMoney(moneyOnDeath);
            getWorld().removeObject(this);
            return;
        }
        
        if(freezeTime==0) {
            if (distanceMoved%5 == 0) {
                updateImage();
            }
            if(distanceMoved%100 < speed){
                findNextPath();
            }
            move(speed);
            distanceMoved += speed;
        }
        else {
            freezeTime--;
        }
    }
    
    /**
     * Wird beim Tod aufgerufen
     */
    protected void onDeath() {}
}
