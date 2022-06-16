package quemepongo.dominio.armario;

import quemepongo.dominio.armario.prenda.Prenda;
import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Guardarropa {

  private final List<Prenda> prendas = new ArrayList<>();
  private String criterio = "ropa default";
  private final List<PropuestaUsuario> propuestas = new ArrayList<>();

  public Guardarropa() {
  }

  public String getCriterio() {
    return criterio;
  }

  public void setCriterio(String criterio) {
    this.criterio = criterio;
  }

  public void agregarPrenda(Prenda prenda){
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
      prendas.remove(prenda);
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public List<Prenda> getPrendasdeTipo(CategoriaPrenda tipoPrenda) {
    return prendas.stream().filter(prenda -> prenda.getCategoriaPrenda().equals(tipoPrenda)).collect(Collectors.toList());
  }

  public List<PropuestaUsuario> getPropuestas() {
    return propuestas;
  }

  public List<PropuestaUsuario> getPropuestasPendientes() {
    return propuestas
        .stream()
        .filter(reco -> reco.getEstado().equals(EstadoRecomendacion.PENDIENTE))
        .collect(Collectors.toList());
  }

  public void agregarPropuesta(PropuestaUsuario propuestaUsuario) {
    propuestas.add(propuestaUsuario);
  }

}
