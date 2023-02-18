import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.DocumentationTool;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private static int IndexPlayer;

    private static boolean isFinish = false;

    private static HashMap<Integer, String> ListJoueur = new HashMap<>();

    public static boolean getIsFinish(){
        return isFinish;
    }

    public static HashMap<Integer, String> getPlayerList(){
        return ListJoueur;
    }
    public static int getIndexPlayer(){
        return IndexPlayer;
    }
    public Panel(){
        //Initialisation du bouton
        JButton button = new JButton ("Confirmer");

        //LABEL
        JLabel label = new JLabel("Choisir le nom des joueurs :");
        label.setForeground(Color.WHITE);

        //Boite de dialogue
        JTextArea textArea = new JTextArea(10,30);

        //Phrase d'introduction
        textArea.append("Bienvenue dans le Monopoly java ! \n");
        textArea.append("Veuillez saisir le nom des joueurs. \n");

        //Champ nom Joueur
        JTextField nomJoueur = new JTextField(10);

        //Logique du bouton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(IndexPlayer <2){
                    textArea.append("Le jeu accepte 2 joueurs minimum.\n");
                }
                else{
                    textArea.append("Lancement du jeu !\n");
                    isFinish = true;
                }
            }
        });

        //Logique de la zone de texte
        nomJoueur.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10 && nomJoueur.getText() != null){
                    if(IndexPlayer<4){
                        IndexPlayer++;
                        textArea.append("Bonjour " + nomJoueur.getText() + ", tu es le joueur n°" + IndexPlayer + " ! \n");
                        ListJoueur.put(IndexPlayer,nomJoueur.getText());
                        nomJoueur.setText("");
                    }
                    else{
                        textArea.append("Le jeu accepte 4 joueurs maximum.\n");
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