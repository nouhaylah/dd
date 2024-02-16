package src.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import src.controllers.AvancementJeu;
import src.controllers.Case;
import src.models.Personnage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class FenetreCaseCombat extends JFrame {

    private static Personnage personnage;
    private static AvancementJeu avancementJeu;
    private static Case case1;

    private static final String font = "Arial Black";
    private static final ImageIcon backgroundImage = new ImageIcon("src\\resources\\monstreencounter.png");

    // JButton btnFuirClerc = new CustomButton("Fuir", Color.DARK_GRAY, Color.WHITE,
    // new Font(font, Font.BOLD, 20));
    JButton btnLutterClerc = new CustomButton("Lutter", Color.DARK_GRAY, Color.WHITE,
            new Font(font, Font.BOLD, 20));
    JLabel lblNewLabel = new JLabel("");
    JPanel buttonPanel = new JPanel(new GridBagLayout());
    BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage.getImage());
    GridBagConstraints gbc = new GridBagConstraints();

    JLabel btnFuir = new JLabel("");
    JLabel btnLutter = new JLabel("");

    public FenetreCaseCombat(Case case1, Personnage personnage, AvancementJeu avancementJeu) {
        FenetreCaseCombat.case1 = case1;
        FenetreCaseCombat.personnage = personnage;
        FenetreCaseCombat.avancementJeu = avancementJeu;
        setupUIComponents();

        if ("Clerc".equals(personnage.getType())) {
            handleClercClick();
        }

        // btnFuirClerc.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // fuir(personnage, avancementJeu);
        // }
        // });

        btnLutterClerc.addActionListener(new ActionListener() { // bouton invisible pour le clerc
            @Override
            public void actionPerformed(ActionEvent e) {
                lutter(personnage, avancementJeu);
            }
        });
    }

    private void setupUIComponents() {
        JPanel contentPane;
        setTitle("Combat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 751, 586);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\resources\\CentraleFlame.png"));
        lblNewLabel_1.setBounds(255, 22, 522, 446);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\resources\\dragon.png"));
        lblNewLabel.setBounds(-74, 45, 524, 417);
        contentPane.add(lblNewLabel);

        btnFuir.setIcon(new ImageIcon("src\\resources\\fuir.png"));
        btnFuir.setBounds(-104, 445, 252, 104);
        contentPane.add(btnFuir);

        btnLutter.setIcon(new ImageIcon("src\\resources\\lutter.png"));
        btnLutter.setBounds(475, 445, 252, 104);
        contentPane.add(btnLutter);

        addListeners();
    }

    // Action listeners
    private void addListeners() {
        btnFuir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fuir(personnage, avancementJeu);
            }
        });

        btnLutter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lutter(personnage, avancementJeu);
            }
        });
    }

    private void handleClercClick() {
        int delay = 2000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    btnLutterClerc.doClick();
                });
                updateAvancementJeu();
                ((Timer) evt.getSource()).stop(); // Stop the timer after executing once
            }
        });

        timer.start();
    }

    private void fuir(Personnage personnage, AvancementJeu avancementJeu) {
        personnage.setPointsDeVie(personnage.getPointsDeVie() - 100);
        updateAvancementJeu();
        autoDismissDialog("Vous avez fui, mais le monstre vous a quand même attaqué et vous avez perdu 100 PV.");
        dispose();
    }

    private void lutter(Personnage personnage, AvancementJeu avancementJeu) {
        autoDismissDialog("Vous avez choisi de lutter.");
        int de = jouezDe();
        if ((de % 2) != 0) {
            perdrePv(personnage, avancementJeu);
        } else {
            gagnePv(personnage, avancementJeu);
        }
        dispose();
    }

    private void perdrePv(Personnage personnage, AvancementJeu avancementJeu) {
        personnage.setPointsDeVie(personnage.getPointsDeVie() - 200);
        updateAvancementJeu();
        autoDismissDialog("Le monstre vous avez blessé et vous avez perdu 200 PV.");
    }

    private void gagnePv(Personnage personnage, AvancementJeu avancementJeu) {
        personnage.setPointsDeVie(personnage.getPointsDeVie() + 300);
        updateAvancementJeu();
        autoDismissDialog("Vous avez vaincu le monstre, pris son trésor et gagné 300 PV.");
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

    private static int jouezDe() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenetreCaseCombat(case1, personnage, avancementJeu).setVisible(true);
            }
        });
    }

    private void autoDismissDialog(String message) {
        // Create a JOptionPane
        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        final JDialog dialog = pane.createDialog("Auto-closing Dialog");

        // Set a Timer to close the dialog after 5 seconds (5000 milliseconds)
        Timer timer = new Timer(5000, e -> dialog.dispose());
        timer.setRepeats(false);
        timer.start();

        // Display the dialog
        dialog.setVisible(true);
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image image) {
            this.backgroundImage = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    class CustomButton extends JButton {
        private Color backgroundColor;
        private Color foregroundColor;
        private Font buttonFont;

        public CustomButton(String text, Color background, Color foreground, Font font) {
            super(text);
            this.backgroundColor = background;
            this.foregroundColor = foreground;
            this.buttonFont = font;
            setContentAreaFilled(false);
            setForeground(foregroundColor);
            setFont(buttonFont);
            setFocusPainted(false); // Optional: Removes the focus border when clicked
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For High quality
                                                                                                     // rendering
            if (getModel().isRollover()) {
                g2.setColor(backgroundColor.brighter()); // Make the button color slightly brighter when the mouse is
                                                         // over it
            } else {
                g2.setColor(backgroundColor);
            }
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);

            super.paintComponent(g);
        }
    }
}
