package com.msd.ham.utils;

public class testEx {
	
	public static void main(String[] args) {
		LeerExcel le = new LeerExcel();
		try {
			le.LeerEx();
		} catch (Exception e) {
			System.out.println("Error en Test Excel :::>> " + e.getMessage());
		}

	}

}
