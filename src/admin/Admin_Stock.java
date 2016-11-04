package admin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Admin_Stock extends JFrame implements ActionListener{

	Admin_Pc mm;
	MaPanel panel;
	JPanel upPanel;
	JLayeredPane lp;	
	BufferedImage img = null;
	JTable jt;
	
	JButton add; //검색버튼. 
	JButton delete; //삭제
	JButton modify; //수정
	
//	JTextField sField;//검색 필드
//	Vector<String> select;
//	JLabel test;//시험용
	
	   public Admin_Stock(Admin_Pc mm) {
		      // TODO Auto-generated constructor stub
		      setTitle("재고관리");
		      setBounds(500, 50, 500, 600);
		      setLayout(null);
//		      addWindowListener(new WinClose());
		      this.mm = mm;
		      
		      try {
		         img = ImageIO.read(new File("img/mainc.png"));
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      
		     
		      
		      panel = new MaPanel();		      
		      panel.setBounds(0, 0, 500, 600);
		      panel.setLayout(null);
		      
		      upPanel = new JPanel(new GridLayout(4,5,10,10));
		      upPanel.setBackground(Color.BLACK);
		      upPanel.setBounds(0, 0, 500, 150);
		    		     
		      lp =  new JLayeredPane();
		      lp.setBounds(0, 0, 500, 600);
		      lp.setLayout(null);
		      
		      //테스트 시작
		      String[][] rowData = {
	                    {"컵라면","새우탕", "10","700원"},
	                    {"컵라면","신라면", "10","650원"},
	                    {"컵라면","튀김우동", "10","800원"},
	                    {"컵라면","짜파게티", "10","750원"},
	                    {"과자","오레오", "30","1000원"},
	                    {"과자","새우깡", "30","500원"},
	                    {"과자","포카칩", "30","700원"},
	                    {"과자","빼뺴로", "30","700원"},
	                    
	            };
//	              String[] columnNames = {"번호", "아이디", "이름","연락처","주소","이메일","생년월일","등급정보","가입일","총사용내역"};
	              String[] columnNames = {"구분","물품명","수량","가격"};
	              
		      ////---------------------->>


   
		      JTable tt = new JTable(rowData, columnNames);// 표 형식으로 들어온다 (1차원배열+2차원배열)
//		        tt.setBounds(410, 240, 180, 100);
		        //ff.add(tt);
		        JScrollPane ttJS = new JScrollPane(tt); //얘한테 넘겨주기
		        ttJS.setBounds(30, 170, 420, 300);
		        lp.add(ttJS);
		
				
		      /////////////////////////
		      
		      add = new JButton("물품추가");
		      add.setBounds(100, 60, 100, 30);
		      add.setFocusPainted(false);
		      add.setContentAreaFilled(false);
		      add.setForeground(Color.white);
		      add.addActionListener(this);
		      lp.add(add);
		      
		      ////////////////////////////////////
		      
		      
		      modify = new JButton("물품수정");
		      modify.setBounds(200, 60, 100, 30);
		      modify.setFocusPainted(false);
		      modify.setContentAreaFilled(false);
		      modify.setForeground(Color.white);
		      modify.addActionListener(this);
		      lp.add(modify);
		      
		      ////////////////////////////
		      
		      delete = new JButton("물품삭제");
		      delete.setBounds(300, 60, 100, 30);
		      delete.setFocusPainted(false);
		      delete.setContentAreaFilled(false);
		      delete.setForeground(Color.white);
		      delete.addActionListener(this);
		      lp.add(delete);
		      		      
		      ///		      
		     
		      
		      lp.add(upPanel);
		      lp.add(panel);
		      add(lp);
		      
		      setResizable(false);
		      setVisible(true);
		      	      
		      
	   }
	   
	   
/*	public static void main(String[] args) { // 테스트용. 
		// TODO Auto-generated method stub

		new Admin_Stock();
		
		
	}*/

	   @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		   
		  if(e.getSource().equals(modify))
	         {
			  new Admin_Stock_Modify(this);
	         }
		  
		  if(e.getSource().equals(delete))
	         {
			 //삭제버튼 누를때 액션.
	         }
		  
		  if(e.getSource().equals(add))
	         {
			  new Admin_Stock_Add(this);
	         }
		  
			
		}
	   
	 class MaPanel extends JPanel
	   {
	   public void paint(Graphics g){
	      g.drawImage(img, 0, 0, null);
	   }
	   
	   }

	
	 
}
