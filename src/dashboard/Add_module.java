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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Add_module {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_modu;
	private JTextField txt_years;
	private JTextField txt_cour;

	/**
	 * Launch the application.
	 */
	public static void add_module() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_module window = new Add_module();
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
	public Add_module() {
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
				try 
				(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
				Statement stmt = con.createStatement();)
				{	
				String s =  "INSERT INTO module VALUES (?,?,?,?);";
				PreparedStatement pst = con.prepareStatement(s);
//				ResultSet rs = pst.executeQuery();
				
			String id = txt_id.getText();
			String name = txt_modu.getText();
			String year = txt_years.getText();
			String course = txt_cour.getText();
		
			
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, year);
			pst.setString(4, course);
			
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"inserted");
					
//					con.commit();
					con.close();
				}
			
		
		catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
//			System.out.println(e1);
		}
			}
		});
		btnNewButton.setBounds(401, 290, 89, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(10, 52, 86, 14);
		layeredPane.add(lblNewLabel_1);
		
		txt_id = new JTextField();
		txt_id.setBounds(106, 50, 131, 20);
		layeredPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Module Name");
		lblNewLabel_1_1.setBounds(10, 91, 86, 14);
		layeredPane.add(lblNewLabel_1_1);
		
		txt_modu = new JTextField();
		txt_modu.setColumns(10);
		txt_modu.setBounds(106, 85, 131, 20);
		layeredPane.add(txt_modu);
		
		JLabel lblNewLabel = new JLabel("ADD MODULE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 10, 137, 13);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Years");
		lblNewLabel_1_1_1_1_1.setBounds(10, 131, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1_1_1);
		
		txt_years = new JTextField();
		txt_years.setColumns(10);
		txt_years.setBounds(106, 129, 131, 20);
		layeredPane.add(txt_years);
		
		txt_cour = new JTextField();
		txt_cour.setColumns(10);
		txt_cour.setBounds(106, 177, 131, 20);
		layeredPane.add(txt_cour);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Courses");
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 180, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1);
		
	
	}
}