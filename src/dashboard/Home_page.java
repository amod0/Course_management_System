package dashboard;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Home_page {

	private JFrame frmHome_page;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page window = new Home_page();
					window.frmHome_page.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome_page = new JFrame();
		frmHome_page.setTitle("Home");
		frmHome_page.setBounds(100, 100, 450, 300);
		frmHome_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome_page.getContentPane().setLayout(null);
		
		JButton CreateButton = new JButton("Create Account");
		CreateButton.setBounds(143, 166, 122, 35);
		frmHome_page.getContentPane().add(CreateButton);
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create window = new Create();
				frmHome_page.setVisible(false);
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Welcome To");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel.setBounds(84, 68, 263, 43);
		frmHome_page.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Management System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(47, 113, 344, 43);
		frmHome_page.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Already Have one,");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(126, 210, 106, 13);
		frmHome_page.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sign In");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn window = new SignIn();
				frmHome_page.setVisible(false);
			}
		});
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(231, 211, 45, 13);
		frmHome_page.getContentPane().add(lblNewLabel_3);
		frmHome_page.setVisible(true);
	}
}
