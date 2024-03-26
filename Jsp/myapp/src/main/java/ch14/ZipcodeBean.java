package ch14;

public class ZipcodeBean {
private String id;
private String pwd;
private String name;
private String gender;
private String birthday;
private String email;
private String zipcode;
private String address;
private String hobby;
private String job;
private String area1;
private String area2;
private String area3;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getArea1() {
	return area1;
}
public void setArea1(String area1) {
	this.area1 = area1;
}
public String getArea2() {
	return area2;
}
public void setArea2(String area2) {
	this.area2 = area2;
}
public String getArea3() {
	return area3;
}
public void setArea3(String area3) {
	this.area3 = area3;
}
public ZipcodeBean(String zipcode, String area1, 
		String area2, String area3) {
	this.zipcode = zipcode;
	this.area1 = area1;
	this.area2 = area2;
	this.area3 = area3;
}
}
