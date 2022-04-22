package quemepongo.dominio.prenda;

import quemepongo.dominio.prenda.detallesprenda.Color;
import quemepongo.dominio.prenda.detallesprenda.Material;

import java.util.Objects;

public abstract class Prenda {

  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;

  public Prenda(Material material, Color colorPrimario, Color colorSecundario) {
    this.material = Objects.requireNonNull(material, "La prende DEBE tener un material definido");
    this.colorPrimario = Objects.requireNonNull(colorPrimario, "La prende DEBE tener un color primario aunque sea");
    this.colorSecundario = colorSecundario;
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorPrimario() {
    return colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
