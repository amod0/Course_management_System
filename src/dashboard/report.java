package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class report {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_stud;
	private JTextField txt_mod;
	private JTextField txt_percent;
	private JTextField txt_gpa;
	private JTextField txt_course;

	/**
	 * Launch the application.
	 */
	public static void Report() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report window = new report();
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
	public report() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "name_34477608305000");
		
		JLabel lblNewLabel = new JLabel("REPORT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 10, 110, 17);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID");
		lblNewLabel_1.setBounds(10, 48, 132, 14);
		layeredPane.add(lblNewLabel_1);
		
		txt_id = new JTextField();
		txt_id.setBounds(10, 73, 140, 17);
		layeredPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Student Name");
		lblNewLabel_1_1.setBounds(10, 101, 132, 14);
		layeredPane.add(lblNewLabel_1_1);
		
		txt_stud = new JTextField();
		txt_stud.setColumns(10);
		txt_stud.setBounds(10, 122, 140, 17);
		layeredPane.add(txt_stud);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Module Name");
		lblNewLabel_1_1_1.setBounds(238, 48, 132, 14);
		layeredPane.add(lblNewLabel_1_1_1);
		
		txt_mod = new JTextField();
		txt_mod.setColumns(10);
		txt_mod.setBounds(238, 72, 140, 17);
		layeredPane.add(txt_mod);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Enter total percentage(%)");
		lblNewLabel_1_1_2.setBounds(237, 150, 154, 14);
		layeredPane.add(lblNewLabel_1_1_2);
		
		txt_percent = new JTextField();
		txt_percent.setColumns(10);
		txt_percent.setBounds(238, 174, 140, 17);
		layeredPane.add(txt_percent);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Enter GPA");
		lblNewLabel_1_1_2_1.setBounds(10, 150, 154, 14);
		layeredPane.add(lblNewLabel_1_1_2_1);
		
		txt_gpa = new JTextField();
		txt_gpa.setColumns(10);
		txt_gpa.setBounds(10, 174, 140, 17);
		layeredPane.add(txt_gpa);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//using try and catch to connect the mysql 
				try 
				(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");)
				{
									String sql =  "INSERT INTO report VALUES (?,?,?,?,?,?);";
									PreparedStatement pstmt = conn.prepareStatement(sql);
									
									//using 'get' to get the values
									//using 'set' to insert the values
									
									pstmt.setString(1,txt_id.getText());
									pstmt.setString(2,txt_stud.getText());
									pstmt.setString(3,txt_course.getText());
									pstmt.setString(4,txt_mod.getText());
									pstmt.setString(5,txt_gpa.getText());
									pstmt.setString(6,txt_percent.getText());
									
									pstmt.executeUpdate();
									
									JOptionPane.showMessageDialog(null,"DONE!!");
									conn.commit();
									conn.close();
								}
								catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Enter Course Name");
		lblNewLabel_1_1_3.setBounds(238, 101, 132, 14);
		layeredPane.add(lblNewLabel_1_1_3);
		
		txt_course = new JTextField();
		txt_course.setColumns(10);
		txt_course.setBounds(238, 121, 140, 17);
		layeredPane.add(txt_course);
	}
}