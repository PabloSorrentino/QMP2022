package quemepongo.dominio.apis;

public interface APIClimaAdapter {

  public int obtenerCondicionesClimaticasParaCiudad(String ciudad);

  public int obtenerTemperaturaEnCentigradosParaCiudad(String ciudad);

  public String obtenerAlertaClimaticaParaCiudad(String ciudad);

}
