package quemepongo.dominio.prenda.tiposprenda;
import quemepongo.dominio.prenda.Prenda;
import quemepongo.dominio.prenda.detallesprenda.Color;
import quemepongo.dominio.prenda.detallesprenda.Material;

import java.util.Objects;

public class Calzado extends Prenda {

  private TipoCalzado tipoCalzado;

  public Calzado(TipoCalzado tipoCalzado, Material material, Color colorPrimario, Color colorSecundario) {
    super(material, colorPrimario, colorSecundario);
    this.tipoCalzado = Objects.requireNonNull(tipoCalzado, "Se debe definir un tipo calzado de la lista");
  }

  public TipoCalzado getTipoCalzado() {
    return tipoCalzado;
  }

}
