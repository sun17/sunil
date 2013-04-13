package com.example.androidhive;

public class Result 
{
	public String Content;
	public  String Format;		
	
	public Result()
	{
		
	}
	public Result(String content,String format)
	{
		Content=content;
		Format=format;
	}
	public String getContents()
	{
		return Content;
	}
	public String getFormatName()
	{
		return Format;
	}
	public String getText() {
		// TODO Auto-generated method stub
		return Content;
	}

}
