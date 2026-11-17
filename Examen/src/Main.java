import Services.FileService;
import Services.XogadoresService;
import models.Celta;
import models.Xogadores;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando secuencia");

        Xogadores x1 = new Xogadores("Alexander Mostovoi", "Mediocentro", 34);
        Xogadores x2 = new Xogadores("Valeri Karpin", "Interior Dereito", 33);
        Xogadores x3 = new Xogadores("Gustavo Lopez", "Extremo esquerdo", 29);
        Xogadores x4 = new Xogadores("Haim Revivo", "Mediapunta", 20);
        Xogadores x5 = new Xogadores("Claude Makelele", "Pivote", 26);
        Xogadores x6 = new Xogadores("Michel Salgado", "Lateral dereito", 23);
        Xogadores x7 = new Xogadores("Patxi Salinas", "Central", 34);
        Xogadores x8 = new Xogadores("Catanha", "Delantero", 28);

        XogadoresService.createXogadores(x1);
        XogadoresService.createXogadores(x2);
        XogadoresService.createXogadores(x3);
        XogadoresService.createXogadores(x4);
        XogadoresService.createXogadores(x5);
        XogadoresService.createXogadores(x6);
        XogadoresService.createXogadores(x7);
        XogadoresService.createXogadores(x8);

        System.out.println("--------------");

        System.out.println("Lendo a táboa!");
        //obterXogadores


        System.out.println("--------------");

        System.out.println("Formando equipo!");
        //obterXogadoresPorNome


        System.out.println("----------------");

        System.out.println("Valores inseridos \\n” + “Exportando equipo para a federación!");
        // obterCelta

//        FileService serial = FileService.Serial(, "Celta");

        System.out.println("----------------");

        System.out.println("Actualizando soldos");


        System.out.println("----------------");

        System.out.println("Diñeiro insuficiente, debemos baixarlle o soldos a alguén :( !");

        List<Celta> deserial = FileService.deserial( "Celta");

        System.out.println("o xogador nomeDoXogadorObtido debería cobrar soldoObtido, xerando\n" +
                "informe…");
        //XML

    }
}
