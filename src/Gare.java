import java.util.HashMap;
/**
 * Classe des patrimoines de type Gare
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 * @date (2023/01/12)
 */
public class Gare extends Patrimoine{

    /**
     * Constructeur de la classe gare
     * @param pNomPatrimoine String le nom de la case
     * @param pIdPropriete int le numéro de la case
     * @param pPrixAchat int le prix d'achat de la case
     * @param pJoueurBoss int le numéro du joueur qui possède cette case(0 s'il n'y a pas de propriétaire)
     * @param pHypotheque int le prix d'hypothèque du terrain
     */
    public Gare(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss, int pHypotheque)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat,pJoueurBoss,"gare", pHypotheque);
    }

    /**
     * Renvoie le prix à payer si on atterrit sur cette case alors que l'on n'est pas propriétaire
     * @param vListPlayer HashMap<Integer,Player> la liste des joueurs
     * @return int le prix à payer
     */
    @Override public int getPrixPayer(HashMap<Integer,Player> vListPlayer)
    {
        int vJoueur = getJoueurBoss();
        int vNbGarePossede = vListPlayer.get(vJoueur).getNbGare();
        int vPrixAPayer=0;
        for(int i =0;i<vNbGarePossede;i++)
        {
            vPrixAPayer+=25;
        }
        return vPrixAPayer;
    }


}
