/**
 * Classe pour les informations des cases
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 * @date (2023/01/12)
 */
public class Cases_Plateau
{

    private final boolean aTypeCase;
    private final int aNbCase;
    private final String aNomCase;

    public Cases_Plateau(String pNomCase,int pNbCase,boolean pTypeCase) {
        this.aNbCase = pNbCase;
        this.aNomCase = pNomCase;
        this.aTypeCase = pTypeCase;
    }

    /**
     * Accesseur du type de la case
     * @return aTypeCase type de la case
     */
    public boolean getTypeCase()
    {
        return this.aTypeCase;
    }//getTypeCase()



    /**
     * accesseur du numéro de la case
     * @return aNbCase numéros de la case depuis la case départ
     */
    public int getNbCase()
    {
        return this.aNbCase;
    }//getNbCase()


    /**
     * accesseur du nom de la case
     * @return aNomCase nom de la case
     */
    public String getNomCase()
    {
        return this.aNomCase;
    }//getNomCase()

}//Cases_Plateau