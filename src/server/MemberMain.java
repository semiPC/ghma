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
         Class.forName("oracle.jdbc.driver.OracleDriver"); // 찾는 게 없을 수도 있으니까 try_Catch
         Connection con = DriverManager.getConnection(
               "jdbc:oracle:thin:@localhost:1521:orcl",
               "hr", "hr"
               );
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from member"); // 쿼리에서 날린 결과를 가져올 것ㅇ ㅣ다.
         
         while(rs.next()) // 다음값이 있는동안 순서대로 돌린다
         {
            // 여기 변수명은 내 맘대로! 컬럼명은 정확한 이름 땡겨와야함.
            String id = rs.getString("id"); // 컬럼명을 땡기는것
            String pw = rs.getString("pw");
            String name = rs.getString("name");
            Date birth = rs.getDate("birth"); //util로 땡기는거
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