package proyecto;
import java.util.Random;
import java.util.ArrayList;

public class Fruta {
    private Posicion posicion;

    public Fruta(int tam, ArrayList<Posicion> snake){
       pos_random(tam, snake);
    }
    
    public void pos_random(int tam, ArrayList<Posicion> snake){
        Random rand= new Random();

        while (true) {
            boolean ocupado = false;
            int xr= rand.nextInt(tam);
            int yr= rand.nextInt(tam);
            for (Posicion pos : snake ){
                if (xr == pos.get_fila() && yr == pos.get_columna()){
                    ocupado = true;
                    break;    
                }
            }
            if (ocupado == false){
                this.posicion= new Posicion(xr,yr);
                break;       
                }
        }
    }
    
    public Posicion get_posicion(){
        return this.posicion; 
    }
    
}
