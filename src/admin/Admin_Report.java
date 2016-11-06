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


public class Admin_Report extends JFrame implements ActionListener{

	Admin_Pc mm;
	MaPanel panel;
	JPanel upPanel;
	JLayeredPane lp;	
	BufferedImage img = null;
	JTable jt;
	
	JButton year;  
	JButton month; 
	JButton date; 
	JButton period; 
	
	   public Admin_Report(Admin_Pc mm) {
		      // TODO Auto-generated constructor stub
		      setTitle("������");
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
		      
		      //�׽�Ʈ ����
		      String[][] rowData = {
	                    {"11/1","1,500,000", "500,000","1,000,000"},
	                    {"11/2","1,500,000", "500,000","1,000,000"},
	                    {"11/3","1,500,000", "500,000","1,000,000"},
	                    {"11/4","1,500,000", "500,000","1,000,000"},
	                    {"11/5","1,500,000", "500,000","1,000,000"},
	                    {"11/6","1,500,000", "500,000","1,000,000"},
	                    {"11/7","1,500,000", "500,000","1,000,000"},
	                    {"11/8","1,500,000", "500,000","1,000,000"},
	                    {"11/9","1,500,000", "500,000","1,000,000"},
	                    {"11/10","1,500,000", "500,000","1,000,000"},
	                    {"11/11","1,500,000", "500,000","1,000,000"},
	                    {"11/12","1,500,000", "500,000","1,000,000"},
	                    {"11/13","1,500,000", "500,000","1,000,000"},
	                    {"11/14","1,500,000", "500,000","1,000,000"},
	                    {"11/15","1,500,000", "500,000","1,000,000"},
	                    {"11/16","1,500,000", "500,000","1,000,000"},
	                    {"11/17","1,500,000", "500,000","1,000,000"},
	                    {"11/18","1,500,000", "500,000","1,000,000"},
	                    {"11/19","1,500,000", "500,000","1,000,000"},
	                    {"11/20","1,500,000", "500,000","1,000,000"},
	                 
	                    {"11�� ��","15,000,000", "5,000,000","10,000,000"},
	                    
	            };
//	              String[] columnNames = {"��ȣ", "���̵�", "�̸�","����ó","�ּ�","�̸���","�������","�������","������","�ѻ�볻��"};
	              String[] columnNames = {"��¥","����","ȯ�Ҿ�","������"};
	              
		      ////---------------------->>


   
		      JTable tt = new JTable(rowData, columnNames);// ǥ �������� ���´� (1�����迭+2�����迭)
//		        tt.setBounds(410, 240, 180, 100);
		        //ff.add(tt);
		        JScrollPane ttJS = new JScrollPane(tt); //������ �Ѱ��ֱ�
		        ttJS.setBounds(30, 170, 420, 300);
		        lp.add(ttJS);
		
				
		      /////////////////////////
		      
		      year = new JButton("�⺰����");
		      year.setBounds(40, 60, 100, 30);
		      year.setFocusPainted(false);
		      year.setContentAreaFilled(false);
		      year.setForeground(Color.white);
		      year.addActionListener(this);
		      lp.add(year);
		      
		  
		      
		      ////////////////////////////
		      
		      month = new JButton("��������");
		      month.setBounds(140, 60, 100, 30);
		      month.setFocusPainted(false);
		      month.setContentAreaFilled(false);
		      month.setForeground(Color.white);
		      month.addActionListener(this);
		      lp.add(month);
		      		      
		      ///		
    ////////////////////////////////////
		      
		      date = new JButton("�Ϻ�����");
		      date.setBounds(240, 60, 100, 30);
		      date.setFocusPainted(false);
		      date.setContentAreaFilled(false);
		      date.setForeground(Color.white);
		      date.addActionListener(this);
		      lp.add(date);
		      
		      period = new JButton("�Ⱓ������");
		      period.setBounds(340, 60, 100, 30);
		      period.setFocusPainted(false);
		      period.setContentAreaFilled(false);
		      period.setForeground(Color.white);
		      period.addActionListener(this);
		      lp.add(period);
		      		      
		      
		     
		      
		      lp.add(upPanel);
		      lp.add(panel);
		      add(lp);
		      
		      setResizable(false);
		      setVisible(true);
		      	      
		      
	   }
	   
	   
/*	public static void main(String[] args) { // �׽�Ʈ��. 
		// TODO Auto-generated method stub

		new Admin_Report();
		
		
	}*/

	   @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		   
		  if(e.getSource().equals(date))
	         {
			  new Admin_Report_Date(this);
	         }
		  
		  if(e.getSource().equals(month))
	         {
			  new Admin_Report_Month(this);
	         }
		  
		  if(e.getSource().equals(year))
	         {
			  new Admin_Report_Year(this);
	         }
		  if(e.getSource().equals(period))
	         {
			  new Admin_Report_Period(this);
	         }
		  
		}
	   
	 class MaPanel extends JPanel
	   {
	   public void paint(Graphics g){
	      g.drawImage(img, 0, 0, null);
	   }
	   
	   }

	
	 
}
