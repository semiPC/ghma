package admin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin_Member_Modify extends JFrame implements ActionListener{

	BufferedImage img = null;

	Admin_Member nn;
	JTextField name,id,birth,address,phoneNum,emailId;
	JPasswordField pw,pw_re;
	JButton finish; 
	JLabel lb;

	String [] arr = {"아  이  디","이        름","비        번","비번확인","생년월일",
			"주        소","연  락  처","이  메  일"};


	public Admin_Member_Modify(Admin_Member nn) { 
	
		this.nn = nn;
		setTitle("회원가입");
		setBounds(400, 50, 400, 600);
		setLayout(null);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		addWindowListener(new WinClose());
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,1000,700);
		layeredPane.setLayout(null);

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1000, 800);


			try {
				img = ImageIO.read(new File("img/join.png"));
			} catch (Exception e) {
				// TODO: handle exception
				//System.exit(0);
			}
		
			for (int i = 0; i < arr.length; i++) {
				lb = new JLabel(arr[i]);
				lb.setBounds(50, 50+45*i, 80, 50);
				lb.setForeground(Color.white);
				layeredPane.add(lb);
			}
			
			id = new JTextField("id값 (고정) ");
			id.setBounds(150, 60, 130, 30);
			id.setOpaque(false); // 투명처리
			id.setForeground(Color.cyan);
			id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(id);
			
			name = new JTextField("입력하세요.");
			name.setBounds(150, 105, 200, 30);
			name.setOpaque(false); // 투명처리
			name.setForeground(Color.cyan);
			name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(name);
			
			pw = new JPasswordField("원래값");
			pw.setBounds(150, 150, 150, 30);
			pw.setOpaque(false); // 투명처리
			pw.setForeground(Color.cyan);
			pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(pw);

			pw_re = new JPasswordField("원래값");
			pw_re.setBounds(150, 195, 150, 30);
			pw_re.setOpaque(false); // 투명처리
			pw_re.setForeground(Color.cyan);
			pw_re.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(pw_re);

			birth = new JTextField("원래값");
			birth.setBounds(150, 240, 150, 30);
			birth.setOpaque(false); // 투명처리
			birth.setForeground(Color.cyan);
			birth.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(birth);

			address = new JTextField("원래값");
			address.setBounds(150, 285, 150, 30);
			address.setOpaque(false); // 투명처리
			address.setForeground(Color.cyan);
			address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(address);

			phoneNum = new JTextField("원래값");
			phoneNum.setBounds(150, 330, 150, 30);
			phoneNum.setOpaque(false);
			phoneNum.setForeground(Color.cyan);
			phoneNum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(phoneNum);

			emailId = new JTextField("원래값");
			emailId.setBounds(150, 375, 150, 30);
			emailId.setOpaque(false);
			emailId.setForeground(Color.cyan);
			emailId.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(emailId);

			finish = new JButton("수정확인");
			finish.setBounds(140, 517, 90, 30);
			finish.setForeground(Color.cyan);
			finish.setContentAreaFilled(false);
			finish.setFocusPainted(false);
			finish.addActionListener(this);
			layeredPane.add(finish);
		
		layeredPane.add(panel);
		add(layeredPane);
		setResizable(false);
		setVisible(true);
	}

	class MyPanel extends JPanel
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(img, 0, 0, null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource().equals(finish)) {
			dispose();
		}
		
	}

	
/*
	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			mm.setEnabled(true);
			dispose();
		}
	}
		
	
	//테스트용 메인 ----
	/*	public static void main(String[] args) {
			// TODO Auto-generated method stub

			new Admin_Member_Modify();
			
		}*/
		
		

	}

