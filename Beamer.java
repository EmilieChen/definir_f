
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aRoomBeamer;

    /**
     * @param pN is the name of item Beamer
     * @param pD is the description of item Beamer
     * @param pW is the weight of item Beamer
     * Constructeur d'objets de classe Beamer
     */
    public Beamer(final String pN, final String pD, final int pW)
    {
        super (pN,pD,pW);
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param pR is the Room we want to return using Beamer
     */
    public void chargeBeamer (final Room pR)
    {
        this.aRoomBeamer = pR;
    
    }
    
   
    
    public Room getRoomBeamer()
    {
        return this.aRoomBeamer;
    }
}





    
    
    
    
