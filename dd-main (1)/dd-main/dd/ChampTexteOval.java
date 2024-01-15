import javax.swing.JTextField;

import interfaces.ChampTexte;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ChampTexteOval extends JTextField implements ChampTexte {
    private static final long serialVersionUID = 1L;
    private int rayon;
    private static final Color TEXTBOX_FOREGROUND_COLOR = Color.BLACK;
    private static final Font TEXTBOX_FONT = new Font("Arial Black", Font.BOLD, 14);
    private static final Color TEXTBOX_BACKGROUND_COLOR = new Color(204, 167, 81);

    // classe pour aider avec les styles des textfields (arrondis) dans le menu de
    // choix de personnages
    public ChampTexteOval(int rayon) {
        super();
        this.rayon = rayon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, rayon, rayon);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, rayon, rayon);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        RoundRectangle2D rectangleArrondi = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, rayon,
                rayon);
        return rectangleArrondi.contains(x, y);
    }

    @Override
    public void create() {
        setOpaque(false); // As we paint our own background
        setColumns(10);
        setBackground(TEXTBOX_BACKGROUND_COLOR);
        setForeground(TEXTBOX_FOREGROUND_COLOR);
        setHorizontalAlignment(JTextField.CENTER);
        setFont(TEXTBOX_FONT);
    }
}