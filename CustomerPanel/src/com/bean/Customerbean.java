package com.bean;



public class Customerbean 
{
	private int custid;
	private String custname;
	private String custadd;
	//private String custcity;
	private String custstate;
	private String custmobile;

	private String custemail;
	private String custpassword;
	private String custemailormobile;
	private boolean valid;
	public int getCustid() 
	{
		return custid;
	}
	public void setCustid(int custid) 
	{
		this.custid = custid;
	}
	
	public String getCustname() 
	{
		return custname;
	}
	public void setCustname(String custname)
	{
		this.custname = custname;
	}
	
	public String getCustemail() 
	{
		return custemail;
	}
	public void setCustemail(String custemail) 
	{
		/*if(custemail == null)
			this.custemail = null;
		else*/
			this.custemail = custemail;
	}
	
	public String getCustpassword()
	{
		return custpassword;
	}
	public void setCustpassword(String custpassword) 
	{
		this.custpassword = custpassword;
	}
	
	public String getCustadd() 
	{
		return custadd;
	}
	public void setCustadd(String custadd) 
	{
		this.custadd = custadd;
	}
	
	/*public String getCustcity() 
	{
		return custcity;
	}
	public void setCustcity(String custcity) 
	{
		this.custcity = custcity;
	}
	*/
	public String getCuststate() 
	{
		return custstate;
	}
	public void setCuststate(String custstate) 
	{
		this.custstate = custstate;
	}
	
	public String getCustmobile() 
	{
		return custmobile;
	}
	public void setCustmobile(String custmobile) 
	{
		this.custmobile = custmobile;
	}
	
	public String getCustemailormobile() 
	{
		return custemailormobile;
	}
	public void setCustemailormobile(String custemailormobile) 
	{
		this.custemailormobile = custemailormobile;
	}
	
	public boolean isValid()
	{
		return valid;
	}
	public void setValid(boolean newValid)
	{
		valid = newValid;
	}
}
