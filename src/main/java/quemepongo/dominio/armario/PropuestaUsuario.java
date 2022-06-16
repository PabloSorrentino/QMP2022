package quemepongo.dominio.armario;

import quemepongo.dominio.armario.prenda.Prenda;

public abstract class PropuestaUsuario {
  private Guardarropa guardarropa;
  private Prenda prenda;
  private EstadoRecomendacion estado = EstadoRecomendacion.PENDIENTE;

  public PropuestaUsuario(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda;
  }

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  public void aceptarRecomendacion() {
    this.estado = EstadoRecomendacion.ACEPTADA;
    this.aceptar();
  }

  public abstract void aceptar();

  public void rechazarRecomendacion() {
    this.estado = EstadoRecomendacion.RECHAZADA;
  }

  public EstadoRecomendacion getEstado() {
    return estado;
  }

  public void revertir() {
    this.estado = EstadoRecomendacion.PENDIENTE;
    this.revertirPropuesta();
  }

  public abstract void revertirPropuesta();
}
