package admin;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
 
//192.168.43.121
 
class FFF extends JFrame implements ActionListener {
    Admin_Chat_Server tcp;
 
    Admin_Pc mm;
    
    JButton jbb = new JButton("������");
    JTextField jf = new JTextField();
    JTextArea jta = new JTextArea();
 
    JButton jjj = new JButton("��ư�� �����ּ���"); // ��ư��
    JLabel jljl = new JLabel(" "); // �޼���
 
    JTextField jtff = new JTextField(""); // ������ �ּ� ������
    JTextField jtff1 = new JTextField(""); // ��Ʈ��ȣ ������
 
    String sss = "";
    String sss1 = "";
 
    String str = "";
    String str1 = "";
 
    DataOutputStream dos;
    String name;
    String name1 = "��ȣ : ";
 
    int cnt = 1;
    int cnt1 = 0;
 
    public FFF(Admin_Pc mm) {
        // TODO Auto-generated constructor stub
    	
    	 try {
             Socket socket = new Socket("127.0.0.1", 7777);
  
             jljl.setText("���� ���� ����!!!!!!");
             System.out.println("���� ���� ����");
  
             new TCPSingleSender(socket).start();
             new TCPSingleReceiver(socket).start();
  
         } catch (IOException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         }
    	
        setBounds(100, 100, 500, 700);
        setLayout(null);
 
        this.mm = mm;
        JLabel jl = new JLabel("ê�� ����!!!!!!!!!!!!!!");
        jl.setBounds(200, 30, 150, 50);
        add(jl);
 
        jta.setBounds(35, 70, 400, 400);
        add(jta);
 
        DefaultCaret scupdate = (DefaultCaret) jta.getCaret();
        scupdate.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
 
        JScrollPane jp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // ��ũ�ѹ� ������Ʈ
 
        jp.setBounds(35, 100, 400, 400);
 
        add(jp);
 
        jf.setBounds(35, 520, 400, 30);
        jf.addActionListener(this);
        add(jf);
 
        jbb.setBounds(35, 570, 400, 50);
        add(jbb);
 
        JLabel jlj = new JLabel("IP �ּ�");
        JLabel jlj1 = new JLabel("��Ʈ ��ȣ");
 
        jjj.setBounds(600, 230, 150, 30); // ��ư
        jtff.setBounds(600, 130, 150, 30); // ������ �ּ�
        jtff1.setBounds(600, 170, 150, 30); // ��Ʈ��ȣ
        jlj.setBounds(530, 130, 60, 50); // ������ �ּ� ��
        jlj1.setBounds(530, 170, 70, 50); // ��Ʈ��ȣ ��
        jljl.setBounds(530, 330, 130, 50); // �޼���
        add(jjj);
        add(jtff);
        add(jtff1);
        add(jlj);
        add(jlj1);
        add(jljl);
 
        jbb.addActionListener(this);
        jjj.addActionListener(this);
 
        setVisible(true);
 
    }
 
    class TCPSingleSender extends Thread {
 
        public TCPSingleSender(Socket socket) {
            // TODO Auto-generated constructor stub
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                name = "[" + socket.getLocalAddress() + "]";
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 
        @Override
        public void run() {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
 
            while (dos != null) {
                try {
                    str1 = jf.getText();
                    dos.writeUTF(name + sc.nextLine() + str);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
 
    }
 
    class TCPSingleReceiver extends Thread {
        DataInputStream dis;
 
        public TCPSingleReceiver(Socket socket) {
            // TODO Auto-generated constructor stub
            try {
                dis = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (dis != null) {
                try {
 
                    str += dis.readUTF() + "\n";
                    jta.setText(str);
                    // System.out.println(dis.readUTF());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
 
        if (cnt == 0) {
            ipstart();
            cnt = 1;
        }
        if (cnt == 1) {
            chatstart();
        }
 
    }
 
    void ipstart() {
        sss = jtff.getText(); // ������ �ּ� �޾ƿ���
        sss1 = jtff1.getText(); // ��Ʈ��ȣ �޾ƿ���
        int s1 = Integer.parseInt(sss1); // ��Ʈ ��ȣ ��Ƽ�� ����ȯ
 
       
    }
 
    void chatstart() {
 
        try {
            if (cnt1 == 0) {
                dos.writeUTF(name1 + "����!!!!!");
                cnt1 = 1;
            } else
                dos.writeUTF(name1 + jf.getText());
            jf.setText("");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
 
}
 
public class Admin_Chat_Client {
 
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
// 
//        new FFF();
// 
//    }
 
}