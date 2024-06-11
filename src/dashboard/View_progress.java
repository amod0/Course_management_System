package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.util.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View_progress {

	private JFrame frame;
	protected AbstractButton tblData;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void progress() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_progress window = new View_progress();
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
	public View_progress() {
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
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, "name_35136534484300");
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_3);
		
		JPanel panel_1 = new JPanel();
		splitPane_3.setLeftComponent(panel_1);
		
		JLabel lblNewLabel = new JLabel("REPORT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel_1.add(lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		panel_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		panel_1.add(separator_3);
		
		JLabel lblNewLabel_1 = new JLabel("Report Id of student");
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 
			}
		});
		panel_1.add(textField);
		textField.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		panel_1.add(separator_1);
		
		JSeparator separator = new JSeparator();
		panel_1.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_3.setRightComponent(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//using try and catch to connect the mysql 
				try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");){
					Statement stmt = con.createStatement();
					
					String sql = "SELECT * FROM report WHERE id="+textField.getText()+"";
//					String sql = "SELECT * FROM grade";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						
					String[] columnNames = {"Id","studentname","course","modulename","percentage","GPA"};
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model= (DefaultTableModel) table.getModel();
		
					model.setColumnIdentifiers(columnNames);
					
					String id,stud,course,mod,per,gpa;
						id=rs.getString(1);
						stud=rs.getString(2);
						course=rs.getString(3);
						mod=rs.getString(4);
						per=rs.getString(5);
						gpa=rs.getString(6);
						
						String[] row = {id,stud,course,mod,per,gpa};
						model.addRow(row);
						
						stmt.close();
						con.close();
					}
						
					else {
						JOptionPane.showMessageDialog(null,"record not found");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1);
				}
			}
		});
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
	}
}