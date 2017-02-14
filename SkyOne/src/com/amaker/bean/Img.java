package com.amaker.bean;

/*
******************************************************************************
*Copyright(c).
*Allrightsreserved.
*
*File 		$ProjectName: SkyOne$
*Author		$Author:jian Wang$
*Version	$Revision:0.0.1$
*Date$Date:	2016/2/14 18:33$
*Description
*	a Bean of the imgtable table 
******************************************************************************
*/

public class Img {
	
	private int userId;		//forign User.id
	
	//YYYY-MM-DD hh:mm:ss
	private String url;		// url = /userId/YYYYMMDDhhmmss.jpg
	
	private String date;	//YYYY-MM-DD

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
