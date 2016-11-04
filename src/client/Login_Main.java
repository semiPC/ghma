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
import java.util.Vector;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_Main extends JFrame implements ActionListener{

	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt, gaip, idRe, passRe;
	boolean chk;

	JFrame ff = new JFrame("ȸ������");

	JTextField name,id,birth,address,phoneNum,emailId,reply;
	JButton id_hwakIn;
	JPasswordField pw,pw_re;
	JButton finish; // ���ԿϷ�
	Vector<String> que;
	JLabel lb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login_Main();
	}

	public Login_Main() { 
		// TODO Auto-generated constructor stub
		setTitle("�α���");
		setBounds(0, 0, 1000, 700);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		try {
			img = ImageIO.read(new File("img/example_bg.png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(0);
		}

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,1000,700);
		layeredPane.setLayout(null);

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1000, 800);

		loginTextField = new JTextField(15);
		loginTextField.setBounds(420, 370, 200, 60);
		loginTextField.setFont(new Font("����", Font.BOLD, 20));
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.yellow);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(loginTextField);

		passwordField = new JPasswordField(15);
		passwordField.setBounds(420, 440, 200, 60);
		passwordField.setFont(new Font("����", Font.BOLD, 20));
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.yellow);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);

		bt = new JButton(new ImageIcon("img/login_enter.png"));
		bt.setBounds(630, 370, 130, 50);

		gaip = new JButton(new ImageIcon("img/login_join.png"));
		gaip.setBounds(630,440,130,50);
		gaip.setForeground(Color.white);

		idRe = new JButton(new ImageIcon("img/login_ids.png"));
		idRe.setBounds(410, 530, 130, 50);
		idRe.setForeground(Color.white);

		passRe = new JButton(new ImageIcon("img/login_pws.png")); 
		passRe.setBounds(580, 530, 130, 50);
		passRe.setForeground(Color.white);

		gaip.addActionListener(this);
		idRe.addActionListener(this);
		bt.addActionListener(this);
		passRe.addActionListener(this);

		bt.setContentAreaFilled(false);

		gaip.setFocusPainted(false);
		gaip.setContentAreaFilled(false);

		idRe.setFocusPainted(false);
		idRe.setContentAreaFilled(false);

		passRe.setFocusPainted(false);
		passRe.setContentAreaFilled(false);

		layeredPane.add(bt);
		layeredPane.add(gaip);
		layeredPane.add(idRe);
		layeredPane.add(passRe);
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

		if(e.getSource().equals(gaip)) {
			new Login_Join();   
			setEnabled(false);
		}
		else if(e.getSource().equals(bt))
			new Play_Main(this);

		else if(e.getSource().equals(idRe)) {
			new Login_IDfind(this);
			setEnabled(false);
		}
		else if(e.getSource().equals(passRe)) {
			new Login_PWfind(this);
			setEnabled(false);
		}
	}

	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			setEnabled(true);
			e.getWindow().dispose();
		}
	}

	class Login_Join implements ActionListener
	{
		BufferedImage img = null;

		String [] arr = {"��        ��","��  ��  ��","��        ��","���Ȯ��","�������",
				"��        ��","��  ��  ó","��  ��  ��","��        ��","��        ��"};

		public Login_Join()
		{
			ff.setTitle("ȸ������");
			ff.setBounds(400, 50, 400, 600);
			ff.setLayout(null);
			ff.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			ff.addWindowListener(new WinClose());

			try {
				img = ImageIO.read(new File("img/join.png"));
			} catch (Exception e) {
				// TODO: handle exception
				System.exit(0);
			}

			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(0,0,400,600);
			layeredPane.setLayout(null);

			MyPanel panel = new MyPanel();
			panel.setBounds(0, 0, 400, 600);

			for (int i = 0; i < arr.length; i++) {
				lb = new JLabel(arr[i]);
				lb.setBounds(50, 50+45*i, 80, 50);
				lb.setForeground(Color.white);
				layeredPane.add(lb);
			}

			name = new JTextField("�Է��ϼ���.");
			name.setBounds(150, 60, 200, 30);
			name.setOpaque(false); // ����ó��
			name.setForeground(Color.cyan);
			name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(name);
			name.addActionListener(this);

			id = new JTextField("�Է��ϼ���.");
			id.setBounds(150, 105, 130, 30);
			id.setOpaque(false); // ����ó��
			id.setForeground(Color.cyan);
			id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(id);

			id_hwakIn = new JButton("�ߺ�Ȯ��");
			id_hwakIn.setBounds(280, 105, 90, 30);
			id_hwakIn.setForeground(Color.cyan);
			id_hwakIn.setContentAreaFilled(false);
			id_hwakIn.setFocusPainted(false);
			layeredPane.add(id_hwakIn);
			id_hwakIn.addActionListener(this);

			pw = new JPasswordField("�Է��ϼ���.");
			pw.setBounds(150, 150, 150, 30);
			pw.setOpaque(false); // ����ó��
			pw.setForeground(Color.cyan);
			pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(pw);

			pw_re = new JPasswordField("�Է��ϼ���.");
			pw_re.setBounds(150, 195, 150, 30);
			pw_re.setOpaque(false); // ����ó��
			pw_re.setForeground(Color.cyan);
			pw_re.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(pw_re);

			birth = new JTextField("�Է��ϼ���.");
			birth.setBounds(150, 240, 150, 30);
			birth.setOpaque(false); // ����ó��
			birth.setForeground(Color.cyan);
			birth.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(birth);

			address = new JTextField("�Է��ϼ���.");
			address.setBounds(150, 285, 150, 30);
			address.setOpaque(false); // ����ó��
			address.setForeground(Color.cyan);
			address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(address);

			phoneNum = new JTextField("�Է��ϼ���.");
			phoneNum.setBounds(150, 330, 150, 30);
			phoneNum.setOpaque(false);
			phoneNum.setForeground(Color.cyan);
			phoneNum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(phoneNum);

			emailId = new JTextField("�Է��ϼ���.");
			emailId.setBounds(150, 375, 150, 30);
			emailId.setOpaque(false);
			emailId.setForeground(Color.cyan);
			emailId.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(emailId);

			que = new Vector<>();
			que.add("����� ������ �����Դϱ�?");
			que.add("����� ���� 1ȣ��?");
			que.add("��Ӵ� ������ ��� �ǽʴϱ�?");
			que.add("���� �߾￡ ���� ��Ҵ�?");
			que.add("���� �����ϴ� ���ڴ�?");
			que.add("�����ϴ� ������?");

			JComboBox que_adress = new JComboBox<>(que);
			que_adress.setBounds(150, 420, 190, 30);
			layeredPane.add(que_adress);

			reply = new JTextField("�Է��ϼ���."); // 15 ���ڱ����� ���� �� �նǷ�
			reply.setBounds(150, 465, 150, 30);
			reply.setOpaque(false); // ����ó��
			reply.setForeground(Color.cyan);
			reply.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(reply);

			finish = new JButton("���ԿϷ�");
			finish.setBounds(140, 517, 90, 30);
			finish.setForeground(Color.cyan);
			finish.setContentAreaFilled(false);
			finish.setFocusPainted(false);
			layeredPane.add(finish);

			finish.addActionListener(this);

			layeredPane.add(panel);
			ff.add(layeredPane);
			ff.setResizable(false);
			ff.setVisible(true);
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
			
			if (e.getSource().equals(name))
				System.out.println("Qwd");

			if ( e.getSource().equals(id_hwakIn) );

			if ( e.getSource().equals(finish) )
			{
				chk = false;
				chk();
				if (chk) {
					setEnabled(true);
					ff.dispose();
					ff.setVisible(false);
				}
			}
		}

		void chk()
		{ 	// �̸�, id, pw, (pwchk), ����, (�ּ�), ����, ����
			int cnt=0;
			chk=true;

			String [] arr = {
					"[��-�R]*",
					"[a-zA-Z]*+[0-9]{6,15}",
					"[a-zA-Z0-9!@#$%^&*]{8,20}",
					"[0-9]{6}",
					"[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}",
					"[0-9a-zA-Z]{3,}@[0-9a-zA-Z_]{2,}[.][0-9a-zA-Z]{3,}" };

			String [] errmsg = {
					"�̸��� ��Ȯ�� �Է����ּ���.",
					"id�� �ٽ� Ȯ�����ּ���.",
					"�н����带 �ٽ� Ȯ�����ּ���.",
					"��������� ��Ȯ�� �Է����ּ���.",
					"����ó�� ��Ȯ�� �Է����ּ���.",
					"email�� ��Ȯ�� �Է����ּ���."
					 };

			// �̸�, ���̵�, �ߺ�Ȯ��, ���, ���Ȯ��, ����, �ּ�, ����ó, �̸���, ����, �亯
			
			if (! Pattern.matches(arr[5], emailId.getText())) {
				chk=false;
				cnt=5;
			}
			if (!Pattern.matches(arr[4], phoneNum.getText())) {
				chk=false;
				cnt=4;
			}
			if (!Pattern.matches(arr[3], birth.getText())) {
				chk=false;
				cnt=3;
			}
			if (!Pattern.matches(arr[2], pw.getText())) {
				chk=false;
				cnt=2;
			}
			if (!Pattern.matches(arr[1], id.getText())) {
				chk=false;
				cnt=1;
			}
			if (!Pattern.matches(arr[0], name.getText())) {
				chk=false;
				cnt=0;
			}

			JOptionPane.showMessageDialog(null, errmsg[cnt]);

		}
	}
}