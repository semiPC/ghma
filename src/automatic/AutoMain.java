package automatic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class AutoMain extends JFrame implements ActionListener{

	public AutoMain() {
		// TODO Auto-generated constructor stub
		
		setTitle("무인 결제 시스템");
		setBounds(0, 0, 1000, 700);
		setLayout(null);
		
		JLayeredPane lp = new JLayeredPane();
		lp.setBounds(0, 0, 1000, 700);
		lp.setLayout(null);
		
		JButton bt1 = new JButton("잔여 포인트 확인");
		bt1.setBounds(40, 150, 300, 300);
		lp.add(bt1);
		
		JButton bt2 = new JButton("결제 내역 조회");
		bt2.setBounds(340, 150, 300, 300);
		lp.add(bt2);
		
		JButton bt3 = new JButton("포인트 충전");
		bt3.setBounds(640, 150, 300, 300);
		lp.add(bt3);
		
		bt3.addActionListener(this);
		
		add(lp);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		new AutoMain_Point();
		setEnabled(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new AutoMain();

	}

}
