

 public class MetodoPrincipal {
    public static void main(String[] args) {
        // criando variável tipo primitivo
        int codigo = 235658;
        int codigo1= 4568;
        codigo = (Integer) codigo1;
        System.out.println(codigo);
        // criando variável tipo wripper e fazendo o casting do long para o primitivo int
        long codigo2= 1658913445587642128l;
        Integer codigo3= (int) codigo2;
        System.out.println(codigo3);
        // printando o resultado no console, note que o codigo2 acaba perdendo parte de seu valor

    }
}