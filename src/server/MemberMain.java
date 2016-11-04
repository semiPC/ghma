package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class MemberMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver"); // ã�� �� ���� ���� �����ϱ� try_Catch
         Connection con = DriverManager.getConnection(
               "jdbc:oracle:thin:@localhost:1521:orcl",
               "hr", "hr"
               );
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from member"); // �������� ���� ����� ������ �ͤ� �Ӵ�.
         
         while(rs.next()) // �������� �ִµ��� ������� ������
         {
            // ���� �������� �� �����! �÷����� ��Ȯ�� �̸� ���ܿ;���.
            String id = rs.getString("id"); // �÷����� ����°�
            String pw = rs.getString("pw");
            String name = rs.getString("name");
            Date birth = rs.getDate("birth"); //util�� ����°�
            String tel = rs.getString("tel");
            String ad = rs.getString("address");
            String que = rs.getString("q");
            String ans = rs.getString("ans");
            Date join = rs.getDate("join");
            String totalT = rs.getString("totalT"); // timestamp
            String totalP = rs.getString("totalP");
            
         }
         
         rs.close();
         stmt.close();
         con.close();
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}