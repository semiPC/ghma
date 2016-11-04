package admin;

import java.awt.BorderLayout;

//��ȣ, �̸�, ���, �� ��� �ð�, ������ 

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

//import admin.Manager_IdFine.MaPanel;

public class Admin_Pc extends JFrame implements ActionListener {

	Admin_Main mm;

	BufferedImage img = null;

	MaPanel panel;
	JPanel com_pane;
	JLayeredPane lp;
	JButton member;
	JButton staff;
	JButton stock;
	JButton sales;
	JButton admin_logout;
	JButton chat;
	JButton user_logout;
	JButton pause;
	JButton move;
	JButton refund;
	JLabel com_num;
	JLabel com_num1;
	JLabel start_time;
	JLabel start_time_1;
	JLabel use_time;
	JLabel use_time_1;
	JLabel level;
	JLabel level1;
	JLabel condition;
	JLabel condition1;
	JLabel today_sales;
	JLabel today_sales1;
	JLabel[] condi_;
	JLabel lb;
	JLabel lb1;

	// ArrayList<JButton> com_list = new ArrayList<>();

	JLabel id_chk;

	private Thread thread;
	private JLabel label;

	JToggleButton[] com = new JToggleButton[21];

	public Admin_Pc(Admin_Main mm) {
		// TODO Auto-generated constructor stub
		setTitle("������ PC");
		setBounds(500, 50, 1000, 700);
		setLayout(null);
		addWindowListener(new WinClose());

		this.mm = mm;

		try {
			img = ImageIO.read(new File("img/mainc.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panel = new MaPanel();
		panel.setBounds(0, 0, 1000, 700);
		panel.setLayout(null);

		com_pane = new JPanel(new GridLayout(4, 5, 10, 10));
		com_pane.setBackground(Color.black);
		com_pane.setBounds(300, 120, 650, 500);
		lp = new JLayeredPane();
		lp.setBounds(0, 0, 1000, 700);
		lp.setLayout(null);

		for (int i = 1; i < com.length; i++) {
			com[i] = new JToggleButton();
			com[i].setLayout(null);

			lb = new JLabel("");
			lb.setBounds(5, 1, 30, 30);
			lb1 = new JLabel("" + i);
			lb1.setBounds(100, 5, 15, 10);
			JLabel lb2 = new JLabel("��� ����");
			lb2.setBounds(35, 20, 60, 20);
			JLabel lb3 = new JLabel("��         ��");
			lb3.setBounds(35, 50, 60, 20);
			JLabel lb4 = new JLabel("��� �ð�");
			lb4.setBounds(35, 80, 60, 20);
			com[i].add(lb);
			com[i].add(lb1);
			com[i].add(lb2);
			com[i].add(lb3);
			com[i].add(lb4);
			lb.setFont(new Font("����", Font.BOLD, 25));
			lb.setForeground(Color.BLUE);
			lb1.setForeground(Color.red);
			lb2.setForeground(Color.cyan);
			lb3.setForeground(Color.yellow);
			lb4.setForeground(Color.white);
			com[i].setBackground(Color.darkGray);
			com[i].setForeground(Color.white);
			// com[i].setFocusPainted(false);
			// com[i].setContentAreaFilled(false);
			com[i].addActionListener(this);
			com_pane.add(com[i]);

		}

		member = new JButton("ȸ������");
		member.setBounds(50, 20, 100, 50);
		member.setFocusPainted(false);
		member.setContentAreaFilled(false);
		member.setForeground(Color.CYAN);
		member.addActionListener(this);
		lp.add(member);

		staff = new JButton("��������");
		staff.setBounds(190, 20, 100, 50);
		staff.setFocusPainted(false);
		staff.setContentAreaFilled(false);
		staff.setForeground(Color.cyan);
		staff.addActionListener(this);
		lp.add(staff);

		stock = new JButton("��ǰ����");
		stock.setBounds(330, 20, 100, 50);
		stock.setFocusPainted(false);
		stock.setContentAreaFilled(false);
		stock.setForeground(Color.cyan);
		stock.addActionListener(this);
		lp.add(stock);

		sales = new JButton("���� ����");
		sales.setBounds(470, 20, 100, 50);
		sales.setFocusPainted(false);
		sales.setContentAreaFilled(false);
		sales.setForeground(Color.CYAN);
		lp.add(sales);

		admin_logout = new JButton("Logout");
		admin_logout.setBounds(610, 20, 100, 50);
		admin_logout.setFocusPainted(false);
		admin_logout.setContentAreaFilled(false);
		admin_logout.setForeground(Color.CYAN);
		admin_logout.addActionListener(this);
		lp.add(admin_logout);

		com_num = new JLabel("��ǻ�� ��ȣ : ");
		com_num.setBounds(50, 130, 80, 30);
		com_num.setForeground(Color.white);
		lp.add(com_num);

		com_num1 = new JLabel("");
		com_num1.setBounds(150, 130, 70, 30);
		com_num1.setForeground(Color.white);
		lp.add(com_num1);

		start_time = new JLabel("����  �ð�     : ");
		start_time.setBounds(50, 180, 80, 30);
		start_time.setForeground(Color.white);
		lp.add(start_time);

		start_time_1 = new JLabel("���۽ð�");
		start_time_1.setBounds(150, 180, 70, 30);
		start_time_1.setForeground(Color.white);
		lp.add(start_time_1);

		use_time = new JLabel("���  �ð�     : ");
		use_time.setBounds(50, 230, 80, 30);
		use_time.setForeground(Color.white);
		lp.add(use_time);

		use_time_1 = new JLabel("��� �ð�");
		use_time_1.setBounds(150, 230, 70, 30);
		use_time_1.setForeground(Color.white);
		lp.add(use_time_1);

		level = new JLabel("��          ��      : ");
		level.setBounds(50, 280, 80, 30);
		level.setForeground(Color.white);
		lp.add(level);

		level1 = new JLabel("���");
		level1.setBounds(150, 280, 70, 30);
		level1.setForeground(Color.white);
		lp.add(level1);

		condition = new JLabel("���  ����     : ");
		condition.setBounds(50, 330, 80, 30);
		condition.setForeground(Color.white);
		lp.add(condition);

		condition1 = new JLabel("����� ");
		condition1.setBounds(150, 330, 70, 30);
		condition1.setForeground(Color.white);
		lp.add(condition1);

		today_sales = new JLabel("���� ���� :  ");
		today_sales.setBounds(770, 50, 70, 30);
		today_sales.setForeground(Color.white);
		lp.add(today_sales);

		today_sales1 = new JLabel("10000 ����");
		today_sales1.setBounds(840, 50, 70, 30);
		today_sales1.setForeground(Color.white);
		lp.add(today_sales1);

		chat = new JButton("1:1ê��");
		chat.setBounds(50, 420, 100, 50);
		chat.setForeground(Color.CYAN);
		chat.setFocusPainted(false);
		chat.setContentAreaFilled(false);
		chat.addActionListener(this);
		lp.add(chat);

		user_logout = new JButton("��� ����");
		user_logout.setBounds(170, 420, 100, 50);
		user_logout.setForeground(Color.CYAN);
		user_logout.setFocusPainted(false);
		user_logout.setContentAreaFilled(false);
		user_logout.addActionListener(this);
		lp.add(user_logout);

		pause = new JButton("�Ͻ� ����");
		pause.setBounds(50, 490, 100, 50);
		pause.setForeground(Color.CYAN);
		pause.setFocusPainted(false);
		pause.setContentAreaFilled(false);
		pause.addActionListener(this);
		lp.add(pause);

		move = new JButton("�ڸ� �̵�");
		move.setBounds(170, 490, 100, 50);
		move.setForeground(Color.CYAN);
		move.setFocusPainted(false);
		move.setContentAreaFilled(false);
		move.addActionListener(this);
		lp.add(move);

		refund = new JButton("����Ʈ ȯ��");
		refund.setBounds(50, 560, 220, 50);
		refund.setForeground(Color.CYAN);
		refund.setFocusPainted(false);
		refund.setContentAreaFilled(false);
		refund.addActionListener(this);
		lp.add(refund);

		label = new JLabel();

		label.setFont(new Font("Serif", Font.BOLD, 15));
		label.setForeground(Color.cyan);

		label.setBounds(770, 20, 250, 30);

		lp.add(label);
		lp.add(com_pane);
		lp.add(panel);

		add(lp);

		JFrame.setDefaultLookAndFeelDecorated(true);

		new DigitalClock();

		setResizable(false);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 1; i < com.length; i++) {
			if (e.getSource().equals(com[i])) {
				lb.setText("��");
				com_num1.setText(i + "  �� �ڸ�");
				System.out.println(com_num1.getText());
			}
		}

		
		if (e.getSource().equals(admin_logout)) {
			int i = JOptionPane.showConfirmDialog(null, "       �α� �ƿ� �Ͻðڽ��ϱ�?", "������ �α� �ƿ�", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (i == 0){
				System.out.println("Ȯ��");
				new Admin_Main();
				dispose();
			}

				
			else
				System.out.println("");
			
			

		}
		
		if (e.getSource().equals(user_logout)) {
			int i = JOptionPane.showConfirmDialog(null, "       ��� ���� �Ͻðڽ��ϱ�?", "��� ����", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (i == 0)

				System.out.println("Ȯ��");
			else
				System.out.println("");

		}

		if (e.getSource().equals(pause)) {
			int i = JOptionPane.showConfirmDialog(null, "       �Ͻ� ���� �Ͻðڽ��ϱ�?", "�Ͻ� ����", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (i == 0)

				System.out.println("Ȯ��");
			else
				System.out.println("");

		}

		
		if (e.getSource().equals(move)) {
			int i = JOptionPane.showConfirmDialog(null, "       �ڸ� �̵� �Ͻðڽ��ϱ�?", "�ڸ� �̵�", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (i == 0)

				System.out.println("Ȯ��");
			else
				System.out.println("");
		}

		if (e.getSource().equals(refund)) {
			int i = JOptionPane.showConfirmDialog(null, "       ����Ʈ ȯ�� �Ͻðڽ��ϱ�?", "����Ʈ ȯ��", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (i == 0)

				System.out.println("Ȯ��");
			else
				System.out.println("");
		}

		
		if (e.getSource().equals(chat)) {
			new FFF(this);

		}

		if (e.getSource().equals(stock)) {
			new Admin_Stock(this);
		}

		if (e.getSource().equals(staff)) {
			new Admin_Staff(this);
		}

		if (e.getSource().equals(member)) {
			new Admin_Member(this);

		}
		
		// mm.setEnabled(true);
		// dispose();

	}

	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			// mm.setEnabled(true);

			new Admin_Main();
			e.getWindow().dispose();
		}

	}

	class MaPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

	}

	public class DigitalClock implements Runnable {

		public DigitalClock() {

			if (thread == null) {

				// this�� �ǹ̴� Runnable�� ������ ��ü�� ����(DigitalClock)

				thread = new Thread(this);

				thread.start();

			}

		}

		public void run() {

			while (true) {

				Calendar cal = Calendar.getInstance();

				String now = cal.get(Calendar.YEAR) + "��" +

						(cal.get(Calendar.MONTH) + 1) + "�� " +

						cal.get(Calendar.DATE) + "�� " +

						cal.get(Calendar.HOUR) + "�� " +

						cal.get(Calendar.MINUTE) + "�� " +

						cal.get(Calendar.SECOND) + "�� ";

				label.setText(now);

				try {

					Thread.sleep(1000);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

			}

		}
	}

	// public static void main(String[] args) {
	// new Admin_Pc();
	// }
}