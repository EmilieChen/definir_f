
/**
 * Décrivez votre classe Door ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Door
{
    private Room aFirstRoom;
    private Room aSecondRoom;
    private boolean aIsUnlocked;
    private Item aKey;
    

    /**
     * Constructeur d'objets de classe Door
     * @param pFirstRoom is a Room next to the Door
     * @param pSecondRoom is an another Room next to the Door
     * @param pKey can open the Door
     * @param pIsUnlocked give true if we can access without unlock it
     */
    public Door(final Room pFirstRoom, final Room pSecondRoom, final Item pKey, final boolean pIsUnlocked)
    {
        // initialisation des variables d'instance
        this.aFirstRoom = pFirstRoom;
        this.aSecondRoom = pSecondRoom;
        this.aKey = pKey;
        this.aIsUnlocked = pIsUnlocked;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     */
    public void setUnlocked ()
    {
        // Insérez votre code ici
        this.aIsUnlocked = true;
    }
    
    public void setLocked ()
    {
        this.aIsUnlocked = false;
    }
    
    public boolean getIsUnlocked ()
    {
        return this.aIsUnlocked;
    }
    
    public void setDoorToRoom()
    {
        this.aFirstRoom.addDoor (this.aSecondRoom, this);
        this.aSecondRoom.addDoor (this.aFirstRoom, this);
    }
    
    public Item getKey()
    {
        return this.aKey;
    }
    
    public Room getFistRoom ()
    {return this.aFirstRoom;}
    
    public Room getSecondRoom ()
    {return this.aSecondRoom;}
    
}
