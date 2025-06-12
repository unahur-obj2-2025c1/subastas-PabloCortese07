package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public class ConLimite implements TipoDeSubastador {

    private Integer limite;

    public ConLimite(Integer limite){
        this.limite = limite;
    }

    @Override
    public void crearOferta(Observable producto, Subastador subastador) {
       if(subastador.getUltimaOferta().getPrecio() <= this.limite){
           producto.agregarOferta(new Oferta(subastador.getNombre(), subastador.getUltimaOferta().getPrecio() + 10));
       }
    }
}
