import java.util.ArrayList;

/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private RoomRandomizer aRoomRandomizer;
    /***
     * @param pRooms is a list of Room we want to acess by the transporter
     * @param pImage is the name of the Image
     * @param pDescription is a description of the Room
     * 
     * Constructeur d'objets de classe TransporterRoom
     * 
     */
    public TransporterRoom(final String pDescription,final String pImage,final ArrayList <EnigmeRoom> pRooms)
    {
        super(pDescription,pImage);
        this.aRoomRandomizer = new RoomRandomizer(pRooms);
        
    }

    @Override
    public Room getExit(final String pDirection)
    {
        return this.aRoomRandomizer.findRandomDonjonRoom();
        
    }
    
    @Override
    public String getExitString ()
    {return "Vous allez être transporté aléatoirement vers une salle du donjon. Veuillez continuer vers l'est." ;}

    
}