import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Personnage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreCaseEnigme extends JFrame implements ActionListener {
	private JButton btnRepondre, btnAbondonner;
	private JTextField reponse;
	private Personnage personnage;
	private Case case1;
	private AvancementJeu avancementJeu;

	public FenetreCaseEnigme(AvancementJeu av, Personnage personnage, Case case1, String answer) {
		JPanel contentPane;
		this.personnage = personnage;
		this.case1 = case1;
		this.avancementJeu = av;
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(case1.getPathEnigme()));
		lblNewLabel.setBounds(91, -18, 865, 584);
		contentPane.add(lblNewLabel);

		reponse = new JTextField();
		reponse.setFont(new Font("Tahoma", Font.BOLD, 12));
		reponse.setBounds(444, 576, 199, 19);
		contentPane.add(reponse);
		reponse.setColumns(10);

		btnRepondre = new JButton("REPONDRE");
		btnRepondre.setFont(new Font("Calibri", Font.BOLD, 18));
		btnRepondre.setBounds(885, 646, 141, 37);
		btnRepondre.setBackground(Color.GRAY);
		btnRepondre.setForeground(Color.black);
		contentPane.add(btnRepondre);
		btnRepondre.addActionListener(this);

		btnAbondonner = new JButton("ABANDONNER");
		btnAbondonner.setFont(new Font("Calibri", Font.BOLD, 17));
		btnAbondonner.setBounds(34, 652, 141, 37);
		btnAbondonner.setBackground(Color.GRAY);
		btnAbondonner.setForeground(Color.black);
		contentPane.add(btnAbondonner);
		btnAbondonner.addActionListener(this);

		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = ((JButton) e.getSource()).getText();
		if (btn.equals("REPONDRE")) {
			String answer = reponse.getText();
			System.out.println(answer);
			System.out.println(case1.getAnswer());
			if (case1.getAnswer().contains(answer.toUpperCase())) {
				System.out.println(answer);
				JOptionPane.showMessageDialog(this,
						"Vous avez bien répondue à l'énigme, vous gagnez 50 points de vie !");
				personnage.setPointsDeVie(personnage.getPointsDeVie() + 50);
				if (personnage.getType().equals("Sorcier")) {
					avancementJeu.setSorciere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
				} else if (personnage.getType().equals("Guerrier")) {
					avancementJeu.setGuerrier_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
				} else if (personnage.getType().equals("Archer")) {
					avancementJeu.setArchere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
				}
				this.setVisible(false);
			} else if (case1.getAnswer() != answer.toUpperCase()) {
				JOptionPane.showMessageDialog(this,
						"Vous avez mal répondue à l'énigme, vous perdez 50 points de vie !");
				personnage.setPointsDeVie(personnage.getPointsDeVie() - 50);
				if (personnage.getType().equals("Sorcier")) {
					avancementJeu.setSorciere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
				} else if (personnage.getType().equals("Guerrier")) {
					avancementJeu.setGuerrier_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
				} else if (personnage.getType().equals("Archer")) {
					avancementJeu.setArchere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
				}
				this.setVisible(false);
			}
		} else if (btn.equals("ABANDONNER")) {
			personnage.setPointsDeVie(personnage.getPointsDeVie() - 50);
			if (personnage.getType().equals("Sorcier")) {
				avancementJeu.setSorciere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
			} else if (personnage.getType().equals("Guerrier")) {
				avancementJeu.setGuerrier_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
			} else if (personnage.getType().equals("Archer")) {
				avancementJeu.setArchere_name(personnage.getPointsDeVie() + "PV  " + personnage.getNom());
			}
			this.setVisible(false);
		}
	}

}
