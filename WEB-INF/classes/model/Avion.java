package model;

public class Avion {
	private int mat ;
	private String brand ;
	private String locCity ;
	
	public Avion(int mat, String brand, String locCity) {
		this.mat = mat;
		this.brand = brand;
		this.locCity = locCity;
	}

	public int getMat() {
		return mat;
	}

	public String getBrand() {
		return brand;
	}

	public String getLocCity() {
		return locCity;
	}
	
	

}
