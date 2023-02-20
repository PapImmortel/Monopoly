/**
 * Classe pour les informations des cases
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Cases_Plateau
{

    private final boolean aTypeCase;
    private final int aNbCase;
    private final String aNomCase;

    /**
     * Constructeur de la classe Cases_Plateau
     * @param pNomCase String le nom de la case du plateau
     * @param pNbCase int le numéro de la case du plateau
     * @param pTypeCase boolean le type de la case (si c'est une case achetable ou non)
     */
    public Cases_Plateau(String pNomCase,int pNbCase,boolean pTypeCase) {
        this.aNbCase = pNbCase;
        this.aNomCase = pNomCase;
        this.aTypeCase = pTypeCase;
    }

    /**
     * Accesseur du type de la case
     * @return aTypeCase boolean le type de la case(achetable ou non)
     */
    public boolean getTypeCase()
    {
        return this.aTypeCase;
    }//getTypeCase()



    /**
     * accesseur du numéro de la case
     * @return aNbCase int numéro de la case
     */
    public int getNbCase()
    {
        return this.aNbCase;
    }//getNbCase()


    /**
     * accesseur du nom de la case
     * @return aNomCase String nom de la case
     */
    public String getNomCase()
    {
        return this.aNomCase;
    }//getNomCase()

}//Cases_Plateau