package quemepongo.dominio.armario.prenda.detallesprenda;

import java.util.*;

public enum CategoriaPrenda {

  PARTE_SUPERIOR("remera", "remera manga larga","campera","sweater", "remera manga corta", "camisa", "musculosa"),
  PARTE_INFERIOR("pantalon", "pollera", "short"),
  CALZADO("zapato", "zapatilla", "bota", "hojota"),
  ACCESORIO("anteojo", "anteojo de sol" , "cinturon", "mochila", "cartera", "reloj");


  private final List<String> values;


  CategoriaPrenda(String ... values) {

    this.values = Arrays.asList(values);
  }

  public List<String> getValues() {
    return values;
  }

}
