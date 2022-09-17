import java.util.Random;
import java.util.ArrayList;

/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer 
{
    private Random aRandom;
    private ArrayList <EnigmeRoom> aRoomForTransporter;
    
    /**
     * @param pRooms is a list of Rooms we can access by the Transporter 
     * 
     * Constructeur d'objets de classe RoomRandomizer
     */
    public RoomRandomizer(final ArrayList <EnigmeRoom> pRooms)
    {
        this.aRoomForTransporter = pRooms;
        this.aRandom = new Random();
    }

    public int getRandomInt()
    {
        int vE = this.aRoomForTransporter.size();
        return this.aRandom.nextInt(vE);
    }
    
    
    public Room findRandomDonjonRoom()
    {
        return this.aRoomForTransporter.get(getRandomInt());
    }
}
