package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public class Subastador implements Observer {

    private String nombre;
    private Integer ultimaOferta;

    public Subastador(String nombre){
        this.nombre = nombre;
        this.ultimaOferta = 0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void actualizarOferta(Integer valor) {
        ultimaOferta = valor;
        
    }

    @Override
    public void realizarOferta(Observable producto) {
        Integer nuevaOferta = ultimaOferta + 10;
        producto.agregarOferta(new Oferta(this.getNombre(),nuevaOferta));
        
    }

    @Override
    public void reset() {
        ultimaOferta = 0;
    }

}
