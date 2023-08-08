import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultadoNota {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Aluno aluno = new Aluno();
        System.out.println("Digite seu nome");
        aluno.setNome(scann.nextLine());
        System.out.println("Digite sua primeira nota: ");
        int nota1 = scann.nextInt();
            System.out.println("Sua primeira nota foi : " +nota1);
        System.out.println("Digite sua segunda nota: ");
        int nota2 = scann.nextInt();
            System.out.println("Sua primeira nota foi : "+nota1+ ", Sua segunda nota foi : " +nota2  );
        System.out.println("Digite sua terceira nota: ");
        int nota3 = scann.nextInt();
            System.out.println("Sua primeira nota foi : "+nota1+ ", Sua segunda nota foi : " +nota2+", Sua terceira nota foi : " +nota3);
        System.out.println("Digite sua última nota: ");
        int nota4 = scann.nextInt();
            System.out.println("Sua primeira nota foi : "+nota1+ ", Sua segunda nota foi : " +nota2+", Sua terceira nota foi : " +nota3+", Sua quarta nota foi : " +nota4);
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
