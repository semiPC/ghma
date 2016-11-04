package client;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

//import admin.Admin_Pc.DigitalClock;


//   일시정지, 사용종료, 관리자에게 메세지, 상품주문(상품목록, 주문하기)
// 주문조회(상품내역, 총금액), 회원등급, 사용 시작시간, 사용시간, 남은포인트
// 충전내역 조회
class WinClose extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}



public class Play_Main extends JFrame implements ActionListener{ 
	JButton stop;
	JButton exit;
	JButton message;
	JButton order;
	JButton orderChk;
	JButton mGrade;
	JButton payChk;
	JButton pointchk;
	JButton move;
	JButton pointcharge;
	JButton infoEdit;
	private Thread thread;
	private JLabel label;
	JLabel start;
	JLabel useTime;
	JLabel point;
	JLabel startL;
	JLabel useTimeL;
	JLabel pointL;
	JLabel grade;
	JLabel gradeL;
	long startT;
	long curT;
	Login_Main lf;

	BufferedImage img = null;
	String stopTime="";
	long useSecond;

	int width = 400;
	int height = 300;
	int hh, mm, ss;
	public Play_Main(Login_Main lf) {
		// TODO Auto-generated constructor stub
		setTitle("로그인");
		setBounds(0, 0, width, height);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WinClose());
		this.lf = lf;
		lf.dispose();
		//이미지를 넣는 과정
		try {
			img = ImageIO.read(new File("img/stpcc.png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("이미지를 불러올 수 없습니다");
			System.exit(0);
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		startT = c1.getTimeInMillis();
		//      System.out.println(c1.getTimeInMillis());

		// 요건 셀로판지
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0, width, height);
		layeredPane.setLayout(null);


		// 패널크기는 같게(프레임이랑)
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0,  width, height);


		stop = new JButton("사용중지");
		stop.setBounds(20,20,100,30);
		stop.setForeground(Color.cyan);
		stop.setContentAreaFilled(false);
		stop.setFocusPainted(false);
		layeredPane.add(stop);

		exit = new JButton("사용종료");
		exit.setBounds(130,20,100,30);
		exit.setForeground(Color.cyan);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		layeredPane.add(exit);

		order = new JButton("주문하기");
		order.setBounds(240,20,100,30);
		order.setForeground(Color.cyan);
		order.setContentAreaFilled(false);
		order.setFocusPainted(false);
		layeredPane.add(order);


		move = new JButton("자리이동");
		move.setBounds(240,60,100,30);
		move.setForeground(Color.cyan);
		move.setContentAreaFilled(false);
		move.setFocusPainted(false);
		layeredPane.add(move);

		//      (250,215,120,30);
		orderChk = new JButton("주문내역");
		orderChk.setBounds(20,215,100,30);
		orderChk.setForeground(Color.cyan);
		orderChk.setContentAreaFilled(false);
		orderChk.setFocusPainted(false);
		layeredPane.add(orderChk);

		payChk = new JButton("결제내역");
		payChk.setBounds(135,215,100,30);
		payChk.setForeground(Color.cyan);
		payChk.setContentAreaFilled(false);
		payChk.setFocusPainted(false);
		layeredPane.add(payChk);


		message = new JButton("관리자에게 보내는 메세지");
		message.setBounds(170,100,190,30);
		message.setForeground(Color.cyan);
		message.setContentAreaFilled(false);
		message.setFocusPainted(false);
		layeredPane.add(message);

		/*
      message = new JButton("관리자에게 보내는 메세지");
      message.setBounds(20,180,200,30);
      message.setForeground(Color.cyan);
      message.setContentAreaFilled(false);
      message.setFocusPainted(false);
      layeredPane.add(message);
		 */
		pointchk = new JButton("포인트 사용 내역");
		pointchk.setBounds(170,140,190,30);
		pointchk.setForeground(Color.cyan);
		pointchk.setContentAreaFilled(false);
		pointchk.setFocusPainted(false);
		layeredPane.add(pointchk);


		pointcharge = new JButton("포인트 충전 내역");
		pointcharge.setBounds(170,180,190,30);
		pointcharge.setForeground(Color.cyan);
		pointcharge.setContentAreaFilled(false);
		pointcharge.setFocusPainted(false);
		layeredPane.add(pointcharge);

		//      JButton infoEdit;
		infoEdit = new JButton("회원정보 수정");
		infoEdit.setBounds(250,215,120,30);
		infoEdit.setForeground(Color.cyan);
		infoEdit.setContentAreaFilled(false);
		infoEdit.setFocusPainted(false);
		layeredPane.add(infoEdit);

		start = new JLabel("시작시간: "); 
		start.setBounds(30, 60, 80, 30);
		start.setForeground(Color.white);
		layeredPane.add(start);

		startL = new JLabel(Calendar.getInstance().get(Calendar.HOUR)+":"+
				Calendar.getInstance().get(Calendar.MINUTE));

		startL.setBounds(120, 60, 80, 30);
		startL.setForeground(Color.white);
		layeredPane.add(startL);


		/*label = new JLabel("");
      label.setFont(new Font("Serif", Font.BOLD, 15));
      label.setForeground(Color.cyan);
      label.setBounds(120, 60, 150, 30);
      layeredPane.add(label);*/



		useTime = new JLabel("사용시간: "); 
		useTime.setBounds(30, 100, 80, 30);
		useTime.setForeground(Color.white);
		layeredPane.add(useTime);

		useTimeL = new JLabel("00:00");
		useTimeL.setBounds(120, 100, 80, 30);
		useTimeL.setForeground(Color.white);
		layeredPane.add(useTimeL);


		point = new JLabel("포인트: ");
		point.setBounds(30, 140, 80, 30);
		point.setForeground(Color.white);
		layeredPane.add(point);

		pointL = new JLabel("10000");
		pointL.setBounds(120, 140, 80, 30);
		pointL.setForeground(Color.white);
		layeredPane.add(pointL);


		grade = new JLabel("회원등급:");
		grade.setBounds(30, 180, 80, 30);
		grade.setForeground(Color.white);
		layeredPane.add(grade);

		gradeL = new JLabel("브론즈");
		gradeL.setBounds(120, 180, 80, 30);
		gradeL.setForeground(Color.white);
		layeredPane.add(gradeL);



		exit.addActionListener(this);
		order.addActionListener(this);


		/*java.util.Date date = Calendar.getTime();
      String Today = new SimpleDateFormat("yyyyMMdd").format(date);
      try {
          Calendar.setTime(formatter.parse(Today));
      } catch (ParseException e1) {
          e1.printStackTrace();
      } */



		new DigitalClock();


		layeredPane.add(panel);
		add(layeredPane);
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
	private String useTime(String udate){
		//      System.out.println(udate);
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// 포맷방식
		Date date1 = null;
		Date date2 = null;
		Calendar c1 = Calendar.getInstance();   // 시간차를 계산하기위한 달력객체
		Calendar c2 = Calendar.getInstance();   // 시간차를 계산하기위한 달력객체

		try{
			date1 = sdf.parse(udate);   // 데이트 객체에 시작시간 입력
			if( this.stopTime != null ){
				date2 = sdf.parse(this.stopTime);
			}
		}catch(Exception e){}

		c1.setTime(date1);      // 시작시간셋팅
		if( this.stopTime == null ){
			c2.setTime(new Date());   // 현재시간셋팅
		}else{
			c2.setTime(date2);      // 사용중지요청시간셋팅 this.stopTime
		}

		long intervalMilli = (c2.getTimeInMillis() - c1.getTimeInMillis())/1000;   // 초 값이 나옴
		long minute = 60;         // 초값을 분으로 계산하기위한 값
		long hour = minute * 60;   // 초값을 시간으로 계산하기 위한 값 

		int useHour = (int)(intervalMilli/hour);
		int useMinute = (int)((intervalMilli%hour)/minute);
		int useSecond = (int)((intervalMilli%hour)%minute);
		this.useSecond = intervalMilli; // 요금 계산을 위해 멤버변수에 초값을 입력하여 사용

		String tmp = (useHour < 10 ) ? "0"+useHour : useHour+"";
		tmp += ":";
		tmp += (useMinute < 10 ) ? "0"+useMinute : useMinute+"";
		tmp += ":";
		tmp += (useSecond < 10 ) ? "0"+useSecond : useSecond+"";
		return tmp;

		//return useHour+"시 "+useMinute+"분";
		//      return useHour+"시 "+useMinute+"분 "+useSecond+"초";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(exit))
		{
			setVisible(false);
			new Login_Main();
			dispose();
		}
		else if(e.getSource().equals(order))
		{
			setEnabled(false);
			new Play_Order(this);
		}
	}

	public class DigitalClock implements Runnable {

		public DigitalClock() {

			if (thread == null) {
				// this의 의미는 Runnable이 구현된 객체를 뜻함(DigitalClock)
				thread = new Thread(this);
				thread.start();

			}

		}

		public void run() {

			while (true) {

				Calendar cal = Calendar.getInstance();
				curT = cal.getTimeInMillis();
				JTextField jt = new JTextField("dfd");



				String now = 
						cal.get(Calendar.HOUR) + "시 " +
								cal.get(Calendar.MINUTE) + "분 " +
								cal.get(Calendar.SECOND) + "초 ";
				//            Calendar.getInstance().get(Calendar.)
				//            label.setText(now);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
}