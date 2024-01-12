import javax.swing.*;

import actions.TourManager;
import models.Archer;
import models.Guerrier;
import models.Sorcier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PlateauDeJeu extends JPanel implements ActionListener  {
    public Cases cases = new Cases();
    public Case[][] casess = cases.getPlateau();
    public JButton[][] plateau = new JButton[7][7];
    private int currentJoueur = 1;
    public Archer archere;
    public Sorcier sorciere;
    public Guerrier guerrier;
    public String personnage;
    public AvancementJeu avancementJeu;
    public int xSorciere,ySorciere,xArcher,yArcher,xGuerrier,yGuerrier,x;

    public PlateauDeJeu(Archer archere, Sorcier sorciere,Guerrier guerrier, AvancementJeu avancementJeu) {
        this.avancementJeu = avancementJeu;
        this.archere = archere;
        this.sorciere = sorciere;
        this.guerrier = guerrier;
        TourManager tourManager = new TourManager();
        this.personnage = tourManager.tourPersonnage(currentJoueur);
        this.xSorciere = sorciere.getX();
        this.ySorciere = sorciere.getY();
        this.xArcher = archere.getX();  
        this.yArcher = archere.getY();  
        this.xGuerrier = guerrier.getX();
        this.yGuerrier = guerrier.getY();
        
        setSize(700, 700); // Taille de la fenêtre
        setLayout(new GridLayout(7, 7)); // Utilisation d'un GridLayout 6x6
        // Remplissage du plateau avec des boutons (vous pouvez personnaliser cela selon vos besoins)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) { 
                    plateau[i][j] = new JButton();
                    //plateau[i][j].setBackground(casess[i][j].getCouleur());
                    plateau[i][j].setBackground(Color.black);
                    plateau[i][j].setIcon(casess[i][j].getIcon());
                    plateau[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
                    //plateau[i][j].setBackground(casess[i][j].getCouleur());
                    plateau[i][j].addActionListener(this);
                    add(plateau[i][j]);
            }
        }  
    }

 

    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(personnage.equals("Sorcier")){
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++){
                    if(e.getSource() == plateau[i][j]){
                        xSorciere=i;ySorciere=j;    
                        System.out.println(xSorciere + " " + ySorciere);
                        if((xSorciere==xArcher && ySorciere==yArcher) || (xSorciere==xGuerrier && ySorciere==yGuerrier) || (sorciere.getX()==5 && xSorciere==6 && (sorciere.getY()==ySorciere+1 || sorciere.getY()==ySorciere-1))) {
                            System.out.println("deplacement impossible");
                        }
                        else if(sorciere.getX()==6 && xSorciere==5 && (sorciere.getY()==ySorciere+1 || sorciere.getY()==ySorciere-1))
                        {
                            System.out.println("sorciere");
                            plateau[sorciere.getX()][sorciere.getY()].setIcon(new ImageIcon(""));
                            sorciere.setX(xSorciere);
                            sorciere.setY(ySorciere);
                            plateau[xSorciere][ySorciere].setIcon(new ImageIcon("images\\sorcierePlateau.png"));
                            if(casess[xSorciere][ySorciere].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, sorciere, casess[xSorciere][ySorciere],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xSorciere][ySorciere].getType().equals("CHANCE") || casess[xSorciere][ySorciere].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xSorciere][ySorciere],sorciere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Guerrier";
                            avancementJeu.joueurActuel.setText(guerrier.getNom());
                            break;
                        }
                        else if(sorciere.getX()<6 && (xSorciere==sorciere.getX()+1 || xSorciere==sorciere.getX()-1 ) && (sorciere.getY()==ySorciere+1 || sorciere.getY()==ySorciere-1))
                        {
                            System.out.println("sorciere");
                            plateau[sorciere.getX()][sorciere.getY()].setIcon(new ImageIcon(""));
                            sorciere.setX(xSorciere);
                            sorciere.setY(ySorciere);
                            plateau[xSorciere][ySorciere].setIcon(new ImageIcon("images\\sorcierePlateau.png"));
                            if(casess[xSorciere][ySorciere].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, sorciere, casess[xSorciere][ySorciere],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xSorciere][ySorciere].getType().equals("CHANCE") || casess[xSorciere][ySorciere].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xSorciere][ySorciere],sorciere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Guerrier";
                            avancementJeu.joueurActuel.setText(guerrier.getNom());
                            break;
                        }
                    
                    }
                }
            }
        }
 
        if(personnage.equals("Guerrier")){
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++){
                    if(e.getSource() == plateau[i][j]){
                        xGuerrier=i;yGuerrier=j;    
                        System.out.println(xGuerrier + " " + yGuerrier);
                        if((xGuerrier==xArcher && yGuerrier==yArcher) || (xGuerrier==xSorciere && yGuerrier==ySorciere)) {
                            System.out.println("deplacement impossible");
                        }
                        else if(guerrier.getX()==5 && xGuerrier==6 && guerrier.getY()==yGuerrier)
                        {
                            System.out.println("deplacement impossible");
                        }
                        else if(guerrier.getX()==6 && xGuerrier==5 && guerrier.getY()==yGuerrier)
                        {
                            System.out.println("guerrier");
                            plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
                            guerrier.setX(xGuerrier);
                            guerrier.setY(yGuerrier);
                            plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon("images\\guerrierPlateau.png"));
                            if(casess[xGuerrier][yGuerrier].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, guerrier, casess[xGuerrier][yGuerrier],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xGuerrier][yGuerrier].getType().equals("CHANCE") || casess[xGuerrier][yGuerrier].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xGuerrier][yGuerrier],guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Archer";
                            avancementJeu.joueurActuel.setText(archere.getNom());
                            break;
                        }
                        else if(guerrier.getX()<6 && (xGuerrier==guerrier.getX()+1 || xGuerrier==guerrier.getX()-1 ) && guerrier.getY()==yGuerrier)
                        {
                            System.out.println("guerrier");
                            plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
                            guerrier.setX(xGuerrier);
                            guerrier.setY(yGuerrier);
                            plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon("images\\guerrierPlateau.png"));
                            if(casess[xGuerrier][yGuerrier].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, guerrier, casess[xGuerrier][yGuerrier],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xGuerrier][yGuerrier].getType().equals("CHANCE") || casess[xGuerrier][yGuerrier].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xGuerrier][yGuerrier],guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Archer";
                            avancementJeu.joueurActuel.setText(archere.getNom());
                            break;
                        }
                        else if(guerrier.getX()<6 && (yGuerrier==guerrier.getY()+1 || yGuerrier==guerrier.getY()-1 ) && guerrier.getX()==xGuerrier)
                        {
                            System.out.println("guerrier");
                            plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
                            guerrier.setX(xGuerrier);
                            guerrier.setY(yGuerrier);
                            plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon("images\\guerrierPlateau.png"));
                            if(casess[xGuerrier][yGuerrier].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, guerrier, casess[xGuerrier][yGuerrier],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xGuerrier][yGuerrier].getType().equals("CHANCE") || casess[xGuerrier][yGuerrier].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xGuerrier][yGuerrier],guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Archer";
                            avancementJeu.joueurActuel.setText(archere.getNom());
                            break;
                        }
                    
                    }
                }
            }
        }

        if(personnage.equals("Archer")){
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++){
                    if(e.getSource() == plateau[i][j]){
                        xArcher=i;yArcher=j;    
                        System.out.println(xArcher + " " + yArcher);
                        if((xArcher==xGuerrier && yArcher==yGuerrier) || (xArcher==xSorciere && yArcher==ySorciere)) {
                            System.out.println("deplacement impossible");
                        }
                        else if(archere.getX()==5 && xArcher==6 )
                        {
                            System.out.println("deplacement impossible");
                        }
                        else if((archere.getX()==6 && xArcher==5 && (archere.getY()==yArcher+2 || archere.getY()==yArcher-2)) || (archere.getX()==6 && xArcher==4 && (archere.getY()==yArcher+1 || archere.getY()==yArcher-1)))
                        {
                            System.out.println("archer");
                            plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
                            archere.setX(xArcher);
                            archere.setY(yArcher);
                            plateau[xArcher][yArcher].setIcon(new ImageIcon("images\\archerePlateau.png"));
                            if(casess[xArcher][yArcher].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, archere, casess[xArcher][yArcher],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xArcher][yArcher].getType().equals("CHANCE") || casess[xArcher][yArcher].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xArcher][yArcher],archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Sorcier";
                            avancementJeu.joueurActuel.setText(sorciere.getNom());
                            break;
                        }
                        else if(archere.getX()<6 && (xArcher==archere.getX()+1 || xArcher==archere.getX()-1 ) && (archere.getY()==yArcher+2 || archere.getY()==yArcher-2 ))
                        {
                    
                            System.out.println("archer");
                            plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
                            archere.setX(xArcher);
                            archere.setY(yArcher);
                            plateau[xArcher][yArcher].setIcon(new ImageIcon("images\\archerePlateau.png"));
                            if(casess[xArcher][yArcher].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, archere, casess[xArcher][yArcher],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xArcher][yArcher].getType().equals("CHANCE") || casess[xArcher][yArcher].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xArcher][yArcher],archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Sorcier";
                            avancementJeu.joueurActuel.setText(sorciere.getNom());
                            break;
                        }
                        else if(archere.getX()<6 && (xArcher==archere.getX()+2 || xArcher==archere.getX()-2 ) && (archere.getY()==yArcher+1 || archere.getY()==yArcher-1))
                        {
                            System.out.println("archer");
                            plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
                            archere.setX(xArcher);
                            archere.setY(yArcher);
                            plateau[xArcher][yArcher].setIcon(new ImageIcon("images\\archerePlateau.png"));
                            if(casess[xArcher][yArcher].getType().equals("ENIGME")){
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, archere, casess[xArcher][yArcher],"");
                                fenetreCase.setVisible(true);
                            }
                            else if(casess[xArcher][yArcher].getType().equals("CHANCE") || casess[xArcher][yArcher].getType().equals("MALCHANCE")){
                                PopUp fenetreCase = new PopUp(casess[xArcher][yArcher],archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Sorcier";
                            avancementJeu.joueurActuel.setText(sorciere.getNom());
                            break;
                        }
                    }
                }
            }
        }
    }
}   

    
    

