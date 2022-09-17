import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    
    private HashMap<String, CommandWord> aValidCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        aValidCommands = new HashMap<String, CommandWord>();
        aValidCommands.put("prendre", CommandWord.TAKE);
        aValidCommands.put("poser", CommandWord.DROP);
        aValidCommands.put("aller", CommandWord.GO);
        aValidCommands.put("retour", CommandWord.BACK);
        aValidCommands.put("parler", CommandWord.TALK);
        aValidCommands.put("donner", CommandWord.GIVE);
        aValidCommands.put("regarder", CommandWord.LOOK);
        aValidCommands.put("répondre", CommandWord.ANSWER);
        aValidCommands.put("liste", CommandWord.LIST);
        aValidCommands.put("inventaire", CommandWord.ITEMS);
        aValidCommands.put("insérer", CommandWord.INSERT);
        aValidCommands.put("charger", CommandWord.CHARGE);
        aValidCommands.put("déclencher", CommandWord.FIRE);
        aValidCommands.put("tester", CommandWord.TEST);
        aValidCommands.put("aide", CommandWord.HELP);
        aValidCommands.put("valider", CommandWord.VALIDATE);
        aValidCommands.put("dévérouiller", CommandWord.UNLOCK);
        aValidCommands.put("quitter_le_jeu", CommandWord.QUIT_GAME);
        
    } // CommandWords()

    public CommandWord getCommandWord(final String pCommandWord)
    {
        CommandWord vCommand = aValidCommands.get(pCommandWord);
        if(vCommand != null) {
            return vCommand;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
   
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     * @param pString qui prend l'input
     */
    
    
    public boolean isCommand(final String pString)
    {
        return aValidCommands.containsKey(pString);
    }
    
    
    
    
    public String getCommandList() 
    {
        String vS = "";
        for(String vCommand : aValidCommands.keySet()) {
            vS += vCommand + "  ";
        }
        return vS;
    }
    
} 
// CommandWords