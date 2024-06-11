package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_course {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_seats;
	private JTextField txt_years;

	/**
	 * Launch the application.
	 */
	public static void add_course() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_course window = new Add_course();
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
	public Add_course() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//using try and catch to connect the mysql 
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
						Statement stmt = conn.createStatement();)
				{	
					String sql =  "INSERT INTO courses VALUES (?,?,?,?);";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1,txt_id.getText());
					pstmt.setString(2,txt_name.getText());
					pstmt.setString(3,txt_seats.getText());
					pstmt.setString(4,txt_years.getText());
					
					
					pstmt.executeUpdate();
					
					//opening window
					JOptionPane.showMessageDialog(null,"Added");
					conn.commit();
					conn.close();
					
				}catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(401, 290, 89, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 52, 86, 14);
		layeredPane.add(lblNewLabel_1);
		
		txt_id = new JTextField();
		txt_id.setBounds(106, 50, 131, 20);
		layeredPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course Name");
		lblNewLabel_1_1.setBounds(10, 91, 86, 14);
		layeredPane.add(lblNewLabel_1_1);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(106, 85, 131, 20);
		layeredPane.add(txt_name);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Seats");
		lblNewLabel_1_1_1.setBounds(10, 142, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1);
		
		txt_seats = new JTextField();
		txt_seats.setColumns(10);
		txt_seats.setBounds(106, 140, 131, 20);
		layeredPane.add(txt_seats);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Years");
		lblNewLabel_1_1_1_1.setBounds(10, 194, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1_1);
		
		txt_years = new JTextField();
		txt_years.setColumns(10);
		txt_years.setBounds(106, 192, 131, 20);
		layeredPane.add(txt_years);
		
		JLabel lblNewLabel = new JLabel("ADD COURSE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 10, 137, 13);
		layeredPane.add(lblNewLabel);
	
	}
}