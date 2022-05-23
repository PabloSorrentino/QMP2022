package quemepongo.dominio.armario;

import quemepongo.dominio.apis.APIClima;
import quemepongo.dominio.armario.prenda.Prenda;
import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;

import java.util.function.Predicate;

public class Recomendador {

  private APIClima apiClima;
  private Armario armario;

  public Recomendador(APIClima apiClima) {
    this.apiClima = apiClima;
  }

  public void setApiClima(APIClima apiClima) {
    this.apiClima = apiClima;
  }

  public Atuendo generarAtuendoSegunTemperaturaHoy(Armario armario) {
    this.armario = armario;
    int temperatura = apiClima.obtenerCondicionesClimaticasParaCiudad("Buenos Aires, Argentina");
    Prenda prendaSuperior= this.prendaRecomendada(CategoriaPrenda.PARTE_SUPERIOR, temperatura);
    Prenda prendaInferior = this.prendaRecomendada(CategoriaPrenda.PARTE_INFERIOR, temperatura);
    Prenda calzado = this.prendaRecomendada(CategoriaPrenda.CALZADO, temperatura);
    Prenda accesorio = this.prendaRecomendada(CategoriaPrenda.ACCESORIO, temperatura);
    return new Atuendo(prendaSuperior, prendaInferior, calzado, accesorio);
  }

  public Prenda prendaRecomendada(CategoriaPrenda tipoPrenda, int temperatura) {
    Predicate<Prenda> prendaRecomendada = prenda -> prenda.esAptaParaTemperatura(temperatura);
    return armario
        .getPrendasdeTipo(tipoPrenda)
        .stream()
        .filter(prendaRecomendada)
        .findFirst()
        .get();
  }

}
