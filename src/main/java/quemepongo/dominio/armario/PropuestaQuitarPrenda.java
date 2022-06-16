package quemepongo.dominio.armario;

import quemepongo.dominio.armario.prenda.Prenda;

public class PropuestaQuitarPrenda extends PropuestaUsuario {

  public PropuestaQuitarPrenda(Guardarropa guardarropa, Prenda prenda) {
    super(guardarropa, prenda);
  }

  @Override
  public void aceptar() {
    getGuardarropa().quitarPrenda(getPrenda());
  }

  @Override
  public void revertirPropuesta() {
    getGuardarropa().agregarPrenda(getPrenda());
  }

}
