import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Sx implements ItemListener {
	int id;
	JFrame jf;
	JPanel jpn;
	JRadioButton jrb1, jrb2, jrb3, jrb4, jrb5, jrb6, jrb7, jrb8, jrb9, jrb10, jrb11, jrb12;
	ButtonGroup btg;
	JTabbedPane jtp;
	JTextArea jta1, jta2, jta3, jta4, jta5;
	Font ft;

	public Sx() {
		jpn = new JPanel();
		btg = new ButtonGroup();
		jrb1 = new JRadioButton(new ImageIcon("res/shu.png"));
		jrb1.addItemListener(this);
		jpn.add(jrb1);
		btg.add(jrb1);
		jrb2 = new JRadioButton(new ImageIcon("res/niu.png"));
		jrb2.addItemListener(this);
		jpn.add(jrb2);
		btg.add(jrb2);
		jrb3 = new JRadioButton(new ImageIcon("res/hu.png"));
		jrb3.addItemListener(this);
		jpn.add(jrb3);
		btg.add(jrb3);
		jrb4 = new JRadioButton(new ImageIcon("res/tu.png"));
		jrb4.addItemListener(this);
		jpn.add(jrb4);
		btg.add(jrb4);
		jrb5 = new JRadioButton(new ImageIcon("res/long.png"));
		jrb5.addItemListener(this);
		jpn.add(jrb5);
		btg.add(jrb5);
		jrb6 = new JRadioButton(new ImageIcon("res/she.png"));
		jrb6.addItemListener(this);
		jpn.add(jrb6);
		btg.add(jrb6);
		jrb7 = new JRadioButton(new ImageIcon("res/ma.png"));
		jrb7.addItemListener(this);
		jpn.add(jrb7);
		btg.add(jrb7);
		jrb8 = new JRadioButton(new ImageIcon("res/yang.png"));
		jrb8.addItemListener(this);
		jpn.add(jrb8);
		btg.add(jrb8);
		jrb9 = new JRadioButton(new ImageIcon("res/hou.png"));
		jrb9.addItemListener(this);
		jpn.add(jrb9);
		btg.add(jrb9);
		jrb10 = new JRadioButton(new ImageIcon("res/ji.png"));
		jrb10.addItemListener(this);
		jpn.add(jrb10);
		btg.add(jrb10);
		jrb11 = new JRadioButton(new ImageIcon("res/gou.png"));
		jrb11.addItemListener(this);
		jpn.add(jrb11);
		btg.add(jrb11);
		jrb12 = new JRadioButton(new ImageIcon("res/zhu.png"));
		jrb12.addItemListener(this);
		jpn.add(jrb12);
		btg.add(jrb12);
		jtp = new JTabbedPane();
		ft = new Font("微软雅黑", 1, 20);
		jta1 = new JTextArea();
		jta1.setLineWrap(true);
		jta1.setFont(ft);
		jtp.addTab("运程综述", jta1);
		jta2 = new JTextArea();
		jta2.setLineWrap(true);
		jta2.setFont(ft);
		jtp.addTab("事业运程", jta2);
		jta3 = new JTextArea();
		jta3.setLineWrap(true);
		jta3.setFont(ft);
		jtp.addTab("感情运程", jta3);
		jta4 = new JTextArea();
		jta4.setLineWrap(true);
		jta4.setFont(ft);
		jtp.addTab("健康运程", jta4);
		jta5 = new JTextArea();
		jta5.setLineWrap(true);
		jta5.setFont(ft);
		jtp.addTab("财运运程", jta5);
		jf = new JFrame("星座运程");
		jf.add(jpn, BorderLayout.NORTH);
		jf.add(jtp, BorderLayout.CENTER);
		jf.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 400,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 300, 800, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	public void getData() {
		Connection cnt;
		Statement stm;
		ResultSet rss;
		try {
			Class.forName("org.sqlite.JDBC");
			cnt = DriverManager.getConnection("jdbc:sqlite:sql/database.db");
			stm = cnt.createStatement();
			rss = stm.executeQuery("SELECT * FROM sx WHERE id==" + id + ";");
			jta1.setText(rss.getString("zh"));
			jta2.setText(rss.getString("sy"));
			jta3.setText(rss.getString("gq"));
			jta4.setText(rss.getString("jk"));
			jta5.setText(rss.getString("cy"));
			rss.close();
			stm.close();
			cnt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == jrb1) {
			id = 1;
		} else if (e.getSource() == jrb2) {
			id = 2;
		} else if (e.getSource() == jrb3) {
			id = 3;
		} else if (e.getSource() == jrb4) {
			id = 4;
		} else if (e.getSource() == jrb5) {
			id = 5;
		} else if (e.getSource() == jrb6) {
			id = 6;
		} else if (e.getSource() == jrb7) {
			id = 7;
		} else if (e.getSource() == jrb8) {
			id = 8;
		} else if (e.getSource() == jrb9) {
			id = 9;
		} else if (e.getSource() == jrb10) {
			id = 10;
		} else if (e.getSource() == jrb11) {
			id = 11;
		} else if (e.getSource() == jrb12) {
			id = 12;
		}
		getData();
	}

	public static void main(String[] args) {
		new Sx();
	}
}
