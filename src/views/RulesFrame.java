package src.views;

import java.awt.Color;
import java.awt.FontFormatException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class RulesFrame extends JFrame {

	public RulesFrame() throws FontFormatException, IOException {
		JPanel contentPane;
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 722);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel back = new JLabel("");
		back.setIcon(new ImageIcon(getClass().getResource("/src/resources/back.png")));
		back.setBounds(-80, 623, 232, 64);
		contentPane.add(back);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(getClass().getResource("/src/resources/imgFond.png")));
		bg.setBounds(87, -15, 848, 710);
		contentPane.add(bg);

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