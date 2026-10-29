package proyecto;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int x, int y){
        this.fila=x;
        this.columna=y;
    }
    public int get_fila(){
        return this.fila;
    }
    public int get_columna(){
        return this.columna;
    }
    public void set_fila(int x){
        this.fila=x;
    }
    public void set_columna(int y){
        this.columna=y;
    }
}
