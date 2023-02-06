public class Ville extends Patrimoine
{
    private int aPrixRente;
    private int aNbMaison;
    private boolean aHotel;


    public Ville(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,int pPrixRente,int pNbMaison, boolean pHotel)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat,pJoueurBoss);
        aPrixRente=pPrixRente;
        aNbMaison= pNbMaison;
        aHotel=pHotel;
    }
    


}
