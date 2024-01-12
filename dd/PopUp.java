import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import models.Personnage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUp extends JFrame implements ActionListener{

    private Personnage personnage;
    private AvancementJeu avancementJeu;
    private Case case1;

    public PopUp(Case case1, Personnage personnage, AvancementJeu avancementJeu){
        JPanel contentPane;
        this.personnage = personnage;
        this.avancementJeu = avancementJeu;
        this.case1 = case1;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 991, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(case1.getPath()));
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Calibri", Font.BOLD, 18));
		btnOk.setBackground(Color.GRAY);
        btnOk.addActionListener(this);
        String t = "";
        if (case1.getType().equals("CHANCE")) {
            t = "GAGNE";
        }
        else if (case1.getType().equals("MALCHANCE")) {
            t = "PERDU";
        }
		JLabel lblNewLabel_1 = new JLabel("VOUS AVEZ " + t + " " + case1.getPoints() + "PV");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 22));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(411)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(357)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(367))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
		);
        contentPane.setLayout(gl_contentPane);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = ((JButton) e.getSource()).getText();
		if(btn.equals("OK")){
            if(case1.getType().equals("CHANCE")){
                personnage.setPointsDeVie(personnage.getPointsDeVie() + case1.getPoints());
                if(personnage.getType().equals("Sorcier")){
                avancementJeu.setSorciere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
                }
                else if(personnage.getType().equals("Guerrier")){
                    avancementJeu.setGuerrier_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
                }
                else if(personnage.getType().equals("Archer")){
                    avancementJeu.setArchere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
                }
            }
            else if(case1.getType().equals("MALCHANCE")){
                personnage.setPointsDeVie(personnage.getPointsDeVie() - case1.getPoints());
                if(personnage.getType().equals("Sorcier")){
                avancementJeu.setSorciere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
                }
                else if(personnage.getType().equals("Guerrier")){
                    avancementJeu.setGuerrier_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
                }
                else if(personnage.getType().equals("Archer")){
                    avancementJeu.setArchere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
                }
            }
            
            
        this.setVisible(false);
        }
    }
        
}
