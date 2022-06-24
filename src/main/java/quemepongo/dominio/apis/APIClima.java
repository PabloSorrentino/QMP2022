package quemepongo.dominio.apis;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIClima implements APIClimaAdapter {

  private AccuWeatherAPI weatherAPI;
  private Duration duration;
  private Map<String, RespuestaAccuWeatherClima> respuestasAccuWeather = new HashMap<>();
  private Map<String, RespuestaAccuWeatherAlertas> alertasAccuWeather = new HashMap<>();

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

  @Override
  public String obtenerAlertaClimaticaParaCiudad(String ciudad) {
    return alertasAccuWeather.get(ciudad).getAlerta();
  }

  private void checkearConsultaApiParaCiudad(String ciudad) {
    if(!ciudadConsultadaRecientemente(ciudad)) {
      actualizarRespuestaApiParaCiudad(ciudad);
    }
  }

  private void checkearAlertaApiParaCiudad(String ciudad) {
    if(!alertaConsultadaRecientemente(ciudad)) {
      actualizarAlertaApiParaCiudad(ciudad);
    }
  }

  private boolean alertaConsultadaRecientemente(String ciudad) {
    return alertasAccuWeather.containsKey(ciudad) &&
        alertasAccuWeather
            .get(ciudad)
            .getMomentoConsuta()
            .plusHours(duration.toHours())
            .isAfter(LocalDateTime.now());
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
    this.actualizarRespuestaApiClima(ciudad);
  }

  public void actualizarAlertaApiParaCiudad(String ciudad) {
    this.actualizarRespuestaApiAlertas(ciudad);
  }

  private void actualizarRespuestaApiClima(String ciudad) {
    List<Map<String, Object>> respuestaApi = weatherAPI.getWeather(ciudad);
    RespuestaAccuWeatherClima respuesta = new RespuestaAccuWeatherClima(ciudad,
        respuestaApi,
        LocalDateTime.now());
    respuestasAccuWeather.put(ciudad, respuesta);
  }

  private void actualizarRespuestaApiAlertas(String ciudad) {
    Map<String, Object> alertasApi = weatherAPI.getAlerts(ciudad);
    RespuestaAccuWeatherAlertas respuesta = new RespuestaAccuWeatherAlertas(ciudad,
        alertasApi,
        LocalDateTime.now());
    alertasAccuWeather.put(ciudad, respuesta);
  }

}
