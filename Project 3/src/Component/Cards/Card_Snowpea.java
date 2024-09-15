package Component.Cards;
import Template.GameState;
import javax.swing.*;
import java.io.Serializable;

/**
 * A class to make snow pea card
 *
 * @author Mohammad
 */
public class Card_Snowpea extends Card implements Serializable {

    /**
     * Perform any initialization that is required
     * @param locX The card x coordinate
     * @param locY The card y coordinate
     * @param state The game state
     */
    public Card_Snowpea (int locX, int locY, GameState state){
        super (locX, locY, state) ;
        setCurrentImage(new ImageIcon("./Pics/card_freezepeashooter.png").getImage());
        setPeriod(7500);
        if (getState().getType().equals("Hard")){
            setPeriod(30000);
        }
    }


    //setters/////////////////////////////////////////////////////////////////
    public void setActivePic(){
        setCurrentImage(new ImageIcon("./Pics/card_freezepeashooter.png").getImage());
    }
    public void setInActivePic(){
        setCurrentImage(new ImageIcon("./Pics/card_freezepeashooter_inactive.png").getImage());
    }
    //////////////////////////////////////////////////////////////////////////

}
