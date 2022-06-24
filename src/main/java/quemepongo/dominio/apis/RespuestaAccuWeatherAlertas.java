package quemepongo.dominio.apis;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RespuestaAccuWeatherAlertas {
  private String ciudad;
  private Map<String, Object> alertaApi;
  private LocalDateTime momentoConsuta;

  public RespuestaAccuWeatherAlertas(String ciudad, Map<String, Object> alertaApi, LocalDateTime momentoConsulta) {
  this.ciudad = ciudad;
  this.alertaApi = alertaApi;
  this.momentoConsuta = momentoConsulta;
  }

  public LocalDateTime getMomentoConsuta() {
    return momentoConsuta;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getAlerta(){
    Random r = new Random();
    int randomitem = r.nextInt(alertaApi.size());
    List<String> alertas = (List<String>) alertaApi.get("CurrentAlerts");
    return  alertas.get(randomitem);
  }

}
