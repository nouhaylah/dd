package src.views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import src.controllers.AvancementJeu;
import src.controllers.Case;
import src.controllers.PointsDeVieManager;
import src.models.Personnage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

public class FenetreCaseMalchance extends JFrame implements ActionListener {

    PointsDeVieManager pointsDeVieManager = new PointsDeVieManager();
    private Personnage personnage;
    private AvancementJeu avancementJeu;
    private Case case1;
    JButton btnOkClerc = new JButton("OK");
    JLabel btnOk = new JLabel("");

    public FenetreCaseMalchance(Case case1, Personnage personnage, AvancementJeu avancementJeu) {
        this.personnage = personnage;
        this.avancementJeu = avancementJeu;
        this.case1 = case1;
        setupUIComponents();
        addListeners();

        if ("Clerc".equals(personnage.getType())) {
            handleClercClick();
        }

        btnOkClerc.addActionListener(new ActionListener() { // bouton invisible pour le clerc
            @Override
            public void actionPerformed(ActionEvent e) {
                pointsDeVieManager.diminuerPoints(personnage, case1.getPoints());
                updateAvancementJeu();
                setVisible(false);
            }
        });

    }

    private void addListeners() {
        btnOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pointsDeVieManager.diminuerPoints(personnage, case1.getPoints());
                updateAvancementJeu();
                setVisible(false);
            }
        });
    }

    private void handleClercClick() {
        int delay = 2000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    btnOkClerc.doClick();
                });
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
        JPanel contentPane;
        setTitle("MALCHANCE");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 751, 553);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnOk.setIcon(new ImageIcon("src\\resources\\btn-ok.png"));
        btnOk.setBounds(505, 381, 222, 152);
        contentPane.add(btnOk);

        JLabel lblNewLabel_3 = new JLabel("-" + case1.getPoints() + "PV");
        lblNewLabel_3.setBackground(new Color(0, 0, 0));
        lblNewLabel_3.setForeground(new Color(192, 192, 192));
        lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 24));
        lblNewLabel_3.setBounds(107, 429, 88, 45);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("src\\resources\\bg-malchance.png"));
        lblNewLabel.setBounds(-23, -25, 776, 579);
        contentPane.add(lblNewLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
