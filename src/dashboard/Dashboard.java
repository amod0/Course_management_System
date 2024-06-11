package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Dashboard extends Value{
	
	private CardLayout rightLayout = new CardLayout(0, 0);
	private JFrame frmDashboard;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_4;
//	private JTable table_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frmDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		frmDashboard.setBounds(100, 100, 1009, 620);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frmDashboard.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 176, 562);
		panel_1.setBackground(Color.GRAY);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(196, 11, 789, 562);
		panel.add(mainpanel);
		mainpanel.setLayout(rightLayout);
		
		JButton btnNewButton = new JButton("Courses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//card layout
				rightLayout.show(mainpanel, "name_929307022112000");
			}
		});
		btnNewButton.setBounds(20, 148, 133, 33);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Teachers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightLayout.show(mainpanel, "name_929307029467800");
			}
		});
		btnNewButton_1.setBounds(20, 196, 133, 33);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Students");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightLayout.show(mainpanel, "name_929307036862100");
			}
		});
		btnNewButton_2.setBounds(20, 101, 133, 33);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Courses");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//card layout
				rightLayout.show(mainpanel, "name_929307022112000");
			}
		});
		btnNewButton_1_1.setBounds(20, 148, 133, 33);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("Modules");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightLayout.show(mainpanel,"name_929307044867200");
			}
		});
		btnNewButton_3.setBounds(20, 255, 133, 33);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Home_page q = new Home_page();
			frmDashboard.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(27, 507, 111, 28);
		panel_1.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Course Management");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(20, 10, 143, 33);
		panel_1.add(lblNewLabel);
		
		JLabel lblSystem = new JLabel("System");
		lblSystem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblSystem.setBounds(54, 23, 119, 33);
		panel_1.add(lblSystem);
		
		
		
		JPanel courses = new JPanel(); 
		courses.setBackground(Color.GRAY);
		mainpanel.add(courses, "name_929307022112000");
		courses.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 769, 454);
		courses.add(scrollPane);
		
		// table of course 
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
			
			String[] columnNames = {"Id","Courses","Seats","Years"};
			
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM courses"; 
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model= (DefaultTableModel) table.getModel();

			model.setColumnIdentifiers(columnNames);

			String id,Courses,Seats,Years;
			while(rs.next()) {
				id=rs.getString(1);
				Courses=rs.getString(2);
				Seats=rs.getString(3);
				Years=rs.getString(4);
				String[] row = {id,Courses,Seats,Years};
				model.addRow(row);
			}

			stmt.close();
			con.close();
		} catch ( SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}

		
		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(getUsers());
				if(getUsers().equals("admin")) {
					Add_course a = new Add_course();
					a.add_course();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_5.setBounds(546, 37, 85, 21);
		courses.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Delete");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Delete_Course d=new Delete_Course();
					d.del_course();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_5_1.setBounds(674, 37, 85, 21);
		courses.add(btnNewButton_5_1);
		
		JLabel lblNewLabel_2 = new JLabel("Courses:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(49, 34, 144, 26);
		courses.add(lblNewLabel_2);
		
		JPanel Tutors = new JPanel();
		Tutors.setBackground(Color.GRAY);
		mainpanel.add(Tutors, "name_929307029467800");
		Tutors.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 99, 769, 453);
		Tutors.add(scrollPane_1);
		
		//table of teacher 
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
			
			String[] columnNames = {"User Name","Email","Phone No.:"};
			
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM teacher"; 
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model= (DefaultTableModel) table_1.getModel();

			model.setColumnIdentifiers(columnNames);

			String u,e,p;
			while(rs.next()) {
				u=rs.getString(1);
				e=rs.getString(2);
				p=rs.getString(5);
		
				String[] row = {u,e,p};
				model.addRow(row);
			}

			stmt.close();
			con.close();
		} catch ( SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
		JLabel lblNewLabel_1_2 = new JLabel("Teacher: ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(63, 29, 133, 21);
		Tutors.add(lblNewLabel_1_2);
		
		JButton btnNewButton_8 = new JButton("ADD");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Add_teacher a = new Add_teacher();
					a.add_teacher();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_8.setBounds(518, 31, 85, 21);
		Tutors.add(btnNewButton_8);
		
		JButton btnNewButton_8_1 = new JButton("DELETE");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Delete_teacher d=new Delete_teacher();
					d.del_teacher();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_8_1.setBounds(638, 31, 85, 21);
		Tutors.add(btnNewButton_8_1);
		
		JPanel Students = new JPanel();
		Students.setBackground(Color.GRAY);
		mainpanel.add(Students, "name_929307036862100");
		Students.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 100, 769, 452);
		Students.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		// table of student 
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
			
			String[] columnNames = {"User Name","Email","PhoneNo.:","Courses"};
			
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM student"; 
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model= (DefaultTableModel) table_2.getModel();

			model.setColumnIdentifiers(columnNames);

			String u,v,x,y;
			while(rs.next()) {
				u=rs.getString(1);
				v=rs.getString(2);
				x=rs.getString(5);
				y=rs.getString(6);
				String[] row = {u,v,x,y};
				model.addRow(row);
			}

			stmt.close();
			con.close();
		} catch ( SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
		JLabel lblNewLabel_1 = new JLabel("Student: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(28, 31, 133, 21);
		Students.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("ADD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Add_student a = new Add_student();
					a.add_student();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_6.setBounds(570, 33, 85, 21);
		Students.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("DELETE");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Delete_student d=new Delete_student();
					d.delete_student();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_7.setBounds(677, 33, 85, 21);
		Students.add(btnNewButton_7);
		
		JPanel Moduel = new JPanel();
		Moduel.setBackground(Color.GRAY);
		mainpanel.add(Moduel, "name_929307044867200");
		Moduel.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 92, 769, 460);
		Moduel.add(scrollPane_5);
		
		table_4 = new JTable();
		scrollPane_5.setViewportView(table_4);
		
		// table of module 
				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
					
					String[] columnNames = {"Id","Module Name","Years","Courses"};
					
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM module"; 
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model= (DefaultTableModel) table_4.getModel();

					model.setColumnIdentifiers(columnNames);

					String u,v,x,y;
					while(rs.next()) {
						u=rs.getString(1);
						v=rs.getString(2);
						x=rs.getString(3);
						y=rs.getString(4);
						String[] row = {u,v,x,y};
						model.addRow(row);
					}

					stmt.close();
					con.close();
				} catch ( SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
		
		JLabel lblNewLabel_3 = new JLabel("Moduels");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(36, 31, 144, 19);
		Moduel.add(lblNewLabel_3);
		
		JButton btnNewButton_9 = new JButton("ADD");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Add_module a = new Add_module();
					a.add_module();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_9.setBounds(529, 32, 85, 21);
		Moduel.add(btnNewButton_9);
		
		JButton btnNewButton_9_1 = new JButton("DELETE");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("admin")) {
					Del_module d=new Del_module();
					d.del_module();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_9_1.setBounds(650, 32, 85, 21);
		Moduel.add(btnNewButton_9_1);
		Students.setBackground(Color.GRAY);
		mainpanel.add(Students, "name_929307036862100");
		Students.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_2.setBounds(10, 100, 769, 452);
		Students.add(scrollPane_2);
		
		JButton btnNewButton_10 = new JButton("CREATE REPORT");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUsers().equals("teacher")) {
					report r = new report();
					r.Report();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid user!!");
				}
			}
		});
		btnNewButton_10.setBounds(389, 33, 148, 21);
		Students.add(btnNewButton_10);
		
		JButton btnNewButton_10_1 = new JButton("VIEW PROGRESS");
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_progress v= new View_progress();
				v.progress();
			}
		});
		btnNewButton_10_1.setBounds(217, 33, 148, 21);
		Students.add(btnNewButton_10_1);
	}
		

		// table of modules 
//		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem","root","");
//			
//			String[] columnNames = {"Module Id","Module Name","Years","Course"};
//			
//			Statement stmt = con.createStatement();
//			String sql = "SELECT * FROM module"; 
//			ResultSet rs = stmt.executeQuery(sql);
//			ResultSetMetaData rsmd = rs.getMetaData();
//
//			model.setColumnIdentifiers(columnNames);
//
//			String u,v,x,y;
//			while(rs.next()) {
//				u=rs.getString(1);
//				v=rs.getString(2);
//				x=rs.getString(3);
//				y=rs.getString(4);
//				String[] row = {u,v,x,y};
//				model.addRow(row);
//			}
//
//			stmt.close();
//			con.close();
//		} catch ( SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			}
//	}

	public void DASH() {
		// TODO Auto-generated method stub
		
	}
}