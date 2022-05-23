package quemepongo.dominio.armario;


import quemepongo.dominio.armario.prenda.Prenda;
import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Atuendo {

  private List<Prenda> prendas;

  public Atuendo(Prenda ... prendas){
    this.prendas = Arrays.asList(prendas);
  }

  public Prenda getPrendaDeCategoria(CategoriaPrenda categoriaPrenda) {
    Predicate<Prenda> filtroPrenda = prenda -> prenda.getCategoriaPrenda().equals(categoriaPrenda);
    Optional<Prenda> prenda = prendas.stream().filter(filtroPrenda).findFirst();
    if (!prenda.isPresent()) {
      throw new PrendaNoDefinidaException("No se definio " + categoriaPrenda.toString() + " para este atuendo");
    }
    return prenda.get();
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }
}
