import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class ReglesDuJeu extends JFrame {
    private JLabel rulesLabel;

    public ReglesDuJeu() {
        setForeground(new Color(128, 0, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1308, 773);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setContentPane(contentPane);
        
        JLabel header = new JLabel("CHOISISSEZ VOS PERSONNAGES");
        header.setFont(new Font("Arial Black", Font.BOLD, 26));
        header.setForeground(new Color(204, 167, 81));

        JLabel deco = new JLabel("");
        deco.setIcon(new ImageIcon("images/deco.png"));

        rulesLabel = new JLabel("", SwingConstants.CENTER);
        rulesLabel.setVerticalAlignment(SwingConstants.TOP);
        rulesLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
        rulesLabel.setText(buildHtmlRules());

        JScrollPane scrollPane = new JScrollPane(rulesLabel);
        scrollPane.setOpaque(true);
        scrollPane.getViewport().setOpaque(true);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);

    }

    private String buildHtmlRules() {
        // Using HTML to allow for basic formatting
        String rulesHtml = "<html><body style='color: rgb(204, 167, 81); text-align: center; background-color: black; padding: 10px;'>"
                +
                "<h1>Règles du Jeu</h1>" +
                "<ul>" +
                "Le jeu doit être joué par trois personnes.<br>" +
                "L'archer peut se déplacer en motif en L, comme le cheval aux échecs.<br>" +
                "La sorcière se déplace en diagonale." +
                "Le guerrier se déplace verticalement et horizontalement, mais pas en diagonale.<br>" +
                "Le jeu se déroule sur un plateau, qui contient des cases chanceuses, des cases malchanceuses et des cases à questions.<br>"
                +
                "Les cases chanceuses vous font gagner des PV. Les cases malchanceuses vous font perdre des PV.<br>"
                +
                "Si la question posée dans une case à question est correcte, vous gagnez des PV. Si elle est fausse, vous perdez des PV.<br>"
                +
                "Si un joueur perd tous ses PV, il perd la partie.<br>" +
                "</ul>" +
                "</body></html>";
        return rulesHtml;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ReglesDuJeu frame = new ReglesDuJeu();
            frame.setVisible(true);
        });
    }
}
