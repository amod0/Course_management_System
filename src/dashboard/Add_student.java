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

public class Add_student {

	private JFrame frame;
	private JTextField textUsername;
	private JTextField textemail;
	private JTextField textPhone;
	private JPasswordField password;
	private JPasswordField confirmpassword;

	/**
	 * Launch the application.
	 */
	public static void add_student() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_student window = new Add_student();
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
	public Add_student() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"COURSES", "BSc(hons)C", "BIBM", "IBMA"}));
		comboBox.setBounds(107, 291, 130, 21);
		layeredPane.add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//using try and catch to connect the mysql 
				try 
				(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
				Statement stmt = con.createStatement();)
				{	
				String s =  "INSERT INTO student VALUES (?,?,?,?,?,?);";
				PreparedStatement pst = con.prepareStatement(s);
//				ResultSet rs = pst.executeQuery();
				
			String Username = textUsername.getText();
			String email = textemail.getText();
			String pw = new String (password.getPassword());
			String conpw = new String (confirmpassword.getPassword());
			String phone = textPhone.getText();
			String v1 = comboBox.getSelectedItem().toString();
					
			pst.setString(1, Username);
			pst.setString(2, email);
			pst.setString(3, pw);
			pst.setString(4, conpw);
			pst.setString(5, phone);
			pst.setString(6, v1);
			
		
//			JOptionPane.showMessageDialog(SignUpB, e);
//				
			//checking if username is empty or not
			if(Username.equals("")){
				JOptionPane.showMessageDialog(textUsername, "invalid username");
				
			}
			
			//checking if email is empty or not
			else if(email.equals("")) {
				JOptionPane.showMessageDialog(textemail, "invalid email");
			}
			
			
			else if(!pw.equals(conpw)){
				//displaying error message
				JOptionPane.showMessageDialog(password,"invalid password");
			}
			
			//checking length of mobile number
			else if (phone.length() != 10) 
			{
				JOptionPane.showMessageDialog(textPhone, "invalid phone no.");
				
			}
			
			else {
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"inserted");
					
//					con.commit();
					con.close();
				}

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
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(10, 52, 86, 14);
		layeredPane.add(lblNewLabel_1);
		
		textUsername = new JTextField();
		textUsername.setBounds(106, 50, 131, 20);
		layeredPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(10, 91, 86, 14);
		layeredPane.add(lblNewLabel_1_1);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(106, 85, 131, 20);
		layeredPane.add(textemail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setBounds(10, 142, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ConfirmPassword");
		lblNewLabel_1_1_1_1.setBounds(10, 194, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("ADD STUDENT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 10, 137, 13);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("PhoneNo.");
		lblNewLabel_1_1_1_1_1.setBounds(10, 244, 86, 14);
		layeredPane.add(lblNewLabel_1_1_1_1_1);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(106, 242, 131, 20);
		layeredPane.add(textPhone);
		
		password = new JPasswordField();
		password.setBounds(106, 140, 131, 19);
		layeredPane.add(password);
		
		confirmpassword = new JPasswordField();
		confirmpassword.setBounds(106, 192, 131, 19);
		layeredPane.add(confirmpassword);
		
	
	}
}