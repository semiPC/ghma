package client;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import admin.Admin_Main;
//import admin.Manager_Member.MaPanel;

public class Login_IDfind extends JFrame implements ActionListener{

	BufferedImage img = null;

	MaPanel panel;
	JLayeredPane lp;
	JTextField name,ponnum;
	JButton idf;
	JLabel id_chk,lb;
	Login_Main lf;
	String [] arr = {"이    름","이메일","아이디"};

	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			lf.setEnabled(true);
			e.getWindow().dispose();
		}
	}

	public Login_IDfind(Login_Main lf) {
		// TODO Auto-generated constructor stub

		setTitle("ID 찾기");
		setBounds(100, 200, 430, 450);
		setLayout(null);
		addWindowListener(new WinClose());
		this.lf = lf;

		try {
			img = ImageIO.read(new File("img/id.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panel = new MaPanel();
		panel.setBounds(0, 0, 430, 450);
		add(panel);

		lp =  new JLayeredPane();
		lp.setBounds(0, 0, 430, 450);
		lp.setLayout(null);

		for (int i = 0; i < arr.length; i++) {
			lb = new JLabel(arr[i]);
			lb.setBounds(80, 80+70*i, 50, 50);
			lb.setForeground(Color.white);
			lp.add(lb);
		}

		name = new JTextField("입력하세요.");
		name.setBounds(150, 85, 150, 40);
		name.setOpaque(false);
		name.setForeground(Color.CYAN);
		name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lp.add(name);

		ponnum = new JTextField("입력하세요.");
		ponnum.setBounds(150, 155, 150, 40);
		ponnum.setOpaque(false);
		ponnum.setForeground(Color.CYAN);
		ponnum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lp.add(ponnum);

		idf = new JButton("ID찾기");
		idf.setBounds(319, 110, 78, 55);
		idf.setForeground(Color.cyan);
		idf.setContentAreaFilled(false);
		idf.setFocusPainted(false);
		lp.add(idf);

		JLabel lb4 = new JLabel("[  gamso3  ]  입니다 !!");
		lb4.setBounds(160, 220, 150, 50);
		lb4.setForeground(Color.white);
		lp.add(lb4);

		JButton bt = new JButton("확인");
		bt.setBounds(180, 340, 60, 40);
		bt.setForeground(Color.cyan);
		bt.setContentAreaFilled(false);
		bt.setFocusPainted(false);
		lp.add(bt);

		lp.add(panel);
		add(lp);

		setResizable(false);
		idf.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		lf.setEnabled(true);
		dispose();
	}

	class MaPanel extends JPanel
	{
		public void paint(Graphics g){
			g.drawImage(img, 0, 0, null);
		}
	}
}