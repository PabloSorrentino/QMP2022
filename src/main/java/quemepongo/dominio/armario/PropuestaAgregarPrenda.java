package quemepongo.dominio.armario;

import quemepongo.dominio.armario.prenda.Prenda;

public class PropuestaAgregarPrenda extends PropuestaUsuario {

  public PropuestaAgregarPrenda(Guardarropa guardarropa, Prenda prenda) {
    super(guardarropa, prenda);
  }

  @Override
  public void aceptar() {
    getGuardarropa().agregarPrenda(getPrenda());
  }

  @Override
  public void revertirPropuesta() {
    getGuardarropa().quitarPrenda(getPrenda());
  }


}
