import java.util.HashMap ;
/**
 * Décrivez votre classe ItemList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private HashMap <String, Item> aItemMap;

    /**
     * Constructeur d'objets de classe ItemList
     */
    public ItemList()
    {
        this.aItemMap = new HashMap<>();
    }

    public String getItemString ()
    {   
        StringBuilder returnString = new StringBuilder( "" );
        for ( String vS : this.aItemMap.keySet() )
            returnString.append(vS + "/ " );
        return returnString.toString();
    }
    
    
    public HashMap <String, Item> getItemMap ()
    {
        return this.aItemMap;
    }
}
