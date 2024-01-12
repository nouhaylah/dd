import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RulesFrame extends JFrame {

    public RulesFrame() {
        JPanel contentPane;
        setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 734);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txt1 = new JLabel("Si un joueur perd tous ses PV, il perd la partie.");
		txt1.setForeground(new Color(204, 167, 81));
		txt1.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt1.setBounds(234, 487, 571, 37);
		contentPane.add(txt1);
		
		JLabel txt2 = new JLabel("Les cases chance vous font gagner des PV. Les cases malchance vous en font perdre.");
		txt2.setForeground(new Color(204, 167, 81));
		txt2.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt2.setBounds(10, 424, 1026, 37);
		contentPane.add(txt2);
		
		JLabel txt3 = new JLabel("malchanceuses et des cases à questions.");
		txt3.setForeground(new Color(204, 167, 81));
		txt3.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt3.setBounds(256, 375, 507, 37);
		contentPane.add(txt3);
		
		JLabel txt4 = new JLabel("Le jeu se déroule sur un plateau, qui contient des cases chanceuses, des cases ");
		txt4.setForeground(new Color(204, 167, 81));
		txt4.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt4.setBounds(33, 328, 974, 37);
		contentPane.add(txt4);
		
		JLabel txt5 = new JLabel("Le guerrier se déplace verticalement et horizontalement, mais pas en diagonale.");
		txt5.setForeground(new Color(204, 167, 81));
		txt5.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt5.setBounds(33, 270, 974, 37);
		contentPane.add(txt5);
		
		JLabel txt6 = new JLabel("La sorcière se déplace en diagonale.");
		txt6.setForeground(new Color(204, 167, 81));
		txt6.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt6.setBounds(267, 213, 454, 37);
		contentPane.add(txt6);
		
		JLabel txt7 = new JLabel("L'archer peut se déplacer en motif en L, comme le cheval aux échecs.");
		txt7.setForeground(new Color(204, 167, 81));
		txt7.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt7.setBounds(91, 156, 846, 37);
		contentPane.add(txt7);
		
		JLabel txt8 = new JLabel("Le jeu doit être joué par trois personnes.");
		txt8.setForeground(new Color(204, 167, 81));
		txt8.setFont(new Font("Arial Black", Font.BOLD, 20));
		txt8.setBounds(267, 95, 507, 37);
		contentPane.add(txt8);
		
		JLabel lblRe = new JLabel("REGLES DU JEU");
		lblRe.setForeground(new Color(204, 167, 81));
		lblRe.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblRe.setBounds(362, 21, 359, 37);
		contentPane.add(lblRe);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon("images/bg-rules.jpg"));
		bg.setBounds(0, 10, 1026, 638);
		contentPane.add(bg);
		
		JLabel back = new JLabel("");
		back.setIcon(new ImageIcon("images/back.png"));
		back.setBounds(-80, 623, 232, 64);
		contentPane.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                MainMenu m = new MainMenu();
                m.setVisible(true);
            }
        });
    }

    

    
}