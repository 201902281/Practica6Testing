package com.icai.practicas.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DNITest {
    
    @Test
    public void validarDNIInvalidoTesting(){

        //DNIs inválidos
        DNI dni = new DNI("00000000T");
        boolean resultado = dni.validar();
        assertEquals(false,resultado);
        dni = new DNI("00000001R");
        resultado = dni.validar();
        assertEquals(false,resultado);
        dni = new DNI("99999999R");
        resultado = dni.validar();
        assertEquals(false,resultado);
    }

    public void validarDNIPatronErroneoTesting(){
        //DNIs con patron erróneo
        DNI dni = new DNI("345");
        boolean resultado = dni.validar();
        assertEquals(false,resultado);
        dni = new DNI("4512N");
        resultado = dni.validar();
        assertEquals(false,resultado);
        dni = new DNI("72849506Ñ");
        resultado = dni.validar();
        assertEquals(false,resultado);
        dni = new DNI("728495063");
        resultado = dni.validar();
        assertEquals(false,resultado);
        dni = new DNI("72849503336Ñ");
        resultado = dni.validar();
        assertEquals(false,resultado);
    }
    
    @Test
    public void validarDNIValidoTesting(){
        //DNIs válidos
        DNI dni = new DNI("53857194A");
        boolean resultado = dni.validar();
        assertEquals(true,resultado);
        dni = new DNI("45132222N");
        resultado = dni.validar();
        assertEquals(true,resultado);
        dni = new DNI("72849506L");
        resultado = dni.validar();
        assertEquals(true,resultado);
    }
}
