import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel new_game;
	private JLabel game_rules;
	private JLabel exit;
	private static final String NEWGAME_IMAGE_PATH = "images/nv_partie.png";
	private static final String RULES_IMAGE_PATH = "images/rules.png";
	private static final String QUIT_IMAGE_PATH = "images/quitter.png";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MainMenu() {
		setupFrame();
		initComponents();
		layoutComponents();
		addListeners();
	}

	private void setupFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 656);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	private void initComponents() {
		new_game = new JLabel("");
		new_game.setIcon(loadImageIcon(NEWGAME_IMAGE_PATH));

		game_rules = new JLabel("");
		game_rules.setIcon(loadImageIcon(RULES_IMAGE_PATH));

		exit = new JLabel("");
		exit.setIcon(loadImageIcon(QUIT_IMAGE_PATH));
	}

	private void layoutComponents() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap(216, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(new_game, GroupLayout.PREFERRED_SIZE, 508,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(game_rules, GroupLayout.PREFERRED_SIZE, 525,
																GroupLayout.PREFERRED_SIZE))
												.addGap(173))
										.addComponent(exit, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 188,
												GroupLayout.PREFERRED_SIZE))));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(new_game, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(game_rules, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
								.addComponent(exit, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)));
		contentPane.setLayout(gl_contentPane);
	}

	private ImageIcon loadImageIcon(String path) {
		try {
			return new ImageIcon(getClass().getResource(path));
		} catch (Exception e) {
			// Handle the case where the image is not found
			System.err.println("Image not found: " + path);
			return null;
		}
	}

	private void addListeners() {
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); // Exits the program
			}
		});

		new_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navigateToMenuChoix();
			}
		});

		game_rules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navigateToRulesFrame();
			}
		});
	}

	private void navigateToMenuChoix() {
		MenuChoix menuChoice = new MenuChoix();
		setVisible(false);
		menuChoice.setVisible(true);
	}

	private void navigateToRulesFrame() {
		try {
			RulesFrame rulesFrame = new RulesFrame();
			setVisible(false);
			rulesFrame.setVisible(true);
		} catch (FontFormatException | IOException ex) {
			ex.printStackTrace();
		}
	}

}