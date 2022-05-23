import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.dominio.apis.APIClima;
import quemepongo.dominio.apis.AccuWeatherAPI;
import quemepongo.dominio.armario.Armario;
import quemepongo.dominio.armario.Atuendo;
import quemepongo.dominio.armario.Recomendador;
import quemepongo.dominio.armario.prenda.Prenda;
import quemepongo.dominio.armario.prenda.detallesprenda.CategoriaPrenda;
import quemepongo.dominio.armario.prenda.detallesprenda.Color;
import quemepongo.dominio.armario.prenda.detallesprenda.Material;
import quemepongo.dominio.armario.prenda.detallesprenda.Trama;

import java.time.Duration;


public class RecomendadorTest {

  private Recomendador recomendadorMock;

  @BeforeEach
  public void before(){
    recomendadorMock = new Recomendador(
        new APIClima(new AccuWeatherAPI(), Duration.ofHours(3)));
  }

  @Test
  public void seRecomiendaUnAtuendoCon4Prendas(){
    Armario armario = crearArmarioConTodasLasPrendas();
    Atuendo atuendo = recomendadorMock.generarAtuendoSegunTemperaturaHoy(armario);

    Assertions.assertTrue(atuendo.getPrendas().size() == 4);
  }

  @Test
  public void seRecomiendaUnAtuendoConLos4TiposDePrenda() {
    Armario armario = crearArmarioConTodasLasPrendas();
    Atuendo atuendo = recomendadorMock.generarAtuendoSegunTemperaturaHoy(armario);
    Prenda superior = atuendo.getPrendaDeCategoria(CategoriaPrenda.PARTE_SUPERIOR);
    Prenda inferior = atuendo.getPrendaDeCategoria(CategoriaPrenda.PARTE_INFERIOR);
    Prenda accesorio = atuendo.getPrendaDeCategoria(CategoriaPrenda.ACCESORIO);
    Prenda Calzado = atuendo.getPrendaDeCategoria(CategoriaPrenda.CALZADO);
    Assertions.assertTrue(CategoriaPrenda.PARTE_SUPERIOR.getValues().contains(superior.getTipoPrenda()));
  }

  public Armario crearArmarioConTodasLasPrendas() {
    Armario armario = new Armario();
    armario.agregarPrenda(crearRemeraAzulMangaCortaVerano());
    armario.agregarPrenda(crearCamisaRojaLargaOtonio());
    armario.agregarPrenda(crearCamperaAzulInvierno());
    armario.agregarPrenda(crearSweaterVerdePrimavera());
    armario.agregarPrenda(crearPantalonGris());
    armario.agregarPrenda(crearShort());
    armario.agregarPrenda(crearZapatilla());
    armario.agregarPrenda(crearBota());
    armario.agregarPrenda(crearHojota());
    armario.agregarPrenda(crearMochilla());
    armario.agregarPrenda(crearCinturonCuero());
    armario.agregarPrenda(crearAnteojo());
    return armario;
  }

  private Prenda crearCinturonCuero() {
    return new Prenda(Material.CUERO,
        null,
        rojo(),
        null,
        "cinturon",
        CategoriaPrenda.ACCESORIO,
        null);
  }


  private Prenda crearMochilla() {
    return new Prenda(Material.KEVLAR,
        null,
        azul(),
        blanco(),
        "mochila",
        CategoriaPrenda.ACCESORIO,
        null
    );
  }

  private Prenda crearBota() {
    return new Prenda(Material.KEVLAR,
        null,
        azul(),
        blanco(),
        "bota",
        CategoriaPrenda.CALZADO,
        5
    );
  }

  private Prenda crearHojota() {
    return new Prenda(Material.KEVLAR,
        null,
        azul(),
        blanco(),
        "hojota",
        CategoriaPrenda.CALZADO,
        25
    );

  }

  private Prenda crearZapatilla() {
    return new Prenda(Material.NAYLON,
        Trama.ESTAMPADO,
        blanco(),
        null,
        "zapatilla",
        CategoriaPrenda.CALZADO,
        20
    );

  }

  private Prenda crearShort() {
    return new Prenda(Material.POLYESTER,
        null,
        rojo(),
        null,
        "short",
        CategoriaPrenda.PARTE_INFERIOR,
        25
    );

  }

  private Prenda crearPantalonGris() {
    return new Prenda(Material.POLYESTER,
        Trama.LUNARES,
        rojo(),
        blanco(),
        "pantalon",
        CategoriaPrenda.PARTE_INFERIOR,
        5
    );
  }

  private Prenda crearSweaterVerdePrimavera() {
    return new Prenda(Material.ALGODON,
        Trama.RAYADA,
        azul(),
        rojo(),
        "sweater",
        CategoriaPrenda.PARTE_SUPERIOR,
        20
    );
  }


  private Prenda crearCamperaAzulInvierno() {
    return new Prenda(Material.JEAN,
        Trama.RAYADA,
        azul(),
        azul(),
        "campera",
        CategoriaPrenda.PARTE_SUPERIOR,
        5
    );
  }

  private Prenda crearCamisaRojaLargaOtonio() {
    return new Prenda(Material.ALGODON,
        Trama.A_CUADROS,
        rojo(),
        blanco(),
        "remera manga larga",
        CategoriaPrenda.PARTE_SUPERIOR,
        5
    );
  }

  private Prenda crearRemeraAzulMangaCortaVerano() {
    return new Prenda(Material.ALGODON,
        Trama.A_CUADROS,
        azul(),
        blanco(),
        "remera manga corta",
        CategoriaPrenda.PARTE_SUPERIOR,
        25
    );
  }

  private Prenda crearAnteojo() {
    return new Prenda(Material.PLASTICO,
        null,
        rojo(),
        null,
        "anteojo",
        CategoriaPrenda.ACCESORIO,
        null);
  }

  private Color rojo(){
    return new Color("255", "0", "0", "rojo puro");
  }

  private Color azul(){
    return new Color("0", "0", "255", "azul puro");
  }

  private Color blanco(){
    return new Color("255", "255", "255", "blanco");
  }

}
