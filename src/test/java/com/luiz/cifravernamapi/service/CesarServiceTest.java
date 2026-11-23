package com.luiz.cifravernamapi.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CesarServiceTest {

    CesarService service = new CesarService();

    @Test
    public void deveCifrarMensagemComDeslocamento3() {
        assertEquals("rod pxqgr", service.cifrar("ola mundo", 3));
    }

    @Test
    public void deveDecifrarMensagemComDeslocamento3() {
        assertEquals("ola mundo", service.decifrar("rod pxqgr", 3));
    }

    @Test
    public void deveRespeitarMaiusculasEMinusculas() {
        assertEquals("Def abc", service.cifrar("Abc xyz", 3));
    }

    @Test
    public void deveVoltarAoInicioDoAlfabeto() {
        assertEquals("ABC", service.cifrar("XYZ", 3));
    }

    @Test
    public void devePreservarEspacosPontuacaoENumeros() {
        assertEquals("DEF, abc! 123", service.cifrar("ABC, xyz! 123", 3));
    }

    @Test
    public void deslocamento26DeveManterTextoOriginal() {
        assertEquals("ABC xyz", service.cifrar("ABC xyz", 26));
    }

    @Test
    public void deveAceitarDeslocamentoNegativo() {
        assertEquals("XYZ", service.cifrar("ABC", -3));
    }

    @Test
    public void deveAceitarDeslocamentoMaiorQue26() {
        assertEquals("DEF", service.cifrar("ABC", 29));
    }

    @Test
    public void deveDecifrarMensagemPorForcaBruta() {
        assertEquals("ola mundo", service.decifrarForcaBruta("rod pxqgr"));
    }
}