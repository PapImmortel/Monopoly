import java.util.HashMap;

/**
 * Classe Patrimoine
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Patrimoine extends Cases_Plateau{
    private final int aPrixAchat;
    private int aJoueurBoss;
    private final String aColor;
    private final int aPrixHypotheque;
    /**
     * Constructeur naturel de patrimoine
     * @param pNomPatrimoine String le nom de la case
     * @param pIdPropriete int l'id de la propriété
     * @param pPrixAchat int le prix de l'achat
     * @param pJoueurBoss int le joueur qui possède la case(0 s'il n'y a pas de propriétaire
     * @param pColor String la couleur de la case
     * @param pPrixHypotheque int le prix d'hypothèque de la case
     */
    public Patrimoine(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,String pColor, int pPrixHypotheque)

    {
        super(pNomPatrimoine,pIdPropriete,true);
        this.aPrixAchat = pPrixAchat;
        this.aJoueurBoss = pJoueurBoss;
        this.aColor= pColor;
        this.aPrixHypotheque=pPrixHypotheque;
    }

    /**
     * Accesseur du prix d'achat du terrain
     * @return aPrixAchat int renvoie le prix d'achat du terrain
     */
    public int getPrixAchat()
    {
        return this.aPrixAchat;
    }

    /**
     * Accesseur du propriétaire du terrain
     * @return aJoueurBoss int renvoie le propriétaire du terrain
     */

    public int getJoueurBoss()
    {
        return this.aJoueurBoss;
    }
    /**
     * mutateur de l'attribue aJoueurBoss
     * @param pJoueurBoss int le joueur qui possède la case
     */
    public void setJoueurBoss(int pJoueurBoss)
    {
        this.aJoueurBoss = pJoueurBoss;
    }
    /**
     *renvoie le prix à payer si on se situe sur une propriété d'un autre joueur (cette fonction est override dans les sous classes)
     * @param vListPlayer HashMap<Integer,Player> la liste des joueurs
     * @return renvoie le prix à payer
     */
    public int getPrixPayer(HashMap<Integer,Player> vListPlayer){return -1;}
    /**
     *renvoie le prix à payer si on se situe sur une compagnie d'un autre joueur (cette fonction est override dans la sous classe compagnie)
     * @param vListPlayer HashMap<Integer,Player> la liste des joueurs
     * @param vScoreDes int le résultat des dés du joueur qui vient de jouer
     * @return int renvoie le prix à payer
     */
    public int getPrixPayer(HashMap<Integer,Player> vListPlayer,int vScoreDes){return -1;}

    /**
     * Accesseur du prix de l'hypothèque
     * @return int le prix de l'hypothèque
     */
    public int getHypotheque()
    {
        return this.aPrixHypotheque;
    }
    /**
     * Accesseur de la couleur
     * @return String la couleur
     */

    public String getColor()
    {
        return this.aColor;
    }

}