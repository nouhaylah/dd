
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Archer;
import models.Guerrier;
import models.Sorcier;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuChoix extends JFrame{
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel archere;
	private JLabel sorciere;
	private JLabel guerrier;
	private JTextField archere_textbox;
	private JTextField sorciere_textbox;
	private JTextField guerrie_textBox;
	private JLabel header;
	private JLabel deco;
	private JLabel next;

	private String archere_name;
	private String sorciere_name;
	private String guerrier_name;

	
	public MenuChoix() {
		setForeground(new Color(128, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 773);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		
		archere = new JLabel("");
		archere.setIcon(new ImageIcon("images/archere.png"));
		
		sorciere = new JLabel("");
		sorciere.setIcon(new ImageIcon("images/sorciere.png"));
		
		guerrier = new JLabel("");
		guerrier.setIcon(new ImageIcon("images/guerrier.png"));
		
		archere_textbox = new JTextField();
		archere_textbox.setColumns(10);
		
		sorciere_textbox = new JTextField();
		sorciere_textbox.setColumns(10);
		
		guerrie_textBox = new JTextField();
		guerrie_textBox.setColumns(10);
		
		header = new JLabel("CHOISISSEZ VOS PERSONNAGES");
		header.setFont(new Font("Arial Black", Font.BOLD, 26));
		header.setForeground(new Color(204, 167, 81));
		
		deco = new JLabel("");
		deco.setIcon(new ImageIcon("images/deco.png"));
		
		next = new JLabel("");
		next.setIcon(new ImageIcon("images/next.png"));
		
		JLabel deco_1 = new JLabel("");
		deco_1.setIcon(new ImageIcon("images/deco.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(369, Short.MAX_VALUE)
					.addComponent(deco_1, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(next, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(397, Short.MAX_VALUE)
					.addComponent(header, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)
					.addGap(365))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(329)
					.addComponent(deco)
					.addContainerGap(330, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(archere, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
							.addGap(154))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addComponent(archere_textbox, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addGap(162)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(sorciere_textbox)
						.addComponent(sorciere, GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(guerrier, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(189)
							.addComponent(guerrie_textBox, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(header)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(deco, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(sorciere)
								.addComponent(archere, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(archere_textbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sorciere_textbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(guerrie_textBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(guerrier, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(deco_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(next, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
		
		next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				Archer archer = Archer.getInstance(archere_textbox.getText());
				Sorcier sorcier = Sorcier.getInstance(sorciere_textbox.getText());
				Guerrier guerrier = Guerrier.getInstance(guerrie_textBox.getText());
				FenetreJeu f = new FenetreJeu(archer, sorcier, guerrier);
				setVisible(false);
				f.setVisible(true);
			}
        });
	}

	public String getArchere_name() {
		return archere_name;
	}

	public String getSorciere_name() {
		return sorciere_name;
	}

	public String getGuerrier_name() {
		return guerrier_name;
	}
}
