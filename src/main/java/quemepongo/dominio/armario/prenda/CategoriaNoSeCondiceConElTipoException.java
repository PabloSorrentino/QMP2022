package quemepongo.dominio.armario.prenda;

import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;

public class CategoriaNoSeCondiceConElTipoException extends RuntimeException {
  public CategoriaNoSeCondiceConElTipoException(String tipoPrenda, CategoriaPrenda categoriaPrenda) {
    super("El tipo " + tipoPrenda+" no se condice para la categoria " + categoriaPrenda);
  }
}
