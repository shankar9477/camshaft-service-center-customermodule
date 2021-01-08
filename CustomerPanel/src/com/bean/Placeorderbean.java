package com.bean;


public class Placeorderbean
{
private int orderid;
private String vehino;
private String brand;
private String model;
private String services;
private String exptime;
//private int custworkorderid;
private int custid;
/*private String custvehicleno;
private String custbrand;
private String custmodel;
private String custservices;
private String custorderdate;
private String custexpectedtime;

*/


public int getOrderid() {
	return orderid;
}
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public String getVehino() {
	return vehino;
}
public void setVehino(String vehino) {
	this.vehino = vehino;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getServices() {
	return services;
}
public void setServices(String services) {
	this.services = services;
}
public String getExptime() {
	return exptime;
}
public void setExptime(String exptime) {
	this.exptime = exptime;
}


}
