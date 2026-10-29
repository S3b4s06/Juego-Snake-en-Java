package proyecto;
import java.util.ArrayList;
import java.util.Random;
 
public class Snake{
    private int tamano_snake;
    private ArrayList<Posicion> posicion;
    
    public Snake(){
        this.tamano_snake=3;
        this.posicion = new ArrayList<>();
    }
    public ArrayList<Posicion> get_posicion() {
        return this.posicion;
    }
    public void pos_random(int tam){
        this.tamano_snake=3;
        Random rand= new Random();
        int xr= rand.nextInt(tam);
        int yr= rand.nextInt(tam);
        Posicion head= new Posicion(xr,yr);
        this.posicion.add(head);
        this.posicion.add(head);
        this.posicion.add(head);    
    }

    public void Movimiento(String m){ 
        Posicion head= posicion.get(0);
        int x=head.get_columna();
        int y=head.get_fila();
        Posicion nuevaHead= new Posicion(y,x);
        if(m.equalsIgnoreCase("W") ){
            nuevaHead.set_fila(y-1);
        }
       if(m.equalsIgnoreCase("A") ){
            nuevaHead.set_columna(x-1);
        }
        if(m.equalsIgnoreCase("S")  ){
            nuevaHead.set_fila(y+1);
        }
       if(m.equalsIgnoreCase("D")){ 
            nuevaHead.set_columna(x+1);
        }
       for(int i=this.tamano_snake-1;i>0;i--){         
        posicion.set(i,posicion.get(i-1));
       }
        posicion.set(0,nuevaHead);
    }

    public boolean comer_fruta(Fruta f){

        Posicion frutapos=f.get_posicion();
        Posicion head=posicion.get(0);
        Posicion tail=posicion.get(tamano_snake-1);
        int xt=tail.get_columna();
        int yt=tail.get_fila();
        if(frutapos.get_fila()==head.get_fila() && frutapos.get_columna()==head.get_columna()){
            this.tamano_snake+=1;
            posicion.add(new Posicion(yt,xt));
            return true;
        }
        return false;
    }
    public int get_tamano(){
        return this.tamano_snake;
    }

    public boolean verificar_colision(int tam){
        Posicion head=posicion.get(0);
        int yt=head.get_columna();
        int xt=head.get_fila();
        if (xt < 0 || xt >= tam || yt < 0 || yt >= tam) {
            return true;
        }
        for (int i = 1; i < tamano_snake; i++) {
            Posicion cuerpo = posicion.get(i);
            if (cuerpo.get_fila() == xt && cuerpo.get_columna() == yt) {
                return true;
            }
        }
        return false;
    }
}