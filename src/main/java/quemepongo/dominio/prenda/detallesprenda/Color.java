package quemepongo.dominio.prenda.detallesprenda;

public class Color {
  private String r;
  private String g;
  private String b;
  private String descripcion;

  public Color(String r, String g, String b, String descripcion) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.descripcion = descripcion;
  }

  public String getR() {
    return r;
  }

  public String getG() {
    return g;
  }

  public String getB() {
    return b;
  }

  public String getDescripcion() {
    return descripcion;
  }
}
