import java.util.HashMap;
/**
 * Classe des patrimoines de type compagnie
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Compagnie extends Patrimoine{

    /**
     * le constructeur de la classe Compagnie
     * @param pNomPatrimoine String le nom de la case
     * @param pIdPropriete int le numéro de la case
     * @param pPrixAchat int le prix d'achat de la case
     * @param pJoueurBoss int le numéro du joueur qui possède cette case(0 s'il n'y a pas de propriétaire)
     * @param pHypotheque int le prix d'hypothèque du terrain
     */
    public Compagnie(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,int pHypotheque)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat, pJoueurBoss,"compagnie",pHypotheque);
    }


    /**
     * Renvoie le prix à payer si on atterrit sur cette case alors que l'on n'est pas propriétaire
     * @param vListPlayer HashMap<Integer,Player> la liste des joueurs
     * @param vScoreDes  int le résultat des dés du joueur qui vient de jouer
     * @return int le prix à payer
     */
    @Override public int getPrixPayer(HashMap<Integer,Player> vListPlayer,int vScoreDes)
    {
        int vJoueur = getJoueurBoss();
        int vNbCompagniePossede = vListPlayer.get(vJoueur).getNbCompagnie();
        int vPrixAPayer=vScoreDes;
        if(vNbCompagniePossede==1)
        {
            vPrixAPayer*=4;
        }
        else
        {
            vPrixAPayer*=10;
        }
        return vPrixAPayer;
    }




}
