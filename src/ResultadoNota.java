import java.util.Scanner;

public class ResultadoNota {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        System.out.println("Digite sua primeira nota: ");
        int nota1 = scann.nextInt();
            if (nota1 > 10 || nota1 < 0) {
                System.out.println("Não é possível inserir essa nota!");
            } else {
                System.out.println("Sua primeira nota foi : " +nota1);
            }
        int nota2 = scann.nextInt();
            if (nota2 > 10 || nota2 < 0) {
                System.out.println("Não é possível inserir essa nota!");
            } else {
                System.out.println("Sua primeira nota foi : "+nota1+ ", Sua segunda nota foi : " +nota2  );
            }
        int nota3 = scann.nextInt();
            if (nota3 > 10 || nota3 < 0) {
                System.out.println("Não é possível inserir essa nota!");
            } else {
                System.out.println("Sua primeira nota foi : "+nota1+ ", Sua segunda nota foi : " +nota2+", Sua terceira nota foi : " +nota3);
            }
        int nota4 = scann.nextInt();
            if (nota4 > 10 || nota4 < 0) {
                System.out.println("Não é possível inserir essa nota!");
            } else {
                System.out.println("Sua primeira nota foi : "+nota1+ ", Sua segunda nota foi : " +nota2+", Sua terceira nota foi : " +nota3+", Sua quarta nota foi : " +nota4);
            }
            int notaResultado = (nota1+nota2+nota3+nota4)/4  ;
            System.out.println("Sua média foi: " +notaResultado);
                if (notaResultado>=7) {
                    System.out.println("Parabéns, você foi aprovado!!!");
                }
                if (notaResultado>=5 && notaResultado<7) {
                    System.out.println("Você está de recuperação!!");
                }
                if (notaResultado<5) {
                    System.out.println("Você foi reprovado!!!");
                }





    }
}