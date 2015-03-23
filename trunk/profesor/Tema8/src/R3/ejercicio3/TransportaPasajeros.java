package R3.ejercicio3;

public interface TransportaPasajeros {
	public boolean subirPasajero(Persona p);
	public boolean bajarPasajero(Persona p);
	Persona[] getEstadoOcupacion();
	public int getNumActualPasajeros();
	public int getNumMaximoPasajeros();
	public int getNumPlazasLibres();
	
}
