package server.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Member_Dao { // 데이터베이스에 접근하는 클래스객체.

   Connection con = null;
   Statement stmt = null;
   ResultSet rs = null;
   String sql = null;

//   private static final String User = "hr";
//   private static final String Pass = "hr";
   
   public Member_Dao() {
      // TODO Auto-generated constructor stub
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로딩
         con = DriverManager.getConnection( // 드라이버 연결
               "jdbc:oracle:thin:@localhost:1521:orcl",
               "hr","hr"
               );

         stmt = con.createStatement();

      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }


   /////리스트가져오기
   public ArrayList<Member_Dto> list()
   {
      ArrayList<Member_Dto> res = new ArrayList<>();

      try {

         sql ="select * from MEMBER";
         rs = stmt.executeQuery(sql);

         //birth, tel, email, regdate, grade

         while(rs.next())
         {
            Member_Dto dto = new Member_Dto();
            dto.name = rs.getString("name");
            dto.id = rs.getString("id");
            dto.pw = rs.getString("pw");
            dto.birth = rs.getDate("birth");
            dto.tel = rs.getString("tel");
            dto.ad = rs.getString("address");
            dto.que = rs.getString("q");
            dto.ans = rs.getString("ans");
            dto.join = rs.getDate("join");
            dto.totalT = rs.getString("totalT");
            dto.totalP = rs.getString("totalP");


            res.add(dto);
         }

      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         close();
      }

      return res;
   }


   ///삽입
   public void insert(Member_Dto dto)
   {
      try {

         sql = "insert into member (name,id,pw,birth,tel,address,q,ans,join,totalT,totalP) "+"values ('"+
                     dto.name+
               "','"+dto.id+
               "','"+dto.pw+
               "','"+dto.getBirStr()+
               "','"+dto.tel+
               "','"+dto.ad+
               "','"+dto.que+
               "','"+dto.ans+
               "','"+dto.getJoinStr()+
               "','"+dto.totalT+
               "','"+dto.totalP+
               "')";
         
         stmt.executeUpdate(sql);

      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         close();
      }
   }

   public void close()
   {
      if(rs!=null) try {rs.close();} catch (SQLException e) {}
      if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
      if(con!=null) try {con.close();} catch (SQLException e) {}

   }

}