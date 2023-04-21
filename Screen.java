import greenfoot.Greenfoot;

/**
 * Win-/Lose screen
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Screen extends GUI {
    /**
     * Act-Methode von Screen:<br>
     * -Wenn angeklickt wird das Mainmenu geöffnet
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ((Level) getWorld()).getMusic().stop();

            Greenfoot.setWorld(new MainMenu());
        }
    }
}
