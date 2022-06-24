package quemepongo.dominio.usuario;

import quemepongo.dominio.armario.Atuendo;
import quemepongo.dominio.armario.Guardarropa;
import quemepongo.dominio.armario.PropuestaAgregarPrenda;
import quemepongo.dominio.armario.PropuestaQuitarPrenda;
import quemepongo.dominio.armario.prenda.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

  private final List<Guardarropa> guardarropas = new ArrayList<>();
  private Atuendo atuendoSugerido;
  public void agregarGuardarropa(Guardarropa guardarropa) {
    guardarropas.add(guardarropa);
  }

  public Guardarropa crearNuevoGuardarropa(){
    Guardarropa guardarropa = new Guardarropa();
    guardarropas.add(guardarropa);
    return guardarropa;
  }

  public void quitarGuardarropa(Guardarropa guardarropa) {
    guardarropas.remove(guardarropa);
  }

  public List<Guardarropa> getGuardarropasSegunCriterio(String criterio) {
   return guardarropas.stream()
        .filter(guardarropa -> guardarropa.getCriterio().equals(criterio))
        .collect(Collectors.toList());
  }

  public List<Guardarropa> getListaMisGuardarropas() {
    return guardarropas;
  }

  public void compartirGuardarropaCon(Usuario otroUsuario, Guardarropa guardarropa) {
    otroUsuario.agregarGuardarropa(guardarropa);
  }

  public List<Guardarropa> getListaGuardarropas() {
    return guardarropas;
  }

  public void recomendarAgregarPrenda(Guardarropa guardarropa, Prenda prenda) {
    PropuestaAgregarPrenda reco = new PropuestaAgregarPrenda(guardarropa, prenda);
    guardarropa.agregarPropuesta(reco);
  }

  public void recomendarQuitarPrenda(Guardarropa guardarropa, Prenda prenda) {
    PropuestaQuitarPrenda reco = new PropuestaQuitarPrenda(guardarropa, prenda);
    guardarropa.agregarPropuesta(reco);
  }

  public void setAtuendoSugerido(Atuendo sugerenciaDiaria) {
    this.atuendoSugerido = sugerenciaDiaria;
  }

  public Atuendo getAtuendoSugerido() {
    if(atuendoSugerido == null) {
      throw new NoSeGeneroSugerenciaException();
    }
    return atuendoSugerido;
  }


}
