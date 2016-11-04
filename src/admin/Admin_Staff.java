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


public class Admin_Staff extends JFrame implements ActionListener{

	Admin_Pc mm;
	MaPanel panel;
	JPanel upPanel;
	JLayeredPane lp;	
	BufferedImage img = null;
	JTable jt;
	
	JButton search; //검색버튼. 
	JButton delete; //삭제
	JButton modify; //수정
	
	JTextField sField;//검색 필드
	Vector<String> select;
	JLabel test;//시험용
	
	   public Admin_Staff(Admin_Pc mm) {
		      // TODO Auto-generated constructor stub
		      setTitle("직원정보");
		      setBounds(500, 50, 1000, 700);
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
		      panel.setBounds(0, 0, 1000, 700);
		      panel.setLayout(null);
		      
		      upPanel = new JPanel(new GridLayout(4,5,10,10));
		      upPanel.setBackground(Color.BLACK);
		      upPanel.setBounds(0, 0, 1000, 150);
		    		     
		      lp =  new JLayeredPane();
		      lp.setBounds(0, 0, 1000, 700);
		      lp.setLayout(null);
		      
		      
		     String[][] rowData = {
		              {"12", "jgwhan0570", "정재환","010-1234-1234","서울 마포구 공덕동 현대하이엘오피스텔 808호","jgwhan0570@naver.com","91-11-07","PLATINUM","16-11-03","150,000,000원"},
		              {"12", "jgwhan0570", "정재환","010-1234-1234","서울 마포구 공덕동 현대하이엘오피스텔 808호","jgwhan0570@naver.com","91-11-07","PLATINUM","16-11-03","150,000,000원"}
		              
		      };
		        String[] columnNames = {"번호", "아이디", "이름","연락처","주소","이메일","생년월일","등급정보","가입일","총사용내역"};
		 
		      
		     
		      
		      
		      JTable tt = new JTable(rowData, columnNames);// 표 형식으로 들어온다 (1차원배열+2차원배열)
//		        tt.setBounds(410, 240, 180, 100);
		        //ff.add(tt);
		        JScrollPane ttJS = new JScrollPane(tt); //얘한테 넘겨주기
		        ttJS.setBounds(20, 200, 950, 400);
		        lp.add(ttJS);
		        
		    ///
		        
		      select = new Vector<>();
				select.add("아이디");
				select.add("이름");
				

				JComboBox idname = new JComboBox<>(select);
				idname.setBounds(200, 60, 100, 30);
				lp.add(idname);
				
		       ////////////////////////////
		      
		        sField = new JTextField(" ");
				sField.setBounds(300, 60, 200, 30);
//				sField.setOpaque(false); // 투명처리
				sField.setForeground(Color.black);
				sField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				lp.add(sField);

				
		      /////////////////////////
		      
		      search = new JButton("검색");
		      search.setBounds(500, 60, 100, 30);
		      search.setFocusPainted(false);
		      search.setContentAreaFilled(false);
		      search.setForeground(Color.white);
		      lp.add(search);
		      
		      ////////////////////////////////////
		      
		      delete = new JButton("정보삭제");
		      delete.setBounds(650, 60, 100, 30);
		      delete.setFocusPainted(false);
		      delete.setContentAreaFilled(false);
		      delete.setForeground(Color.white);
		      lp.add(delete);
		      
		      
		      ///
		      
		      modify = new JButton("정보수정");
		      modify.setBounds(750, 60, 100, 30);
		      modify.setFocusPainted(false);
		      modify.setContentAreaFilled(false);
		      modify.setForeground(Color.white);
		      modify.addActionListener(this);
		      lp.add(modify);
		      
		      
		      lp.add(upPanel);
		      lp.add(panel);
		      add(lp);
		      
		      setResizable(false);
		      setVisible(true);
		      	      
		      
	   }
	   
	   
	/*public static void main(String[] args) { // 테스트용. 
		// TODO Auto-generated method stub

		new Admin_Staff();
		
		
	}*/

	   @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		   
		   if(e.getSource().equals(modify))
	         {
	            new Admin_Staff_Modify(this);
	         }
			
		}
	   
	 class MaPanel extends JPanel
	   {
	   public void paint(Graphics g){
	      g.drawImage(img, 0, 0, null);
	   }
	   
	   }

	
	 
}
