package model;

public class Hospedagem {
	private int id;
	private String incluso;
	private int diarias;
	
	public Hospedagem() {
		
	}
	
	public Hospedagem(int id, String incluso, int diarias) {
		this.id = id;
		this.incluso = incluso;
		this.diarias = diarias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIncluso() {
		return incluso;
	}

	public void setIncluso(String incluso) {
		this.incluso = incluso;
	}

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	
}
