package com.pace.jdbc.main;

import com.pace.jdbc.ReadData;

public class MainReadData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReadData rd=new ReadData();
		rd.registerDriver();
		rd.getDetails();
		
	}

}
