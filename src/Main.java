import br.com.dio.desafio.dominio.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Bootcamp> bootcamps = new ArrayList<>();

        while (true) {
            System.out.print("cadastrar um bootcamp? (s/n): ");
            String resposta = sc.nextLine();

            if (resposta.equals("s") || resposta.equals("S")) {
                Set<Conteudo> conteudos = new HashSet<>();
                Set<Dev> devs = new HashSet<>();
                Bootcamp bc;
                System.out.println("Cadastrando um bootcamp, insira as informações");
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Descrição: ");
                String descricao = sc.nextLine();
                bc = new Bootcamp(nome, descricao);

                System.out.println();
                System.out.print("Hora de adicionar conteudo ao bootcamp, deseja adcionar quantos itens? ");
                int numeroDeItens = sc.nextInt();
                for (int i = 0; i < numeroDeItens; i++) {
                    System.out.println();
                    System.out.println("Mentoria ou Curso? (M/C)");
                    sc.nextLine();
                    String resp = sc.nextLine();
                    System.out.println("_____________________________________________________________________");
                    if (resp.equals("m") || resp.equals("M")) {
                        Conteudo conteudo;
                        System.out.print("Nome: ");
                        String titulo = sc.nextLine();
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        System.out.print("Data(yyyy-MM-dd): ");
                        String data = sc.nextLine();
                        conteudo = new Mentoria(titulo, desc, LocalDate.parse(data));

                        conteudos.add(conteudo);
                    } else if (resp.equals("c") || resp.equals("C")) {
                        Conteudo conteudo;
                        System.out.print("Nome: ");
                        String titulo = sc.nextLine();
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        System.out.print("cargaHoraria: ");
                        int cargaHoraria = sc.nextInt();
                        conteudo = new Curso(titulo, desc, cargaHoraria);

                        conteudos.add(conteudo);
                    } else {
                        System.out.println("Opção inválida");
                        i--;
                    }
                }
                bc.setConteudos(conteudos);

                System.out.println();
                System.out.print("Hora de adicionar os devs ao bootcamp, quantos serão? ");
                int numeroDeDevs = sc.nextInt();
                System.out.println();
                System.out.println("_________________________________________________________");
                for (int i = 0; i < numeroDeDevs; i++) {
                    System.out.print("Nome: ");
                    sc.nextLine();
                    nome = sc.nextLine();
                    Dev dev = new Dev(nome);
                    dev.inscreverBootcamp(bc);

                    devs.add(dev);
                }
                bc.setDevsInscritos(devs);
                
                bootcamps.add(bc);
            } else {
                break;

            }
        }

        if (!bootcamps.isEmpty()){
            bootcamps.forEach(System.out::println);
        } else {
            System.out.println("Não há nenhum bootcamp cadastrado");
        }

        sc.close();
    }
}
