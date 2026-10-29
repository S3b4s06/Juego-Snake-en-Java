package proyecto;
public class Usuario {
    private long id;
    private int max_punt;

    public Usuario(long id){
        this.id=id;
        this.max_punt=0;
    }
    public void set_max_punt(int p){
        this.max_punt=p;
    }
    public long get_id(){
        return this.id;
    }
    public void set_id(long id){
        this.id=id;
    }
    public int get_puntaje_max(){
        return this.max_punt;
    }

}
