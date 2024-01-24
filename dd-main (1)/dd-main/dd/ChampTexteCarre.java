import javax.swing.JTextField;
import interfaces.ChampTexte;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ChampTexteCarre extends JTextField implements ChampTexte {
    private static final long serialVersionUID = 1L;

    public ChampTexteCarre() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g2.dispose();
    }

    public void create() {
        setOpaque(false);
    }
}