import java.util.ArrayList;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class GameEngine
{

    private Parser aParser;
    private UserInterface aGui;
    private Player aPlayer;
    private int aCount;
    private int aCountTemptation;
    private ArrayList<Room> aRoomList;

    private ArrayList<EnigmeRoom> aDonjonEnigmeRoomList;
    private ArrayList<EnigmeRoom> aEnigmeRoomList; 

    private ArrayList<TrapDoor> aTrapDoorList;
    private int aGoodAnswerDonjon;
   
    
    private void createRooms ()
    {

            
        Room vRue1 = new Room("dans la rue1", "rue1.jpg");
        Room vRue2 = new Room("dans la rue2","rue2.jpg");
        Room vRue3 = new Room("dans la rue3","rue3.jpg");
        Room vRue4 = new Room("dans la rue4","rue4.jpg");
        Room vRue5 = new Room("dans la rue5","rue5.jpg");
        Room vRue6 = new Room ("dans la rue6","rue6.jpg");

        Room vParc2 = new Room ("dans le parc imaginaire: zone fleur", "parc2.jpg");
        Room vParc1 = new Room ("dans le parc imaginaire: zone conviviale", "parc1.jpg");
        Room vSport1 = new Room ("dans la salle de sport 'just exp up!': zone poids lourds","sport1.jpg");
        
        EnigmeRoom vSport2 = new EnigmeRoom ("dans la salle de sport 'just exp up!': zone cardio","sport2.jpg","Je suis le premier dans la course, mais je ne suis pas le champion, alors que mon rang est premier, quel est mon rang?", "2" );
        
        Room vSport3 = new Room ("dans la salle de sport 'just exp up!': zone fitness","sport3.jpg");
        Room vCabinet = new Room ("dans le cabinet du psychologue sinc","cabinet.jpg");
        Room vBureau = new Room ("dans le bureau identité","bureau.jpg");
        TransporterRoom vTransporteur = new TransporterRoom ("entrain de vous transporter","transporteur.jpg", this.aDonjonEnigmeRoomList);
        
        Room vDonjonEntree = new Room ("à l'entrée du donjon intellectuel.","donjonE.jpg");
        Room vDonjonSortie = new Room ("dans le donjon intellectuel","donjonS.jpg");
        Room vBoulangerie = new Room ("dans la boulangerie","boulangerie.jpg");
        Room vRestaurant = new Room ("au restaurant 'coscos'","resto.jpg");
        Room vHopital = new Room ("à l'Hôpital spécialisé en chirurgie esthétique","hopital.jpg");
        
        EnigmeRoom vBu = new EnigmeRoom ("à la bibliothèque des fonctions", "bibli.jpg","Quel est la bonne carte de lieux?","2");
        EnigmeRoom vDonjon2 = new EnigmeRoom ("dans la salle 2 du Donjon", "salle2.jpg","Quelle est la courbe représentative de f?", "3");
        EnigmeRoom vDonjon3 = new EnigmeRoom ("dans la salle 3 du Donjon", "salle3.jpg","Quelle est l'image manquante?", "4");
        EnigmeRoom vDonjon5 = new EnigmeRoom ("dans une salle du Donjon", "salle5.jpg","Quel est le numéro de la salle?", "5");
        EnigmeRoom vDonjon7 = new EnigmeRoom ("dans la salle 7 du Donjon", "salle7.jpg","Une permutation a été faite, après neuf même autres permutations, quel sera le résultat?", "1");
        EnigmeRoom vDonjon11 = new EnigmeRoom ("dans la salle 11 du Donjon", "salle11.jpg","Quel est le plan du donjon sachant que celui-ci est orienté comme sur la boussole ci-contre?", "2");
 
        
        
        
        aPlayer.setCurrentRoom(vBureau);
            
        this.aRoomList.add (vRue1);
        this.aRoomList.add (vRue2);
        this.aRoomList.add (vRue3);
        this.aRoomList.add (vRue4);
        this.aRoomList.add (vRue5);
        this.aRoomList.add (vRue6); 
        this.aRoomList.add (vParc1);
        this.aRoomList.add (vParc2);
        this.aRoomList.add (vSport1);
        this.aRoomList.add (vSport2);
        this.aRoomList.add (vSport3);
        this.aRoomList.add (vCabinet);
        this.aRoomList.add (vHopital);   
        this.aRoomList.add (vBureau);
        this.aRoomList.add (vBoulangerie);
        this.aRoomList.add (vRestaurant);    
        this.aRoomList.add (vDonjonEntree);
        this.aRoomList.add (vDonjonSortie);
        this.aRoomList.add(vBu);
        
        
        this.aDonjonEnigmeRoomList.add(vDonjon2);
        this.aDonjonEnigmeRoomList.add(vDonjon3);
        this.aDonjonEnigmeRoomList.add(vDonjon5);
        this.aDonjonEnigmeRoomList.add(vDonjon7);
        this.aDonjonEnigmeRoomList.add(vDonjon11);

        this.aEnigmeRoomList.add(vDonjon2);
        this.aEnigmeRoomList.add(vDonjon3);
        this.aEnigmeRoomList.add(vDonjon5);
        this.aEnigmeRoomList.add(vDonjon7);
        this.aEnigmeRoomList.add(vDonjon11);
        this.aEnigmeRoomList.add(vBu);
        this.aEnigmeRoomList.add(vSport2);
        
        vRue1.setExits ("est",vParc1);
        vRue2.setExits ("ouest",vSport1);
        vRue2.setExits ("est",vBoulangerie);
        vRue3.setExits ("est",vRestaurant);
        vRue4.setExits ("nord",vCabinet);
        vRue4.setExits ("ouest",vHopital);
        vRue5.setExits ("nord",vBureau);
        vRue5.setExits ("est",vDonjonEntree);
        vRue6.setExits ("nord",vDonjonSortie);
        vRue6.setExits ("sud",vParc2);

        vParc1.setExits ("ouest",vRue1);
        vParc1.setExits ("est",vParc2);
        vParc2.setExits ("ouest",vParc1);
        vParc2.setExits ("nord", vRue6);

        vSport1.setExits ("est",vRue2);
        vSport1.setExits ("nord",vSport3);
        vSport1.setExits ("sud",vSport2);
        vSport2.setExits( "nord",vSport1);
        vSport3.setExits ("sud",vSport1);

        vBoulangerie.setExits ("ouest",vRue2);
        vRestaurant.setExits ("ouest",vRue3);
        vCabinet.setExits ("sud",vRue4);
        vHopital.setExits ("est",vRue4);
        vBureau.setExits ("sud",vRue5);
        vDonjonEntree.setExits ("ouest",vRue5);
        vDonjonEntree.setExits ("sud",vDonjonSortie);
        vDonjonEntree.setExits ("est", vTransporteur);
        vTransporteur.setExits ("est", vDonjon2);
        
        vDonjon2.setExits ("ouest", vTransporteur);
        vDonjon2.setExits ("est",vDonjon3);
        vDonjon3.setExits ("ouest",vDonjon2);
        vDonjon3.setExits ("nord",vDonjon11);
        vDonjon11.setExits("sud", vDonjon3);
        vDonjon2.setExits ("nord", vDonjon7);
        vDonjon7.setExits ("sud", vDonjon2);
        
        vDonjon5.setExits ("est", vDonjon7);
        vDonjon7.setExits ("ouest",vDonjon5);

            
        vDonjon2.setExits ("ouest",vDonjonEntree);
        vDonjonSortie.setExits ("nord",vDonjonEntree);
        vDonjonSortie.setExits ("sud", vRue6);
        vParc1.setExits ("nord",vRue6);
        vRue6.setExits ("est", vBu);
        vBu.setExits ("ouest",vRue6);
        
        vRue1.setExits ("nord", vRue2);
        vRue2.setExits ("nord", vRue3);
        vRue3.setExits ("nord", vRue4);
        vRue4.setExits ("est", vRue5);

            
        vRue2.setExits ("sud", vRue1);
        vRue3.setExits ("sud", vRue2);
        vRue4.setExits ("sud", vRue3);
        vRue5.setExits ("ouest", vRue4);
        
            
        Item vCalculatrice = new Item ("calculatrice","Outil indispensable pour stocker les données des items",0);
        Item vDerivation = new Item ("carte_derivation","Carte pouvant donner des informations sur f'", 100);
        Item vCarte1Go = new Item ("carte_stockage","Carte donnant une capacité de stockage de 1Go une fois insérée à la calculatrice",0);
        Item vPieceId = new Item ("carte_identite","Cette pièce d'identité correspond au n°13: f(x) = sinc",200);
        Item vCarteSport = new Item ("carte_sport","Carte pour une accèder à la salle de sport",100);
        Item vArgent = new Item ("1i", "Pièce de monnaie d'une valeur de 1i",10);
        Item vPapier = new Item ("papier","Liste de cartes d'identité retrouvées. En votre possession, tapez 'liste' pour la lire." ,10);
        Item vLunettes = new Item ("lunettes","Paire de lunette un peu usé",30);
        Item vTeleporteur = new Beamer ("téléporteur",
                "Deux commandes à appliquer sur le téléporteur :"+
                "'charger' sauvegardant le lieu actuelle et 'déclencher' permettant au joueur d'y retourner automatiquement",100);
        Item vCarteBu = new Item ("carte_bu", "Carte d'accès à la bibliothéque des fonctions",100); 
        this.aPlayer.pickItemPlayer(vCalculatrice);

        vSport3.addItem(vPieceId);
        vBureau.addItem (vPapier);
        vParc2.addItem(vCarteSport);
        vBureau.addItem(vArgent);
        vParc1.addItem (vLunettes);

        Door vDoorSport = new Door (vRue2, vSport1, vCarteSport, false);
        Door vDoorBu = new Door (vRue6, vBu, vCarteBu, false);
        TrapDoor vDoorDonjon = new TrapDoor (vDonjonEntree, vTransporteur);
        vDoorSport.setDoorToRoom();
        vDoorDonjon.setDoorToRoom();
        vDoorBu.setDoorToRoom();
        

        this.aTrapDoorList.add (vDoorDonjon);

        Character vExp = new Character ("Exponentielle",
                "'Bonjour, je suis le coatch Exponentielle. Répondez à l'énigme et je vous dit si votre limite en +infini est fini ou pas!'", 
                null, null,"'C'est fini pour vous, désolé si cela paraît offensant mais votre limite en +infini est fini...'");

        Character vCos = new Character ("Cosinus", 
                "'Désolé on est un peu occupé. Tout ce que je peux vous dire c'est que vous n'êtes pas périodique.'",
                null, null,null);

        Character vV = new Character ("Valeur_absolue", 
                "'Bienvenue, je suis le maître Valeur absolue."+
                "Veuillez réussir le donjon pour gagner une carte de stockage!" + "\n"+ 
                "Vous n'avez que droit à 5 erreurs dans toute votre quête, ne faites pas trop d'erreur en donjon! Cela fait partie des nouvelles règles de l'examen de réadmission pour les fonctions.'",
                vCarte1Go, null,null);

        Character vId = new Character ("Identité", 
                "'Bonjour, je suis le responsable Identité. J'ai bien compris votre situation."+"\n"+
                "'Si vous avez besoin d'une carte de stockage performant pour ramasser plus d'items, le donjon intellectuel au sud-est pourra vous en faire gagner une.'"+ "\n"+ 
                "'Perdre sa carte d'identité est une erreur grave pour une fonction, sachez que votre quête s'accompagne d'un examen suivi pour repartir d'une bonne allure." +"\n"+
                "'Prenez donc un papier recensant la liste des pièces d'identité retrouvées et une pièce de monnaie de 1i en espérant qu'elle vous porte chance. " +"\n" +
                "'Bon courage!'"
            ,null,null,null);

        Character vLn = new Character ("Logarithme népérien",
                "'Bonjour, jeune fonction, est-ce que vous auriez vu des lunettes quelque part?'"
            ,vTeleporteur,vLunettes,"'Merci jeune fonction, voici un cadeau de ma part. Vous pouvez constater qu'il est ancien, il date de 50 ans, je népérien de mes affaires!'"+"\n"+
                "'Maintenant que j'ai ma paire de lunettes, j'y vois plus clair. La mer est derrière moi, elle n'est pas père et vous non plus.'");

        Character vVoyante = new Character ("Échelon", 
                "'Bonjour, je suis la voyante échelon. Mes paroles sont toujours sûres. Une petite pièce de 1i et vous saurez votre identité!'"
            , null, vArgent, null);

        Character vPerdu = new Character ("Fonction inconnue", 
                "'Bonjour, j'ai perdu ma carte d'identité comme toi. D'après mes recherches, je serais non périodique, paire et de limite finie.'" + "\n" +
                "'Si vous pensez l'avoir retrouvé, venez me voir s'il-vous-plaît! Et une dernière chose, je trouve la voyante du parc pas très nette...'"
            ,vCarteBu, vPieceId,"'Merci! J'ai pris le risque de valider, c'est bien la mienne! Je suis le Psychologue sinc.'"+"\n"+
            "'Je peux vous dire qu'un moment de votre vie vous vous sentirez nulle, peut-être maintenant à cause de tout ça, force à vous!'" +"\n"+   
                "'Voilà pour vous un petit cadeau pour vous aider.'");

        Character vChirurgien = new Character ("Constante nulle",
                "'Bonjour, je suis le chirurgien nulle. Malgré mon nom, vous pouvez me faire confiance! Je peux vous dériver/intégrer en une magnifique fonction."
            ,null,vDerivation,"'Je ne peux pas vous dériver avec cette carte. Mais je peux vous dire que vous êtes convexe d'après les infos!'");

        Character vBoulanger = new Character ("Fonction carrée", 
                "'Bonjour, vous voulez un test de croissants et décroissants? Pour une pièce de 1i, vous en aurez des faits boulangerie!'"
            ,null,vArgent,"'Vous êtes stric.décroissante.'");

        Character vCosh = new Character ("Cosinus hyperbolique", 
                "'Bonjour, vous pouvez résoudre cette incroyable énigme pour obtenir l'item la plus miraculeuse vous sauvant la mise.'" +"\n"+
                "'Sur ce, je vous laisse j'ai une tonne de livres à ranger.'",
                vDerivation, null, "'Désolé j'aurai voulu vous aider davantage à vous définir, mais on est en rupture de dictionnaire ces temps-ci.");

        vDonjonEntree.addCharacter(vV);
        vRestaurant.addCharacter(vCos);
        vSport2.addCharacter(vExp);
        vBureau.addCharacter (vId);
        vHopital.addCharacter(vChirurgien);
        vRue2.addCharacter (vPerdu);
        vParc2.addCharacter (vLn);
        vParc1.addCharacter (vVoyante);
        vBoulangerie.addCharacter (vBoulanger);
        vBu.addCharacter (vCosh);
    }

    public GameEngine ()
    {
        this.aParser = new Parser();
        this.aPlayer = new Player();
        this.aRoomList = new ArrayList<Room>();
        this.aDonjonEnigmeRoomList = new ArrayList <EnigmeRoom>();
        this.aEnigmeRoomList = new ArrayList <EnigmeRoom>();
        this.aTrapDoorList = new ArrayList <TrapDoor>();
        createRooms();

    }

    public ArrayList<Room> getRoomList(){return this.aRoomList;}

    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }

    private void addCapacity (final Command pC)
    {
        if (!pC.hasSecondWord()) this.aGui.println ("Veuillez insérer une carte de stockage");

        else{
            String vS = pC.getSecondWord();

            if (vS.equals( "carte_stockage")){
                this.aPlayer.setWeightMax (1000);
                this.aGui.println ("Vous avez à présent une capacité de stockage de 1000 Mo");
            }
            else this.aGui.println ("Cet item n'est pas une carte mémoire!");
        }
    }

    private void look(final Command pC)
    {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());

        if (pC.hasSecondWord()){
            String vS = pC.getSecondWord();
            Item vItemPlayer = this.aPlayer.getItemPlayer(vS);
            Item vItemRoom = this.aPlayer.getCurrentRoom().getItem(vS);
            if (vItemRoom == null)
                if (vItemPlayer == null) this.aGui.println ("Cet item n'est ni dans la pièce ni sur vous.");
                else this.aGui.println (vItemPlayer.getDescriptionItem());
            else this.aGui.println (vItemRoom.getDescriptionItem());
        }
    }

    public Character getCharacterInTheRoom ()
    {
        String vNameCharacter = this.aPlayer.getCurrentRoom().getCharacterString();
        Character vCharacter = this.aPlayer.getCurrentRoom().getCharacter(vNameCharacter);
        return vCharacter;
    }

    private void back(final Command pC) 
    {
        if (pC.hasSecondWord()) this.aGui.println ("retour n'accepte pas de second mot.");

        else if (this.aPlayer.lastRoomIsEmpty())this.aGui.println("Vous ne pouvez pas accèder à la pièce précédente.");

        else
        {              
            this.aPlayer.setLast();
            this.aGui.println("Vous êtes retourné à la pièce précédente");
            this.printLocationInfo();
        }

    }

        
    private void goRoom (final Command pC)
    {
        if (!pC.hasSecondWord()) this.aGui.println ("aller où ?");

        Room vNextRoom = null;
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        String vDirection = pC.getSecondWord();

        vNextRoom = vCurrentRoom.getExit(vDirection);

        if ( vNextRoom == null )
            this.aGui.println( "Il n'y a pas de sortie!" );
        else {
            if (vCurrentRoom.isExit(vNextRoom)){
                if (vCurrentRoom.getDoor(vNextRoom)!= null) {
                    Door vDoor = vCurrentRoom.getDoor(vNextRoom);
                    if (this.aTrapDoorList.contains(vDoor)){
                        this.aGui.println ("La porte derrière vous s'est refermée."); 
                        vCurrentRoom.getDoor(vNextRoom).setLocked();
                        this.aPlayer.setNext(vNextRoom);
                        this.aPlayer.clearLastRooms();
                    }
                    else this.aPlayer.setNext(vNextRoom);
                } 
                else this.aPlayer.setNext(vNextRoom);
                this.printLocationInfo();
                this.aCount += 1;

            }
            else{
                this.aGui.println ("Porte vérouillée, vous ne pouvez pas y accéder!");

            }
            if ( this.aCount%5==0 )this.aGui.println ("Vous avez utilisé "+this.aCount+" déplacement(s) sur 50.");
            if ( this.aCount==50 ){
                this.aGui.println ("Vous avez dépassé le nombre de déplacements maximal de 50, GameOver!");
                endGame();
            }
        }

    }

    private void printLocationInfo()
    {     
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );

        if (this.aEnigmeRoomList.contains(this.aPlayer.getCurrentRoom())){
            EnigmeRoom vEnigmeRoom = (EnigmeRoom)this.aPlayer.getCurrentRoom();
            this.aGui.println ("Enigme: " + vEnigmeRoom.getEnigme());
        }
    }           

    private void endGame()
    {
        this.aGui.println( "Merci d'avoir joué, au revoir" );
        this.aGui.enable( false );
    }

        
    private void printWelcome()
    {
        this.aGui.println( "Bienvenue au jeu de Zuul : Définir f!" );
        this.aGui.println( "Vous êtes une fonction ayant perdu sa carte d'identité. Perdre sa carte d'identité est équivalent à perdre sa mémoire! Vous avez oublié votre expression!");  
        this.aGui.println( "Vous devez parcourir la map à la recherche d'indices et d'items afin de le retrouver. Est-elle déjà déposée au bureau ou erre-t-elle encore dans un recoin?");
        this.aGui.println( "Vous n'avez qu'une calculatrice de stockage 20 Mo sur vous, comme vous pouvez le constatez en tapant 'inventaire'.");
        this.aGui.print( "\n" );
        this.aGui.println("Les commandes principaux du jeu sont 'parler' (à la fonction présente), 'prendre/poser + un item', 'aller + une sortie', 'retour' (au lieu précédent). Tapez 'aide' pour en savoir plus sur les commandes.");
        this.aGui.print( "\n" );
        this.printLocationInfo();
    }

    private void printHelp()
    {
        this.aGui.println( "Dans ce jeu, une commande doit être tapée pour effectuer une action. Certaines commandes doivent être suivie d'un deuxième mot de précision pour fonctionner.");
        this.aGui.println ("Vos commandes sont : "+ this.aParser.getCommandString());
        this.aGui.println ("'répondre' et 'valider' prennent un nombre en second mot.");
        this.aGui.println("'retour','regarder','liste','inventaire','test' et 'quitter_le_jeu' ne prennent pas de second mot.");
        this.aGui.println("'insérer' s'utilise sur l'item 'carte_stockage', 'charger' et 'déclencher' sur le 'téléporteur'.");
    }

    private void drop(final Command pC)
    {
        if (!pC.hasSecondWord())this.aGui.println ("poser quoi?");

        else{
            String vS = pC.getSecondWord();
            Item vItem = this.aPlayer.getItemPlayer(vS);
            if (vItem == null) this.aGui.println("Vous n'avez pas cet item");
            else{
                this.aPlayer.getCurrentRoom().addItem(vItem);
                this.aPlayer.dropItemPlayer(vS);
                this.aPlayer.removeWeightPlayer (vItem);
                this.aGui.println ("Vous avez posé l'item " + vS +".");
            }
        }
    }

    private void take (final Command pC)
    {
        if (!pC.hasSecondWord())this.aGui.println ("prendre quoi?");

        else{
            String vS = pC.getSecondWord();
            Item vItem = this.aPlayer.getCurrentRoom().getItem(vS);

            if (vItem == null) this.aGui.println("cet item n'est pas là !");
            else if ( this.aPlayer.iCanTake(vItem)){
                this.aPlayer.getCurrentRoom().removeItem(vS);
                this.aPlayer.pickItemPlayer(vItem);
                this.aPlayer.addWeightPlayer(vItem);
                this.aGui.println ("Vous avez pris l'item " + vS +".");
                this.aGui.println (vItem.getDescriptionItem());
            }
            else this.aGui.println("Nous n'avez plus assez de stockage!");

        }
    }

    private void give (final Command pC)
    {
        if (!pC.hasSecondWord()) 
        {
            this.aGui.println ("donner quoi?");
            return;
        }

        Character vCharacter = getCharacterInTheRoom ();
        if( vCharacter == null) {
            this.aGui.println ("Il n'y a pas de personnage ici!");
            return;
        }

        Item vItemWanted = getCharacterInTheRoom ().getItemWanted();
        if (vItemWanted == null){
            this.aGui.println ("'Je n'ai besoin de rien, mais merci quand même!'");
            return;
        }

        String vS = pC.getSecondWord();
        Item vItemPlayer = this.aPlayer.getItemPlayer(vS);
        if (vItemPlayer == null)
            this.aGui.println ("Vous n'avez pas cet item.");
        else if (vItemPlayer.equals(vItemWanted))
        {
            this.aPlayer.dropItemPlayer(vS);
            this.aPlayer.removeWeightPlayer (vItemPlayer);
            this.aGui.println ("Vous avez donné l'item "+ vItemPlayer.getNameItem()+".");
            Item vItemForPlayer = vCharacter.getItemForPlayer();
            characterHelpPlayer();
            printLocationInfo();
        }
        
        else this.aGui.println ("Ce n'est pas l'item demandé."); 
    }

    public void characterHelpPlayer ()
    {
        Character vCharacter = getCharacterInTheRoom();
        Item vItemForPlayer = vCharacter.getItemForPlayer();
        String vIndice = vCharacter.getIndice();
        if (vIndice != null) this.aGui.println (vIndice);
        if (vItemForPlayer != null){
            this.aPlayer.pickItemPlayer(vItemForPlayer);
            this.aPlayer.addWeightPlayer(vItemForPlayer);
            vCharacter.removeItemForPlayer (vItemForPlayer);
            this.aGui.println ("Vous avez obtenu l'item " + vItemForPlayer.getNameItem()+".");
            this.aGui.println (vItemForPlayer.getDescriptionItem());}
        
        if (vItemForPlayer == null&&vIndice == null){
            this.aGui.println ("Game Over, vous avez perdu!");
            this.aGui.println ("Cette voyante est en fait un examinateur dont le métier est de repérer les fonctions trop naïve.");
            this.aGui.println ("Elle a jugé que vous n'êtes pas digne d'être une fontion et vous a retirez votre calculatrice.");
            this.aGui.println ("Vous êtes maintenant réduit à un simple point de coordonnée...");
            endGame();
        }
        
        if (vCharacter.equals(this.aPlayer.getCurrentRoom().getCharacter("Fonction inconnue"))){
                
                vCharacter.setNameCharacter("Sinus cardinal");
                this.aPlayer.getCurrentRoom().setImageName("rue2happy.jpg");
                this.aPlayer.getCurrentRoom().getExit("sud").setImageName("rue1happy.jpg");
        }
        vCharacter.changePresentation();
    }

    private void items(final Command pC)
    {
        if (pC.hasSecondWord())this.aGui.println ("inventaire n'accepte pas de second mot");
        else 
        {
            this.aGui.println ("Items en possession : "+  this.aPlayer.getItemList().getItemString());
            this.aGui.println ("Vous avez utilisé " + this.aPlayer.getWeightPlayer() + "Mo."); 
            this.aGui.println ("Votre capacité de stockage est de " + this.aPlayer.getWeightMax() + "Mo."); 
        }
    }

    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println("\n");
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) this.aGui.println( "Ce n'est pas une commande valide. Tapez 'aide' si vous en avez besoin." );

        CommandWord vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord == CommandWord.HELP)
            this.printHelp();
        else if ( vCommandWord == CommandWord.GO) 
            this.goRoom( vCommand );
        else if (vCommandWord == CommandWord.INSERT)
            this.addCapacity(vCommand);
        else if (vCommandWord == CommandWord.LOOK)
            this.look(vCommand);
        else if (vCommandWord == CommandWord.BACK)
            this.back(vCommand);
        else if (vCommandWord == CommandWord.TEST)
            this.test(vCommand);
        else if (vCommandWord == CommandWord.VALIDATE)
            this.valid(vCommand);
        else if (vCommandWord == CommandWord.TAKE)
            this.take(vCommand);
        else if (vCommandWord == CommandWord.DROP)
            this.drop(vCommand);    
        else if (vCommandWord == CommandWord.ITEMS)
            this.items(vCommand);
        else if (vCommandWord == CommandWord.GIVE)
            this.give(vCommand);   
        else if (vCommandWord == CommandWord.CHARGE)
            this.charge(vCommand);
        else if (vCommandWord == CommandWord.FIRE)
            this.fire(vCommand);   
        else if (vCommandWord == CommandWord.ANSWER)
            this.answer(vCommand);   
        else if (vCommandWord == CommandWord.LIST)
            this.list(vCommand);   
        else if (vCommandWord == CommandWord.TALK)
            this.talk(vCommand);       
        else if (vCommandWord == CommandWord.UNLOCK)
            this.unlock(vCommand);           
        else if (vCommandWord == CommandWord.QUIT_GAME){
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Tapez simplement 'quitter_le_jeu' pour le quitter." );
            else
                this.endGame();
        }
    }

    private void unlock(final Command pC)
    {

        if (!pC.hasSecondWord()) this.aGui.println ("La commande '' prend un second mot.");
        else{
            Room vRoomToGo = this.aPlayer.getCurrentRoom().getExit(pC.getSecondWord());
            if (this.aPlayer.getCurrentRoom().getDoor(vRoomToGo) == null) this.aGui.println ("Il n'y a pas de porte à dévérouiller!");
            else {
                Door vDoor= this.aPlayer.getCurrentRoom().getDoor(vRoomToGo);
                if (vDoor.getIsUnlocked()) this.aGui.println ("La porte est déjà dévérouillée");
                else {
                    if ( this.aPlayer.getItemPlayer  (vDoor.getKey().getNameItem()) != null)
                    {
                        vDoor.setUnlocked();
                        this.aGui.println ("La porte est maintenant dévérouillée!");
                    }
                    else this.aGui.println ("Vous n'avez pas de quoi dévérouiller la porte");
                }
            }
        }
    }

    private void talk(final Command pC)
    {
        if (pC.hasSecondWord()) this.aGui.println ("La commande 'parler' ne prend pas de second mot.");
        else{
            if (getCharacterInTheRoom() != null) this.aGui.println(getCharacterInTheRoom().getPresentation());
            else this.aGui.println ("Il n'y a personne ici.");
        }
    }

    private void list(final Command pC)
    {   
        if(pC.hasSecondWord())this.aGui.println("liste ne prend pas de second mot.");

        else {
            Item vItem = this.aPlayer.getItemPlayer("papier");
            if (vItem == null) this.aGui.println ("Vous n'avez pas la liste des pièces d'identités retrouvés sur vous.");
            else{
                String vS = "n°1: f(x) = -arctan(x)"+"    "+"n°7: f(x) = exp(-x) - 1" +"\n"
                    + "n°2: f(x) = 1/sqrt(x)"+"      "+"n°8: n°11: f(x) = 10"+ "\n"
                    + "n°3: f(x) = x^2"+"           "+"n°9: f(x) = -x"+ "\n"
                    + "n°4: f(x) = x * sqrt(x)"+"      "+"n°10: f(x) = -ln(x)"+ "\n"
                    + "n°5: f(x) = -th(x)"+"         "+"n°11: f(x) = x*exp( -x )"+"\n"
                    + "n°6: f(x) = ln( -x )"+"         "+"n°12: f(x) = 4x + 12"+ "\n";

                this.aGui.println("Liste de pièces d'identité retrouvées :");
                this.aGui.println(vS);
                this.aGui.println ("Un nombre est associé à chaque expression, tapez 'valider + nombre' pour vous définir.");
                this.aGui.println ("Attention, vous n'avez qu'une tentative possible!");
            }
        }
    }

    private void answer (final Command pC)
    {   
        if(!pC.hasSecondWord())this.aGui.println("Veuillez donner un nombre.");

        else {
            String vNum = pC.getSecondWord();
            if ((EnigmeRoom) this.aPlayer.getCurrentRoom() != null){
                EnigmeRoom vEnigmeRoom = (EnigmeRoom) this.aPlayer.getCurrentRoom();
                if (vEnigmeRoom.getSucess()) this.aGui.println ("Vous avez déjà réussit l'énigme.");
                else{
                    boolean vIsInDonjon = this.aDonjonEnigmeRoomList.contains(this.aPlayer.getCurrentRoom());
                    if(vNum.equals(vEnigmeRoom.getAnswer())){
                        this.aGui.println ("Bravo, c'est la bonne réponse!");
                        vEnigmeRoom.setSucess();
                        if (getCharacterInTheRoom() != null) characterHelpPlayer();
                        if (vIsInDonjon)this.aGoodAnswerDonjon +=1;
                    }   
                    else {
                        this.aGui.println ("Non, ce n'est pas la bonne réponse.");
                        if (vIsInDonjon) this.aCountTemptation +=1;
                    }
                    if (this.aCountTemptation == 5){
                        this.aGui.println ("Game Over, vous avez utilisé trop de tentatives!");
                        endGame();
                    }
                    if (this.aGoodAnswerDonjon == 5) {
                        this.aGui.println ("Félicitation, vous avez réussit le Donjon!");
                       
                        this.aPlayer.setCurrentRoom (this.aRoomList.get(16));
                        this.aGui.println ("\n");
                        printLocationInfo();
                        characterHelpPlayer();
                        this.aGoodAnswerDonjon = 0;
                    }
                }
            }
            else this.aGui.println ("Vous n'êtes pas au Donjon intellectuel!");
        }    
    }

    
    private void charge(final Command pC)
    {
        if(!pC.hasSecondWord())this.aGui.println("Veuillez charger un téléporteur.");

        else {
            String vNameBeamer = pC.getSecondWord();
            Beamer vBeamer = (Beamer) this.aPlayer.getItemPlayer(vNameBeamer);

            if(vBeamer == null) this.aGui.println("Je n'ai pas de téléporteur!");
            else{
                vBeamer.chargeBeamer(this.aPlayer.getCurrentRoom());
                this.aGui.println("Le téléporteur est chargé.");
            }
        }
    }

    private void fire (final Command pC)
    {
        if(!pC.hasSecondWord())this.aGui.println("Veuillez déclencher un déclencheur.");

        else {
            String vNameBeamer = pC.getSecondWord();
            Beamer vBeamer = (Beamer) this.aPlayer.getItemPlayer(vNameBeamer);

            if(vBeamer == null) this.aGui.println("Je n'ai pas de téléporteur!");
            else{
                this.aGui.println("Vous êtes retourné au point de sauvegarde.");
                this.aPlayer.setCurrentRoom(vBeamer.getRoomBeamer());
                this.aPlayer.clearLastRooms();
                printLocationInfo();
            }
        }
    }

    private void valid (final Command pC)
    {
        if (!pC.hasSecondWord())
            this.aGui.println("Veuillez rentrer un numéro.");
        else{
            if (pC.getSecondWord().equals("7"))
                this.aGui.println( "Bravo, il s'agit bien de votre expression Vous avez gagné!");
            else 
                this.aGui.println( "Ce n'était pas votre expression! Game Over, Vous avez perdu!");
            endGame();
        }
    }

    
    private void test(final Command pC)
    {   
        if (pC.hasSecondWord()){
            try{
                String vWord2 = pC.getSecondWord();

                Scanner vS = new Scanner (new File ("test/" + vWord2+".txt"));
                while ( vS.hasNext()) {
                    this.interpretCommand (vS.nextLine());      
                } // if
                return;
            }
            catch (final FileNotFoundException pE)
            {this.aGui.println("fichier non trouvé");}  

        } // if
        else
            this.aGui.println("tester quoi?");
    }

}// Game
