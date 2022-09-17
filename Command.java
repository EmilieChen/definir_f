public class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;
    
    public Command (final CommandWord pCom, final String pSec)
    {
        this.aCommandWord = pCom;
        this.aSecondWord = pSec;
        
    }
   
    public CommandWord getCommandWord()
    { 
        return this.aCommandWord;
    }
    
    public String getSecondWord()
    {
        return this.aSecondWord;
    }
    
    public boolean hasSecondWord ()
    {
        return this.aSecondWord != null;
    }
    
    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (aCommandWord == CommandWord.UNKNOWN);
    }
    
    
    
    
    
    
    
} // Command
