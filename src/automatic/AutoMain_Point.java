package automatic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class AutoMain_Point extends JFrame{

	public AutoMain_Point() {
		// TODO Auto-generated constructor stub
	
		setTitle("포인트 충전");
		setBounds(0,0,1000,700);
		setLayout(null);
		
		JLayeredPane jp = new JLayeredPane();
		jp.setBounds(0, 0, 1000, 700);
		jp.setLayout(null);
		
		JTextField jf = new JTextField();
		jf.setBounds(100, 100, 300, 300);
		jp.add(jf);
		
		JButton bt = new JButton("충전하기");
		bt.setBounds(400, 100, 300, 300);
		jp.add(bt);
		
		add(jp);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new AutoMain_Point();

	}

}
