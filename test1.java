import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test1 {

	private JFrame frame;
	private JTextField textField;
	// unsure if declaring these JPanels here is necessary
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test1 window = new test1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 270, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0)); // <- set LayoutManager for frame
		
		// Create cards for the CardLayout
		// One card is a panel, which holds all the GUI components for a single screen
		// gets included in the CardLayout when you add it to the frame???
		// don't know why final is needed
		final JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_116373023146585");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 48, 89, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 20, 50, 30, 10, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel.setVisible(false); // setVisible is how to control which card is on top
		
		final JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_116637896466647");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		panel_1.setVisible(false);
		
		final JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_116641126801523");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{48, 80, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{120, 22, 43, 25, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		panel_2.setVisible(true);
		
		// Components for each panel. these get assigned to a certain panel via each panel's add() method.
		// buttons that change the displayed screen change state by changing the visibility of all the panels.
		// since only panel is visible at a time, it is possible that each actionListener only needs to change
		// 	two panel: the current one and the next one 
		JButton btnNewButton = new JButton("go to panel_1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				// panel_2.setVisible(false); // consider taking this line out
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnGoToPanel_1 = new JButton("go to panel_2");
		btnGoToPanel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 2;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		GridBagConstraints gbc_btnGoToPanel_1 = new GridBagConstraints();
		gbc_btnGoToPanel_1.gridx = 5;
		gbc_btnGoToPanel_1.gridy = 4;
		panel_1.add(btnGoToPanel_1, gbc_btnGoToPanel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;  // columns that the textfield stretches over
		gbc_textField.gridheight = 2; // rows that ....
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.BOTH; // ctrl directions in which component fills the grid
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(4);
		
		JButton btnGoToPanel = new JButton("go to panel");
		btnGoToPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnGoToPanel = new GridBagConstraints();
		gbc_btnGoToPanel.insets = new Insets(0, 0, 0, 5);
		gbc_btnGoToPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGoToPanel.gridx = 1;
		gbc_btnGoToPanel.gridy = 3;
		panel_2.add(btnGoToPanel, gbc_btnGoToPanel);
	}
}
