import java.util.HashMap ;
import java.util.Set;


public class Room
{
    private String aDescription; 
    private String aImageName;
    private HashMap <String, Room> aExits;
    private HashMap <String, Character> aCharacters;
    private ItemList aItemList;
    private HashMap<Room,Door> aDoors = new HashMap<Room,Door>();
    
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        aExits = new HashMap <String, Room>();
        aCharacters = new HashMap <String, Character>();
        aDoors = new HashMap <Room, Door>();
        this.aImageName = pImage;
        this.aItemList = new ItemList();
    }
    
   
    public boolean isExit(final Room pRoom)
    {
        if (this.aDoors.get(pRoom)!=null)
        { return this.aDoors.get(pRoom).getIsUnlocked() ; }
        return true;
    }
    
    
    public Door getDoor (final Room pRoom)
    {
        return this.aDoors.get(pRoom);
    }
    
    
    public String getDescription()
    {
        return this.aDescription;
    }
    
    public void setExits(final String pDirection, final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }
    
    public void setImageName (final String pImage)
    {
        this.aImageName = pImage;
    }
    
    
    public Room getExit(final String pDirection)
    {
        return this.aExits.get(pDirection);
    }
    
    public void addItem (final Item pItem)
    {
        this.aItemList.getItemMap().put(pItem.getNameItem(), pItem);
    }
        
    public void removeItem (final String pS)
    {
        this.aItemList.getItemMap().remove(pS);
    }
    
    public void addCharacter (final Character pCharacter)
    {
        this.aCharacters.put(pCharacter.getNameCharacter(),pCharacter);
    }
    
    public void addDoor(final Room pRoom, final Door pDoor)
    {
        this.aDoors.put(pRoom,pDoor);
    }
    
    
    public Item getItem(final String pNameItem)
    {
        return this.aItemList.getItemMap().get(pNameItem);
    }
    
    
    
    
    public String getExitString ()
    {   
        StringBuilder returnString = new StringBuilder( "Sortie(s):" );
        for ( String vS : aExits.keySet() )
            returnString.append( " " + vS );
        return returnString.toString();
    }
    
    public String getCharacterString ()
    {   
        StringBuilder returnString = new StringBuilder( "" );
        for ( String vS : aCharacters.keySet() )
            returnString.append(vS);
        return returnString.toString();
    }
    
    public Character getCharacter (final String pName)
    {
        return this.aCharacters.get(pName);
    }
    
    public String getLongDescription()
    {   
        String vItem = "Item(s) : " + this.aItemList.getItemString();
        String vPnj = "Fonction : " + getCharacterString();
        if (this.aItemList.getItemMap().size() == 0){
            
            if (this.aCharacters.size() == 0)
                 return "Vous êtes " + this.aDescription + ".\n" + "Il n'y a pas de personnage" + ".\n" + "Il n'y a pas d'Item" + ".\n" + getExitString();
            
            else return "Vous êtes "+this.aDescription  +"\n" +  vPnj +  "\n" + "Il n'y a pas d'Item" + ".\n"  + getExitString();
        }
        else{
            if (this.aCharacters.size() == 0)
                 return "Vous êtes "+this.aDescription + ".\n" +"Il n'y a pas de personnage"+ ".\n" + vItem + "\n" +  getExitString();
            else return "Vous êtes "+this.aDescription + ".\n"  +  vPnj + "\n" + vItem + "\n"+ getExitString();
        }
   
    }
    
    public String getImageName(){return this.aImageName;}
     
} //Room
    
    
    
        
        
