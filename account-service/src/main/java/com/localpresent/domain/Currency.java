package com.localpresent.domain;

public enum Currency {
	USD, EUR;
	
	public static Currency getDefault(){
		return USD;
	}
}
