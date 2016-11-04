package server.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member_Dto { // 한명의 회원 정보를 저장하는 클래스 

   public String id ; // 얘네들이 여기 멤버변수로 있으면 된다.
   public String pw;
   public String name ;
   public Date birth; 
   public String tel ;   
   public String ad;
   public String que;
   public String ans;   
   public Date join;
   public String totalT; //timestamp
   public String totalP;
   
   SimpleDateFormat birth2 = new SimpleDateFormat("yyyy-MM-dd");
   SimpleDateFormat join2 = new SimpleDateFormat("yyyy-MM-dd");
//   SimpleDateFormat totalT2 = new SimpleDateFormat("hh:mm:ss");

   
   public String getBirStr() {
      return birth2.format(birth);
   }
   public String getJoinStr() {
      return join2.format(join);
   }
//   public String getTTStr() {
//      return totalT2.format(totalT);
//   }

   public void setBirStr(String birStr) {
      try {         
            birth = birth2.parse(birStr);
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
   }
   public void setJoinStr(String joinStr) {
      try {         
            join = join2.parse(joinStr);
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
   }
/*   public void setTTStr(String TTStr) {
      try {         
            totalT = totalT2.parse(TTStr);
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
   }*/
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Date getBirth() {
      return birth;
   }
   public void setBirth(Date birth) {
      this.birth = birth;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getAd() {
      return ad;
   }
   public void setAd(String ad) {
      this.ad = ad;
   }
   public String getQue() {
      return que;
   }
   public void setQue(String que) {
      this.que = que;
   }
   public String getAns() {
      return ans;
   }
   public void setAns(String ans) {
      this.ans = ans;
   }
   public Date getJoin() {
      return join;
   }
   public void setJoin(Date join) {
      this.join = join;
   }
   public String getTotalT() {
      return totalT;
   }
   public void setTotalT(String totalT) {
      this.totalT = totalT;
   }
   public String getTotalP() {
      return totalP;
   }
   public void setTotalP(String totalP) {
      this.totalP = totalP;
   }

   

   @Override
   public String toString() {
      return "Member_Dto [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", tel=" + tel + ", ad="
            + ad + ", que=" + que + ", ans=" + ans + ", join=" + join + ", totalT=" + totalT + ", totalP=" + totalP
            +  ", birth2=" + birth2 + ", join2=" + join2 +  "]";
   }
   
   
}