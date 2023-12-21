// RONI COMPANOCCA CHECCO
// CUI: 20210558
// LABORATORIO 22
// FUNDAMENTOS DE PROGRAMACION 
public class Main {
    public static void main(String[] args){
        int cant;
        String cultura[] = {"Inglaterra","Francia","Sacro Imperio Romano Germanico","Aragon","Moros"};
        cant = aleatorio(1,10);
        Ejercito e1 = new Ejercito(cultura[aleatorio(0,4)], cant);
        mostrar(e1);
        cant = aleatorio(1,10);
        Ejercito e2 = new Ejercito(cultura[aleatorio(0,4)], cant);
        mostrar(e2);
        determinarGanador(e1,e2);
    }
    
    public static int aleatorio(int a, int b){
        return (int)(Math.random()*(b-a+1))+a;
    }

    private static int aux = 1;

    public static void mostrar(Ejercito e){
        System.out.print("Ejercito "+aux+" "+e.getCultura());
        System.out.println("\nCantidad total de Soldados: "+Soldado.cuantos()+"\n"+"Espadachines: "+Espadachin.cuantos()+"\n"+"Arqueros: "+Arquero.cuantos()+"\n"+"Lanceros: "+Lancero.cuantos()+"\n"+"Caballeros: "+Caballero.cuantos()+"\n");
        Ejercito.resetearCantidad();
        aux++;
    }

    public static void determinarGanador(Ejercito e1, Ejercito e2){
        System.out.println("Ejercito 1: "+e1.getCultura()+" con un poder de "+e1.poder());
        System.out.println("Ejercito 2: "+e2.getCultura()+" con un poder de "+e2.poder());
        if (e1.poder()>e2.poder()){
            System.out.println("El ganador es ejercito 1 de : "+e1.getCultura());
        } else if (e1.poder()<e2.poder()){
            System.out.println("El ganador es ejercito 2 de : "+e2.getCultura());
        } else{
            System.out.println("Sin ganador");
        }
    }
}
