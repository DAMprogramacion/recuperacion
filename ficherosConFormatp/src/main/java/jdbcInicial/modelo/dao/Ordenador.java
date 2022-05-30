package jdbcInicial.modelo.dao;

public class Ordenador {
	
	private int id;
	private int ram;
	private float cpu;
	private int capacidadDisco;
	private TipoDisco tipoDisco;
	private Marca marca;
	
	public Ordenador(int id,int ram, float cpu, int capacidadDisco, TipoDisco tipoDisco, Marca marca) {
		this.id             = id;
		this.ram            = ram;
		this.cpu            = cpu;
		this.capacidadDisco = capacidadDisco;
		this.tipoDisco      = tipoDisco;
		this.marca          = marca;
	}
	public Ordenador(int ram, float cpu, int capacidadDisco, TipoDisco tipoDisco, Marca marca) {
		this.ram            = ram;
		this.cpu            = cpu;
		this.capacidadDisco = capacidadDisco;
		this.tipoDisco      = tipoDisco;
		this.marca          = marca;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ordenador() {}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public float getCpu() {
		return cpu;
	}

	public void setCpu(float cpu) {
		this.cpu = cpu;
	}

	public int getCapacidadDisco() {
		return capacidadDisco;
	}

	public void setCapacidadDisco(int capacidadDisco) {
		this.capacidadDisco = capacidadDisco;
	}

	public TipoDisco getTipoDisco() {
		return tipoDisco;
	}

	public void setTipoDisco(TipoDisco tipoDisco) {
		this.tipoDisco = tipoDisco;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d,%.2f,%d,%s,%s",
				 ram, cpu,capacidadDisco, tipoDisco, marca);
	}

}
