package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import client.Login_PWfind.WinClose;
import client.Play_Main.MyPanel;

public class Play_Order extends JFrame implements ActionListener  {
	int width = 600;
	int height = 300;

	int priceSum = 0;
	String [] menu1 = {"콜라","사이다","커피"};
	//	 String [] menu1Price = {"1000", "2000", "3000"};
	int [] menu1Price = {1000, 2000, 3000};
	String [] menu2 = {"짜파게티","너구리","삼양라면"};
	//	 String [] menu2Price = {"1500", "1200", "1000"};
	int [] menu2Price = {1500, 1200, 1000};
	String [] menu3 = {"새우볶음밥","김치볶음밥","오징어제육덮밥"};
	//	 String [] menu3Price = {"5000", "4000", "6000"};
	int [] menu3Price = {5000, 4000, 6000};
	int ii = 1;
	BufferedImage img = null;
	Play_Main pm;
	Vector<String> orderDrink;
	Vector<String> orderND;
	Vector<String> orderRice;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JComboBox DrinkCombo;
	JComboBox NDCombo;
	JComboBox RiceCombo;
	String orderGo = "";
	JLabel resultPrice;
	JPanel list;
	//	 JLabel orderList;
	JLayeredPane layeredPane;
	MyPanel panel;
	JTextArea orderList;
	JScrollPane orderListsc;
	JButton orderBt;
	JButton init;
	class WinClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			pm.setEnabled(true);
			e.getWindow().dispose();
		}
	}
	public Play_Order(Play_Main pm) {
		// TODO Auto-generated constructor stub
		setTitle("주문하기!!");
		setBounds(20, 10, width, height);
		setLayout(null);
		addWindowListener(new WinClose());

		this.pm = pm;

		// 요건 셀로판지
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0, width, height);
		layeredPane.setLayout(null);

		panel = new MyPanel();
		panel.setBounds(0, 0,  width, height);
		panel.setBackground(Color.black);
		panel.setLayout(null);




		//		
		//		 JPanel menuPane = new JPanel();
		//		 menuPane.setBounds(20,20, 200, 195);
		//		 menuPane.setLayout(null);


		//	     String [] hArr = {"콜라", "사이다", "라면","짜파게티", "김치볶음밥","새우볶음밥"};
		//	     JCheckBox [] hbox = new JCheckBox[hArr.length];
		/*Vector<String> orderDrink;
		 Vector<String> orderND;
		 Vector<String> orderRice;*/



		orderDrink = new Vector<>();
		/*for (String string : menu1) { // 음료 선택
			orderDrink.add(string);
		}*/
		for (int i = 0; i < menu1Price.length; i++) {
			orderDrink.add(menu1[i]+": "+menu1Price[i]+"원");
		}
		DrinkCombo = new JComboBox<>(orderDrink);
		DrinkCombo.setBounds(20, 20, 230, 30);
		layeredPane.add(DrinkCombo);

		orderND = new Vector<>();
		/*for (String string : menu2) { // 라면 선택
			orderND.add(string);
		}*/
		for (int i = 0; i < menu2Price.length; i++) {
			orderND.add(menu2[i]+": "+menu2Price[i]+"원");
		}
		NDCombo = new JComboBox<>(orderND);
		NDCombo.setBounds(20, 90, 230, 30);
		layeredPane.add(NDCombo);

		orderRice = new Vector<>();
		/*for (String string : menu3) { // 밥 선택
			orderRice.add(string);
		}*/
		for (int i = 0; i < menu3Price.length; i++) {
			orderRice.add(menu3[i]+": "+menu3Price[i]+"원");
		}
		RiceCombo = new JComboBox<>(orderRice);
		RiceCombo.setBounds(20, 160, 230, 30);
		layeredPane.add(RiceCombo);
		//////////////////////////////////////////////////////////


		jb1 = new JButton("추가");
		jb1.setBounds(260, 20, 70, 30);
		jb1.addActionListener(this);
		layeredPane.add(jb1);

		jb2 = new JButton("추가");
		jb2.setBounds(260, 90, 70, 30);
		jb2.addActionListener(this);
		layeredPane.add(jb2);

		jb3 = new JButton("추가");
		jb3.setBounds(260, 160, 70, 30);
		jb3.addActionListener(this);
		layeredPane.add(jb3);
		//////////////////////////

		list = new JPanel();
		list.setBounds(360, 20, 200, 200);
		list.setBackground(Color.white);


		resultPrice = new JLabel("0");
		resultPrice.setBounds(400,230, 100, 30);
		layeredPane.add(resultPrice);

		JLabel result = new JLabel("결과: ");
		result.setBounds(340, 230, 60, 30);
		layeredPane.add(result);

		init = new JButton("초기화");
		init.setBounds(20, 200, 230, 30);
		layeredPane.add(init);

		orderList = new JTextArea("");
		orderList.setBounds(0, 0, 200, 200);

		orderBt = new JButton("주문하기");
		orderBt.setBounds(450,230, 100, 30);
		layeredPane.add(orderBt);

		orderBt.addActionListener(this);
		init.addActionListener(this);
		layeredPane.add(list);
		list.add(orderList);
		layeredPane.add(panel);
		add(layeredPane);

		setVisible(true);
	}

	int num = 0;
	ArrayList<String> buyList= new ArrayList<>();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource().equals(jb1)) // 음료 버튼
		{
			orderGo += DrinkCombo.getSelectedItem()+"\n";
			orderList.setText(orderGo);
			num += menu1Price[DrinkCombo.getSelectedIndex()];
			resultPrice.setText(num+"");
		}
		else if(e.getSource().equals(jb2)) //라면 버튼
		{
			orderGo += NDCombo.getSelectedItem()+"\n";
			orderList.setText(orderGo);
			num +=menu2Price[NDCombo.getSelectedIndex()];
			resultPrice.setText(num+"");
		}
		else if(e.getSource().equals(jb3)) // 밥 버튼
		{
			orderGo += RiceCombo.getSelectedItem()+"\n";
			orderList.setText(orderGo);
			num += menu3Price[RiceCombo.getSelectedIndex()];
			resultPrice.setText(num+"");
		}
		else if(e.getSource().equals(orderBt))
		{
			pm.setEnabled(true);
			dispose();
		}
		else if(e.getSource().equals(init))
		{
			num = 0;
			orderGo = "";
			orderList.setText(orderGo);
			resultPrice.setText(num+"");
		}
	}

	class MyPanel extends JPanel
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(img, 0, 0, null);
		}
	}
}
