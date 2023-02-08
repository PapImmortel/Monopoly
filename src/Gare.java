import java.util.HashMap;

public class Gare extends Patrimoine{

    public Gare(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat,pJoueurBoss);
    }

    /*
    accesseur
    renvoie le prix à payer en fonction du nombre de gare mis en entrée
     */
    @Override public int getPrixPayer(HashMap vListPlayer)
    {
        int vJoueur = getJoueurBoss();
        int vNbGarePossede = vListPlayer.get(vJoueur).getNbGare(); // nbgare cest monopole(non resolu)
        int vPrixAPayer=0;
        for(int i =0;i<vNbGarePossede;i++)
        {
            vPrixAPayer+=25;
        }
        return vPrixAPayer;
    }


}
