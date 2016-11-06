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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin_Report_Year extends JFrame implements ActionListener{ 

	BufferedImage img = null;
	Admin_Report nn;
	JButton finish; 
	Vector<String> yearV;   
	JLabel lb;
	
	public Admin_Report_Year(Admin_Report nn) { 
	
		this.nn = nn;
		setTitle("년도별 매출조회");
		setBounds(400, 50, 240, 220);
		setLayout(null);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		addWindowListener(new WinClose());
			
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,400,400);
		layeredPane.setLayout(null);

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 400, 400);

			try {
				img = ImageIO.read(new File("img/mainc.png"));
			} catch (Exception e) {
				// TODO: handle exception
				//System.exit(0);
			}

			
			yearV = new Vector<>();
				for (int i = 0; i < 7; i++) {
				yearV.add((2010+i)+"");
			}
		
			JComboBox year_adress = new JComboBox<>(yearV);
			year_adress.setBounds(70, 40, 60, 30);
			layeredPane.add(year_adress);
			
			lb = new JLabel("년");
			lb.setBounds(150, 35, 50, 50);
			lb.setForeground(Color.white);
			layeredPane.add(lb);
        			
			
			finish = new JButton("조회하기");
			finish.setBounds(70, 100, 90, 30);
			finish.setForeground(Color.cyan);
			finish.setContentAreaFilled(false);
			finish.setFocusPainted(false);
			finish.addActionListener(this);
			layeredPane.add(finish);

//			
		
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
	
/*
	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			mm.setEnabled(true);
			dispose();
		}
	}*/

	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			 if(e.getSource().equals(finish))
	         {
			//  finish버튼 누르면 발생.
				 dispose();
	         }
			 
//			mm.setEnabled(true);
//			dispose();
			//setVisible(false);
		}
	
	/*//테스트용 메인 ---- 생성자 매개값 제거후 사용.
	public static void main(String[] args) {
			// TODO Auto-generated method stub

			new Admin_Report_Date();			
		}
		*/
		

	}

