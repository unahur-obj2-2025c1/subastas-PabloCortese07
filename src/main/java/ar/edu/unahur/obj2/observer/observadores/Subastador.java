package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public class Subastador implements Observer {

    private String nombre;
    private Oferta ultimaOferta = new Oferta(this.nombre, 0);
    private Observable producto;
    private TipoDeSubastador estrategia;
    
    public Subastador(String nombre, TipoDeSubastador estrategia){
        this.nombre = nombre;
        this.estrategia = estrategia;
    }

    @Override
    public void setObjetoSubastable(Observable objeto){
        producto = objeto;
    }
    
    @Override
    public Oferta getUltimaOferta() {
        return this.ultimaOferta;
    }
    
    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void guardarUltimaOferta(Oferta valor) {
        ultimaOferta = valor;
        
    }

    @Override
    public void actualizarOferta() {
        estrategia.crearOferta(producto, this);
    }

    @Override
    public void reset() {
        ultimaOferta = new Oferta(this.nombre, 0);
        producto = null;
    }
}
