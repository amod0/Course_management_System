package dashboard;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignIn extends Value {

	private JFrame frmSignIn;
	private JTextField textUsername;
	private JPasswordField password;
	protected Object rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frmSignIn.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignIn = new JFrame();
		frmSignIn.setTitle("Sign In");
		frmSignIn.setBounds(300, 350, 450, 300);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUsers(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"admin", "teacher", "student"}));
		comboBox.setBounds(128, 173, 167, 21);
		frmSignIn.getContentPane().add(comboBox);
		
		
		JLabel txtSignIn = new JLabel("Sign In");
		txtSignIn.setBounds(171, 10, 65, 35);
		txtSignIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textUsername = new JTextField();
		textUsername.setBounds(128, 72, 167, 19);
		textUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String v =comboBox.getSelectedItem().toString();
				
				if(v.equals("admin")) {
					try 
					(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
					Statement pst = con.createStatement();)
					{
						String txtUserName = textUsername.getText();
						String Password = new String (password.getPassword());
						String textUsertype = comboBox.getSelectedItem().toString();
						String sql="SELECT *FROM admin WHERE UserName='"+txtUserName+"' && Password = '"+Password+"'";
						
						ResultSet rs = pst.executeQuery(sql);
						if(rs.next()){
							JOptionPane.showMessageDialog(null, "login");
							Dashboard window = new Dashboard();
							frmSignIn.setVisible(false);
							
						}else {
							JOptionPane.showMessageDialog(null,"Username or Password is invalid");
							}
						
					}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
					System.out.println(e1);
				}
				}
				
				else if(v.equals("teacher"))
				{
					try 
					(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
					Statement pst = con.createStatement();)
					{
						String txtUserName = textUsername.getText();
						String Password = new String (password.getPassword());
						String textUsertype = comboBox.getSelectedItem().toString();
						String sql="SELECT *FROM teacher WHERE UserName='"+txtUserName+"' && Password = '"+Password+"'";
						
						ResultSet rs = pst.executeQuery(sql);
						if(rs.next()){
							JOptionPane.showMessageDialog(null, "login");
							Dashboard window = new Dashboard();
							frmSignIn.setVisible(false);
							
						}else {
							JOptionPane.showMessageDialog(null,"Username or Password is invalid");
							}
						
					}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
					System.out.println(e1);
				}
			}
				else {
					try 
					(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
					Statement pst = con.createStatement();)
					{
						String txtUserName = textUsername.getText();
						String Password = new String (password.getPassword());
						String textUsertype = comboBox.getSelectedItem().toString();
						String sql="SELECT *FROM student WHERE UserName='"+txtUserName+"' && Password = '"+Password+"'";
						
						ResultSet rs = pst.executeQuery(sql);
						if(rs.next()){
							JOptionPane.showMessageDialog(null, "login");
							Dashboard window = new Dashboard();
							frmSignIn.setVisible(false);
							
						}else {
							JOptionPane.showMessageDialog(null,"Username or Password is invalid");
							}
						
					}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
					System.out.println(e1);
				}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(171, 209, 85, 21);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(171, 51, 89, 15);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(171, 101, 69, 15);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmSignIn.getContentPane().setLayout(null);
		
		password = new JPasswordField();
		password.setBounds(128, 120, 167, 19);
		frmSignIn.getContentPane().add(password);
		frmSignIn.getContentPane().add(lblUsername);
		frmSignIn.getContentPane().add(txtSignIn);
		frmSignIn.getContentPane().add(textUsername);
		frmSignIn.getContentPane().add(lblPassword);
		frmSignIn.getContentPane().add(btnNewButton);
		
		
		
		JLabel lblUsertype = new JLabel("User Type:");
		lblUsertype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsertype.setBounds(171, 150, 89, 13);
		frmSignIn.getContentPane().add(lblUsertype);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home_page window = new Home_page();
				frmSignIn.setVisible(false);
			}
		});
		lblBack.setBounds(10, 10, 45, 13);
		frmSignIn.getContentPane().add(lblBack);
		

		frmSignIn.setVisible(true);
	}

		
	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		// TODO Auto-generated method stub
	
	}
}
		
