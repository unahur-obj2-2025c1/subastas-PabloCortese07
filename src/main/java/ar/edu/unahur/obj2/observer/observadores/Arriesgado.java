package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.*;

public class Arriesgado implements TipoDeSubastador {

    @Override
    public void crearOferta(Observable producto, Subastador subastador) {
        Oferta nuevaOferta = new Oferta(subastador.getNombre(), subastador.getUltimaOferta().getPrecio() + 10);
        producto.agregarOferta(nuevaOferta);
    }

}
