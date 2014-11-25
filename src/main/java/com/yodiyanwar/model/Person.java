package com.yodiyanwar.model;

public class Person{
	private int nik;
	private String nama;
	private String alamat;

	public void setNik(int nik){
		this.nik = nik;
	}
	public int getNik(){
		return nik;
	}

	public void setNama(String nama){
		this.nama = nama;
	}
	public String getNama(){
		return nama;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
	public String getAlamat(){
		return alamat;
	}
}