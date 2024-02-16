package src.views;

import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import src.controllers.AvancementJeu;
import src.controllers.Case;
import src.controllers.PointsDeVieManager;
import src.models.Personnage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class FenetreCaseChance extends JFrame implements ActionListener {

    PointsDeVieManager pointsDeVieManager = new PointsDeVieManager();
    private Personnage personnage;
    private AvancementJeu avancementJeu;
    private Case case1;
    JButton btnOk = new JButton("OK");

    public FenetreCaseChance(Case case1, Personnage personnage, AvancementJeu avancementJeu) {
        this.personnage = personnage;
        this.avancementJeu = avancementJeu;
        this.case1 = case1;
        setupUIComponents();

        if ("Clerc".equals(personnage.getType()) && "CHANCE".equals(case1.getType())) {
            handleClercClick();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = ((JButton) e.getSource()).getText();
        if (btn.equals("OK")) {
            pointsDeVieManager.diminuerPoints(personnage, case1.getPoints());
            updateAvancementJeu();
        }
        this.setVisible(false);
    }

    private void handleClercClick() {
        int delay = 2000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    btnOk.doClick();
                });
                updateAvancementJeu();
                ((Timer) evt.getSource()).stop(); // Stop the timer after executing once
            }
        });

        timer.start();
    }

    private void updateAvancementJeu() {
        // Logic to update avancementJeu based on personnage type
        String pvText = personnage.getPointsDeVie() + "PV  " + personnage.getNom();
        switch (personnage.getType()) {
            case "Sorcier":
                avancementJeu.setSorciere_name(pvText);
                break;
            case "Guerrier":
                avancementJeu.setGuerrier_name(pvText);
                break;
            case "Archer":
                avancementJeu.setArchere_name(pvText);
                break;
            case "Clerc":
                avancementJeu.setClerc_name(pvText);
                break;
        }
    }

    private void setupUIComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 991, 705);

        JPanel contentPane;
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(case1.getPath()));

        // Ok (dismiss) button setup
        btnOk.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnOk.setBackground(Color.GRAY);
        btnOk.setFocusable(false);
        btnOk.addActionListener(this);
        String t = "";

        if (case1.getType().equals("CHANCE")) {
            t = "GAGNE";
        } else if (case1.getType().equals("MALCHANCE")) {
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
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 954,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(411)
                                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 141,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(13, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(357)
                                .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(367)));
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(lblNewLabel_1)
                                .addGap(18)
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)));
        contentPane.setLayout(gl_contentPane);
        setResizable(false);
    }
}
