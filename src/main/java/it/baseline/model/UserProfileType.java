package it.baseline.model;

public enum UserProfileType {
	MMG("MMG"),
	INF("INF");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
