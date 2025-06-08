package ar.edu.unahur.obj2.observer;

public class Oferta {

    private Integer precio;
    private String cliente;

    public Integer getPrecio() {
        return precio;
    }

    public String getCliente() {
        return cliente;
    }

    public Oferta(String cliente,Integer precio){
        this.cliente = cliente;
        this.precio = precio;
    }
}
