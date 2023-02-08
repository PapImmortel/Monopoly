import java.util.HashMap;

public class Patrimoine extends Cases_Plateau{
    private String aNomPatrimoine;
    private int aIdPropriete;
    private int aPrixAchat;
    private int aJoueurBoss;
    public Patrimoine(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss  )
    {
        super(pNomPatrimoine,pIdPropriete,true);
        this.aPrixAchat = pPrixAchat;
        this.aJoueurBoss = pJoueurBoss;
    }

    /*
    Accesseur du prix d'achat du terrain
     */
    public int getPrixAchat()
    {
        return this.aPrixAchat;
    }
    /*
    Accesseur du propriétaire du terrain
     */
    public int getJoueurBoss()
    {
        return this.aJoueurBoss;
    }
    /*
    set du propriétaire du terrain
     */
    public void setJoueurBoss(int pJoueurBoss)
    {
        this.aJoueurBoss = pJoueurBoss;
    }

    public int getPrixPayer(HashMap vListPlayer){return -1;}
}