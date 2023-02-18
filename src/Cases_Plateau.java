public class Cases_Plateau
{
    /**
     * Classe pour les informations des cases
     * @author Arvind Tangavelou
     * @author Quentin Guyot
     * @author Timothée Royer
     * @author Clément Lavie
     * @date (2023/01/12)
     */
    private boolean aTypeCase;
    //private Player aPossesseur;
    private int aNbCase;
    private String aNomCase;
    //private int aPrix;
    //private boolean aAchetable;

    public Cases_Plateau(String pNomCase,int pNbCase,boolean pTypeCase) {
        this.aNbCase = pNbCase;
        this.aNomCase = pNomCase;
        this.aTypeCase = pTypeCase;
    }
    /**
     * Mutateur du type de la Case
     * @param pTypeCase reccupere le type de case(si cest un lieu ou une carte achetable
     */
    public void setTypeCase(boolean pTypeCase)
    {
        this.aTypeCase = pTypeCase;
    }//setTypeCase(.)
    /**
     * Assesseur du type de la case
     * @return aTypeCase type de la case
     */
    public boolean getTypeCase()
    {
        return this.aTypeCase;
    }//getTypeCase()


    /**
     * Mutateur du numéros de la case
     * @param pNbCase nouveau numéros de la case
     */
    public void setNbCase(int pNbCase)
    {
        this.aNbCase = pNbCase;
    }//setNbCase(.)
    /**
     * assesseur du numéros de la case
     * @return aNbCase numéros de la case depuis la case départ
     */
    public int getNbCase()
    {
        return this.aNbCase;
    }//getNbCase()

    /**
     * Mutateur du nom de la case
     * @param pNomCase nouveau nom de la case
     */
    public void setNomCase(String pNomCase)
    {
        this.aNomCase = pNomCase;
    }//setNomCase(.)

    /**
     * assesseur du nom de la case
     * @return aNomCase nom de la case
     */
    public String getNomCase()
    {
        return this.aNomCase;
    }//getNomCase()

}//Cases_Plateau