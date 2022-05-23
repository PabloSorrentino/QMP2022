package quemepongo.dominio.apis;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIClima implements APIClimaAdapter {

  private AccuWeatherAPI weatherAPI;
  private Duration duration;
  private Map<String, RespuestaAccuWeather> respuestasAccuWeather = new HashMap<>();

  public APIClima(AccuWeatherAPI weatherAPI, Duration duration) {
    this.weatherAPI = weatherAPI;
    this.duration = duration;
  }

  public AccuWeatherAPI getWeatherAPI() {
    return weatherAPI;
  }

  public void setWeatherAPI(AccuWeatherAPI weatherAPI) {
    this.weatherAPI = weatherAPI;
  }

  @Override
  public int obtenerCondicionesClimaticasParaCiudad(String ciudad) {
    checkearConsultaApiParaCiudad(ciudad);
    return respuestasAccuWeather.get(ciudad).getProbabilidadPrecipitacion();
  }

  @Override
  public int obtenerTemperaturaEnCentigradosParaCiudad(String ciudad) {
    checkearConsultaApiParaCiudad(ciudad);
    return respuestasAccuWeather.get(ciudad).getTemperatura();
  }

  private void checkearConsultaApiParaCiudad(String ciudad) {
    if(!ciudadConsultadaRecientemente(ciudad)) {
      actualizarRespuestaApiParaCiudad(ciudad);
    }
  }

  private boolean ciudadConsultadaRecientemente(String ciudad) {
    return respuestasAccuWeather.containsKey(ciudad) &&
        respuestasAccuWeather
        .get(ciudad)
        .getMomentoConsuta()
        .plusHours(duration.toHours())
        .isAfter(LocalDateTime.now());
  }

  private void actualizarRespuestaApiParaCiudad(String ciudad) {
    List<Map<String, Object>> respuestaApi = weatherAPI.getWeather("Buenos Aires, Argentina");
    RespuestaAccuWeather respuesta = new RespuestaAccuWeather (ciudad,
        respuestaApi,
        LocalDateTime.now());
    respuestasAccuWeather.put(ciudad, respuesta);
  }

}
