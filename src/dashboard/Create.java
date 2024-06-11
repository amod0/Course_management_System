package dashboard;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Create {

	private JFrame frmCreateAccount;
	private JTextField textUsername;
	private JTextField textemail;
	private JTextField textPhone;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JComboBox Usertype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create window = new Create();
					window.frmCreateAccount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Create() {
		initialize();
		layeredPane();
	}
	
	private void layeredPane() {
		// TODO Auto-generated method stub
		
	}



	
	

		

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmCreateAccount = new JFrame();
		frmCreateAccount.setTitle("Create Account");
		frmCreateAccount.setBounds(100, 100, 543, 389);
		frmCreateAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateAccount.getContentPane().setLayout(null);
		
		JLabel username = new JLabel("User Name:");
		username.setBounds(171, 21, 172, 13);
		frmCreateAccount.getContentPane().add(username);
		
		textUsername = new JTextField();
		textUsername.setBounds(171, 33, 172, 19);
		frmCreateAccount.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(171, 61, 172, 13);
		frmCreateAccount.getContentPane().add(email);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(171, 74, 172, 19);
		frmCreateAccount.getContentPane().add(textemail);
		
		JLabel pw = new JLabel("Password");
		pw.setBounds(171, 103, 172, 13);
		frmCreateAccount.getContentPane().add(pw);
		
		JLabel conpw = new JLabel("Confirm Password:");
		conpw.setBounds(171, 145, 172, 13);
		frmCreateAccount.getContentPane().add(conpw);
		
		JLabel phone = new JLabel("Phone No.:");
		phone.setBounds(171, 187, 172, 13);
		frmCreateAccount.getContentPane().add(phone);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(172, 200, 172, 19);
		frmCreateAccount.getContentPane().add(textPhone);
		
		//combobox2
		JComboBox textUsertype_1 = new JComboBox();
		textUsertype_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textUsertype_1.getSelectedItem().toString();
			}
		});
		textUsertype_1.setModel(new DefaultComboBoxModel(new String[] {"COURSES", "BSc(hons)C", "BIBM", "IBMA"}));
		textUsertype_1.setBounds(171, 290, 172, 21);
		frmCreateAccount.getContentPane().add(textUsertype_1);
		textUsertype_1.setVisible(false);
		//combobox1
		JComboBox textUsertype = new JComboBox();
		textUsertype.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("student")) {
					textUsertype_1.setVisible(true);
				}else {
					textUsertype_1.setVisible(false);
				}
				//
				textUsertype.getSelectedItem().toString();
			}
		});
		
		textUsertype.setModel(new DefaultComboBoxModel(new String[] {"admin", "teacher", "student"}));
		textUsertype.setBounds(171, 245, 172, 21);
		frmCreateAccount.getContentPane().add(textUsertype);
		
		JLabel lblUsertype = new JLabel("User Type:");
		lblUsertype.setBounds(171, 229, 172, 13);
		frmCreateAccount.getContentPane().add(lblUsertype);
		frmCreateAccount.setVisible(true);
		
		JButton SignUpB = new JButton("Sign Up");
		SignUpB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String v = textUsertype.getSelectedItem().toString();
				String v1 = textUsertype_1.getSelectedItem().toString();
				//using if statement in which try catch will run if combobox value is selected student and stores in student database
				
				if (v.equals("student")) {
					try 
					(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
					Statement stmt = con.createStatement();)
					{	
//					String v = textUsertype.getSelectedItem().toString();
					System.out.println(v);
					String s =  "INSERT INTO student VALUES (?,?,?,?,?,?);";
					PreparedStatement pst = con.prepareStatement(s);
//					ResultSet rs = pst.executeQuery();
					
				String Username = textUsername.getText();
				String email = textemail.getText();
				String pw = new String (password.getPassword());
				String conpw = new String (confirmPassword.getPassword());
				String phone = textPhone.getText();

				pst.setString(1, Username);
				pst.setString(2, email);
				pst.setString(3, pw);
				pst.setString(4, conpw);
				pst.setString(5, phone);
				pst.setString(6, v1);
				
			
//				JOptionPane.showMessageDialog(SignUpB, e);
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
						
						SignIn window = new SignIn();
						frmCreateAccount.setVisible(false);
						
//						con.commit();
						con.close();
					}

				}
				
			
			catch (SQLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
//				System.out.println(e1);
			}
				}
				
				if (!v.equals("student")) {
				try 
				(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
				Statement stmt = con.createStatement();)
				{	
//				String v = textUsertype.getSelectedItem().toString();
				System.out.println(v);
				String s =  "INSERT INTO "+v+" VALUES (?,?,?,?,?);";
				PreparedStatement pst = con.prepareStatement(s);
//				ResultSet rs = pst.executeQuery();
				
			String Username = textUsername.getText();
			String email = textemail.getText();
			String pw = new String (password.getPassword());
			String conpw = new String (confirmPassword.getPassword());
			String phone = textPhone.getText();

			pst.setString(1, Username);
			pst.setString(2, email);
			pst.setString(3, pw);
			pst.setString(4, conpw);
			pst.setString(5, phone);
//			pst.setString(6, v);
			
		
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
					
					SignIn window = new SignIn();
					frmCreateAccount.setVisible(false);
					
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
			} 
		});
		SignUpB.setBounds(212, 321, 85, 21);
		frmCreateAccount.getContentPane().add(SignUpB);
		
		password = new JPasswordField();
		password.setBounds(171, 116, 172, 19);
		frmCreateAccount.getContentPane().add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(171, 158, 172, 19);
		frmCreateAccount.getContentPane().add(confirmPassword);
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home_page window = new Home_page();
				frmCreateAccount.setVisible(false);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 10, 48, 13);
		frmCreateAccount.getContentPane().add(lblNewLabel);
		
//		JComboBox textUsertype_1 = new JComboBox();
//		textUsertype_1.setModel(new DefaultComboBoxModel(new String[] {"COURSES", "BSc(hons)C", "BIBM", "IBMA"}));
//		textUsertype_1.setBounds(171, 290, 172, 21);
//		frmCreateAccount.getContentPane().add(textUsertype_1);
		

		frmCreateAccount.setVisible(true);
	}

	protected static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

