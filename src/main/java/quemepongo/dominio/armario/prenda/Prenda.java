package quemepongo.dominio.armario.prenda;

import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;
import quemepongo.dominio.armario.prenda.detallesprenda.Color;
import quemepongo.dominio.armario.prenda.detallesprenda.Material;
import quemepongo.dominio.armario.prenda.detallesprenda.Trama;

import java.util.Objects;

public class Prenda {

  private Material material;
  private Trama trama = Trama.LISA;
  private Color colorPrimario;
  private Color colorSecundario;
  private CategoriaPrenda categoriaPrenda;
  private String tipoPrenda;
  private Integer temperaturaPromedio;

  public Prenda(Material material, Trama trama, Color colorPrimario, Color colorSecundario,String tipoPrenda, CategoriaPrenda categoriaPrenda, Integer temperaturaPromedio) {

    if(!categoriaPrenda.getValues().contains(tipoPrenda)) {
      throw new CategoriaNoSeCondiceConElTipoException(tipoPrenda, categoriaPrenda);
    }

    this.material = Objects.requireNonNull(material, "La prende DEBE tener un material definido");
    this.colorPrimario = Objects.requireNonNull(colorPrimario, "La prende DEBE tener un color primario aunque sea");
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.categoriaPrenda = Objects.requireNonNull(categoriaPrenda, "Se requiere definir un tipo de prenda");
    this.temperaturaPromedio = temperaturaPromedio;
    this.tipoPrenda = tipoPrenda;
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

  public Trama getTrama() {
    return trama;
  }

  public String getTipoPrenda() {
    return tipoPrenda;
  }

  public CategoriaPrenda getCategoriaPrenda() {
    return categoriaPrenda;
  }

  public Integer getTemperaturaPromedioRecomendada (Integer temperaturaPromedio) {
    return this.temperaturaPromedio;
  }

  public boolean esAptaParaTemperatura(int temperatura) {
    if(temperaturaPromedio == null) {
      return true;
    }
    int temperaturaMaxima = temperaturaPromedio + 10;
    int temperaturaMinima = temperaturaPromedio - 10;
    return (temperaturaMinima <= temperatura) && (temperatura <= temperaturaMaxima);
  }
}
