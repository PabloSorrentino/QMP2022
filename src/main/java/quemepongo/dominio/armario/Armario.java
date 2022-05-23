package quemepongo.dominio.armario;

import quemepongo.dominio.armario.prenda.Prenda;
import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Armario {

  private List<Prenda> prendas = new ArrayList<>();

  public Armario() {
  }

  public void agregarPrenda(Prenda prenda){
    prendas.add(prenda);
  }

  public List<Prenda> getPrendasdeTipo(CategoriaPrenda tipoPrenda) {
    return prendas.stream().filter(prenda -> prenda.getCategoriaPrenda().equals(tipoPrenda)).collect(Collectors.toList());
  }

}
