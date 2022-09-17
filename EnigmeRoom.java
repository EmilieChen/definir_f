
/**
 * Décrivez votre classe EnigmeRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EnigmeRoom extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aEnigme;
    private String aAnswer;
    private boolean aSucess;

    /**
     * Constructeur d'objets de classe EnigmeRoom*
     * @param pDescription give a description of the Room
     * @param pImage is the name of the image
     * @param pEnigme give the enigme
     * @param pAnswer is the answer wanting
     */
    public EnigmeRoom(final String pDescription, final String pImage, final String pEnigme, final String pAnswer)
    {
       super (pDescription, pImage);
       this.aEnigme = pEnigme;
       this.aAnswer = pAnswer;
       this.aSucess = false;
    }

    public boolean getSucess ()
    {
        return this.aSucess;
    
    }
    
    public void setSucess ()
    {
        this.aSucess = true;
    }
    
    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     * @return the Enigme text
     */
    public String getEnigme ()
    { 
        return this.aEnigme;
    }
    
    public String getAnswer ()
    { 
        return this.aAnswer;
    }
}
