package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Arriesgado;
import ar.edu.unahur.obj2.observer.observadores.Observer;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
    Observable producto = new ProductoSubatado();

    Observer gonzager = new Subastador("gonzager", new Arriesgado());
    Observer diazdan = new Subastador("diazdan", new Arriesgado());
    Observer martomau = new Subastador("martomau", new Arriesgado());

    public void escenario1(){
        producto.reset();
        gonzager.reset();
        diazdan.reset();
        martomau.reset();
    }

    @Test
    void verificarQueLoParticipantesRecibieronLaUltimaOferta(){
        this.escenario1();
        producto.agregarParticipante(gonzager);
        producto.agregarParticipante(martomau);

        martomau.setObjetoSubastable(producto);
        gonzager.setObjetoSubastable(producto);
        
        martomau.actualizarOferta();
        gonzager.actualizarOferta();
        martomau.actualizarOferta();

        assertEquals(30, martomau.getUltimaOferta().getPrecio());
        assertEquals(30, gonzager.getUltimaOferta().getPrecio());
        assertEquals(martomau.getUltimaOferta().getPrecio(),gonzager.getUltimaOferta().getPrecio());
    }

    @Test
    void verificarQueLaUltimaOfertaEsDeMartomau(){
        this.escenario1();
        producto.agregarParticipante(gonzager);
        producto.agregarParticipante(martomau);

        martomau.setObjetoSubastable(producto);
        gonzager.setObjetoSubastable(producto);
        
        martomau.actualizarOferta();
        gonzager.actualizarOferta();
        martomau.actualizarOferta();
        
        assertEquals(producto.ultimaOferta(), martomau.getUltimaOferta());
    }

    @Test 
    void verificamosElAumentoProgrecivo(){
        this.escenario1();
        producto.agregarParticipante(gonzager);
        producto.agregarParticipante(martomau);

        martomau.setObjetoSubastable(producto);
        gonzager.setObjetoSubastable(producto);
        
        martomau.actualizarOferta();
        gonzager.actualizarOferta();
        martomau.actualizarOferta();

        assertEquals(30, martomau.getUltimaOferta().getPrecio());
        assertEquals(30, gonzager.getUltimaOferta().getPrecio());
    }

    @Test
    void verificamosLaCantidadDeOfertas(){
        this.escenario1();
        producto.agregarParticipante(gonzager);
        producto.agregarParticipante(martomau);

        martomau.setObjetoSubastable(producto);
        gonzager.setObjetoSubastable(producto);
        
        martomau.actualizarOferta();
        gonzager.actualizarOferta();
        martomau.actualizarOferta();

        assertEquals(3, producto.cantDeOfertas());
    }

    @Test
    void diazdanIntentaAgregarUnaOfertaPeroNoEstaPArticipando(){
        this.escenario1();
        producto.agregarParticipante(gonzager);
        producto.agregarParticipante(martomau);

        martomau.setObjetoSubastable(producto);
        gonzager.setObjetoSubastable(producto);
        
        martomau.actualizarOferta();
        gonzager.actualizarOferta();
        martomau.actualizarOferta();

        diazdan.setObjetoSubastable(producto);
        

        OfertaSubastadorException exp = assertThrows(
            OfertaSubastadorException.class, 
            () -> diazdan.actualizarOferta()
        );

        assertEquals("no esta participando en la subasta", exp.getMessage());
    }
}
