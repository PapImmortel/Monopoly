import java.util.*;
/**
 * Classe de base du jeu avec toutes les informations du monopoly
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 * @date (2023/01/12)
 */
public class VideoGame
{

    private final int aNbJoueur;
    private final Banque aBanque;
    private int aNumJoueurActif;
    private final HashMap<Integer,Player> aListPlayer;
    private final HashMap<Integer,Cases_Plateau> aListeCase;

    /**
     * Constructeur à 3 paramètre de la Classe VideoGame
     * @param pNbJoueur aNbJoueur nombre de joueurs actifs pour la partie à venir
     * @param pListPlayer aListPlayer HashMap de la liste des joueurs
     */
    public VideoGame(int pNbJoueur,HashMap<Integer,String> pListPlayer,String[] pListCouleur)
    {
        this.aNbJoueur = pNbJoueur;
        this.aBanque = new Banque();
        new GameFrame("Javapoly");
        this.aListPlayer = new HashMap<>();
        this.aListeCase = new HashMap<>();
        remplirCase();
        int vPositionListCouleur=0;
        for (Map.Entry<Integer,String> PlayerEntry : pListPlayer.entrySet())
        {
            Player PlayerTemp = new Player(1500,PlayerEntry.getValue(),pListCouleur[vPositionListCouleur],getCase(0) );
            this.aListPlayer.put((vPositionListCouleur+1),PlayerTemp);
            vPositionListCouleur+=1;
        }//while(.)
        this.aNumJoueurActif = 1;
        tourJoueur();
        //début du tour du joueur1
    }//VideoGame(.,.,.)



    /**
     * Accesseur du nombre de joueurs dans la partie
     * @return aNbJoueur nombre de joueurs dans la partie
     */
    public int getNbJoueur()
    {
        return this.aNbJoueur;
    }//getNbJoueur()



    /**
     * Accesseur de Banque
     * @return aBanque Banque du jeu
     */
    public Banque getBanque()
    {
        return this.aBanque;
    }//getBanque()




    /**
     * Accesseur du Joueur actif
     * @return JoueurActif le joueur actif
     */
    public Player getJoueurActif()
    {
        return this.aListPlayer.get(this.aNumJoueurActif);
    }//getJoueurActif()
    /**
     * Mutateur de numéro du joueur Actif
     * @param pNumJoueurActif le numéro du joueurActif de la classe Player
     */
    public void setNumJoueurActif(int pNumJoueurActif)
    {
        this.aNumJoueurActif = pNumJoueurActif;
    }//setJoueurActif(.)

    /**
     * Accesseur du numéro du Joueur actif
     * @return aNumJoueurActif joueur actif
     */
    public int getNumJoueurActif()
    {
        return this.aNumJoueurActif;
    }//getJoueurActif()



    /**
     * Accesseur de la liste des cases du plateau
     * @return aListeCase liste des cases du plateau
     */
    public HashMap<Integer,Cases_Plateau> getListeCase()
    {
        return this.aListeCase;
    }//getListeCase()

    /**
     * Permet d'obtenir une case en fonction de son numéro dans le plateau
     * @param pNbCase numéros de la case à retourner
     * @return case correspondant au numéros passé en paramètre
     */
    public Cases_Plateau getCase(int pNbCase)
    {
        return this.aListeCase.get(pNbCase);
    }//getCase(.)

    /**
     * Méthode permettant de remplir la hashMap de la liste des cases avec les cases du plateau
     */
    public void remplirCase()
    {
        this.aListeCase.put( 0,new Cases_Plateau("DEPART",0,false));
        this.aListeCase.put( 1,new Rue("BOULEVARD DE BELLEVILLE",1, 60,0,0, 0, "marron",new int[]{2,10,30,90,160,250},30));
        this.aListeCase.put( 2,new CaseEffet("CAISSE DE COMMUNAUTE", 2,2));
        this.aListeCase.put( 3,new Rue("RUE LECOURBE",3, 60,0,0, 0, "marron",new int[]{4,20,60,180,320,450},30));
        this.aListeCase.put( 4,new Cases_Plateau("IMPOTS SUR LE REVENU",4,false));
        this.aListeCase.put( 5,new Gare("GARE MONTPARNASSE",5, 200,0,100));
        this.aListeCase.put( 6,new Rue("RUE DE VAUGIRARD",6, 100,0,0, 0, "cyan",new int[]{6,30,90,270,400,550},50));
        this.aListeCase.put( 7,new CaseEffet("CHANCE",7,1));
        this.aListeCase.put( 8,new Rue("RUE DE COURCELLES",8, 100,0,0, 0, "cyan",new int[]{6,30,90,270,400,550},50));
        this.aListeCase.put( 9,new Rue("AVENUE DE LA REPUBLIQUE",9, 120,0,0, 0, "cyan",new int[]{8,40,100,300,450,600},60));
        this.aListeCase.put(10,new Cases_Plateau("Prison",10,false));
        this.aListeCase.put(11,new Rue("BOULEVARD DE LA VILLETTE",11, 140,0,0, 0, "rose",new int[]{10,50,150,450,625,750},70));
        this.aListeCase.put(12,new Compagnie("COMPAGNIE DE La DISTRIBUTION D'ELECTRICITE",12, 150,0,75));
        this.aListeCase.put(13,new Rue("AVENUE DE NEUILLY",13, 140,0,0, 0, "rose",new int[]{10,50,150,450,625,750},70));
        this.aListeCase.put(14,new Rue("RUE DU PARADIS",14, 160,0,0, 0, "rose",new int[]{12,60,180,500,700,900},80));
        this.aListeCase.put(15,new Gare("GARE DE LYON",15, 200,0,100));
        this.aListeCase.put(16,new Rue("AVENUE DE MOZART",16, 180,0,0, 0, "orange",new int[]{14,70,200,550,750,950},90));
        this.aListeCase.put(17,new CaseEffet("CAISSE DE COMMUNAUTE",17,2));
        this.aListeCase.put(18,new Rue("BOULEVARD SAINT-MICHEL",18, 180,0,0, 0, "orange",new int[]{14,70,200,550,750,950},90));
        this.aListeCase.put(19,new Rue("PLACE DE PIGALLE",19, 200,0,0, 0, "orange",new int[]{16,80,220,600,800,1000},100));
        this.aListeCase.put(20,new Cases_Plateau("PARC GRATUIT",20,false));
        this.aListeCase.put(21,new Rue("AVENUE DE MATIGNON",21, 220,0,0, 0, "rouge",new int[]{18,90,250,700,875,1050},110));
        this.aListeCase.put(22,new CaseEffet("CHANCE",22,1));
        this.aListeCase.put(23,new Rue("BOULEVARD MALESHERBES",23, 220,0,0, 0, "rouge",new int[]{18,90,250,700,875,1050},110));
        this.aListeCase.put(24,new Rue("AVENUE HENRY-MARTIN",24, 240,0,0, 0, "rouge",new int[]{20,100,300,750,925,1100},120));
        this.aListeCase.put(25,new Gare("GARE DU NORD",25, 200,0,100));
        this.aListeCase.put(26,new Rue("FAUBOURG SAINT-HONORE",26, 260,0,0, 0, "jaune",new int[]{22,110,330,800,975,1150},130));
        this.aListeCase.put(27,new Rue("PlACE DE LA BOURSE",27, 260,0,0, 0, "jaune",new int[]{22,110,330,800,975,1150},130));
        this.aListeCase.put(28,new Compagnie("COMPAGNIE DE la DISTRIBUTION DES EAUX",28, 150,0,75));
        this.aListeCase.put(29,new Rue("RUE DE LA FAYETTE",29, 280,0,0, 0, "jaune",new int[]{24,120,360,850,1025,1200},140));
        this.aListeCase.put(30,new Cases_Plateau("EN ALLEZ PRISON",30,false));
        this.aListeCase.put(31,new Rue("AVENUE de BRETEUIL",31, 300,0,0, 0, "vert",new int[]{26,130,390,900,1100,1275},150));
        this.aListeCase.put(32,new Rue("AVENUE FOCH",32, 300,0,0, 0, "vert",new int[]{26,130,390,900,1100,1275},150));
        this.aListeCase.put(33,new CaseEffet("CAISSE DE COMMUNAUTE",33,2));
        this.aListeCase.put(34,new Rue("BOULEVARD DES CAPUCINES",34, 320,0,0, 0, "vert",new int[]{28,150,450,1000,1200,1400},160));
        this.aListeCase.put(35,new Gare("GARE SAINT-LAZARE",35, 200,0,100));
        this.aListeCase.put(36,new CaseEffet("CHANCE",36,1));
        this.aListeCase.put(37,new Rue("AVENUE DES CHAMPS-ELYSEES",37, 350,0,0, 0, "bleu",new int[]{35,175,500,1100,1300,1500},175));
        this.aListeCase.put(38,new Cases_Plateau("TAXE DE LUXE",38,false));
        this.aListeCase.put(39,new Rue("RUE DE LA PAIX",39, 400,0,0, 0, "bleu",new int[]{50,200,600,1400,1700,2000},200));
    }//remplirCase()

    /**
     * Méthode de gestion de l'achat d'un terrain par un joueur
     */
    public boolean acheterTerrain()
    {
        Patrimoine vTerrain=(Patrimoine)getJoueurActif().getPosition();

        if(getJoueurActif().getArgent() - vTerrain.getPrixAchat()>=0)//si on a l'argent pour acheter le terrain
        {
            GameFrame.PrintMSG("Tu achètes le titre de propriété : " + vTerrain.getNomCase());
            getJoueurActif().ajouteArgent(- vTerrain.getPrixAchat());
            vTerrain.setJoueurBoss(getNumJoueurActif());
            getJoueurActif().ajouterPatrimoine(vTerrain,1);
            getJoueurActif().getPatrimoine().get(vTerrain.getNbCase()).setJoueurBoss(getNumJoueurActif());
            Patrimoine vCaseSetting= (Patrimoine) this.aListeCase.get(vTerrain.getNbCase());
            vCaseSetting.setJoueurBoss(getNumJoueurActif());
            return true;
        }
        else {
            GameFrame.PrintMSG("Tu n'as pas l'argent pour acheter le titre de propriété : " + vTerrain.getNomCase());
            GameFrame.PrintMSG("Celui-ci coute : " + vTerrain.getPrixAchat() + " or tu n'as que " + getJoueurActif().getArgent());
            GameFrame.PrintMSG("Tu dois donc le mettre en enchère ou revendre certaines de tes possessions pour l'acheter");
            return false;
        }
    }
    /**
     * Méthode de gestion de l'enchère d'un terrain
     */
    public void enchere()
    {
        Patrimoine vTerrain=(Patrimoine)getJoueurActif().getPosition();
        int prix = vTerrain.getPrixAchat();
        int vGagnant = 0;
        int vJoueurActuel=getNumJoueurActif();
        for(int i=0; i<getNbJoueur();i++)
        {
            if(this.aListPlayer.get(vJoueurActuel).getArgent()-prix>=0)
            {

                boolean fonctionne = false;
                while(!fonctionne)
                {
                    GameFrame.PrintMSG("Le terrain coute actuellement " + vTerrain.getPrixAchat());
                    GameFrame.PrintMSG(this.aListPlayer.get(vJoueurActuel).getNomJoueur() + ", si tu souhaites l'acheter tape acheter, sinon tape laisser");
                    String temp = GameFrame.getCommand();
                    if(temp.equals("acheter"))
                    {
                        vGagnant=vJoueurActuel;
                        vJoueurActuel=(vJoueurActuel+1) % (getNbJoueur()+1);
                        if(vJoueurActuel==0)
                        {
                            vJoueurActuel+=1;
                        }
                        fonctionne=true;
                    }
                    else if (temp.equals("laisser") )
                    {
                        fonctionne=true;
                    }
                    else
                    {
                        GameFrame.PrintMSG("Je n'ai pas compris votre commande, tape acheter pour acheter le terrain, sinon tape laisser");
                    }
                }
            }
            if(vGagnant==0)
            {
                vJoueurActuel=(vJoueurActuel+1) % (getNbJoueur()+1);
                if(vJoueurActuel==0)
                {
                    vJoueurActuel+=1;
                }
            }
            else
            {
                break;
            }
        }
        if(vGagnant!=0) {
            while (vGagnant != vJoueurActuel) {
                if (this.aListPlayer.get(vJoueurActuel).getArgent() - prix > 0) {

                    boolean fonctionne = false;
                    while (!fonctionne) {
                        GameFrame.PrintMSG("Le terrain coute actuellement " + prix);
                        GameFrame.PrintMSG(this.aListPlayer.get(vJoueurActuel).getNomJoueur() + ", si tu souhaites enchérir tape le prix que tu souhaites enchérir ");
                        GameFrame.PrintMSG("sinon tape laisser\n");
                        String temp = GameFrame.getCommand();
                        boolean valeurEntiere = true;
                        try {
                            Integer.parseInt(temp);
                        } catch (NumberFormatException e) {
                            valeurEntiere = false;
                        }
                        if (temp.equals("laisser"))
                        {
                            fonctionne = true;
                        }
                        else if (valeurEntiere) {
                            if (this.aListPlayer.get(vJoueurActuel).getArgent() - Integer.parseInt(temp) >= 0 && Integer.parseInt(temp)>prix) {
                                GameFrame.PrintMSG(this.aListPlayer.get(vJoueurActuel).getNomJoueur() + "a enchéri pour " + Integer.parseInt(temp));
                                prix = Integer.parseInt(temp);
                                vGagnant = vJoueurActuel;
                                fonctionne = true;
                            }
                            else if(Integer.parseInt(temp)<=prix)
                            {
                                GameFrame.PrintMSG("Tu dois miser une somme supérieur si tu veux acquérir cette propriété\n");
                            }
                            else
                            {
                                GameFrame.PrintMSG("Tu ne possèdes pas autant d'argent\n");
                            }
                        }
                        else
                        {
                            GameFrame.PrintMSG("Je n'ai pas compris votre commande\n");
                        }
                    }

                }
                vJoueurActuel = (vJoueurActuel + 1) % (getNbJoueur() + 1);
                if (vJoueurActuel == 0) {
                    vJoueurActuel += 1;
                }
            }
            GameFrame.PrintMSG(this.aListPlayer.get(vGagnant).getNomJoueur() + " emporte l'enchère et achète le terrain " + vTerrain.getNomCase());
            GameFrame.PrintMSG(" pour un prix de " + prix);
            this.aListPlayer.get(vGagnant).ajouteArgent(-prix);
            this.aListPlayer.get(vGagnant).ajouterPatrimoine(vTerrain,1);
            this.aListPlayer.get(vGagnant).getPatrimoine().get(vTerrain.getNbCase()).setJoueurBoss(vGagnant);
            Patrimoine vCaseSetting= (Patrimoine) this.aListeCase.get(vTerrain.getNbCase());
            vCaseSetting.setJoueurBoss(vGagnant);
        }
        else {
            GameFrame.PrintMSG(" Personne n'a acheté ce terrain :( .");
        }

    }

    public int[] villeCouleurCorrespondance(String pCouleur)
    {
        int[] vListCouleur = new int[3];
        switch(pCouleur)
        {
            case "marron":
                vListCouleur[0] = 1;
                vListCouleur[1] = 3;
                vListCouleur[2] = -1;
                break;
            case "cyan":
                vListCouleur[0] = 6;
                vListCouleur[1] = 8;
                vListCouleur[2] = 9;
                break;

            case "rose":
                vListCouleur[0] = 11;
                vListCouleur[1] = 13;
                vListCouleur[2] = 14;
                break;

            case "orange":
                vListCouleur[0] = 16;
                vListCouleur[1] = 18;
                vListCouleur[2] = 19;
                break;

            case "rouge":
                vListCouleur[0] = 21;
                vListCouleur[1] = 23;
                vListCouleur[2] = 24;
                break;

            case "jaune":
                vListCouleur[0] = 26;
                vListCouleur[1] = 28;
                vListCouleur[2] = 29;
                break;

            case "vert":
                vListCouleur[0] = 31;
                vListCouleur[1] = 32;
                vListCouleur[2] = 34;
                break;

            case "bleu":
                vListCouleur[0] = 37;
                vListCouleur[1] = 39;
                vListCouleur[2] = -1;
                break;

        }
        return vListCouleur;
    }
    /**
     * Méthode de gestion de l'achat de maison et/ou d'hotel
     */
    public void construction()
    {
        if(getJoueurActif().getNbMonopole()==0)
        {
            GameFrame.PrintMSG(getJoueurActif().afficheMonopole());
            return;
        }
        boolean fonctionne = false;
        while (!fonctionne) {
            GameFrame.PrintMSG(getJoueurActif().afficheMonopole());
            GameFrame.PrintMSG("Tapez le nom de la couleur où vous souhaitez construire des maisons\n");
            GameFrame.PrintMSG(" Sinon, vous pouvez taper 'retour' pour arrêter de construire \n");
            String temp = GameFrame.getCommand();
            if((temp.equals("marron") ||temp.equals("cyan") ||temp.equals("rose") ||temp.equals("orange") ||temp.equals("rouge") ||temp.equals("jaune") ||temp.equals("vert") ||temp.equals("bleu"))&& this.getJoueurActif().getMonopole(temp))
            {

                int[] listVille=villeCouleurCorrespondance(temp);
                int vPrixMaison=getPrixMaison(listVille[0]);

                boolean fonctionne2 = false;
                while(!fonctionne2)
                {
                    for(int i =0;i<3;i++)
                    {
                        if(listVille[i]!=-1)
                        {
                            GameFrame.PrintMSG("Tapez " + i+1 + " pour acheter une maison sur : " + this.aListeCase.get(listVille[i]).getNomCase() + "\n");
                        }
                    }
                    GameFrame.PrintMSG("Tapez 'retour' pour revenir en arriere\n");
                    String temp2 = GameFrame.getCommand();
                    if(temp2.equals("1") || temp2.equals("2") || (temp2.equals("3") && listVille[2]!=-1))
                    {
                        int idTerrain = Integer.parseInt(temp2)-1;
                        Rue terrain = (Rue)this.getJoueurActif().getPatrimoine().get(idTerrain);
                        if(getJoueurActif().getArgent()-vPrixMaison>=0)
                        {
                            if(terrain.getNbMaison()[0]<4 &&terrain.getNbMaison()[1]==0 &&getBanque().getNbMaison()>0  )
                            {
                                getBanque().setNbMaison(-1);
                                terrain.setaNbMaison(1);
                                getJoueurActif().ajouteArgent(-vPrixMaison);
                                GameFrame.PrintMSG(" Vous avez acheté une maison sur : " + terrain.getNomCase() +"\n");

                            }
                            else if(terrain.getNbMaison()[0]<4 &&terrain.getNbMaison()[1]==0 && getBanque().getNbMaison()==0)
                            {
                                GameFrame.PrintMSG(" La banque ne possède plus de maison à vendre, tu ne peux donc pas construire\n");
                            }
                            else if (terrain.getNbMaison()[1]==1 )
                            {
                                GameFrame.PrintMSG(" Tu possèdes deja un hotel ici, tu ne peux plus rajouter de bâtiment\n");
                            }
                            else if(getBanque().getNbHotel()>0)
                            {
                                boolean vAchatPossible = true;
                                for(int i =0;i<3;i++) {
                                    if (listVille[i] != -1) {
                                        Rue terrain2 = (Rue) this.getJoueurActif().getPatrimoine().get(i);
                                        if (terrain2.getNbMaison()[0] != 4 && terrain2.getNbMaison()[1] != 1) {
                                            vAchatPossible = false;
                                        }
                                    }
                                }
                                if(vAchatPossible)
                                {
                                    getBanque().setNbHotel(-1);
                                    terrain.setaNbMaison(1);
                                    getJoueurActif().ajouteArgent(-vPrixMaison);
                                    GameFrame.PrintMSG(" Vous avez acheté une hotel sur : " + terrain.getNomCase() +"\n");
                                }
                                else {
                                    GameFrame.PrintMSG(" Tu ne peux pas construire d'hotel ici, tu dois d'abord avoir au moins 4 maisons sur les autres rues de la meme couleur\n");
                                }

                            }
                            else {
                                GameFrame.PrintMSG(" La banque ne possède plus d'Hotel' à vendre, tu ne peux donc pas construire\n");

                            }
                        }
                        else
                        {
                            GameFrame.PrintMSG(" Tu n'as pas l'argent pour acheter une maison ici\n");
                            GameFrame.PrintMSG(" Celles-ci coutent : "+ vPrixMaison + "\n");
                            fonctionne2=true;
                        }
                    }
                    else if(temp.equals("retour"))
                    {
                        fonctionne2=true;
                    }
                    else
                    {
                        GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                    }
                }
            }
            else if(temp.equals("retour"))
            {
                fonctionne=true;
                return;
            }
            else
            {
                GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
            }
        }

    }

    /**
     * Méthode de gestion de l'achat et de vente de terrain nu avec les autres joueurs
     */
    public void businessJoueur() {
        int[] listJoueur = new int[getNbJoueur()-1];
        for (int i = 0; i < getNbJoueur()-1; i++)
        {
            listJoueur[i]=-1;

        }
        int positionList=0;
        for (int i = 1; i <= getNbJoueur(); i++) {
            if (this.aListPlayer.get(i).getArgent() >= 0 && this.aListPlayer.get(i)!=getJoueurActif())
            {
                listJoueur[positionList]=i;
                positionList+=1;
            }
        }

        boolean fonctionne = false;
        while (!fonctionne) {
            GameFrame.PrintMSG("Tapez 'achat' si vous souhaitez racheter des terrains à d'autres joueurs.\n");
            GameFrame.PrintMSG("Tapez 'vendre' si vous souhaitez vendre des terrains à d'autres joueurs.\n");
            GameFrame.PrintMSG(" Sinon, vous pouvez taper 'retour' pour revenir en arriere.' \n");
            String temp = GameFrame.getCommand();
            switch (temp)
            {
                case"achat":

                    boolean fonctionne2 = false;
                    while (!fonctionne2) {
                        for (int i = 0; i < positionList; i++) {
                            GameFrame.PrintMSG("Tapez " + i + " , si vous souhaitez racheter des terrains à " + this.aListPlayer.get(listJoueur[i]).getNomJoueur() + "\n");
                        }
                        GameFrame.PrintMSG(" Sinon, vous pouvez taper 'retour' pour revenir en arriere.' \n");

                        String temp2 = GameFrame.getCommand();
                        boolean valeurEntiere = true;
                        try {
                            Integer.parseInt(temp2);
                        } catch (NumberFormatException e) {
                            valeurEntiere = false;
                        }
                        if (temp2.equals("retour"))
                        {
                            fonctionne2 = true;
                        }

                        else if (valeurEntiere && Integer.parseInt(temp2) >= 0 && Integer.parseInt(temp2) < positionList)
                        {
                            boolean fonctionne3 = false;
                            Player joueurEchange = this.aListPlayer.get(listJoueur[Integer.parseInt(temp2)]);
                            int[] listPatrimoineVente = new int[joueurEchange.getPatrimoine().size()];
                            int positionListPatrimoine = 0;
                            Iterator<Map.Entry<Integer,Patrimoine>> iterator = joueurEchange.getPatrimoine().entrySet().iterator();
                            if (joueurEchange.getPatrimoine().isEmpty()) {
                                GameFrame.PrintMSG(joueurEchange.getNomJoueur() + " ne possède aucun terrain, vous ne pouvez donc pas lui en acheter. \n");
                                fonctionne3 = true;
                            }//if(aPatrimoine.isEmpty())
                            else {

                                while (iterator.hasNext()) {
                                    Map.Entry<Integer,Patrimoine> terrain =  iterator.next();
                                    Patrimoine terrain2 = terrain.getValue();
                                    if (terrain2.getNbCase() != 12 && terrain2.getNbCase() != 28 && (terrain2.getNbCase() % 5) != 0) {
                                        Rue terrain3 = (Rue) terrain2;
                                        if (terrain3.getNbMaison()[0] == 0 && terrain3.getNbMaison()[1] == 0) {
                                            listPatrimoineVente[positionListPatrimoine] = terrain3.getNbCase();
                                            positionListPatrimoine += 1;
                                        }
                                    }
                                    else
                                    {
                                        listPatrimoineVente[positionListPatrimoine] = terrain2.getNbCase();
                                        positionListPatrimoine += 1;
                                    }
                                }//while()
                            }

                            while (!fonctionne3) {
                                for (int i = 0; i < positionListPatrimoine; i++) {
                                    GameFrame.PrintMSG("Tapez " + i + " pour demander l'autorisation d'acheter : " + joueurEchange.getPatrimoine().get(listPatrimoineVente[i]).getNomCase() + " pour le prix de " + joueurEchange.getPatrimoine().get(listPatrimoineVente[i]).getPrixAchat() + "\n");
                                }
                                GameFrame.PrintMSG("Tapez 'retour' pour revenir en arriere\n");
                                String temp3 = GameFrame.getCommand();
                                boolean valeurEntiere2 = true;
                                try {
                                    Integer.parseInt(temp3);
                                } catch (NumberFormatException e) {
                                    valeurEntiere2 = false;
                                }
                                if (valeurEntiere2 && Integer.parseInt(temp3) >= 0 && Integer.parseInt(temp3) < positionListPatrimoine) {
                                    Patrimoine vTerrainChoisi = joueurEchange.getPatrimoine().get(listPatrimoineVente[Integer.parseInt(temp3)]);
                                    if (getJoueurActif().getArgent() - vTerrainChoisi.getPrixAchat() < 0) {
                                        GameFrame.PrintMSG(" Vous n'avez pas assez d'argent pour acheter ce terrain.\n");
                                    }
                                    else
                                    {
                                        boolean fonctionne4 = false;
                                        while (!fonctionne4) {
                                            GameFrame.PrintMSG(joueurEchange.getNomJoueur() + " , " + getJoueurActif().getNomJoueur() + " souhaite acheter votre terrain " + vTerrainChoisi.getNomCase() + " pour une somme de " + vTerrainChoisi.getPrixAchat() + "\n");
                                            GameFrame.PrintMSG(" Tapez  'accepter' pour vendre votre terrain, Tapez ' refuser' pour refuser l'offre .\n");
                                            String temp4 = GameFrame.getCommand();

                                            if (temp4.equals("accepter")) {
                                                GameFrame.PrintMSG(getJoueurActif().getNomJoueur() + " a acheté " + vTerrainChoisi.getNomCase() + " à " + joueurEchange.getNomJoueur());
                                                joueurEchange.ajouteArgent(vTerrainChoisi.getPrixAchat());
                                                getJoueurActif().ajouteArgent(-vTerrainChoisi.getPrixAchat());
                                                vTerrainChoisi.setJoueurBoss(getNumJoueurActif());
                                                getJoueurActif().ajouterPatrimoine(vTerrainChoisi, 1);
                                                joueurEchange.ajouterPatrimoine(vTerrainChoisi, -1);
                                                fonctionne4 = true;
                                                fonctionne3=true;
                                                Patrimoine vCaseSetting= (Patrimoine) this.aListeCase.get(vTerrainChoisi.getNbCase());
                                                vCaseSetting.setJoueurBoss(getNumJoueurActif());


                                            }
                                            else if (temp4.equals("refuser"))
                                            {
                                                GameFrame.PrintMSG(" L'offre a été rejetée\n");
                                                fonctionne4 = true;
                                            }
                                            else
                                            {
                                                GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                                            }
                                        }
                                    }
                                }
                                else if (temp3.equals("retour"))
                                {
                                    fonctionne3 = true;
                                }
                                else
                                {
                                    GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                                }
                            }

                        }
                        else
                        {
                            GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                        }
                    }
                    break;

                case"vendre":

                    fonctionne2 = false;
                    while(!fonctionne2)
                    {
                        for(int i = 0; i<positionList;i++)
                        {
                            GameFrame.PrintMSG("Tapez " + i + " , si vous souhaitez vendre des terrains à " + this.aListPlayer.get(listJoueur[i]).getNomJoueur() + "\n");
                        }
                        GameFrame.PrintMSG(" Sinon, vous pouvez taper 'retour' pour revenir en arriere.' \n");

                        String temp2 = GameFrame.getCommand();
                        boolean valeurEntiere = true;
                        try {
                            Integer.parseInt(temp2);
                        } catch (NumberFormatException e) {
                            valeurEntiere = false;
                        }
                        if(temp2.equals("retour"))
                        {
                            fonctionne2=true;
                        }
                        else if(valeurEntiere && Integer.parseInt(temp2)>=0 && Integer.parseInt(temp2)<positionList)
                        {
                            boolean fonctionne3 = false;
                            Player joueurEchange = this.aListPlayer.get(listJoueur[Integer.parseInt(temp2)]);
                            int [] listPatrimoineVente = new int[getJoueurActif().getPatrimoine().size()];

                            int positionListPatrimoine = 0;
                            Iterator<Map.Entry<Integer,Patrimoine>> iterator = getJoueurActif().getPatrimoine().entrySet().iterator();
                            if (getJoueurActif().getPatrimoine().isEmpty())
                            {
                                GameFrame.PrintMSG(  "Vous ne possédez aucun terrain nu, vous ne pouvez donc pas en vendre. \n");
                                fonctionne3=true;
                            }//if(aPatrimoine.isEmpty())
                            else {

                                while (iterator.hasNext())
                                {
                                    Map.Entry<Integer,Patrimoine> terrain = iterator.next();
                                    Patrimoine terrain2 = terrain.getValue();
                                    if(terrain2.getNbCase()!=12 &&terrain2.getNbCase()!=28 && (terrain2.getNbCase()%5)!=0)
                                    {
                                        Rue terrain3 = (Rue) terrain2;
                                        if(terrain3.getNbMaison()[0]==0 && terrain3.getNbMaison()[1]==0)
                                        {
                                            listPatrimoineVente[positionListPatrimoine]=terrain3.getNbCase();
                                            positionListPatrimoine+=1;
                                        }
                                    }
                                    else {
                                        listPatrimoineVente[positionListPatrimoine]=terrain2.getNbCase();
                                        positionListPatrimoine+=1;
                                    }
                                }//while()
                            }

                            while(!fonctionne3)
                            {
                                for(int i =0;i<positionListPatrimoine;i++)
                                {
                                    GameFrame.PrintMSG("Tapez " + i + " pour proposer la vente du terrain : " + getJoueurActif().getPatrimoine().get(listPatrimoineVente[i]).getNomCase() + " ("+getJoueurActif().getPatrimoine().get(listPatrimoineVente[i]).getColor() + ")" + " pour le prix de " + getJoueurActif().getPatrimoine().get(listPatrimoineVente[i]).getPrixAchat() + "\n");
                                }
                                GameFrame.PrintMSG("Tapez 'retour' pour revenir en arriere\n");
                                String temp3 = GameFrame.getCommand();
                                boolean valeurEntiere2 = true;
                                try {
                                    Integer.parseInt(temp3);
                                } catch (NumberFormatException e) {
                                    valeurEntiere2 = false;
                                }
                                if(valeurEntiere2 && Integer.parseInt(temp3)>=0 && Integer.parseInt(temp3)<positionListPatrimoine)
                                {
                                    Patrimoine vTerrainChoisi = getJoueurActif().getPatrimoine().get(listPatrimoineVente[Integer.parseInt(temp3)]);
                                    if(joueurEchange.getArgent()-vTerrainChoisi.getPrixAchat()<0)
                                    {
                                        GameFrame.PrintMSG(joueurEchange.getNomJoueur() + " ne possède pas assez d'argent pour acheter ce terrain.\n");
                                    }
                                    else
                                    {
                                        boolean fonctionne4=false;
                                        while(!fonctionne4)
                                        {
                                            GameFrame.PrintMSG(joueurEchange.getNomJoueur() + " , " + getJoueurActif().getNomJoueur() + " souhaite vous vendre le terrain " + vTerrainChoisi.getNomCase() + " pour une somme de " + vTerrainChoisi.getPrixAchat() + "\n");
                                            GameFrame.PrintMSG(" Tapez  'accepter' pour acheter ce terrain, Tapez ' refuser' pour refuser l'offre .\n");
                                            String temp4 = GameFrame.getCommand();

                                            if(temp4.equals("accepter"))
                                            {
                                                GameFrame.PrintMSG(getJoueurActif().getNomJoueur() + " a vendu " + vTerrainChoisi.getNomCase() + " à " + joueurEchange.getNomJoueur());
                                                joueurEchange.ajouteArgent(-vTerrainChoisi.getPrixAchat());
                                                getJoueurActif().ajouteArgent(vTerrainChoisi.getPrixAchat());
                                                vTerrainChoisi.setJoueurBoss(listJoueur[Integer.parseInt(temp2)]);
                                                getJoueurActif().ajouterPatrimoine(vTerrainChoisi,-1);
                                                joueurEchange.ajouterPatrimoine(vTerrainChoisi,1);
                                                fonctionne4 = true;
                                                fonctionne3=true;
                                                Patrimoine vCaseSetting=(Patrimoine) this.aListeCase.get(vTerrainChoisi.getNbCase());
                                                vCaseSetting.setJoueurBoss(listJoueur[Integer.parseInt(temp2)]);

                                            }
                                            else if(temp4.equals("refuser"))
                                            {
                                                GameFrame.PrintMSG(" L'offre a été rejetée\n");
                                                fonctionne4=true;
                                            }
                                            else
                                            {
                                                GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                                            }
                                        }
                                    }
                                }
                                else if(temp3.equals("retour"))
                                {
                                    fonctionne3=true;
                                }
                                else
                                {
                                    GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                                }
                            }

                        }
                        else
                        {
                            GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                        }
                    }
                    break;

                case"retour":

                    fonctionne=true;
                    return;

                default:

                    GameFrame.PrintMSG("Je n'ai pas compris votre commande \n");
                    break;

            }

        }

    }

    /**
     * Méthode permettant de calculer le prix de fabrication d'une maison pour une rue
     * @param  pVilleId l'identifiant de la ville dont on souhaite calculer le prix de construction
     * @return le prix de la construction d'une maison
     */
    public int getPrixMaison(int pVilleId)
    {
        int vPrixMaison;
        if (pVilleId < 10) {
            vPrixMaison = 50;
        } else if (pVilleId < 20) {
            vPrixMaison = 100;
        } else if (pVilleId < 30) {
            vPrixMaison = 150;
        } else {
            vPrixMaison = 200;
        }
        return vPrixMaison;
    }
    /**
     * Méthode de gestion de la revente d'hotel ou de maison à la banque
     */
    public void venteMaison() /////////////////////////////////////////////////////////////////////////////////////////////////////
    {

        int[] listPatrimoinePossede = new int[getJoueurActif().getPatrimoine().size()];
        int positionListPatrimoine = 0;
        Iterator<Map.Entry<Integer,Patrimoine>> iterator = getJoueurActif().getPatrimoine().entrySet().iterator();
        if (getJoueurActif().getPatrimoine().isEmpty()) {
            GameFrame.PrintMSG("Vous ne possédez aucun terrain, vous n'avez donc rien à vendre.' \n");
            return;
        }//if(aPatrimoine.isEmpty())
        listPatrimoinePossede[0]=-1;
        while (iterator.hasNext()) {
            Map.Entry<Integer,Patrimoine> terrain =  iterator.next();
            Patrimoine terrain2 = terrain.getValue();
            if (terrain2.getNbCase() != 12 && terrain2.getNbCase() != 28 && (terrain2.getNbCase() % 5) != 0) {
                Rue terrain3 = (Rue) terrain2;
                if (terrain3.getNbMaison()[0] != 0 || terrain3.getNbMaison()[1] != 0) {
                    listPatrimoinePossede[positionListPatrimoine] = terrain3.getNbCase();
                    positionListPatrimoine += 1;
                }
            }
        }
        if (listPatrimoinePossede[0] == -1) {
            GameFrame.PrintMSG("Vous ne possédez aucun hotel ni maison, vous n'avez donc rien à vendre.' \n");
            return;
        }
        boolean fonctionne = false;
        while (!fonctionne) {
            for (int i = 0; i < positionListPatrimoine; i++) {
                Rue terrain = (Rue) getJoueurActif().getPatrimoine().get(i);
                if (terrain.getNbMaison()[0] != 0) {
                    GameFrame.PrintMSG("Tapez " + i + " si vous voulez vendre une maison du terrain " + terrain.getNomCase() + "( " + terrain.getColor() + " , " + terrain.getNbMaison()[0] + " maison(s) restante(s)) pour un somme de " + getPrixMaison(terrain.getNbCase()));

                }
                else {
                    GameFrame.PrintMSG("Tapez " + i + " si vous voulez vendre l'hôtel du terrain " + terrain.getNomCase() + "( " + terrain.getColor() + " , " + terrain.getNbMaison()[1] + " hotel restant) pour un somme de " + (getPrixMaison(terrain.getNbCase()) * 5) + ".\n");

                }

            }
            GameFrame.PrintMSG("Tapez 'retour' si vous souhaitez revenir en arrière.");
            String temp = GameFrame.getCommand();
            boolean valeurEntiere = true;
            try {
                Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                valeurEntiere = false;
            }
            if (valeurEntiere && Integer.parseInt(temp) >= 0 && Integer.parseInt((temp)) < positionListPatrimoine) {
                Rue terrain = (Rue) getJoueurActif().getPatrimoine().get(Integer.parseInt(temp));
                if (terrain.getNbMaison()[0] != 0) {
                    getJoueurActif().ajouteArgent(getPrixMaison(terrain.getNbCase()));
                    getBanque().setNbMaison(getBanque().getNbMaison() + 1);
                    GameFrame.PrintMSG("Vous avez vendu une maison sur " + terrain.getNomCase() + "( " + terrain.getNbMaison()[0] + " restante(s) ) ");
                    terrain.supprimeMaison();
                    GameFrame.PrintMSG("Vous avez gagnez " + getPrixMaison(terrain.getNbCase()) + "\n");
                }
                else
                {
                    getJoueurActif().ajouteArgent(getPrixMaison(terrain.getNbCase()) * 5);
                    getBanque().setNbHotel(getBanque().getNbHotel() + 1);
                    GameFrame.PrintMSG("Vous avez vendu un hotel sur " + terrain.getNomCase() + " .");
                    GameFrame.PrintMSG("Vous avez gagnez " + getPrixMaison(terrain.getNbCase()) * 5 + "\n");
                    terrain.supprimeMaison();


                }
                listPatrimoinePossede = new int[getJoueurActif().getPatrimoine().size()];
                positionListPatrimoine = 0;
                Iterator<Map.Entry<Integer,Patrimoine>> iterator2 = getJoueurActif().getPatrimoine().entrySet().iterator();
                if (getJoueurActif().getPatrimoine().isEmpty()) {
                    GameFrame.PrintMSG("Vous ne possédez aucun terrain, vous n'avez donc rien à vendre.' \n");
                    return;
                }//if(aPatrimoine.isEmpty())
                listPatrimoinePossede[0] = -1;

                while (iterator.hasNext()) {
                    Map.Entry<Integer,Patrimoine> patrimoine =  iterator2.next();
                    Patrimoine patrimoine2 =  patrimoine.getValue();
                    if (patrimoine2.getNbCase() != 12 && patrimoine2.getNbCase() != 28 && (patrimoine2.getNbCase() % 5) != 0) {
                        Rue patrimoine3 = (Rue) patrimoine2;
                        if (patrimoine3.getNbMaison()[0] != 0 || patrimoine3.getNbMaison()[1] != 0) {
                            listPatrimoinePossede[positionListPatrimoine] = patrimoine3.getNbCase();
                            positionListPatrimoine += 1;
                        }
                    }
                }
                if (listPatrimoinePossede[0] == -1) {
                    GameFrame.PrintMSG("Vous ne possédez  plus aucun hotel ni maison, vous n'avez donc plus rien à vendre.' \n");
                    return;
                }
            }
            else if (temp.equals("retour"))
            {
                fonctionne = true;
                return;
            }
            else
            {
                GameFrame.PrintMSG("Je n'ai pas compris votre requête.\n");
            }
        }
    }
    public void hypothequer() {
        Player pJoueur = this.getJoueurActif();
        GameFrame.PrintMSG(" Vous n'avez plus d'argent vous devez hypothéquer. Vous possédez actuellement :");

        GameFrame.PrintMSG(this.getJoueurActif().affichePatrimoine());
        int []listPossession = new int[pJoueur.getPatrimoine().size()];
        int positionList = 0;
        Iterator<Map.Entry<Integer,Patrimoine>> iterator = pJoueur.getPatrimoine().entrySet().iterator();
        if (pJoueur.getPatrimoine().isEmpty()) {
            GameFrame.PrintMSG(" Vous êtes ruinés, vous avez perdu");
            return;
        }
        while (iterator.hasNext()) {
            Map.Entry<Integer,Patrimoine> joueur =  iterator.next();

            listPossession[positionList] = joueur.getKey();
            positionList=positionList+1;
        }
        boolean fonctionne=false;
        while(!fonctionne) {
            for (int i = 0; i < positionList; i++) {
                Patrimoine vPat = pJoueur.getPatrimoine().get(listPossession[i]);
                if (vPat.getColor().equals("gare") || vPat.getColor().equals("compagnie")) {
                    GameFrame.PrintMSG("Tape " + i + " pour hypothéquer votre  : " + vPat.getNomCase() + "\net gagner " + vPat.getHypotheque());
                }
                else {
                    Rue vRue = (Rue) vPat;
                    if (vRue.getNbMaison()[0] == 0 && vRue.getNbMaison()[1] == 0) {
                        GameFrame.PrintMSG("Tape " + i + " pour hypothéquer votre  : " + vPat.getNomCase() + "\net gagner " + vPat.getHypotheque());
                    }
                    else if (vRue.getNbMaison()[0] > 0) {
                        GameFrame.PrintMSG("Tape " + i + " pour vendre une maison sur " + vRue.getNomCase() + "(" + vRue.getNbMaison()[0] + " restantes)\n et gagner " + getPrixMaison(vPat.getNbCase()));
                    }
                    else {
                        GameFrame.PrintMSG("Tape " + i + " pour vendre un hotel sur " + vRue.getNomCase() + "\n et gagner " + 5 * getPrixMaison(vPat.getNbCase()));
                    }
                }

            }
            String temp = GameFrame.getCommand();
            boolean valeurEntiere = true;
            try {
                Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                valeurEntiere = false;
            }
            if (valeurEntiere && Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) < positionList) {
                int val = Integer.parseInt(temp);
                Patrimoine vPat = pJoueur.getPatrimoine().get(listPossession[val]);
                if (vPat.getColor().equals("gare") ||vPat.getColor().equals("compagnie")) {
                    GameFrame.PrintMSG("Vous avez vendu : " + vPat.getNomCase());

                    pJoueur.ajouteArgent(vPat.getHypotheque());
                    GameFrame.PrintMSG("Vous avez maintenant " + pJoueur.getArgent());
                    vPat.setJoueurBoss(0);
                    pJoueur.ajouterPatrimoine(vPat,-1);
                    Patrimoine vCaseSetting=(Patrimoine) this.aListeCase.get(listPossession[val]);
                    vCaseSetting.setJoueurBoss(0);

                }
                else {
                    Rue vRue = (Rue) vPat;
                    if (vRue.getNbMaison()[0] == 0 && vRue.getNbMaison()[1] == 0) {
                        GameFrame.PrintMSG("Vous avez vendu : " + vRue.getNomCase());

                        pJoueur.ajouteArgent(vRue.getHypotheque());
                        GameFrame.PrintMSG("Vous avez maintenant " + pJoueur.getArgent());

                        vRue.setJoueurBoss(0);
                        pJoueur.ajouterPatrimoine(vRue,-1);
                        Patrimoine vCaseSetting=(Patrimoine) this.aListeCase.get(listPossession[val]);
                        vCaseSetting.setJoueurBoss(0);

                    }
                    else {
                        int prixM = getPrixMaison(vRue.getNbCase());
                        if (vRue.getNbMaison()[0] > 0) {
                            GameFrame.PrintMSG("Vous avez vendu une maison sur : " + vRue.getNomCase());

                            pJoueur.ajouteArgent(prixM);

                        }
                        else
                        {
                            GameFrame.PrintMSG("Vous avez vendu un hotel sur : " + vRue.getNomCase());

                            pJoueur.ajouteArgent(prixM*5);

                        }
                        GameFrame.PrintMSG("Vous avez maintenant " + pJoueur.getArgent());
                        vRue.supprimeMaison();
                    }
                }
                fonctionne = true;
            }
            else
            {
                GameFrame.PrintMSG("Commande incorrecte");
            }
        }


        if(pJoueur.getArgent() < 0)
        {
            GameFrame.PrintMSG("Vous êtes toujours en négatif, vous devez encore hypothéquer ");
            hypothequer();
        }

    }
    public void affichageCommandeUtilisable(int pNbDouble,int pNbEffetCaseEffectue,boolean pEffectCaseEffectue)
    {
        String vMessage= " Commande : ";
        if(pEffectCaseEffectue && pNbEffetCaseEffectue==pNbDouble)
        {
            vMessage += " 'lancerdes', ";
        }
        if(!pEffectCaseEffectue)
        {
            vMessage += " 'acheter', 'enchere', ";
        }
        if(pNbEffetCaseEffectue>pNbDouble)
        {
            vMessage += " 'findetour', ";
        }
        vMessage += " 'business', 'construction' , 'vente', 'infobatiment','possessionsjoueur', 'help' .";
        GameFrame.PrintMSG(vMessage);
    }


    public void possessionsJoueur()
    {

    }
    /**
     * Méthode de gestion de tour des joueurs
     */

    public void help()
    {
        GameFrame.PrintMSG(" La commande lancerdes vous permet de lancer les dés");
        GameFrame.PrintMSG(" La commande acheter vous permet d'acheter le terrain actuel s'il n'appartient à personne");
        GameFrame.PrintMSG(" La commande enchère vous permet de mettre en enchère le terrain actuel \ns'il n'appartient à personne");
        GameFrame.PrintMSG(" La commande findetour vous permet de finir votre tour \nsi vous avez effectuez toutes vos actions");
        GameFrame.PrintMSG(" La commande business vous permet de proposer des échanges de propriétés \navec les autres joueurs");
        GameFrame.PrintMSG(" La commande construction vous permet d'acheter des hôtels ou des maisons\n sur des terrains où vous avez un monopole");
        GameFrame.PrintMSG(" La commande vente vous permet de vendre certaines de vos maisons et/ou hôtel à la banque");
        GameFrame.PrintMSG(" La commande infobatiment vous permet de savoir le nombre d'hôtel et de maison \nencore disponible à la banque");
        GameFrame.PrintMSG(" La commande possessionsjoueur vous permet de connaitre les possessions d'un joueur");


    }
    public void tourJoueur() // il faut ajouter le fonctionnement d'un tour s'il y a un double
    {
        int nbDouble = 0;
        int nbEffetCaseEffectue = 0;
        boolean vEffetCaseEffectue = true;
        GameFrame.PrintMSG("Tour de " + getJoueurActif().getNomJoueur());
        Random random = new Random();

        boolean finTourAutorise=false;

        while(!finTourAutorise) {
            GameFrame.PrintMSG("Que veux tu faire ?");
            affichageCommandeUtilisable(nbDouble,nbEffetCaseEffectue,vEffetCaseEffectue);
            String temp = GameFrame.getCommand();
            switch (temp) {
                case "acheter":
                    if(!vEffetCaseEffectue) {
                        if (getJoueurActif().getPosition().getTypeCase())//verifier si la case est bien une case propriété
                        {
                            Patrimoine terrain = (Patrimoine) getJoueurActif().getPosition();
                            if (terrain.getJoueurBoss() == 0)//vérifier si le propriètaire est la banque
                            {
                                if (acheterTerrain()) {
                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;
                                }

                            } else if (terrain.getJoueurBoss() == this.getNumJoueurActif()) {
                                GameFrame.PrintMSG("Tu es propriétaire de ce terrain, tu ne peux donc pas l'acheter");
                            } else {
                                GameFrame.PrintMSG("Ce terrain appartient déjà à " + this.aListPlayer.get(terrain.getJoueurBoss()).getNomJoueur());
                                GameFrame.PrintMSG(" utilise la commande business si tu veux lui acheter le terrain");
                            }
                        } else {
                            GameFrame.PrintMSG("Ceci n'est pas une case achetable");
                        }
                        break;
                    }
                    else {
                        GameFrame.PrintMSG("Vous ne pouvez pas utiliser cette commande actuellement");
                    }
                case "enchere":

                    if (getJoueurActif().getPosition().getTypeCase())//verifier si la case est bien une case propriété
                    {
                        Patrimoine terrain = (Patrimoine) getJoueurActif().getPosition();
                        if (terrain.getJoueurBoss() == 0)//vérifier si le propriétaire est la banque
                        {
                            enchere();
                            nbEffetCaseEffectue += 1;
                            vEffetCaseEffectue = true;

                        }
                        else if (terrain.getJoueurBoss() == this.getNumJoueurActif()) {
                            GameFrame.PrintMSG("Tu es propriétaire de ce terrain, tu ne peux donc pas le mettre en enchere");
                            GameFrame.PrintMSG("Utilise la commande business si tu veux le revendre à un autre joueur");
                        }
                        else {
                            GameFrame.PrintMSG("Ce terrain appartient  à " + this.aListPlayer.get(terrain.getJoueurBoss()).getNomJoueur());
                            GameFrame.PrintMSG("Tu ne peux donc pas le mettre en enchère");
                        }
                    }
                    else {
                        GameFrame.PrintMSG("Ceci n'est pas une case achetable, tu ne peux donc pas la mettre en enchère");
                    }
                    break;
                case "lancerdes":

                    if (nbEffetCaseEffectue == nbDouble && vEffetCaseEffectue) {
                        int lancedes1 = random.nextInt(6) + 1;
                        int lancedes2 = random.nextInt(6) + 1;
                        vEffetCaseEffectue = false;
                        if (getJoueurActif().getEstPrisonnier() != 0 && lancedes1 != lancedes2) {
                            GameFrame.PrintMSG("Tu obtiens " + lancedes1 + "et " + lancedes2 + ".");

                            if (getJoueurActif().getEstPrisonnier() < 3) {
                                boolean fonctionne = false;
                                while(!fonctionne)
                                {
                                    GameFrame.PrintMSG("Tu n'as pas fait de double, tu ne sors donc pas de la prison");
                                    GameFrame.PrintMSG(" Tu peux dépenser 50 ou utiliser un passe afin de sortir de prison maintenant");
                                    GameFrame.PrintMSG("Tape sortir, si tu veux sortir maintenant et tape rester, si tu ne veux pas sortir");
                                    String temp2 = GameFrame.getCommand();
                                    if (temp2.equals("sortir"))
                                    {
                                        if (getJoueurActif().getSortiePrison() > 0) {
                                            GameFrame.PrintMSG(" Tu utilises ton passe pour sortir de prison.");
                                            getJoueurActif().setSortiePrison(getJoueurActif().getSortiePrison() - 1);
                                            getJoueurActif().setEstPrisonnier(0);
                                            fonctionne=true;

                                        }
                                        else
                                        {
                                            GameFrame.PrintMSG(" Tu payes 50 pour pouvoir sortir de prison.");
                                            getJoueurActif().ajouteArgent(- 50);
                                            getJoueurActif().setEstPrisonnier(0);
                                            fonctionne=true;
                                            if(getJoueurActif().getArgent()<0)
                                            {
                                                hypothequer();
                                                if(getJoueurActif().getArgent()<0)
                                                {
                                                    finTourAutorise=true;
                                                    break;
                                                }
                                            }

                                        }
                                    }
                                    else if (temp2.equals("rester")) {
                                        nbEffetCaseEffectue += 1;
                                        vEffetCaseEffectue = true;
                                        fonctionne=true;
                                        getJoueurActif().setEstPrisonnier(getJoueurActif().getEstPrisonnier() + 1);
                                    }
                                    else
                                    {
                                        GameFrame.PrintMSG(" Je n'ai pas compris , veux tu rester? ou sortir? ");
                                    }
                                }

                            }
                            else
                            {
                                GameFrame.PrintMSG("Tu es en prison depuis 3 tours et tu n'as toujours pas fait de double.");

                                GameFrame.PrintMSG("Tu dois sortir obligatoirement en payant ou en utilisant un passe.");
                                if (getJoueurActif().getSortiePrison() > 0) {
                                    GameFrame.PrintMSG(" Tu utilises ton passe pour sortir de prison.");
                                    getJoueurActif().setSortiePrison(getJoueurActif().getSortiePrison() - 1);
                                    getJoueurActif().setEstPrisonnier(0);
                                }
                                else
                                {
                                    getJoueurActif().setEstPrisonnier(0);
                                    GameFrame.PrintMSG(" Tu payes 50 pour pouvoir sortir de prison.");
                                    getJoueurActif().ajouteArgent( - 50);
                                    if(getJoueurActif().getArgent()<0)
                                    {
                                        hypothequer();
                                        if(getJoueurActif().getArgent()<0)
                                        {
                                            GameFrame.PrintMSG("Vous êtes ruinés, vous avez perdu");
                                            finTourAutorise=true;
                                            break;
                                        }
                                    }

                                }

                            }

                        }
                        else if(lancedes1 == lancedes2)
                        {
                            GameFrame.PrintMSG("Bravo tu as fait un double");
                            ++nbDouble;
                            if (getJoueurActif().getEstPrisonnier() != 0) {
                                getJoueurActif().setEstPrisonnier(0);
                                GameFrame.PrintMSG("Tu sors donc de prison");
                            }
                            if (nbDouble == 3) {
                                GameFrame.PrintMSG("C'est ton troisième double.");
                                GameFrame.PrintMSG("Tu as trop de chance, tu vas directement en prison sans touché l'argent de la case départ.");
                                getJoueurActif().setPosition(getCase(10)); //!\\ à modifier
                                getJoueurActif().setEstPrisonnier(1);
                                nbEffetCaseEffectue = 4;
                                vEffetCaseEffectue = true;
                            }//if (nbDouble == 3
                        }//if(lancedes1 == lancedes2)
                        if (getJoueurActif().getEstPrisonnier() == 0) {

                            int newCase=getJoueurActif().getPosition().getNbCase()+ lancedes1 + lancedes2;
                            if(newCase >39)
                            {
                                getJoueurActif().setPosition(getCase( newCase- 40));
                                getJoueurActif().ajouteArgent(200);
                                GameFrame.PrintMSG("Tu gagnes 200 car tu es passé par la case départ");
                            }
                            else
                            {
                                getJoueurActif().setPosition(getCase(newCase));
                            }
                            GameFrame.PrintMSG("Tu avances de " + (lancedes1 + lancedes2) + " car tu as fait " + lancedes1 + "et " + lancedes2 + ".");
                            GameFrame.PrintMSG("Tu atterris sur la case : " + getJoueurActif().getPosition().getNomCase());
                            if(getJoueurActif().getPosition().getNbCase()==10)
                            {
                                GameFrame.PrintMSG("(simple visite)");
                            }


                            if (getJoueurActif().getPosition().getTypeCase())//verifier si la case est bien une case propriété
                            {
                                Patrimoine terrain = (Patrimoine) getJoueurActif().getPosition();
                                if (terrain.getJoueurBoss() == 0) {
                                    GameFrame.PrintMSG("Tu es sur une case propriété sans propriétaire,\n tu peux donc l'acheter avec la commande acheter ");
                                    GameFrame.PrintMSG("ou la mettre en enchère avec la commande enchère");
                                    GameFrame.PrintMSG(" Cette propriété ("+ terrain.getColor()+  ") coute " + terrain.getPrixAchat() +" à acheter" );
                                } else if (terrain.getJoueurBoss() == getNumJoueurActif()) {
                                    GameFrame.PrintMSG("Ceci est une de tes propriétés");
                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;

                                }
                                else {
                                    GameFrame.PrintMSG("Tu es sur la propriété de " + this.aListPlayer.get(terrain.getJoueurBoss()).getNomJoueur());
                                    int prixAPayer;
                                    if(terrain.getNbCase()==12 || terrain.getNbCase()==28)
                                    {
                                        Compagnie terrain2 = (Compagnie)terrain;
                                        prixAPayer = terrain2.getPrixPayer(this.aListPlayer,lancedes1+lancedes2);

                                        GameFrame.PrintMSG("Le loyer te coute donc : " + prixAPayer);
                                    }
                                    else{
                                        prixAPayer = terrain.getPrixPayer(this.aListPlayer);
                                        GameFrame.PrintMSG("Le loyer te coute donc : " + terrain.getPrixPayer(this.aListPlayer));
                                    }


                                    getJoueurActif().ajouteArgent(-prixAPayer);
                                    this.aListPlayer.get(terrain.getJoueurBoss()).ajouteArgent(prixAPayer);

                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;
                                    if(getJoueurActif().getArgent()<0)
                                    {
                                        hypothequer();
                                        if(getJoueurActif().getArgent()<0)
                                        {
                                            finTourAutorise=true;
                                            break;
                                        }
                                    }

                                }
                            }
                            else if(getJoueurActif().getPosition().getNbCase() %10==0)
                            {
                                if(getJoueurActif().getPosition().getNbCase()==20)
                                {
                                    GameFrame.PrintMSG("Tu gagnes le gros lot, tu récupères tout l'argent des impôts : " + getBanque().getBenefice());
                                    getJoueurActif().ajouteArgent(getBanque().getBenefice());
                                    getBanque().setBenefice(0);
                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;

                                }
                                else if(getJoueurActif().getPosition().getNbCase()==30)
                                {
                                    getJoueurActif().setPosition(getCase(10));
                                    getJoueurActif().setEstPrisonnier(1);
                                    nbEffetCaseEffectue = 4;
                                    vEffetCaseEffectue = true;

                                }
                                else {
                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;
                                }
                            }
                            else if(getJoueurActif().getPosition().getNbCase()==4 ||getJoueurActif().getPosition().getNbCase()==38)
                            {
                                int vTaxe;
                                if(getJoueurActif().getPosition().getNbCase()==4)
                                {
                                    vTaxe=200;
                                }
                                else
                                {
                                    vTaxe=100;
                                }

                                GameFrame.PrintMSG("Tu perds " + vTaxe);
                                getJoueurActif().ajouteArgent(-vTaxe);
                                getBanque().setBenefice(getBanque().getBenefice()+vTaxe);
                                if(getJoueurActif().getArgent()<0)
                                {
                                    hypothequer();
                                    if(getJoueurActif().getArgent()<0)
                                    {
                                        finTourAutorise=true;
                                        break;
                                    }
                                }

                            }
                            else
                            {
                                CaseEffet terrain = (CaseEffet) getJoueurActif().getPosition();

                                int vChoix =terrain.effetCase(getJoueurActif(),this.aListPlayer,this.aListeCase);

                                if(terrain.getNumeroEffet()==1)
                                {
                                    GameFrame.PrintMSG(" Vous piochez une carte Chance : ");
                                }
                                else
                                {
                                    GameFrame.PrintMSG(" Vous piochez une carte communauté : ");
                                }
                                GameFrame.PrintMSG(terrain.getaEffet());

                                if(vChoix==1)
                                {
                                    while(vChoix!=0)
                                    {
                                        GameFrame.PrintMSG(" Tape 'chance' si tu veux piocher une carte chance, sinon '10' pour dépenser 10 \n");
                                        String temp3 = GameFrame.getCommand();

                                        if(temp3.equals("chance"))
                                        {
                                            GameFrame.PrintMSG(" Vous avez décidé de piocher une carte chance \n");
                                            terrain.caseChance(getJoueurActif(),aListeCase);
                                            GameFrame.PrintMSG(terrain.getaEffet());
                                            vChoix=0;
                                        }
                                        else if(temp3.equals("10"))
                                        {
                                            GameFrame.PrintMSG(" Vous avez décidé de payer 10 \n");
                                            getJoueurActif().ajouteArgent(-10);
                                            vChoix=0;
                                        }
                                        else
                                        {
                                            GameFrame.PrintMSG("Commande invalide\n");
                                        }
                                    }
                                }
                                nbEffetCaseEffectue += 1;
                                vEffetCaseEffectue = true;

                                if(getJoueurActif().getArgent()<0)
                                {
                                    hypothequer();
                                    if(getJoueurActif().getArgent()<0)
                                    {
                                        finTourAutorise=true;
                                        break;
                                    }
                                }

                            }
                        }
                    }
                    else if (nbEffetCaseEffectue > nbDouble) {
                        GameFrame.PrintMSG(" Vous avez deja effectué tous vos déplacements");
                    }
                    else {
                        GameFrame.PrintMSG(" Vous devez d'abord acheter ou mettre en enchère le terrain actuel avant de vous déplacer");
                    }

                    break;
                case "construction":

                    construction();
                    break;
                case "findetour":

                    if (nbEffetCaseEffectue == nbDouble + 1) {
                        finTourAutorise = true;
                    }
                    else if(!vEffetCaseEffectue)
                    {
                        GameFrame.PrintMSG(" Vous devez d'abord acheter le terrain actuel ou le mettre en enchère avant de finir votre tour");
                    }
                    else
                    {
                        GameFrame.PrintMSG(" Vous devez relancer les dés avant de finir votre tour");
                    }

                    break;
                case "vente":

                    venteMaison();
                    break;
                case "business":

                    businessJoueur();
                    break;
                case "infobatiment":
                    GameFrame.PrintMSG(getBanque().informationMaisonHotel());
                    break;
                case "help":
                    help();
                    break;
                case "possessionsjoueur":
                    possessionsJoueur();
                    break;

                default:
                    GameFrame.PrintMSG(" Commande non valide");
                    break;

            }



        }
        finDeTour();

    }//tourJoueur()
    /**
     * fonction ayant pour but de lancer le suivant tour, ou de finir la partie s'il ne reste plus qu'un joueur
     */
    public void finDeTour()
    {
        int nbJoueurVivant =0;
        for (int i=1; i<=getNbJoueur();i++)
        {
            if(this.aListPlayer.get(i).getArgent()>=0)
            {
                nbJoueurVivant+=1;
            }
        }
        if(nbJoueurVivant==1)
        {
            for (int i=1; i<=getNbJoueur();i++) {
                if (this.aListPlayer.get(i).getArgent() >= 0) {
                    GameFrame.PrintMSG("Fin de la partie, " + this.aListPlayer.get(i).getNomJoueur() + " a gagné la partie. Bravo!"); // FIN DE LA PARTIE
                    break;
                }
            }
        }
        else
        {
            setNumJoueurActif((getNumJoueurActif()+1) % (getNbJoueur()+1));
            if(getNumJoueurActif()==0)
            {
                setNumJoueurActif(1);
            }
            while(getJoueurActif().getArgent()<0)
            {
                setNumJoueurActif((getNumJoueurActif()+1) % (getNbJoueur()+1));
                if(getNumJoueurActif()==0)
                {
                    setNumJoueurActif(1);
                }
            }
            tourJoueur();
        }

    }

}//VideoGame
