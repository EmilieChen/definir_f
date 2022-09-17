
/**
 * Décrivez votre classe Character ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Character
{
    private String aNameCharacter;
    private Item aItemForPlayer;
    private Item aItemWanted;
    private String aPresentationCharacter;
    private String aIndice;
    
    /**
     * Constructeur d'objets de classe Character
     * @param pName donne le nom du Character
     * @param pPresentation donne une présentation du Character
     * @param pItemWanted donne l'item que le Character veut en échange
     * @param pItemForPlayer est l'item que le Character donne au Player 
     * s'il obtient son aItemWanted
     * @param pIndice donne l'indice que le Character donne au Player 
     * s'il obtient son aItemWanted
     */
    public Character(final String pName, final String pPresentation, final Item pItemForPlayer, final Item pItemWanted,final String pIndice)
    {
        this.aNameCharacter = pName;
        this.aPresentationCharacter = pPresentation;
        
        this.aItemForPlayer = pItemForPlayer;
        this.aItemWanted = pItemWanted;
        this.aIndice = pIndice;
        
    }

    public String getNameCharacter()
    {
        return this.aNameCharacter;
    }
   
    public void setNameCharacter(final String pName)
    {
        this.aNameCharacter = pName;
    }
    
    public String getPresentation()
    {
        return this.aPresentationCharacter;
    }
   

    public Item getItemForPlayer ()
    {
        return this.aItemForPlayer;
    }
    
    public Item getItemWanted ()
    {
        return this.aItemWanted;
    }
    
    public String getIndice()
    {
        return this.aIndice;
    }
    

    public void removeItemForPlayer (final Item pItem)
    {
        this.aItemForPlayer = null;
    }
     
    public void changePresentation ()
    {
        if (this.aIndice == null) this.aPresentationCharacter =  "'Bonne courage pour la suite, définis-toi'";
        else 
            this.aPresentationCharacter = "'"+ this.aIndice + "\n" + "Bonne courage pour la suite, définis-toi!'";
    }
   
    
    
    
    
    
}
