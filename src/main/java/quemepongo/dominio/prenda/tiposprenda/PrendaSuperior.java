package quemepongo.dominio.prenda.tiposprenda;
import quemepongo.dominio.prenda.Prenda;
import quemepongo.dominio.prenda.detallesprenda.Color;
import quemepongo.dominio.prenda.detallesprenda.Material;

import java.util.Objects;

public class PrendaSuperior extends Prenda {

  private TipoPrendaSuperior tipoPrendaSuperior;

  public PrendaSuperior(Material material, Color colorPrimario, Color colorSecundario, TipoPrendaSuperior tipoPrendaSuperior) {
    super(material, colorPrimario, colorSecundario);
    this.tipoPrendaSuperior = Objects.requireNonNull(tipoPrendaSuperior, "Requiere definir un tipo de prenda superior");
  }

  public TipoPrendaSuperior getTipoPrendaSuperior() {
    return tipoPrendaSuperior;
  }
}
