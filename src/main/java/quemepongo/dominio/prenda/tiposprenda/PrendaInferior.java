package quemepongo.dominio.prenda.tiposprenda;
import quemepongo.dominio.prenda.Prenda;
import quemepongo.dominio.prenda.detallesprenda.Color;
import quemepongo.dominio.prenda.detallesprenda.Material;

import java.util.Objects;

public class PrendaInferior extends Prenda {

  private TipoPrendaInferior tipoPrendaInferior;

  public PrendaInferior( TipoPrendaInferior tipoPrendaInferior, Material material, Color colorPrimario, Color colorSecundario) {
    super(material, colorPrimario, colorSecundario);
    this.tipoPrendaInferior = Objects.requireNonNull(tipoPrendaInferior, "Se requiere especificar un tipo de prenda");
  }

  public TipoPrendaInferior getTipoPrendaInferior() {
    return tipoPrendaInferior;
  }
}
