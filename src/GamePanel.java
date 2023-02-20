import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class GamePanel extends JPanel {

    private static HashMap<Integer, Player> ListJoueur = new HashMap<>();
    private static int nJoueur;
    private static boolean isType = false;

    private static String lastCommand;
    private static final JTextArea textArea = new JTextArea(2,30);

    private static final JLabel Joueur1 = new JLabel();
    private static final JLabel Joueur2 = new JLabel();
    private static final JLabel Joueur3 = new JLabel();
    private static final JLabel Joueur4 = new JLabel();
    private static final int[] CaseCoordX = new int []{600,530,480,430,380,330,280,226,173,126,59,59,59,59,59,59,59,59,59,59,59,124,174,230,277,328,380,430,482,532,600,600,600,600,600,600,600,600,600,600};
    private static final int[] CaseCoordY = new int []{600,600,600,600,600,600,600,600,600,600,610,533,480,434,380,330,280,230,180,130,58,50,50,50,50,50,50,50,50,50,50,125,180,230,280,330,380,430,480,530};


    public static void setPlayerList(HashMap<Integer, Player> ListJoueurP){
        ListJoueur = ListJoueurP;
    }
    public static void setNPlayer(int n){
        nJoueur = n;
    }
    public static boolean getIsType(){
        return isType;
    }
    public static String getLastCommand(){
        if(isType ) {//si une commande tape est en attente de lecture
            String temp = lastCommand;
            lastCommand = "";
            isType = false;
            return temp;
        }
        else return "";
    }

    public static String getCommand(){
        while(!isType){
            System.out.print("");
        }
        return getLastCommand();
    }


    public static void PrintMSG(String text){
        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());

    }
    public static void UpdateMoneyGUI(){
        Joueur1.setText( ListJoueur.get(1).getNomJoueur() + " : " + ListJoueur.get(1).getArgent() + " € " + "("+ListJoueur.get(1).getCouleur()+")");
        Joueur2.setText( ListJoueur.get(2).getNomJoueur() + " : " + ListJoueur.get(2).getArgent() + " € " + "("+ListJoueur.get(2).getCouleur()+")");
        if(nJoueur > 2){
            Joueur3.setText( ListJoueur.get(3).getNomJoueur() + " : " + ListJoueur.get(3).getArgent() + " € " + "("+ListJoueur.get(3).getCouleur()+")");
        }
        if(nJoueur > 3){
            Joueur4.setText( ListJoueur.get(4).getNomJoueur() + " : " + ListJoueur.get(4).getArgent() + " € " + "("+ListJoueur.get(4).getCouleur()+")");
        }
    }

    //Partie logique
    public GamePanel(){
        setLayout(null);

        //Boite de dialogue du jeu
        textArea.setBounds(670,170, 550, 200);
        textArea.setEditable(false);
        textArea.setAutoscrolls(true);

        //Zone de commande pour le joueur
        JTextField CMD = new JTextField(30);
        CMD.setBounds(670,550,550,40);
        //Gestion de l'affichage de l'argent des joueurs
        Joueur1.setBounds(700, 150, 700, 20);
        Font font = new Font("Arial", Font.BOLD, 17);
        Joueur1.setFont(font);
        Joueur1.setForeground(Color.WHITE);

        Joueur2.setBounds(700, 170, 700, 20);
        Joueur2.setFont(font);
        Joueur2.setForeground(Color.WHITE);

        Joueur3.setBounds(700, 190, 700, 20);
        Joueur3.setFont(font);
        Joueur3.setForeground(Color.WHITE);

        Joueur4.setBounds(700, 210, 700, 20);
        Joueur4.setFont(font);
        Joueur4.setForeground(Color.WHITE);


        //Bouton QUITTER
        JButton quit = new JButton("Quitter");
        quit.setBounds(1000, 600, 150, 40);
        quit.setBackground(Color.GRAY);
        quit.setForeground(Color.WHITE);

        JScrollPane textA2 = new JScrollPane(textArea);
        textA2.setBounds(670,250, 550, 250);
        add(textA2);
        add(CMD);
        add(quit);
        add(Joueur1);
        add(Joueur2);
        add(Joueur3);
        add(Joueur4);
        //Logique de la zone de commande du joueur
        CMD.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10){//Quand le joueur utilise la touche entrée
                    lastCommand = CMD.getText();//On stocke sa commande
                    isType = true;//On met la valeur a true pour signifier que le joueur a envoyé une information non lue

                    CMD.setText("");//on efface la commande
                }

            }

            public void keyReleased(KeyEvent e) {
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    //Partie Graphique
    public void paintComponent(Graphics g){

        try{
            g.setColor(Color.BLACK);
            g.fillRect(0,0,670,750);
            g.setColor(Color.GRAY);
            g.fillRect(670,0,750,750);

            Image fond = ImageIO.read(new File("resources/plateau.png"));
            g.drawImage(fond, 20, 20,620, 620, this);

            Image fond2 = ImageIO.read(new File("resources/fond.png"));
            g.drawImage(fond2, 670, 0,1100, 700, this);

            Image fond3 = ImageIO.read(new File("resources/logoJavapoly.png"));
            g.drawImage(fond3, 680, -30,500, 200, this);

            Font font = new Font("Arial", Font.BOLD, 20);
            //GESTION du Pion du JOUEUR 1
            if(ListJoueur.get(1).getCouleur().equals("ROUGE")){
                g.setColor(Color.RED);
            }
            else if(ListJoueur.get(1).getCouleur().equals("BLEU")){
                g.setColor(Color.BLUE);
            }
            else if(ListJoueur.get(1).getCouleur().equals("JAUNE")){
                g.setColor(Color.YELLOW);
            }
            else if(ListJoueur.get(1).getCouleur().equals("VERT")){
                g.setColor(Color.GREEN);
            }
            g.fillOval(CaseCoordX[ListJoueur.get(1).getPosition().getNbCase()],CaseCoordY[ListJoueur.get(1).getPosition().getNbCase()],20,20);

            //GESTION du Pion du JOUEUR 2
            if(ListJoueur.get(2).getCouleur().equals("ROUGE")){
                g.setColor(Color.RED);
            }
            else if(ListJoueur.get(2).getCouleur().equals("BLEU")){
                g.setColor(Color.BLUE);
            }
            else if(ListJoueur.get(2).getCouleur().equals("JAUNE")){
                g.setColor(Color.YELLOW);
            }
            else if(ListJoueur.get(2).getCouleur().equals("VERT")){
                g.setColor(Color.GREEN);
            }
            g.fillOval(CaseCoordX[ListJoueur.get(2).getPosition().getNbCase()]+5,CaseCoordY[ListJoueur.get(2).getPosition().getNbCase()]+5,20,20);

            //GESTION du Pion du JOUEUR 3
            if(nJoueur>2) {
                if (ListJoueur.get(3).getCouleur().equals( "ROUGE")) {
                    g.setColor(Color.RED);
                } else if (ListJoueur.get(3).getCouleur().equals("BLEU")) {
                    g.setColor(Color.BLUE);
                } else if (ListJoueur.get(3).getCouleur().equals("JAUNE")) {
                    g.setColor(Color.YELLOW);
                } else if (ListJoueur.get(3).getCouleur().equals("VERT")) {
                    g.setColor(Color.GREEN);
                }
                g.fillOval(CaseCoordX[ListJoueur.get(3).getPosition().getNbCase()] - 5, CaseCoordY[ListJoueur.get(3).getPosition().getNbCase()] - 5, 20, 20);
            }
            if(nJoueur>3){
                if (ListJoueur.get(4).getCouleur().equals("ROUGE")) {
                    g.setColor(Color.RED);
                } else if (ListJoueur.get(4).getCouleur().equals("BLEU")) {
                    g.setColor(Color.BLUE);
                } else if (ListJoueur.get(4).getCouleur().equals("JAUNE")) {
                    g.setColor(Color.YELLOW);
                } else if (ListJoueur.get(4).getCouleur().equals("VERT")){
                    g.setColor(Color.GREEN);
                }
                g.fillOval(CaseCoordX[ListJoueur.get(4).getPosition().getNbCase()] - 5, CaseCoordY[ListJoueur.get(4).getPosition().getNbCase()] +5 , 20, 20);
            }

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Écrire les commandes ici :",680,595);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}