package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenOttaminenEiMuuta() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(-5);

        assertEquals(5, varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void ylimaaraHukkuu() {
        varasto.lisaaVarastoon(12);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenLisaaminenEiMuuta() {
        varasto.lisaaVarastoon(5);
        varasto.lisaaVarastoon(-2);
        assertEquals(5, varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void annetaanVainMitaVoifaan() {
        varasto.lisaaVarastoon(5);
        assertEquals(5, varasto.otaVarastosta(8), vertailuTarkkuus);
    }

    @Test
    public void varastoTyhjaKunKaikkiAnnettu() {
        varasto.lisaaVarastoon(7);
        varasto.otaVarastosta(10);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriNegatiivisellaTilavuudella() {
        Varasto uusivarasto = new Varasto(-5);
        assertEquals(0, uusivarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void vaihtoehdoinenKonstruktori() {
        Varasto uusivarasto = new Varasto(12,9);
        assertEquals(9, uusivarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void vaihtoehtoinenKonstrukstoriNegatiivisellaVarastolla() {
        Varasto uusivarasto = new Varasto(-7,3);
        assertEquals(0, uusivarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void vaihtoehtoinenKonstruktoriNegatiivisellaSaldolla() {
        Varasto uusivarasto = new Varasto(5.5, -3.5);
        assertEquals(0, uusivarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void merkkijonoEsitys() {
        varasto.lisaaVarastoon(3);
        String merkkijono = "saldo = 3.0, vielä tilaa 7.0 LÄL LÄL LÄÄ";
        String tulos = varasto.toString();
        assertEquals(merkkijono, tulos);
    }
}