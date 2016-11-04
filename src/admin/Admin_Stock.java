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
	
	JButton add; //�˻���ư. 
	JButton delete; //����
	JButton modify; //����
	
//	JTextField sField;//�˻� �ʵ�
//	Vector<String> select;
//	JLabel test;//�����
	
	   public Admin_Stock(Admin_Pc mm) {
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
	                    {"�Ŷ��","������", "10","700��"},
	                    {"�Ŷ��","�Ŷ��", "10","650��"},
	                    {"�Ŷ��","Ƣ��쵿", "10","800��"},
	                    {"�Ŷ��","¥�İ�Ƽ", "10","750��"},
	                    {"����","������", "30","1000��"},
	                    {"����","�����", "30","500��"},
	                    {"����","��īĨ", "30","700��"},
	                    {"����","������", "30","700��"},
	                    
	            };
//	              String[] columnNames = {"��ȣ", "���̵�", "�̸�","����ó","�ּ�","�̸���","�������","�������","������","�ѻ�볻��"};
	              String[] columnNames = {"����","��ǰ��","����","����"};
	              
		      ////---------------------->>


   
		      JTable tt = new JTable(rowData, columnNames);// ǥ �������� ���´� (1�����迭+2�����迭)
//		        tt.setBounds(410, 240, 180, 100);
		        //ff.add(tt);
		        JScrollPane ttJS = new JScrollPane(tt); //������ �Ѱ��ֱ�
		        ttJS.setBounds(30, 170, 420, 300);
		        lp.add(ttJS);
		
				
		      /////////////////////////
		      
		      add = new JButton("��ǰ�߰�");
		      add.setBounds(100, 60, 100, 30);
		      add.setFocusPainted(false);
		      add.setContentAreaFilled(false);
		      add.setForeground(Color.white);
		      add.addActionListener(this);
		      lp.add(add);
		      
		      ////////////////////////////////////
		      
		      
		      modify = new JButton("��ǰ����");
		      modify.setBounds(200, 60, 100, 30);
		      modify.setFocusPainted(false);
		      modify.setContentAreaFilled(false);
		      modify.setForeground(Color.white);
		      modify.addActionListener(this);
		      lp.add(modify);
		      
		      ////////////////////////////
		      
		      delete = new JButton("��ǰ����");
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
	   
	   
/*	public static void main(String[] args) { // �׽�Ʈ��. 
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
			 //������ư ������ �׼�.
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
