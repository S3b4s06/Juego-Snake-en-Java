package proyecto;
import java.util.Scanner;

public class Partida {
   private char[][] tablero ;
   private Snake snake ;
   private Usuario usuario;
   private Fruta fruta;
   private int puntaje;
   
   public Partida(){
   }

   public void iniciar_partida(long id, int tam){
      this.tablero = new char[tam][tam];  
      this.snake = new Snake();                          
      snake.pos_random(tam);
      this.usuario= new Usuario(id);
      this.fruta = new Fruta(tam,snake.get_posicion());
      this.puntaje= 0;

      Scanner sc=new Scanner(System.in);
      System.out.println("--Instrucciones--");
      System.out.println("W: Para ir hacia arriba \nS: Para ir hacia abajo \nA: Para girar a la izquierda \nD: Para girar a la derecha");
      while (true) {
         imprimir_t(tam);
         System.out.println("Ingrese su siguiente movimiento: ");        
         String mov= sc.nextLine();
         if(mov.equalsIgnoreCase("W") || mov.equalsIgnoreCase("S")||mov.equalsIgnoreCase("A")||mov.equalsIgnoreCase("D")){
            snake.Movimiento(mov);
         }
         else{
            System.out.println("Ingrese un movimiento válido");
            }
         actualizar_tablero(tam);


         if (snake.verificar_colision(tam)){
            System.out.println("¡Perdiste!");
            System.out.println("Tu puntaje final fue: "+this.puntaje);
            usuario.set_max_punt(puntaje);
            break;
         }
      }
   }
   public void actualizar_tablero(int tam){
         if (snake.comer_fruta(fruta)){
           fruta.pos_random(tam, snake.get_posicion());
           this.puntaje+=1;        
    }
    
   }
   public void imprimir_t(int tam) {
      for (int i=0; i<tam;i++){
         for(int j=0; j<tam; j++){
         tablero[i][j]=' ';
         }
      }           
      for( Posicion p : snake.get_posicion()){
      tablero[p.get_fila()][p.get_columna()]='O';    
   }
      tablero[snake.get_posicion().get(0).get_fila()][snake.get_posicion().get(0).get_columna()]='0';
      Posicion frutapos=fruta.get_posicion();
      tablero[frutapos.get_fila()][frutapos.get_columna()]='X';
   for (int i=0;i<tam;i++){
      System.out.print("──");

   }

      System.out.println();

   
   for(int i=0;i<tam;i++){
      System.out.print("|");
      for(int j=0;j<tam;j++){
         System.out.print(tablero[i][j] + " ");
      }
      System.out.print("|");
      System.out.println();
   }
   for (int i=0;i<tam;i++){
      System.out.print("──");
   }
      System.out.println();
      System.out.println("Puntaje actual: "+this.puntaje);


}

public Usuario get_usuario(){
   return this.usuario;
}

}
