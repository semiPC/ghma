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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin_Stock_Add extends JFrame implements ActionListener{ 

	BufferedImage img = null;
	Admin_Stock nn;
	JTextField name,price,quantity;
	JButton finish; 
	Vector<String> type;
	JLabel lb;

	String [] arr = {"구분","물품명","가격","수량"};

	public Admin_Stock_Add(Admin_Stock nn) { 
	
		this.nn = nn;
		setTitle("물품추가");
		setBounds(400, 50, 400, 400);
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


			for (int i = 0; i < arr.length; i++) {
				lb = new JLabel(arr[i]);
				lb.setBounds(50, 50+45*i, 80, 50);
				lb.setForeground(Color.white);
				layeredPane.add(lb);
			}
			   
            type = new Vector<>();
            type.add("라면류");	
            type.add("과자류");
            type.add("음료류");
            
            JComboBox idname = new JComboBox<>(type);
            idname.setBounds(150, 60, 130, 30);
            layeredPane.add(idname);
            			
			name = new JTextField("물품명");
			name.setBounds(150, 105, 200, 30);
			name.setOpaque(false); // 투명처리
			name.setForeground(Color.cyan);
			name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(name);

			price = new JTextField("가격");
			price.setBounds(150, 150, 150, 30);
			price.setOpaque(false); // 투명처리
			price.setForeground(Color.cyan);
			price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(price);

			quantity = new JTextField("수량");
			quantity.setBounds(150, 195, 150, 30);
			quantity.setOpaque(false); // 투명처리
			quantity.setForeground(Color.cyan);
			quantity.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			layeredPane.add(quantity);

			finish = new JButton("추가하기");
			finish.setBounds(140, 300, 90, 30);
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
				 dispose();
			//  finish버튼 누르면 발생.
	         }
			 
			 
//			mm.setEnabled(true);
//			dispose();
			//setVisible(false);
		}
		
	
	/*//테스트용 메인 ---- 생성자 매개값 제거후 사용.
	public static void main(String[] args) {
			// TODO Auto-generated method stub

			new Admin_Stock_Add();			
		}
		*/
		

	}

