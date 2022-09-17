import java.util.Stack;
import java.util.HashMap ;
/**
 * Décrivez votre classe Player ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aCurrentRoom;
    private int aWeightMax;
    private int aWeightPlayer;
    private Stack<Room> aLastRooms;
    private UserInterface aGui;
    private ItemList aItemList;
    private String aNamePlayer;
    
    /**
     * Constructeur d'objets de classe Player
     */
    public Player()
    {
        this.aLastRooms = new Stack<Room>();
        this.aItemList = new ItemList();
        this.aWeightMax = 20;
    }
    
    public void setWeightMax (final int pWeight)
    {
        this.aWeightMax = pWeight;
    }
    
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
    }

    
    public void addWeightPlayer(final Item pItem)
    {
        this.aWeightPlayer += pItem.getWeightItem();
    }
    
    public void removeWeightPlayer(final Item pItem)
    {
        this.aWeightPlayer -= pItem.getWeightItem();
    }
    
    public int getWeightPlayer()
    {
        return this.aWeightPlayer;
    }
    
    public int getWeightMax()
    {
        return this.aWeightMax;
    }
 
    
    public boolean iCanTake (final Item pItem)
    {
        return (pItem.getWeightItem() + this.aWeightPlayer <= this.aWeightMax);
    }
    
    public Item getItemPlayer(final String pName)
    {
        return this.aItemList.getItemMap().get(pName);
    }
    
    public void setNext(final Room pNextRoom)
    {
         this.aLastRooms.push (this.aCurrentRoom);
         this.aCurrentRoom = pNextRoom;
    }
    
    public void setLast()
    {
        this.aCurrentRoom = this.aLastRooms.pop(); 
    }
    
    public Room getLastRoom()
    {
        return this.aLastRooms.pop();
    }
    
    public void clearLastRooms()
    {
        this.aLastRooms.clear();
    }
       
    public void setCurrentRoom (final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }
    
    public void dropItemPlayer (final String pS)
    {
        this.aItemList.getItemMap().remove(pS);
    }
    
    public void pickItemPlayer (final Item pItem)
    {
        this.aItemList.getItemMap().put(pItem.getNameItem(), pItem);
    }
    
    public ItemList getItemList()
    {
        return this.aItemList;
    }
    
    
    public boolean lastRoomIsEmpty ()
    {
        return this.aLastRooms.empty() == true;
    }
    
    public Room getCurrentRoom ()
    {
        return this.aCurrentRoom;
    }
    
    
}
