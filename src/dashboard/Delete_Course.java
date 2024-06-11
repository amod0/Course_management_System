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

public class Delete_Course {

	private JFrame frame;
	private JTextField txt_id;

	/**
	 * Launch the application.
	 */
	public static void del_course() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Course window = new Delete_Course();
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
	public Delete_Course() {
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
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
						Statement stmt = conn.createStatement();)
				{	
					String sql =  "DELETE FROM courses WHERE CourseId = (?);";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1,txt_id.getText());
					
					pstmt.executeUpdate();
					
					//opening window
					JOptionPane.showMessageDialog(null,"course deleted");
					conn.close();
					
				}catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setBounds(401, 290, 89, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 75, 86, 14);
		layeredPane.add(lblNewLabel_1);
		
		txt_id = new JTextField();
		txt_id.setBounds(89, 73, 131, 20);
		layeredPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Delete");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 23, 131, 23);
		layeredPane.add(lblNewLabel);
		
	}
}