public class Arquero extends Soldado {
    private int numeroFlechas;
    private static int num = 0;

    public Arquero(String s, int ata, int def, int vid, int cant){
        super(s,ata,def,vid);
        numeroFlechas = cant;
        num++;
    }

    public void disparar(){
        if(numeroFlechas>0){
            numeroFlechas--;
        }
    }

    public static int cuantos(){
        return num;
    }

    public static void resetearCantidad(){
        num = 0;
    }
    
    public String toString(){
        return super.toString()+" "+numeroFlechas;
    }
}
