import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel {

    private static boolean isType = false;
    private static String lastCommand;
    private static JTextArea textArea = new JTextArea(5,30);

    public static boolean getIsType(){
        return isType;
    }
    public static String getLastCommand(){
        if(isType) {//si une commande tapÃ©e est en attente de lecture
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
    }


    //Partie logique
    public GamePanel(){
        setLayout(null);

        //Boite de dialogue du jeu
        textArea.setBounds(670,200, 550, 300);

        //Zone de commande pour le joueur
        JTextField CMD = new JTextField(30);
        CMD.setBounds(670,600,550,40);
        JScrollPane textA2 = new JScrollPane(textArea);
        textA2.setBounds(670,200, 550, 300);
        add(textA2);
        add(CMD);

        //Logique de la zone de commande du joueur
        CMD.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10){//Quand le joueur fait enter
                    lastCommand = CMD.getText();//On stock sa commande
                    isType = true;//On met la valeur a true pour pour signifier que le joueur a envoyer une information non lue
                    CMD.setText("");//on efface la commande
                }

            }

            public void keyReleased(KeyEvent e) {

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
            g.drawImage(fond3, 680, 0,500, 200, this);

            Font font = new Font("Arial", Font.BOLD, 20);

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Ecrire les commandes ici :",680,595);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}