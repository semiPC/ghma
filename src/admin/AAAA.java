//package client;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JLayeredPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class Login_PWfind extends JFrame implements ActionListener{
//
//	BufferedImage img = null;
//	MaPanel panel;
//	JLayeredPane lp;
//	JTextField id,name,ponnum,que_chk;
//	JLabel que,pdf;
//	
//	JLabel lb;
//	String [] str={"��  ��  ��","��        ��","��  ��  ��","��        ��","��        ��","�н�����"};
//
//	public Login_PWfind(Login_Main lf) {
//		// TODO Auto-generated constructor stub
//		setTitle("PW ã��");
//		setBounds(200, 100, 430, 550);
//		setLayout(null);
//		addWindowListener(new WinClose());
//
//		this.lf = lf;
//
//		try {
//			img = ImageIO.read(new File("img/pw.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		panel = new MaPanel();
//		panel.setBounds(0, 0, 430, 550);
//		add(panel);
//
//		lp =  new JLayeredPane();
//		lp.setBounds(0, 0, 430, 550);
//		lp.setLayout(null);
//
//		for (int i = 0; i < str.length; i++) {
//			lb = new JLabel();
//			lb.setText(str[i]);
//			lb.setForeground(Color.white);
//			lb.setBounds(90, 45+i*65, 55, 50);
//			lp.add(lb);
//		}
//
//		id = new JTextField("�Է��ϼ���.");
//		id.setBounds(175, 50, 150, 40);
//		id.setOpaque(false); // ����ó��
//		id.setForeground(Color.CYAN);
//		id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		lp.add(id);
//
//		name = new JTextField("�Է��ϼ���.");
//		name.setBounds(175, 115, 150, 40);
//		name.setOpaque(false); // ����ó��
//		name.setForeground(Color.CYAN);
//		name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		lp.add(name);
//
//		ponnum = new JTextField("�Է��ϼ���.");
//		ponnum.setBounds(175, 180, 150, 40);
//		ponnum.setOpaque(false); // ����ó��
//		ponnum.setForeground(Color.CYAN);
//		ponnum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		lp.add(ponnum);
//
//		que =new JLabel("������");
//		que.setBounds(175, 245, 50, 40);
//		que.setForeground(Color.white);
//		lp.add(que);
//
//		que_chk =new JTextField("�Է��ϼ���.");
//		que_chk.setBounds(175, 312, 150, 40);
//		que_chk.setOpaque(false);
//		que_chk.setForeground(Color.CYAN);
//		que_chk.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		lp.add(que_chk);
//
//		pdf = new JLabel("12345678  �Դϴ� !!");
//		pdf.setForeground(Color.white);
//		pdf.setBounds(175, 370, 150, 50);
//		lp.add(pdf);
//
//		JButton bt = new JButton("pwã��");
//		bt.setBounds(313, 180, 78, 55);
//		bt.setForeground(Color.cyan);
//		bt.setContentAreaFilled(false);
//		bt.setFocusPainted(false);
//		lp.add(bt);
//
//		JButton bt2 = new JButton("Ȯ��");
//		bt2.setBounds(180, 450, 60, 40);
//		bt2.setForeground(Color.cyan);
//		bt2.setContentAreaFilled(false);
//		bt2.setFocusPainted(false);
//		lp.add(bt2);
//
//		lp.add(panel);
//		add(lp);
//
//		setResizable(false);
//		setVisible(true);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//		lf.setEnabled(true);
//		dispose();
//	}
//
//	class WinClose extends WindowAdapter {
//
//		@Override
//		public void windowClosing(WindowEvent e) {
//			// TODO Auto-generated method stub
//			lf.setEnabled(true);
//			e.getWindow().dispose();
//		}
//	}
//
//	class MaPanel extends JPanel
//	{
//		public void paint(Graphics g){
//			g.drawImage(img, 0, 0, null);
//		}
//	}
//}