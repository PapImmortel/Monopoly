import java.util.HashMap;

public class Rue extends Patrimoine
{
    private int aNbMaison;
    private int aHotel;



    private int [] aPrixRente;


    public Rue(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,int pNbMaison, int pHotel, String pColor, int[] pPrixPassage, int pHypotheque)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat,pJoueurBoss,pColor,pHypotheque);
        this.aNbMaison= pNbMaison;
        this.aHotel=pHotel;

        this.aPrixRente=pPrixPassage;
    }

    @Override public int getPrixPayer(HashMap<Integer,Player> vListPlayer)
    {
        if(this.aNbMaison==0 && this.aHotel==0 )
        {
            int vJoueur=getJoueurBoss();
            if(vListPlayer.get(vJoueur).getMonopole(super.getColor()))
            {
                return this.aPrixRente[0]*2;
            }
            else {
                return aPrixRente[0];
            }
        }
        else if(this.aHotel==1)
        {
            return this.aPrixRente[5];
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

    public int[] getNbMaison()
    {
        int [] vNbMaison= {this.aNbMaison,this.aHotel};
        return vNbMaison;
    }




}
