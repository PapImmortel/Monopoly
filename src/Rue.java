import java.util.HashMap;

public class Rue extends Patrimoine
{
    private int aNbMaison;
    private int aHotel;

    private String aColor;

    private int [ ] aPrixRente= new int[6];


    public Rue(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,int pNbMaison, int pHotel, String pColor, int[] pPrixPassage)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat,pJoueurBoss);
        this.aNbMaison= pNbMaison;
        this.aHotel=pHotel;
        this.aColor=pColor;
        this.aPrixRente=pPrixPassage;
    }

    @Override public int getPrixPayer(HashMap vListPlayer)
    {
        if(this.aNbMaison==0 && this.aHotel==0 )
        {
            int vJoueur=getJoueurBoss();
            if(vListPlayer.get(vJoueur).getMonopole(this.aColor))//non officiel
            {
                return this.aPrixRente[0]*2;
            }
            else {
                return aPrixRente[0];
            }
        }
        else if(this.aHotel==1)
        {
            return this.aPrixRente[-1];
        }
        else {
            return this.aPrixRente[this.aNbMaison];
        }
    }
    public void setaNbMaison(int pNbMaison) //ajout potentiel d'une verification du droit de construction
    {
        if (pNbMaison+this.aNbMaison<=4 && this.aHotel==0)
        {
            aNbMaison+=pNbMaison;
        }
        else if(pNbMaison+this.aNbMaison==5 && this.aHotel==0)
        {
            this.aNbMaison=0;
            this.aHotel=1;
        }
        else {
            System.out.print("Erreur");
        }
    }

    public int getNbMaison()
    {
        return 5*this.aHotel+this.aNbMaison;
    }

    public String getColor()
    {
        return this.aColor;
    }



}
