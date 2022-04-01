package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class TelefonoTest {
    @Test
    public void testingTelefonoValido() {


        //Teléfonos válidos
        Telefono telefono = new Telefono("628389354");
        boolean resultado = telefono.validar();
        assertEquals(true,resultado);
        telefono = new Telefono("+35 666666666");
        resultado = telefono.validar();
        assertEquals(true,resultado);
        telefono = new Telefono("666666666");
        resultado = telefono.validar();
        assertEquals(true,resultado);
    }
    
    @Test
    public void testingTelefonoInvalido() {
        //Teléfonos inválidos
        Telefono telefono = new Telefono("66666");
        Boolean resultado = telefono.validar();
        assertEquals(false,resultado);
        telefono = new Telefono("66666666A");
        resultado = telefono.validar();
        assertEquals(false,resultado);
        telefono = new Telefono("66666666-");
        resultado = telefono.validar();
        assertEquals(false,resultado);
        telefono = new Telefono("+3A 666666666");
        resultado = telefono.validar();
        assertEquals(false,resultado);
    }
}
