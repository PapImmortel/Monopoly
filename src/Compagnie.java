import java.util.HashMap;

public class Compagnie extends Patrimoine{
    public Compagnie(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat, pJoueurBoss);
    }


    /*
    accesseur
    renvoie le prix à payer en fonction de notre lancé de dé:
     */
    @Override public int getPrixPayer(HashMap vListPlayer)
    {
        int vJoueur = getJoueurBoss();
        int vNbCompagniePossede = vListPlayer.get(vJoueur).getNbCompagnie();
        int vScoreDes = videoGame.getResultatDés();
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
