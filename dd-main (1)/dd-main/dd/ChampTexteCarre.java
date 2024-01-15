import javax.swing.JTextField;

import interfaces.ChampTexte;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ChampTexteCarre extends JTextField implements ChampTexte {
    private static final long serialVersionUID = 1L;
    private int rayon = 0;

    // classe pour aider avec les styles des textfields (arrondis) dans le menu de
    // choix de personnages
    public ChampTexteCarre() {
        super();
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
    }
}