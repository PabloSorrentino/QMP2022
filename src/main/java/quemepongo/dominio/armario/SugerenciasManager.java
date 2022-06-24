package quemepongo.dominio.armario;

import quemepongo.dominio.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SugerenciasManager {

  private List<Usuario> usuarios = new ArrayList<>();
  private Recomendador recomendador;

  public SugerenciasManager(Recomendador recomendador) {
    this.recomendador = recomendador;
  }

  public void subscribirUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  public void desubscribirUsuario(Usuario usuario) {
    usuarios.remove(usuario);
  }

  public void generarSugerenciasDiarias() {
    usuarios
        .stream()
        .forEach(usuario -> recomendador.sugerirAtuendoDiarioUsuario(usuario));
  }



}
