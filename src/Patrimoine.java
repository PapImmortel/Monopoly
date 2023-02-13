import java.util.HashMap;

public class Patrimoine extends Cases_Plateau{
    private String aNomPatrimoine;
    private int aIdPropriete;
    private int aPrixAchat;
    private int aJoueurBoss;
    private String aColor;
    public Patrimoine(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,String pColor  )
    {
        super(pNomPatrimoine,pIdPropriete,true);
        this.aPrixAchat = pPrixAchat;
        this.aJoueurBoss = pJoueurBoss;
        this.aColor= pColor;
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

    public int getPrixPayer(HashMap<Integer,Player> vListPlayer){return -1;}
    public int getPrixPayer(HashMap<Integer,Player> vListPlayer,int vScoreDes){return -1;}

    public String getColor()
    {
        return this.aColor;
    }

}