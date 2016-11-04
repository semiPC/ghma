package admin;

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

public class Admin_Reg extends JFrame implements ActionListener{

	BufferedImage img = null;

	Admin_Main mm;
	JTextField name,id,birth,address,phoneNum,emailId,reply;
	JButton id_hwakIn;
	JPasswordField pw,pw_re;
	JButton finish; // ���ԿϷ�
	Vector<String> que;
	JLabel lb;

	String [] arr = {"��        ��","��  ��  ��","��        ��","���Ȯ��","�������",
			"��        ��","��  ��  ó","��  ��  ��","��        ��","��        ��"};


	public Admin_Reg(Admin_Main mm) { 
	
		
		setTitle("ȸ������");
		setBounds(680, 150, 400, 600);
		setLayout(null);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WinClose());
		
		
		 this.mm = mm;
		
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

			name = new JTextField("�Է��ϼ���.");
			name.setBounds(150, 60, 200, 30);
			name.setOpaque(false); // ����ó��
			name.setForeground(Color.cyan);
			name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(name);

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

	

	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			mm.setEnabled(true);
			dispose();
		}
	}

	

	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "                              ���� �Ϸ�!!!!","���� ���" ,JOptionPane.PLAIN_MESSAGE);
			mm.setEnabled(true);
			dispose();
			//setVisible(false);
		}
		
		

	}

