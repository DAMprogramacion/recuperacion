package ficherosConFormatp;

public class Company {
	//name,sector,symbol,cap
	private String name;
	private String sector;
	private String symbol;
	private String cap;
	public Company(String name, String sector, String symbol, String cap) {
		
		this.name = name;
		this.sector = sector;
		this.symbol = symbol;
		this.cap = cap;
	}
	public Company() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	@Override
	public String toString() {
		return String.format("Company [name=%s, sector=%s, symbol=%s, cap=%s]", name, sector, symbol, cap);
	}
	
	
	
	
	
	
	
}
