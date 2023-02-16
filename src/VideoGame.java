import java.util.*;

public class VideoGame
{
    /**
     * Classe de base du jeux avec toutes les informations du monopoly
     * @author Arvind Tangavelou
     * @author Quentin Guyot
     * @author Timothée Royer
     * @author Clément Lavie
     * @date (2023/01/12)
     */
    private int aNbJoueur;
    private Banque aBanque;
    private Interface aInterface;
    private int aNumJoueurActif;
    private HashMap<Integer,Player> aListPlayer;
    private HashMap<Integer,Cases_Plateau> aListeCase;

    /**
     * Constructeur à 3 paramètre de la Classe VideoGame
     * @param pNbJoueur aNbJoueur nombre de joueur actif pour la partie à venir
     * @param pListPlayer aListPlayer HashMap de la liste des joueurs
     * @param pCouleur aListCouleur HashMap de la liste des couleurs des joueurs
     */
    public VideoGame(int pNbJoueur,HashMap pListPlayer,HashMap pCouleur)
    {
        this.aNbJoueur = pNbJoueur;
        this.aBanque = new Banque();
        this.aInterface = new Interface();
        this.aListPlayer = new HashMap<Integer,Player>();
        this.aListeCase = new HashMap<Integer,Cases_Plateau>();
        if (pListPlayer.size() != pCouleur.size())
        {
            System.out.println("Pas la même taille ");
            System.exit(0);
        }
        Iterator iteratorP = pListPlayer.entrySet().iterator();
        Iterator iteratorC = pCouleur.entrySet().iterator();
        while (iteratorP.hasNext())
        {
            Map.Entry PlayerEntry = (Map.Entry) iteratorP.next();
            Map.Entry CouleurEntry = (Map.Entry) iteratorC.next();
            Player PlayerTemp = new Player(1500,PlayerEntry.getValue().toString(), CouleurEntry.getValue().toString());
            this.aListPlayer.put(1,PlayerTemp);
        }//while(.)
        this.aNumJoueurActif = 1;
        remplirCase();
        this.tourJoueur();
        //début du tour du joueur1
    }//VideoGame(.,.,.)

    /**
     * Mutateur du nombre de joueur
     * @param pNbJoueur aNbJoueur nouveau nombre de joueur
     */
    public void setNbJoueur(int pNbJoueur)
    {
        this.aNbJoueur = pNbJoueur;
    }//setNbJoueur(.)

    /**
     * Assesseur du nombre de joueur dans la partie
     * @return aNbJoueur nombre de joueur dans la partie
     */
    public int getNbJoueur()
    {
        return this.aNbJoueur;
    }//getNbJoueur()

    /**
     * Mutateur de Banque
     * @param pBanque aBanque Banque du jeux
     */
    public void setBanque(Banque pBanque)
    {
        this.aBanque = pBanque;
    }//setBanque(.)

    /**
     * Assesseur de Banque
     * @return aBanque Banque du jeux
     */
    public Banque getBanque()
    {
        return this.aBanque;
    }//getBanque()

    /**
     * Mutateur d'interface
     * @param pInterface aInterface interface à changer
     */
    public void setInterface(Interface pInterface)
    {
        this.aInterface = pInterface;
    }//setInterface(.)

    /**
     * Assesseur d'Interface
     * @return aInterface
     */
    public Interface getInterface()
    {
        return this.aInterface;
    }//getInterface()


    /**
     * Accesseur du Joueur actif
     * @return JoueurActif le joueur actif
     */
    public Player getJoueurActif()
    {
        return this.aListPlayer.get(this.aNumJoueurActif);
    }//getJoueurActif()
    /**
     * Mutateur de numero du joueur Actif
     * @param pNumJoueurActif le numero du joueurActif de la classe Player
     */
    public void setNumJoueurActif(int pNumJoueurActif)
    {
        this.aNumJoueurActif = pNumJoueurActif;
    }//setJoueurActif(.)

    /**
     * Accesseur du numero du Joueur actif
     * @return aNumJoueurActif joueur actif
     */
    public int getNumJoueurActif()
    {
        return this.aNumJoueurActif;
    }//getJoueurActif()

    /**
     * Mutateur de la liste des cases
     * @param pListeCase nouvelle liste des cases
     */
    public void setListCase(HashMap pListeCase)
    {
        this.aListeCase = pListeCase;
    }//setListeCase(.)

    /**
     * assesseur de la liste des cases du plateau
     * @return aListeCase liste des cases du plateau
     */
    public HashMap getListeCase()
    {
        return this.aListeCase;
    }//getListeCase()

    /**
     * Permet d'obtenir une case en fonction de son numéros dans le plateau
     * @param pNbCase numéros de la case à retourner
     * @return case correspondant au numéros passé en paramètre
     */
    public Cases_Plateau getCase(int pNbCase)
    {
        return this.aListeCase.get(pNbCase);
    }//getCase(.)

    /**
     * Méthode permettant de remplire la hashMap de la liste des cases avec les cases du plateau
     */
    public void remplirCase()
    {
        this.aListeCase.put( 0,new Cases_Plateau("DEPART",0,false));
        this.aListeCase.put( 1,new Rue("BOULEVARD DE BELLEVILLE",1, 60,0,0, 0, "marron",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put( 2,new Cases_Plateau("CAISSE DE COMMUNAUTE", 2,false));
        this.aListeCase.put( 3,new Rue("RUE LECOURBE",3, 60,0,0, 0, "marron",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put( 4,new Cases_Plateau("IMPOTS SUR LE REVENU",4,false));
        this.aListeCase.put( 5,new Gare("GARE MONTPARNASSE",5, 200,0));
        this.aListeCase.put( 6,new Rue("RUE DE VAUGIRARD",6, 100,0,0, 0, "cyan",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put( 7,new Cases_Plateau("CHANCE",7,false));
        this.aListeCase.put( 8,new Rue("RUE DE COURCELLES",8, 100,0,0, 0, "cyan",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put( 9,new Rue("AVENUE DE LA REPUBLIQUE",9, 120,0,0, 0, "cyan",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(10,new Cases_Plateau("Prison",10,false));
        this.aListeCase.put(11,new Rue("BOULEVARD DE LA VILLETTE",11, 140,0,0, 0, "rose",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(12,new Compagnie("COMPAGNIE DE La DISTRIBUTION D'ELECTRICITE",12, 150,0));
        this.aListeCase.put(13,new Rue("AVENUE DE NEUILLY",13, 140,0,0, 0, "rose",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(14,new Rue("RUE DU PARADIS",14, 160,0,0, 0, "rose",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(15,new Gare("GARE DE LYON",15, 200,0));
        this.aListeCase.put(16,new Rue("AVENUE DE MOZART",16, 180,0,0, 0, "orange",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(17,new Cases_Plateau("CAISSE DE COMMUNAUTE",17,false));
        this.aListeCase.put(18,new Rue("BOULEVARD SAINT-MICHEL",18, 180,0,0, 0, "orange",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(19,new Rue("PLACE DE PIGALLE",19, 200,0,0, 0, "orange",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(20,new Cases_Plateau("PARC GRATUIT",20,false));
        this.aListeCase.put(21,new Rue("AVENUE DE MATIGNON",21, 220,0,0, 0, "rouge",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(22,new Cases_Plateau("CHANCE",22,false));
        this.aListeCase.put(23,new Rue("BOULEVARD MALESHERBES",23, 220,0,0, 0, "rouge",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(24,new Rue("AVENUE HENRY-MARTIN",24, 240,0,0, 0, "rouge",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(25,new Gare("GARE DU NORD",25, 200,0));
        this.aListeCase.put(26,new Rue("FAUBOURG SAINT-HONORE",26, 260,0,0, 0, "jaune",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(27,new Rue("PlACE DE LA BOURSE",27, 260,0,0, 0, "jaune",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(28,new Compagnie("COMPAGNIE DE la DISTRIBUTION DES EAUX",28, 150,0));
        this.aListeCase.put(29,new Rue("RUE DE LA FAYETTE",29, 280,0,0, 0, "jaune",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(30,new Cases_Plateau("EN ALLEZ PRISON",30,false));
        this.aListeCase.put(31,new Rue("AVENUE de BRETEUIL",31, 300,0,0, 0, "vert",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(32,new Rue("AVENUE FOCH",32, 300,0,0, 0, "vert",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(33,new Cases_Plateau("CAISSE DE COMMUNAUTE",33,false));
        this.aListeCase.put(34,new Rue("BOULEVARD DES CAPUCINES",34, 320,0,0, 0, "vert",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(35,new Gare("GARE SAINT-LAZARE",35, 200,0));
        this.aListeCase.put(36,new Cases_Plateau("CHANCE",36,false));
        this.aListeCase.put(37,new Rue("AVENUE DES CHAMPS-ELYSEES",37, 350,0,0, 0, "bleu",new int[]{2,10,30,90,160,250}));
        this.aListeCase.put(38,new Cases_Plateau("TAXE DE LUXE",38,false));
        this.aListeCase.put(39,new Rue("RUE DE LA PAIX",39, 400,0,0, 0, "bleu",new int[]{2,10,30,90,160,250}));
    }//remplirCase()

    /**
     * Méthode de gestion de l'achat d'un terrain par un joueur
     */
    public boolean acheterTerrain()
    {
        Patrimoine vTerrain=(Patrimoine)getJoueurActif().getPosition();

        if(getJoueurActif().getArgent() - vTerrain.getPrixAchat()>=0)//si on a l'argent pour acheter le terrain
        {
            System.out.println("Tu achetes le titre de proprièté : " + vTerrain.getNomCase());
            getJoueurActif().ajouteArgent(- vTerrain.getPrixAchat());
            vTerrain.setJoueurBoss(getNumJoueurActif());
            getJoueurActif().ajouterPatrimoine(vTerrain,1);
            return true;
        }
        else {
            System.out.println("Tu n'as pas l'argent pour acheter le titre de proprièté : " + vTerrain.getNomCase());
            System.out.println("Celui-ci coute : " + vTerrain.getPrixAchat() + " or tu n'as que " + getJoueurActif().getArgent());
            System.out.println("Tu dois donc le mettre en enchère ou revendre certaines de tes possessions pour l'acheter");
            return false;
        }
    }
    /**
     * Méthode de gestion de l'enchere d'un terrain
     */
    public void enchere()
    {
        Patrimoine vTerrain=(Patrimoine)getJoueurActif().getPosition();
        int prix = vTerrain.getPrixAchat();
        int vGagnant = 0;
        int vJoueurActuel=getNumJoueurActif();
        for(int i=0; i<this.aNbJoueur;i++)
        {
            if(this.aListPlayer.get(vJoueurActuel).getArgent()-prix>=0)
            {

                boolean fonctionne = false;
                while(!fonctionne)
                {
                    System.out.println("Le terrain coute actuellement" + vTerrain.getPrixAchat());
                    System.out.println(this.aListPlayer.get(vJoueurActuel).getNomJoueur() + ", si tu souhaites l'acheter tape acheter, sinon tape laisser");
                    String temp = this.aInterface.getCommand();//!\\ à modifier
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
                    else if(!temp.isEmpty())
                    {
                        System.out.println("Je n'ai pas compris votre commande, tape acheter pour acheter le terrain, sinon tape laisser");
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
        }
        if(vGagnant!=0) {
            while (vGagnant != vJoueurActuel) {
                if (this.aListPlayer.get(vJoueurActuel).getArgent() - prix > 0) {
                    System.out.println("Le terrain coute actuellement" + prix);
                    System.out.println(this.aListPlayer.get(vJoueurActuel).getNomJoueur() + ", si tu souhaites encherir tape enchere ");
                    System.out.println("ainsi que la valeur dont tu souhaites enchérir, sinon tape laisser\n");
                    String temp = this.aInterface.getCommand();//!\\ à modifier
                    boolean fonctionne = false;
                    while (!fonctionne) {
                        if (temp.equals("enchere") && tempVALEUR > prix) {
                            if (this.aListPlayer.get(vJoueurActuel).getArgent() - tempVALEUR >= 0) {
                                System.out.println(this.aListPlayer.get(vJoueurActuel).getNomJoueur() + "a enchéri pour " + tempVALEUR);
                                prix = tempVALEUR;
                                vGagnant = vJoueurActuel;
                                fonctionne = true;
                            }
                            else
                            {
                                System.out.println("Tu ne possèdes pas autant d'argent\n");
                                temp = this.aInterface.getCommand();
                            }
                        }
                        else if (temp.equals("laisser"))
                        {
                            fonctionne = true;
                        }
                        else if(!temp.isEmpty())
                        {
                            System.out.println("Je n'ai pas compris votre commande\n");
                            temp = this.aInterface.getCommand();//!\\ à modifier
                        }
                    }

                }
                vJoueurActuel = (vJoueurActuel + 1) % (getNbJoueur() + 1);
                if (vJoueurActuel == 0) {
                    vJoueurActuel += 1;
                }
            }
        }
        System.out.println(this.aListPlayer.get(vGagnant).getNomJoueur() + " emporte l'enchère et achete le terrain " + vTerrain.getNomCase());
        System.out.println(" pour un prix de " + prix);
        this.aListPlayer.get(vGagnant).ajouteArgent(-prix);
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
            System.out.println(getJoueurActif().afficheMonopole());
            return;
        }
        boolean fonctionne = false;
        while (!fonctionne) {
            System.out.println(getJoueurActif().afficheMonopole());
            System.out.println("Tapez le nom de la couleur où vous souhaitez construire des maisons\n");
            System.out.println(" Sinon, vous pouvez taper 'retour' pour arretez de construire \n");
            String temp = this.aInterface.getCommand();
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
                            System.out.println("Tapez " + i+1 + " pour acheter une maison sur : " + this.aListeCase.get(listVille[i]).getNomCase() + "\n");
                        }
                    }
                    System.out.println("Tapez 'retour' pour revenir en arriere\n");
                    temp = this.aInterface.getCommand();
                    if(temp.equals("1") || temp.equals("2") || (temp.equals("3") && listVille[2]!=-1))
                    {
                        int idTerrain = Integer.valueOf(temp)-1;
                        Rue terrain = (Rue)this.getJoueurActif().getPatrimoine().get(idTerrain);
                        if(getJoueurActif().getArgent()-vPrixMaison>=0)
                        {
                            if(terrain.getNbMaison()[0]<4 &&terrain.getNbMaison()[1]==0 &&getBanque().getNbMaison()>0  )
                            {
                                getBanque().setNbMaison(-1);
                                terrain.setaNbMaison(1);
                                getJoueurActif().ajouteArgent(-vPrixMaison);
                                System.out.println(" Vous avez acheté une maison sur : " + terrain.getNomCase() +"\n");

                            }
                            else if(terrain.getNbMaison()[0]<4 &&terrain.getNbMaison()[1]==0 && getBanque().getNbMaison()==0)
                            {
                                System.out.println(" La banque ne possède plus de maison à vendre, tu ne peux donc pas construire\n");
                            }
                            else if (terrain.getNbMaison()[1]==1 )
                            {
                                System.out.println(" Tu possèdes deja un hotel ici, tu ne peux plus rajouter de batiment\n");
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
                                    System.out.println(" Vous avez acheté une hotel sur : " + terrain.getNomCase() +"\n");
                                }
                                else {
                                    System.out.println(" Tu ne peux pas construire d'hotel ici, tu dois d'abord avoir au moins 4 maisons sur les autres rues de la meme couleur\n");
                                }

                            }
                            else {
                                System.out.println(" La banque ne possède plus d'Hotel' à vendre, tu ne peux donc pas construire\n");

                            }
                        }
                        else
                        {
                            System.out.println(" Tu n'as pas l'argent pour acheter une maison ici\n");
                            System.out.println(" Celles-ci coutent : "+ vPrixMaison + "\n");
                            fonctionne2=true;
                        }
                    }
                    else if(temp.equals("retour"))
                    {
                        fonctionne2=true;
                    }
                    else if(!temp.isEmpty())
                    {
                        System.out.println("Je n'ai pas compris votre commande \n");
                    }
                }
            }
            else if(temp.equals("retour"))
            {
                fonctionne=true;
                return;
            }
            else if (!temp.isEmpty())
            {
                System.out.println("Je n'ai pas compris votre commande \n");
            }
        }

    }

    /**
     * Méthode de gestion de l'achat et de vente de terrain nu avec les autres joueurs
     */
    public void businessJoueur() {
        int[] listJoueur = new int[this.aNbJoueur-1];
        for (int i = 1; i <= this.aNbJoueur; i++)
        {
            listJoueur[i]=-1;

        }
        int positionList=0;
        for (int i = 1; i <= this.aNbJoueur; i++) {
            if (this.aListPlayer.get(i).getArgent() >= 0 && this.aListPlayer.get(i)!=getJoueurActif())
            {
                listJoueur[positionList]=i;
                positionList+=1;
            }
        }

        boolean fonctionne = false;
        while (!fonctionne) {
            System.out.println("Tapez 'achat' si vous souhaitez racheter des terrains à d'autres joueurs.\n");
            System.out.println("Tapez 'vendre' si vous souhaitez vendre des terrains à d'autres joueurs.\n");
            System.out.println(" Sinon, vous pouvez taper 'retour' pour revenir en arriere.' \n");
            String temp = this.aInterface.getCommand();
            if(temp.equals("achat")) {


                boolean fonctionne2 = false;
                while (!fonctionne2) {
                    for (int i = 0; i < positionList; i++) {
                        System.out.println("Tapez " + i + " , si vous souhaitez racheter des terrains à " + this.aListPlayer.get(listJoueur[i]).getNomJoueur() + "\n");
                    }
                    System.out.println(" Sinon, vous pouvez taper 'retour' pour revenir en arriere.' \n");

                    String temp2 = this.aInterface.getCommand();
                    if (temp2.equals("retour")) {
                        fonctionne2 = true;
                    } else if (Integer.valueOf(temp2) >= 0 && Integer.valueOf(temp2) < positionList) {
                        boolean fonctionne3 = false;
                        Player joueurEchange = this.aListPlayer.get(listJoueur[Integer.valueOf(temp2)]);
                        int[] listPatrimoineVente = new int[joueurEchange.getPatrimoine().size()];
                        listPatrimoineVente[0]=-1;
                        int positionListPatrimoine = 0;
                        Iterator iterator = joueurEchange.getPatrimoine().entrySet().iterator();
                        if (joueurEchange.getPatrimoine().isEmpty()) {
                            System.out.println(joueurEchange.getNomJoueur() + " ne possède aucun terrain, vous ne pouvez donc pas lui en acheter. \n");
                            fonctionne3 = true;
                        }//if(aPatrimoine.isEmpty())
                        else {

                            while (iterator.hasNext()) {
                                Map.Entry terrain = (Map.Entry) iterator.next();
                                Patrimoine terrain2 = (Patrimoine) terrain.getValue();
                                if (terrain2.getNbCase() != 12 && terrain2.getNbCase() != 28 && (terrain2.getNbCase() % 5) != 0) {
                                    Rue terrain3 = (Rue) terrain;
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
                        if(listPatrimoineVente[0]==-1)
                        {
                            System.out.println(  "Vous ne possèdez aucun terrain nu, vous ne pouvez donc pas en vendre. \n");
                            fonctionne3=true;
                        }
                        while (!fonctionne3) {
                            for (int i = 0; i < positionListPatrimoine; i++) {
                                System.out.println("Tapez " + i + " pour demander l'autorisation d'acheter : " + joueurEchange.getPatrimoine().get(listPatrimoineVente[i]).getNomCase() + " pour le prix de " + joueurEchange.getPatrimoine().get(listPatrimoineVente[i]).getPrixAchat() + "\n");
                            }
                            System.out.println("Tapez 'retour' pour revenir en arriere\n");
                            String temp3 = this.aInterface.getCommand();
                            if (Integer.valueOf(temp3) >= 0 && Integer.valueOf(temp3) < positionListPatrimoine) {
                                Patrimoine vTerrainChoisi = joueurEchange.getPatrimoine().get(Integer.valueOf(temp3));
                                if (getJoueurActif().getArgent() - vTerrainChoisi.getPrixAchat() < 0) {
                                    System.out.println(" Vous n'avez pas assez d'argent pour acheter ce terrain.\n");
                                } else {
                                    boolean fonctionne4 = false;
                                    while (!fonctionne4) {
                                        System.out.println(joueurEchange.getNomJoueur() + " , " + getJoueurActif().getNomJoueur() + " souhaite acheter votre terrain " + vTerrainChoisi.getNomCase() + " pour une somme de " + vTerrainChoisi.getPrixAchat() + "\n");
                                        System.out.println(" Tapez  'accepter' pour vendre votre terrain, Tapez ' refuser' pour refuser l'offre .\n");
                                        String temp4 = this.aInterface.getCommand();

                                        if (temp4.equals("accepter")) {
                                            joueurEchange.ajouteArgent(vTerrainChoisi.getPrixAchat());
                                            getJoueurActif().ajouteArgent(-vTerrainChoisi.getPrixAchat());
                                            vTerrainChoisi.setJoueurBoss(getNumJoueurActif());
                                            getJoueurActif().ajouterPatrimoine(vTerrainChoisi, 1);
                                            joueurEchange.ajouterPatrimoine(vTerrainChoisi, -1);
                                            fonctionne3 = true;


                                        } else if (temp.equals("refuser")) {
                                            System.out.println(" L'offre a été rejetée\n");
                                            fonctionne3 = true;
                                        }
                                        else if(!temp.isEmpty())
                                        {
                                            System.out.println("Je n'ai pas compris votre commande \n");
                                        }
                                    }
                                }
                            } else if (temp.equals("retour")) {
                                fonctionne3 = true;
                            }
                            else if (!temp.isEmpty())
                            {
                                System.out.println("Je n'ai pas compris votre commande \n");
                            }
                        }

                    } else {
                        System.out.println("Je n'ai pas compris votre commande \n");
                    }
                }
            }
            else if(temp.equals("vendre"))
            {
                boolean fonctionne2 = false;
                while(!fonctionne2)
                {
                    for(int i = 0; i<positionList;i++)
                    {
                        System.out.println("Tapez " + i + " , si vous souhaitez vendre des terrains à " + this.aListPlayer.get(listJoueur[i]).getNomJoueur() + "\n");
                    }
                    System.out.println(" Sinon, vous pouvez taper 'retour' pour revenir en arriere.' \n");

                    String temp2 = this.aInterface.getCommand();
                    if(temp2.equals("retour"))
                    {
                        fonctionne2=true;
                    }
                    else if(Integer.valueOf(temp2)>=0 && Integer.valueOf(temp2)<positionList)
                    {
                        boolean fonctionne3 = false;
                        Player joueurEchange = this.aListPlayer.get(listJoueur[Integer.valueOf(temp2)]);
                        int [] listPatrimoineVente = new int[joueurEchange.getPatrimoine().size()];
                        listPatrimoineVente[0] =-1;

                        int positionListPatrimoine = 0;
                        Iterator iterator = getJoueurActif().getPatrimoine().entrySet().iterator();
                        if (getJoueurActif().getPatrimoine().isEmpty())
                        {
                            System.out.println(  "Vous ne possèdez aucun terrain nu, vous ne pouvez donc pas en vendre. \n");
                            fonctionne3=true;
                        }//if(aPatrimoine.isEmpty())
                        else {

                            while (iterator.hasNext())
                            {
                                Map.Entry terrain = (Map.Entry) iterator.next();
                                Patrimoine terrain2 = (Patrimoine) terrain.getValue();
                                if(terrain2.getNbCase()!=12 &&terrain2.getNbCase()!=28 && (terrain2.getNbCase()%5)!=0)
                                {
                                    Rue terrain3 = (Rue) terrain;
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
                        if(listPatrimoineVente[0]==-1)
                        {
                            System.out.println(  "Vous ne possèdez aucun terrain nu, vous ne pouvez donc pas en vendre. \n");
                            fonctionne3=true;
                        }
                        while(!fonctionne3)
                        {
                            for(int i =0;i<positionListPatrimoine;i++)
                            {
                                System.out.println("Tapez " + i + " pour proposer la vente du terrain : " + getJoueurActif().getPatrimoine().get(listPatrimoineVente[i]).getNomCase() + " pour le prix de " + getJoueurActif().getPatrimoine().get(listPatrimoineVente[i]).getPrixAchat() + "\n");
                            }
                            System.out.println("Tapez 'retour' pour revenir en arriere\n");
                            String temp3 = this.aInterface.getCommand();
                            if(Integer.valueOf(temp3)>=0 && Integer.valueOf(temp3)<positionListPatrimoine)
                            {
                                Patrimoine vTerrainChoisi = getJoueurActif().getPatrimoine().get(Integer.valueOf(temp3));
                                if(joueurEchange.getArgent()-vTerrainChoisi.getPrixAchat()<0)
                                {
                                    System.out.println(joueurEchange.getNomJoueur() + " ne possède pas assez d'argent pour acheter ce terrain.\n");
                                }
                                else
                                {
                                    boolean fonctionne4=false;
                                    while(!fonctionne4)
                                    {
                                        System.out.println(joueurEchange.getNomJoueur() + " , " + getJoueurActif().getNomJoueur() + " souhaite vous vendre le terrain " + vTerrainChoisi.getNomCase() + " pour une somme de " + vTerrainChoisi.getPrixAchat() + "\n");
                                        System.out.println(" Tapez  'accepter' pour achter ce terrain, Tapez ' refuser' pour refuser l'offre .\n");
                                        String temp4 = this.aInterface.getCommand();

                                        if(temp4.equals("accepter"))
                                        {
                                            joueurEchange.ajouteArgent(-vTerrainChoisi.getPrixAchat());
                                            getJoueurActif().ajouteArgent(vTerrainChoisi.getPrixAchat());
                                            vTerrainChoisi.setJoueurBoss(listJoueur[Integer.valueOf(temp2)]);
                                            getJoueurActif().ajouterPatrimoine(vTerrainChoisi,-1);
                                            joueurEchange.ajouterPatrimoine(vTerrainChoisi,1);
                                            fonctionne3 = true;

                                        }
                                        else if(temp.equals("refuser"))
                                        {
                                            System.out.println(" L'offre a été rejetée\n");
                                            fonctionne3=true;
                                        }
                                        else if(!temp.isEmpty())
                                        {
                                            System.out.println("Je n'ai pas compris votre commande \n");
                                        }
                                    }
                                }
                            }
                            else if(temp.equals("retour"))
                            {
                                fonctionne3=true;
                            }
                            else if(!temp.isEmpty())
                            {
                                System.out.println("Je n'ai pas compris votre commande \n");
                            }
                        }

                    }
                    else if(!temp.isEmpty())
                    {
                        System.out.println("Je n'ai pas compris votre commande \n");
                    }
                }
            }
            else if(temp.equals("retour"))
            {
                fonctionne=true;
                return;
            }
            else if(!temp.isEmpty())
            {
                System.out.println("Je n'ai pas compris votre commande \n");
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
        listPatrimoinePossede[0] = -1;
        int positionListPatrimoine = 0;
        Iterator iterator = getJoueurActif().getPatrimoine().entrySet().iterator();
        if (getJoueurActif().getPatrimoine().isEmpty()) {
            System.out.println("Vous ne possédez aucun terrain, vous n'avez donc rien à vendre.' \n");
            return;
        }//if(aPatrimoine.isEmpty())
        while (iterator.hasNext()) {
            Map.Entry terrain = (Map.Entry) iterator.next();
            Patrimoine terrain2 = (Patrimoine) terrain.getValue();
            if (terrain2.getNbCase() != 12 && terrain2.getNbCase() != 28 && (terrain2.getNbCase() % 5) != 0) {
                Rue terrain3 = (Rue) terrain2;
                if (terrain3.getNbMaison()[0] != 0 || terrain3.getNbMaison()[1] != 0) {
                    listPatrimoinePossede[positionListPatrimoine] = terrain3.getNbCase();
                    positionListPatrimoine += 1;
                }
            }
        }
        if (listPatrimoinePossede[0] == -1) {
            System.out.println("Vous ne possédez aucun hotel ni maison, vous n'avez donc rien à vendre.' \n");
            return;
        }
        boolean fonctionne = false;
        while (!fonctionne) {
            for (int i = 0; i < positionListPatrimoine; i++) {
                Rue terrain = (Rue) getJoueurActif().getPatrimoine().get(i);
                if (terrain.getNbMaison()[0] != 0) {
                    System.out.println("Tapez " + i + " si vous voulez vendre une maison du terrain " + terrain.getNomCase() + "( " + terrain.getColor() + " , " + terrain.getNbMaison()[0] + " maison(s) restante(s)) pour un somme de " + getPrixMaison(terrain.getNbCase()));

                } else {
                    System.out.println("Tapez " + i + " si vous voulez vendre l'hotel du terrain " + terrain.getNomCase() + "( " + terrain.getColor() + " , " + terrain.getNbMaison()[1] + " hotel restant) pour un somme de " + (getPrixMaison(terrain.getNbCase()) * 5) + ".\n");

                }

            }
            System.out.println("Tapez 'retour' si vous souhaitez revenir en arrière.");
            String temp = this.aInterface.getCommand();
            if (Integer.valueOf(temp) >= 0 && Integer.valueOf((temp)) < positionListPatrimoine) {
                Rue terrain = (Rue) getJoueurActif().getPatrimoine().get(Integer.valueOf(temp));
                if (terrain.getNbMaison()[0] != 0) {
                    getJoueurActif().ajouteArgent(getPrixMaison(terrain.getNbCase()));
                    getBanque().setNbMaison(getBanque().getNbMaison() + 1);
                    System.out.println("Vous avez vendu une maison sur " + terrain.getNomCase() + "( " + terrain.getNbMaison()[0] + " restante(s) ) ");
                    System.out.println("Vous avez gagnez " + getPrixMaison(terrain.getNbCase()) + "\n");
                } else {
                    getJoueurActif().ajouteArgent(getPrixMaison(terrain.getNbCase()) * 5);
                    getBanque().setNbHotel(getBanque().getNbHotel() + 1);
                    System.out.println("Vous avez vendu un hotel sur " + terrain.getNomCase() + " .");
                    System.out.println("Vous avez gagnez " + getPrixMaison(terrain.getNbCase()) * 5 + "\n");

                }
                listPatrimoinePossede = new int[getJoueurActif().getPatrimoine().size()];
                listPatrimoinePossede[0] = -1;
                positionListPatrimoine = 0;
                iterator = getJoueurActif().getPatrimoine().entrySet().iterator();
                if (getJoueurActif().getPatrimoine().isEmpty()) {
                    System.out.println("Vous ne possédez aucun terrain, vous n'avez donc rien à vendre.' \n");
                    return;
                }//if(aPatrimoine.isEmpty())
                while (iterator.hasNext()) {
                    Map.Entry patrimoine = (Map.Entry) iterator.next();
                    Patrimoine patrimoine2 = (Patrimoine) patrimoine.getValue();
                    if (patrimoine2.getNbCase() != 12 && patrimoine2.getNbCase() != 28 && (patrimoine2.getNbCase() % 5) != 0) {
                        Rue patrimoine3 = (Rue) patrimoine2;
                        if (patrimoine3.getNbMaison()[0] != 0 || patrimoine3.getNbMaison()[1] != 0) {
                            listPatrimoinePossede[positionListPatrimoine] = patrimoine3.getNbCase();
                            positionListPatrimoine += 1;
                        }
                    }
                }
                if (listPatrimoinePossede[0] == -1) {
                    System.out.println("Vous ne possédez  plus aucun hotel ni maison, vous n'avez donc rien à vendre.' \n");
                    return;
                }
            } else if (temp.equals("retour")) {
                fonctionne = true;
                return;
            }
            else if(!temp.isEmpty())
            {
                System.out.println("Je n'ai pas compris votre requete.\n");
            }
        }
    }

    /**
     * Méthode de gestion de tour des joueurs
     */
    public void tourJoueur() // il faut ajouter le fonctionnement d'un tour s'il y a un double
    {
        int nbDouble = 0;
        int nbEffetCaseEffectue = 0;
        boolean vEffetCaseEffectue = true;
        System.out.println("Tour de " + getJoueurActif().getNomJoueur());
        Random random = new Random();
        String temp;

        boolean finTourAutorise=false;

        while(!finTourAutorise) {
            System.out.println("Que veux tu faire ?");
            temp = this.aInterface.getCommand();//!\\ à modifier
            switch (temp) {
                case "acheter":

                    if (getJoueurActif().getPosition().getTypeCase())//verifier si la case est bien une case propriétée
                    {
                        Patrimoine terrain = (Patrimoine) getJoueurActif().getPosition();
                        if (terrain.getJoueurBoss() == 0)//vérifier si le propriètaire est la banque
                        {
                            if(acheterTerrain())
                            {
                                nbEffetCaseEffectue += 1;
                                vEffetCaseEffectue = true;
                            }

                        }
                        else if (terrain.getJoueurBoss() == this.getNumJoueurActif())
                        {
                            System.out.println("Tu es propriétaire de ce terrain, tu ne peux donc pas l'acheter");
                        }
                        else
                        {
                            System.out.println("Ce terrain appartient déjà à " + this.aListPlayer.get(terrain.getJoueurBoss()).getNomJoueur());
                            System.out.println(" utilise la commande business si tu veux lui acheter le terrain");
                        }
                    }
                    else
                    {
                        System.out.println("Ceci n'est pas une case achetable");
                    }
                    break;

                case "enchere":

                    if (getJoueurActif().getPosition().getTypeCase())//verifier si la case est bien une case propriétée
                    {
                        Patrimoine terrain = (Patrimoine) getJoueurActif().getPosition();
                        if (terrain.getJoueurBoss() == 0)//vérifier si le propriètaire est la banque
                        {
                            enchere();
                            nbEffetCaseEffectue += 1;
                            vEffetCaseEffectue = true;

                        } else if (terrain.getJoueurBoss() == this.getNumJoueurActif()) {
                            System.out.println("Tu es propriétaire de ce terrain, tu ne peux donc pas le mettre en enchere");
                            System.out.println("Utilise la commande business si tu veux le revendre à un autre joueur");
                        } else {
                            System.out.println("Ce terrain appartient  à " + this.aListPlayer.get(terrain.getJoueurBoss()).getNomJoueur());
                            System.out.println("Tu ne êux donc pas le mettre en enchère");
                        }
                    } else {
                        System.out.println("Ceci n'est pas une case achetable, tu ne peux donc pas la mettre en enchère");
                    }
                    break;
                case "LancerDes":

                    if (nbEffetCaseEffectue == nbDouble && vEffetCaseEffectue) {
                        int lancedes1 = random.nextInt(6) + 1;
                        int lancedes2 = random.nextInt(6) + 1;
                        vEffetCaseEffectue = false;
                        if (getJoueurActif().getEstPrisonnier() != 0 && lancedes1 != lancedes2) {
                            System.out.println("Tu obtiens " + lancedes1 + "et " + lancedes2 + ".");

                            if (getJoueurActif().getEstPrisonnier() < 3) {
                                boolean fonctionne = false;
                                while(!fonctionne)
                                {
                                    System.out.println("Tu n'as pas fait de double, tu ne sors donc pas de la prison");
                                    System.out.println(" Tu peux dépenser 50 ou utiliser un passe afin de sortir de prison maintenant");
                                    System.out.println("Tape sortir, si tu veux sortir maitenant et tape rester, si tu ne veux pas sortir");
                                    String temp2 = this.aInterface.getCommand();//!\\ à modifier
                                    if (temp2.equals("sortir"))
                                    {
                                        if (getJoueurActif().getSortiePrison() > 0) {
                                            System.out.println(" Tu utilises ton passe pour sortir de prison.");
                                            getJoueurActif().setSortiePrison(getJoueurActif().getSortiePrison() - 1);
                                            getJoueurActif().setEstPrisonnier(0);
                                        } else {
                                            System.out.println(" Tu payes 50 pour pouvoir sortir de prison.");
                                            getJoueurActif().ajouteArgent(- 50);
                                            if(getJoueurActif().getArgent()<0)
                                            {
                                                System.out.println("Vous etes ruinés, vous avez perdu");
                                                finTourAutorise=true;
                                                break;
                                            }
                                            getJoueurActif().setEstPrisonnier(0);

                                        }
                                    }
                                    else if (temp2.equals("rester")) {
                                        nbEffetCaseEffectue += 1;
                                        vEffetCaseEffectue = true;
                                        getJoueurActif().setEstPrisonnier(getJoueurActif().getEstPrisonnier() + 1);
                                    }
                                    else if (!temp.isEmpty())
                                    {
                                        System.out.println(" Je n'ai pas compris , veux tu rester? ou sortir? ");
                                    }
                                }

                            }
                            else
                            {
                                System.out.println("Tu es en prison depuis 3 tours et tu n'as toujours pas fait de double.");

                                System.out.println("Tu dois sortir obligatoirement en payant ou en utilisant un passe.");
                                if (getJoueurActif().getSortiePrison() > 0) {
                                    System.out.println(" Tu utilises ton passe pour sortir de prison.");
                                    getJoueurActif().setSortiePrison(getJoueurActif().getSortiePrison() - 1);
                                    getJoueurActif().setEstPrisonnier(0);
                                }
                                else
                                {
                                    System.out.println(" Tu payes 50 pour pouvoir sortir de prison.");
                                    getJoueurActif().ajouteArgent( - 50);
                                    if(getJoueurActif().getArgent()<0)
                                    {
                                        System.out.println("Vous etes ruinés, vous avez perdu");
                                        finTourAutorise=true;
                                        break;
                                    }
                                    getJoueurActif().setEstPrisonnier(0);

                                }
                            }

                        } else {
                            System.out.println("Bravo tu as fait un double");
                            ++nbDouble;
                            if (getJoueurActif().getEstPrisonnier() != 0) {
                                getJoueurActif().setEstPrisonnier(0);
                                System.out.println("Tu sors donc de prison");
                            }
                            if (nbDouble == 3) {
                                System.out.println("C'est ton troisième double.");
                                System.out.println("Tu as trop de chance, tu vas directement en prison sans touché l'argent de la case départ.");
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
                                System.out.println("Tu gagnes 200 car tu es passé par la case départ");
                            }
                            else
                            {
                                getJoueurActif().setPosition(getCase(newCase));
                            }
                            System.out.println("Tu avances de " + (lancedes1 + lancedes2) + " car tu as fait " + lancedes1 + "et " + lancedes2 + ".");
                            System.out.println("Tu atterris sur la case : " + getJoueurActif().getPosition().getNomCase());


                            if (getJoueurActif().getPosition().getTypeCase())//verifier si la case est bien une case propriétée
                            {
                                Patrimoine terrain = (Patrimoine) getJoueurActif().getPosition();
                                if (terrain.getJoueurBoss() == 0) {
                                    System.out.println("Tu es sur une case propriété sans propriétaire, tu peux donc l'acheter avec la commande acheter ");
                                    System.out.println("ou la mettre en enchère avec la commande enchere");
                                } else if (terrain.getJoueurBoss() == getNumJoueurActif()) {
                                    System.out.println("Ceci est une de tes propriétés");
                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;

                                } else {
                                    System.out.println("Tu es sur la propriété de " + this.aListPlayer.get(terrain.getJoueurBoss()).getNomJoueur());
                                    int prixAPayer = 0;
                                    if(terrain.getNbCase()==12 || terrain.getNbCase()==28)
                                    {
                                        Compagnie terrain2 = (Compagnie)terrain;
                                        prixAPayer = terrain2.getPrixPayer(this.aListPlayer,lancedes1+lancedes2);

                                        System.out.println("Le loyer te coute donc : " + prixAPayer);
                                    }
                                    else{
                                        prixAPayer = terrain.getPrixPayer(this.aListPlayer);
                                        System.out.println("Le loyer te coute donc : " + terrain.getPrixPayer(this.aListPlayer));
                                    }


                                    getJoueurActif().ajouteArgent(-prixAPayer);
                                    this.aListPlayer.get(terrain.getJoueurBoss()).ajouteArgent(prixAPayer);

                                    nbEffetCaseEffectue += 1;
                                    vEffetCaseEffectue = true;
                                    if(getJoueurActif().getArgent()<0)
                                    {
                                        System.out.println("Vous etes ruinés, vous avez perdu");
                                        finTourAutorise=true;
                                        break;
                                    }

                                }
                            } else {
                                CaseEffet terrain = (CaseEffet) getJoueurActif().getPosition();
                                //faire effet de la case voir avec Klhaimands tien Thymau-Thaie
                                int vChoix =terrain.effetCase(getJoueurActif(),this.aListPlayer,this.aListeCase);
                                if(vChoix==1)
                                {
                                    while(vChoix!=0)
                                    {
                                        String temp3 = this.aInterface.getCommand();//!\\ à modifier
                                        System.out.println(" Tu as le choix entre piocher une carte chance ou perdre 10.\n");
                                        System.out.println(" Tape 'chance' si tu veux piocher une carte chance, sinon '10' pour depenser 10 \n");

                                        if(temp3.equals("chance"))
                                        {
                                            terrain.caseChance(getJoueurActif(),aListPlayer,aListeCase);
                                            vChoix=0;
                                        }
                                        else if(temp3.equals("10"))
                                        {
                                            getJoueurActif().ajouteArgent(-10);
                                            vChoix=0;
                                        }
                                        else if (!temp3.isEmpty()) {
                                            System.out.println("ta dit quoi la ");
                                        }
                                    }
                                }
                                //faire effet de la case( voir avec Klhaimands
                                nbEffetCaseEffectue += 1;
                                vEffetCaseEffectue = true;


                            }
                        }
                    } else if (nbEffetCaseEffectue > nbDouble) {
                        System.out.println(" Vous avez deja effectué tous vos deplacements");
                    }
                    if (nbEffetCaseEffectue < nbDouble) {
                    } else {
                        System.out.println(" Vous devez d'abord acheter ou mettre en enchère le terrrain actuel avant de vous deplacer");
                    }

                    break;
                case "construction":

                    construction();
                    break;
                case "finDeTour":

                    if (nbEffetCaseEffectue == nbDouble + 1) {
                        finTourAutorise = true;
                    } else {
                        System.out.println(" Vous devez d'abord acheter le terrain actuel ou le mettre en enchère avant de finir votre tour");
                    }

                    break;
                case "Vente":

                    venteMaison();
                    break;
                case "business":

                    businessJoueur();
                    break;
                default:
                    System.out.println(" Commande non valide");
                    break;

            }
            finDeTour();


        }

    }//tourJoueur()
    /**
     * fonction ayant pour but de lancer le suivant tour, ou de finir la partie s'il ne reste plus qu'un joueur
     */
    public void finDeTour()
    {
        int nbJoueurVivant =0;
        for (int i=1; i<=this.aNbJoueur;i++)
        {
            if(this.aListPlayer.get(i).getArgent()>=0)
            {
                nbJoueurVivant+=1;
            }
        }
        if(nbJoueurVivant==1)
        {
            for (int i=1; i<=this.aNbJoueur;i++) {
                if (this.aListPlayer.get(i).getArgent() >= 0) {
                    System.out.println("Fin de la partie, " + this.aListPlayer.get(i).getNomJoueur() + " a gagné la partie. Bravo!"); // FIN DE LA PARTIE
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
