package quemepongo.dominio;

import quemepongo.dominio.prenda.tiposprenda.Accesorio;
import quemepongo.dominio.prenda.tiposprenda.Calzado;
import quemepongo.dominio.prenda.tiposprenda.PrendaInferior;
import quemepongo.dominio.prenda.tiposprenda.PrendaSuperior;

public class Atuendo {

  private PrendaSuperior prendaSuperior;
  private PrendaInferior prendaInferior;
  private Calzado calzado;
  private Accesorio accesorio;

  public Atuendo(PrendaSuperior prendaSuperior, PrendaInferior prendaInferior,
                 Calzado calzado, Accesorio accesorio) {
    this.prendaSuperior = prendaSuperior; // un atuendo puede no tener todas las prendas definidas.
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
    this.accesorio = accesorio;
  }

  public PrendaSuperior getPrendaSuperior() {
    return prendaSuperior;
  }

  public void setPrendaSuperior(PrendaSuperior prendaSuperior) {
    this.prendaSuperior = prendaSuperior;
  }

  public PrendaInferior getPrendaInferior() {
    return prendaInferior;
  }

  public void setPrendaInferior(PrendaInferior prendaInferior) {
    this.prendaInferior = prendaInferior;
  }

  public Calzado getCalzado() {
    return calzado;
  }

  public void setCalzado(Calzado calzado) {
    this.calzado = calzado;
  }

  public Accesorio getAccesorio() {
    return accesorio;
  }

  public void setAccesorio(Accesorio accesorio) {
    this.accesorio = accesorio;
  }
}
