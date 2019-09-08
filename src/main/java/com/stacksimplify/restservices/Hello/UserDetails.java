package com.stacksimplify.restservices.Hello;

public class UserDetails {

	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNanme() {
		return lastNanme;
	}
	public void setLastNanme(String lastNanme) {
		this.lastNanme = lastNanme;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private String lastNanme;
	private String city;
	public UserDetails(String firstName, String lastNanme, String city) {
		
		this.firstName = firstName;
		this.lastNanme = lastNanme;
		this.city = city;
	}
	//ToString
	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastNanme=" + lastNanme + ", city=" + city + "]";
	}
	
	
	
}
