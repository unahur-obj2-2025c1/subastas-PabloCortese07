package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public class Unico implements TipoDeSubastador {

    private boolean yaOferto = false;

    @Override
    public void crearOferta(Observable producto, Subastador subastador) {
        if(!yaOferto){
            producto.agregarOferta(new Oferta(subastador.getNombre(), subastador.getUltimaOferta().getPrecio() + 10));
            yaOferto = true;
        }
        
    }

}
