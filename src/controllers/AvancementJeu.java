package src.controllers;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import src.models.Archer;
import src.models.Clerc;
import src.models.Guerrier;
import src.models.Sorcier;

public class AvancementJeu extends JPanel {
	public JLabel joueurActuel;
	private JLabel archere_name, sorciere_name, guerrier_name, clerc_name;

	public AvancementJeu(Archer archere, Sorcier sorciere, Guerrier guerrier, Clerc clerc) {

		setSize(700, 700); // Taille de la fenêtre
		setLayout(null);
		setBackground(Color.black);

		JLabel pvGuerrier = new JLabel("");
		pvGuerrier.setIcon(new ImageIcon("src\\resources\\heart.png"));
		pvGuerrier.setBounds(453, 10, 148, 188);
		add(pvGuerrier);

		JLabel pvSorciere = new JLabel("");
		pvSorciere.setIcon(new ImageIcon("src\\resources\\heart.png"));
		pvSorciere.setBounds(224, 10, 148, 188);
		add(pvSorciere);

		JLabel pvArchere = new JLabel("");
		pvArchere.setIcon(new ImageIcon("src\\resources\\heart.png"));
		pvArchere.setBounds(0, 10, 148, 188);
		add(pvArchere);

		JLabel pvClerc = new JLabel("");
		pvClerc.setIcon(new ImageIcon("src\\resources\\heart.png"));
		pvClerc.setBounds(0, 50, 148, 188);
		add(pvClerc);

		archere_name = new JLabel(archere.getPointsDeVie() + "PV  " + archere.getNom());
		archere_name.setFont(new Font("Calibri", Font.BOLD, 18));
		archere_name.setForeground(new Color(255, 255, 255));
		archere_name.setBounds(90, 20, 124, 35);
		add(archere_name);

		sorciere_name = new JLabel(sorciere.getPointsDeVie() + "PV  " + sorciere.getNom());
		sorciere_name.setForeground(Color.WHITE);
		sorciere_name.setFont(new Font("Calibri", Font.BOLD, 18));
		sorciere_name.setBounds(305, 20, 124, 35);
		add(sorciere_name);

		guerrier_name = new JLabel(guerrier.getPointsDeVie() + "PV  " + guerrier.getNom());
		guerrier_name.setForeground(Color.WHITE);
		guerrier_name.setFont(new Font("Calibri", Font.BOLD, 18));
		guerrier_name.setBounds(539, 20, 124, 35);
		add(guerrier_name);

		clerc_name = new JLabel(clerc.getPointsDeVie() + "PV  " + "Clerc");
		clerc_name.setForeground(Color.WHITE);
		clerc_name.setFont(new Font("Calibri", Font.BOLD, 18));
		clerc_name.setBounds(90, 55, 124, 35);
		add(clerc_name);

		JLabel labelTour = new JLabel("C'est au tour de :");
		labelTour.setForeground(Color.WHITE);
		labelTour.setFont(new Font("Calibri", Font.BOLD, 28));
		labelTour.setBounds(125, 143, 239, 35);
		add(labelTour);

		JLabel blurredbg = new JLabel("");
		blurredbg.setIcon(new ImageIcon("src\\resources\\cadree.png"));
		blurredbg.setBounds(100, 110, 529, 500);
		add(blurredbg);

		this.joueurActuel = new JLabel(sorciere.getNom());
		joueurActuel.setForeground(Color.WHITE);
		joueurActuel.setFont(new Font("Calibri", Font.BOLD, 28));
		joueurActuel.setBounds(125, 188, 239, 35);
		add(joueurActuel);
	}

	public void setArchere_name(String archere_name) {
		this.archere_name.setText(archere_name);
	}

	public void setGuerrier_name(String guerrier_name) {
		this.guerrier_name.setText(guerrier_name);
	}

	public void setSorciere_name(String sorciere_name) {
		this.sorciere_name.setText(sorciere_name);
	}

	public void setClerc_name(String clerc_name) {
		this.clerc_name.setText(clerc_name);
	}
}