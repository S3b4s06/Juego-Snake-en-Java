package proyecto;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Juego{
    private ArrayList<Usuario> scoreboard;
    private Partida partida;

public Juego(){
    this.scoreboard= new ArrayList<>();
    this.partida= new Partida();
}
public void menu(){
    Scanner sc= new Scanner(System.in);
    boolean jugando=true;
    while (jugando){
        System.out.println("----|Menú Juego Snake|----");
        System.out.println("1. Iniciar partida");
        System.out.println("2. Mostrar puntajes guardados");
        System.out.println("3. Salir del juego");
        System.out.println();

        String opcion=sc.nextLine();
        long id ;
        int tam ;
        switch (opcion) {
            case "1":
            while (true) { 
                try {
                    System.out.println("Ingrese su ID");
                    id=sc.nextLong();
                     sc.nextLine();

                    System.out.println("Ingrese el tamaño del tablero (Debe ser de mínimo 5)");
                    tam=sc.nextInt();
                     sc.nextLine();

                    if (tam<5){
                        System.out.println("Ingrese un tamaño mayor a 5");
                        continue;
                                
                    }
                    partida.iniciar_partida(id, tam);
                    agregar_usuario(id,partida.get_usuario().get_puntaje_max());
                    break;

                }
                catch (InputMismatchException exception) {
                    sc.nextLine();
                    System.out.println("Debe ingresar datos validos");
                    
                }
                
            }
            break;
            case "2":
                print_scoreboard();
                break;    
            case "3":        
                System.out.println("¡¡Gracias por jugar!!");
                jugando=false;
                break;             
            default:
                System.out.println("Ingrese un numero valido");
            }
    }

}
public void print_scoreboard(){
    System.out.println("-- TABLERO DE PUNTAJES --");
    for(Usuario u : scoreboard){
        System.out.println("Usuario: "+ u.get_id() + " Puntaje máximo: " + u.get_puntaje_max());
        
        
    }
    System.out.println();
}
public void agregar_usuario(long id, int puntaje){
    if(buscar_usuario(id)==-1){
        scoreboard.add(partida.get_usuario());
    }
    
    else if (scoreboard.get(buscar_usuario(id)).get_puntaje_max()<puntaje){
       scoreboard.get(buscar_usuario(id)).set_max_punt(puntaje);   
    }
}

public int buscar_usuario(long id){
    int inx=0;
    for(Usuario u : scoreboard){
        
        if(u.get_id() == id){
            return inx;
        }
        inx++;
    }
    return -1;
}

}