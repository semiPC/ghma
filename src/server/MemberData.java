package server;

import java.util.ArrayList;

import server.model.Member_Dao;
import server.model.Member_Dto;

import server.model.Member_Dao;
import server.model.Member_Dto;


public class MemberData {

	public MemberData(ArrayList dtoInput) {
		// TODO Auto-generated constructor stub
		
		ArrayList<Member_Dto>list = new Member_Dao().list(); // 뭐 하나 해줄때마다 생성해준다

		for (Member_Dto dto : list) {
			System.out.println(dto);
		}      

		Member_Dto dto = new Member_Dto();
		dto.setName(dtoInput.get(0)+"");
		dto.setId(dtoInput.get(1)+"");
		dto.setPw(dtoInput.get(2)+"");
		dto.setBirStr(dtoInput.get(3)+"");
		dto.setTel(dtoInput.get(4)+"");
		dto.setAd(dtoInput.get(5)+"");
		dto.setQue(dtoInput.get(6)+"");
		dto.setAns(dtoInput.get(7)+"");
		dto.setJoinStr(dtoInput.get(8)+"");
		dto.setTotalT(dtoInput.get(9)+"");
		dto.setTotalP(dtoInput.get(10)+"");

		new Member_Dao().insert(dto); // 뭐 하나 해줄때마다 생성


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

}