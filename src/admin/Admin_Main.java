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
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Admin_Main extends JFrame implements ActionListener{

   BufferedImage img = null;
   
   MaPanel panel; 
   JLayeredPane lp;
   JTextField id;
   JPasswordField pw; 
   JButton malog; 
   JButton member;
   JButton idfind;
   JButton pwfind;
   
   int action_chk = 0; 
   
   public Admin_Main() {
      // TODO Auto-generated constructor stub
      setTitle("관리자 메인");
      setBounds(400, 100, 1000, 700);
      setLayout(null);
      setEnabled(true);
            
      try {
         img = ImageIO.read(new File("img/admin.PNG"));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      panel = new MaPanel();
      panel.setBounds(0, 0, 1000, 700);
      
      add(panel);
      
      
      lp = new JLayeredPane();
      lp.setBounds(0, 0, 1000, 700);
      lp.setLayout(null);
      
      // id 쓰는란
      id = new JTextField(5);
      id.setBounds(410, 370, 150, 60);
      id.setOpaque(false);
      id.setForeground(Color.green);
      id.setFont(new Font("굴림", Font.BOLD, 20));
      id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      lp.add(id);
      
      //pw 쓰는란
      pw = new JPasswordField(15);
      pw.setBounds(410, 440, 150, 60);
      pw.setOpaque(false);
      pw.setFont(new Font("굴림", Font.BOLD, 20));
      pw.setForeground(Color.green);
      pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      lp.add(pw);
      
      //로그인 버튼
      malog = new JButton("ffff",new ImageIcon("img/login_enter.PNG"));
      malog.setBounds(630, 370, 130, 50);
//      malog.setBorderPainted(false);
//      malog.setFocusPainted(false);
      malog.setContentAreaFilled(false);
      lp.add(malog);
      
      //회원가입 버튼
      member = new JButton(new ImageIcon("img/login_join.PNG"));
      member.setBounds(630, 440, 130, 50);
//      neureg.setBorderPainted(false);
//      neureg.setFocusPainted(false);
      member.setContentAreaFilled(false);
      lp.add(member);
      
      //id찾기 버튼
      idfind = new JButton(new ImageIcon("img/login_ids.PNG"));
      idfind.setBounds(410, 530, 130, 50);
//      idfind.setBorderPainted(false);
//      idfind.setFocusPainted(false);
      idfind.setContentAreaFilled(false);
      lp.add(idfind);
      
      //pw찾기 버튼
      pwfind = new JButton(new ImageIcon("img/login_pws.PNG"));
      pwfind.setBounds(580, 530, 130, 50);
//      pwfind.setBorderPainted(false);
//      pwfind.setFocusPainted(false);
      pwfind.setContentAreaFilled(false);
      lp.add(pwfind);
      
      
      lp.add(panel);
      add(lp);
      // 각 버튼 액션리스너들
      malog.addActionListener(this);
      member.addActionListener(this);
      idfind.addActionListener(this);
      pwfind.addActionListener(this);
      
      
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      
		if (e.getSource().equals(malog)) {
			Malog();
			dispose();
		}
		if (e.getSource().equals(member)) {
			Member();
		}
		if (e.getSource().equals(idfind)) {
			Idfine();
		}
		if (e.getSource().equals(pwfind)) {
			Pwfine();
		}
	 
      
   }
   
   
   void Malog()
   {
	   new Admin_Pc(this);
	  
	      setEnabled(false);
	    
   }
   void Member()
   {
	   new Admin_Reg(this);
	      setEnabled(false);
   }
   
   void Idfine()
   {
	   new Admin_IdFind(this);
	      setEnabled(false);
   }
   
   void Pwfine()
   {
	  new Admin_PwFind(this);
	      setEnabled(false);
   }
   

  
   
   class MaPanel extends JPanel
   {
   public void paint(Graphics g){
      g.drawImage(img, 0, 0, null);
   }
   
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      new Admin_Main();
      new Admin_Chat_Server();
   }

   

}