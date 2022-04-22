package quemepongo.dominio.prenda.tiposprenda;

import quemepongo.dominio.prenda.Prenda;
import quemepongo.dominio.prenda.detallesprenda.Color;
import quemepongo.dominio.prenda.detallesprenda.Material;

import java.util.Objects;

public class Accesorio extends Prenda {

  private TipoAccesorio tipoAccesorio;

  public Accesorio(TipoAccesorio tipoAccesorio, Material material, Color colorPrimario, Color colorSecundario) {
    super(material, colorPrimario, colorSecundario);
    this.tipoAccesorio = Objects.requireNonNull(tipoAccesorio, "Requiere un tipo de accesorio definido");
  }

  public TipoAccesorio getTipoAccesorio() {
    return tipoAccesorio;
  }
}
