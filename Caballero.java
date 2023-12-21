public class Caballero extends Soldado{
    private String armaActual = "lanza";
    private boolean montando = true;
    private static int num = 0;

    public Caballero(String s, int ata, int def, int vid){
        super(s,ata,def,vid);
        num++;
    }

    public void envestir(){
        if(montando==true){
            for(int i=0; i<=2; i++){
                super.atacar();
            }
        }else{
            super.atacar();
        }
    }

    public void desmontar(){
        if(montando==true){
            montando = false;
            super.defender();
            cambiaArma();
        }
    }

    public void cambiaArma(){
        if(armaActual=="lanza"){
            armaActual = "Espada";
        }else{
            armaActual = "lanza";
        }
    }

    public void montar(){
        if(montando==false){
            montando = true;
            super.atacar();
            cambiaArma();
        }
    }
    
    public static int cuantos(){
        return num;
    }

    public static void resetearCantidad(){
        num=0;
    }

    public String toString(){
        return super.toString()+" "+armaActual+" "+montando;
    }
}
