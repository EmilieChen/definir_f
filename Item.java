/**
 * Décrivez votre classe Items ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aDescriptionItem;
    private String aNameItem;
    private int aWeightItem;

    /**
     * Constructeur d'objets de classe Items
     * @param pD prend la description de l'item
     * @param pW prend le poids de l'item
     * @param pN prend le nom de l'item
     */
    public Item(final String pN, final String pD, final int pW)
    {
        this.aDescriptionItem = pD;
        this.aNameItem = pN;
        this.aWeightItem = pW;
    }
    
    public String getNameItem()
    {
        return this.aNameItem;
    }
    
    public int getWeightItem ()
    {
        return this.aWeightItem;
    }
    
    
    public String getDescriptionItem ()
    {
        return this.aDescriptionItem;
    }
}