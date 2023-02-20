import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private static int IndexPlayer;

    private static boolean isFinish = false;

    private static final HashMap<Integer, String> ListJoueur = new HashMap<>();

    private static final String[] ListCouleur = new String[4];

    public static boolean getIsFinish(){
        return isFinish;
    }

    public static HashMap<Integer, String> getPlayerList(){
        return ListJoueur;
    }

    public static String[] getColorList(){
        return ListCouleur;
    }

    public static int getIndexPlayer(){
        return IndexPlayer;
    }
    public Panel(){
        //Initialisation du bouton
        JButton button = new JButton ("Confirmer");

        //LABELS
        JLabel label = new JLabel("Choisir le nom du joueur :");
        label.setForeground(Color.WHITE);

        JLabel label2 = new JLabel("et sa couleur :");
        label2.setForeground(Color.WHITE);

        //Boite de dialogue
        JTextArea textArea = new JTextArea(10,30);
        textArea.setAutoscrolls(true);
        textArea.setEditable(false);

        //Phrase d'introduction
        textArea.append("Bienvenue dans le Monopoly java ! \n");
        textArea.append("Veuillez saisir le nom d'un joueur, choisir sa couleur. \nPuis appuyer sur entrer \n");

        //Champ nom Joueur
        JTextField nomJoueur = new JTextField(10);

        //ComboBox pour choisir la couleur du joueur
        String[] couleurs = new String[]{"ROUGE","BLEU","JAUNE","VERT"};
        JComboBox <String> Couleur = new JComboBox<>(couleurs);

        //Logique du bouton
        button.addActionListener(e -> {
            if(IndexPlayer <2){
                textArea.append("Le jeu accepte 2 joueurs minimum.\n");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
            else{
                textArea.append("Lancement du jeu !\n");
                textArea.setCaretPosition(textArea.getDocument().getLength());
                isFinish = true;
            }
        });

        //Logique de la zone de texte
        nomJoueur.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10 && !nomJoueur.getText().equals("")){
                    if(IndexPlayer<4){
                        IndexPlayer++;

                        String temp = Couleur.getItemAt(Couleur.getSelectedIndex());
                        textArea.append("Bonjour " + nomJoueur.getText() + ", tu es le joueur n°" + IndexPlayer + " de couleur " + temp +" ! \n");
                        textArea.setCaretPosition(textArea.getDocument().getLength());

                        ListCouleur[IndexPlayer-1]=temp;
                        ListJoueur.put(IndexPlayer,nomJoueur.getText());

                        Couleur.removeItem(Couleur.getSelectedItem());
                        nomJoueur.setText("");
                    }
                    else{
                        textArea.append("Le jeu accepte 4 joueurs maximum.\n");
                        textArea.setCaretPosition(textArea.getDocument().getLength());
                        nomJoueur.setText("");
                    }

                }

            }

            public void keyReleased(KeyEvent e) {

            }

        });

        //Ajout des éléments au panel
        add(label);
        add(nomJoueur);
        add(label2);
        add(Couleur);
        add(new JScrollPane(textArea));//Ajout d'une scrollbar
        add(button);
    }
    //Partie Graphique
    public void paintComponent(Graphics g){

        try{
            Image fond2 = ImageIO.read(new File("resources/fond.png"));
            g.drawImage(fond2, 0, 0,1500, 700, this);

            Image fond3 = ImageIO.read(new File("resources/logoJavapoly.png"));
            g.drawImage(fond3, 100, 200,1000, 400, this);

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

}