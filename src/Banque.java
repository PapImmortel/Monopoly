public class Banque
{
    /**
     * Classe de la Banque
     * @author Arvind Tangavelou
     * @author Quentin Guyot
     * @author Timothée Royer
     * @author Clément Lavie
     * @date (2023/01/12)
     */
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
     * Mutateur du nombre de maison
     * @param pNbMaison aNbmaison modification du nombre de maison restante
     */
    public void setNbMaison(int pNbMaison)
    {
        this.aNbMaison = pNbMaison;
    }//setNbMaison(.)

    /**
     * Assesseur du nombre de maison restante
     * @return aNbMaison nombre de maison restante dans la banque
     */
    public int getNbMaison()
    {
        return this.aNbMaison;
    }//getNbMaison()

    /**
     * Mutateur du nombre d'hotel
     * @param pNbHotel aHotel modification du nombre d'hotel restante
     */
    public void setNbHotel(int pNbHotel)
    {
        this.aNbHotel = pNbHotel;
    }//setNbHotel(.)

    /**
     * Assesseur du nombre d'hotel
     * @return aNbHotel nombre d'hotel restant dans la banque
     */
    public int getNbHotel()
    {
        return this.aNbHotel;
    }//getNbHotel()

    /**
     * Mutateur du Benefice de la banque
     * @param pBenefice aBenefice montant en banque venant des impots et taxes
     */
    public void setBenefice(int pBenefice)
    {
        this.aBenefice = pBenefice;
    }//setBenefice(.)

    /**
     * Assesseur du Benedice de la banque
     * @return aBenefice montant en banque venant des impots et taxes
     */
    public int getBenefice()
    {
        return this.aBenefice;
    }//getBenefice()

    /**
     * Chaine de caractère à afficher pour que les joueurs ait les informations sur le nombre de maison et d'hôtel disponible
     * @return String avec nombre d'hôtel et de maison disponible.
     */
    public String informationMaisonHotel()
    {
        String retS = "";
        if (this.aNbHotel > 0 && this.aNbMaison > 0)
        {
            retS = "Il est possible de construire encore " + this.aNbMaison + " maison et encore " + this.aNbHotel + " Hôtel.\n";
        }
        else if (this.aNbMaison == 0 && this.aNbHotel == 0)
        {
            retS = "Il n'y a plus de maison ni d'Hôtel à construire.\n C'est la crise de l'immobilier.\n";
        }
        else if (this.aNbHotel > 0 && this.aNbMaison == 0)
        {
            retS =  "Il n'y a plus que "+ this.aNbHotel + " hôtel constructible mais il n'y a plus de maison disponible.\n";
        }
        else if (this.aNbHotel == 0 && this.aNbMaison > 0)
        {
            retS = "Il n'y a plus que "+ this.aNbMaison + " maison constructible mais il n'y a plus d'hôtel disponible.\n";
        }
        else
        {
            retS = " ";
        }
        return  retS;
    }
}//Banque