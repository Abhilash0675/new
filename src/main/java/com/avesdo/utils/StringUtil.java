package com.avesdo.utils;

public class StringUtil
{
	public static boolean hasValue(String str)
	{
		if (str != null && str.length() > 0)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String str)
	{
		if (str != null && str.length() > 0)
		{
			try
			{
				Integer.parseInt(str);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		return false;
	}
}
