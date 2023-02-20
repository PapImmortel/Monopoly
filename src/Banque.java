/**
 * Classe de la Banque
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Banque
{

    private int aNbMaison;
    private int aNbHotel;
    private int aBenefice;

    /**
     * Constructeur par défaut de la classe banque
     */
    public Banque()
    {
        this.aNbMaison = 32;
        this.aNbHotel = 12;
        this.aBenefice = 0;
    }//Banque()

    /**
     * Mutateur du nombre de maisons
     * @param pNbMaison int modification du nombre de maisons restantes
     */
    public void setNbMaison(int pNbMaison)
    {
        this.aNbMaison = pNbMaison;
    }//setNbMaison(.)

    /**
     * Accesseur du nombre de maisons restantes
     * @return aNbMaison nombre de maisons restantes dans la banque
     */
    public int getNbMaison()
    {
        return this.aNbMaison;
    }//getNbMaison()

    /**
     * Mutateur du nombre d'hotel
     * @param pNbHotel int modification du nombre d'hotel restant
     */
    public void setNbHotel(int pNbHotel)
    {
        this.aNbHotel = pNbHotel;
    }//setNbHotel(.)

    /**
     * Accesseur du nombre d'hotel
     * @return aNbHotel int nombre d'hotel restant dans la banque
     */
    public int getNbHotel()
    {
        return this.aNbHotel;
    }//getNbHotel()

    /**
     * Mutateur du Benefice de la banque
     * @param pBenefice  int somme d'argent, venant des impôts et des taxes, et récupérable par le joueur
     *                   s'il atterrit sur la case Parc gratuit
     */
    public void setBenefice(int pBenefice)
    {
        this.aBenefice = pBenefice;
    }//setBenefice(.)

    /**
     * Accesseur du bénéfice de la banque
     * @return aBenefice int somme d'argent, venant des impôts et des taxes, et récupérable par le joueur
     *                         s'il atterrit sur la case Parc gratuit
     */
    public int getBenefice()
    {
        return this.aBenefice;
    }//getBenefice()

    /**
     * Chaine de caractère à afficher pour que les joueurs aient les informations sur le nombre de maisons et d'hôtels disponibles en banques
     * @return String contenant le nombre d'hôtels et de maisons disponibles.
     */
    public String informationMaisonHotel()
    {
        String retS;
        if (this.aNbHotel > 0 && this.aNbMaison > 0)
        {
            retS = "Il est possible de construire encore " + this.aNbMaison + " maison(s) et encore " + this.aNbHotel + " hôtel(s).\n";
        }
        else if (this.aNbMaison == 0 && this.aNbHotel == 0)
        {
            retS = "Il n'y a plus de maison ni d'Hôtel à construire.\n C'est la crise de l'immobilier.\n";
        }
        else if (this.aNbHotel > 0 && this.aNbMaison == 0)
        {
            retS =  "Il n'y a plus que "+ this.aNbHotel + " hôtel(s) constructible(s) mais il n'y a plus de maison disponible.\n";
        }
        else if (this.aNbHotel == 0 && this.aNbMaison > 0)
        {
            retS = "Il n'y a plus que "+ this.aNbMaison + " maison(s) constructible(s) mais il n'y a plus d'hôtel disponible.\n";
        }
        else
        {
            retS = " ";
        }
        return  retS;
    }
}//Banque