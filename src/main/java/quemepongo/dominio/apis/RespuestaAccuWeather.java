package quemepongo.dominio.apis;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class RespuestaAccuWeather {
  private String ciudad;
  private List<Map<String, Object>> respuestaApi;
  private LocalDateTime momentoConsuta;

  public RespuestaAccuWeather(String ciudad, List<Map<String, Object>> respuestaApi, LocalDateTime momentoConsulta) {
  this.ciudad = ciudad;
  this.respuestaApi = respuestaApi;
  this.momentoConsuta = momentoConsulta;
  }

  public List<Map<String, Object>> getRespuestaApi() {
    return respuestaApi;
  }

  public int getProbabilidadPrecipitacion() {
    return (int) respuestaApi.get(0).get("PrecipitationProbability");
  }

  public int getTemperatura(){
    return ( (int) respuestaApi.get(0).get("Temperature") - 32 ) * 5 / 9;
  }

  public LocalDateTime getMomentoConsuta() {
    return momentoConsuta;
  }

  public String getCiudad() {
    return ciudad;
  }

}
