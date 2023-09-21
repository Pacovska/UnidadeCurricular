package engtelecom.poo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private final Map<String,UnidadeCurricular> unidadesCurriculares = new HashMap<>();
    public int menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println(" 1 - Adicione uma unidade curricular ");
        System.out.println(" 2 - Exclua uma unidade curricular   ");
        System.out.println(" 3 - Alterar unidade curricular      ");
        System.out.println(" 4 - Exibir todas as informações     ");
        System.out.println(" 5 - Listar todas as disciplinas     ");
        System.out.println(" 6 - Sair                            ");
        System.out.println("=====================================");
        System.out.print("Escolha uma opção: ");

        return scanner.nextInt();
    }

    public void adicioneUnidadeCurricular(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.print("Unidade curricular: ");
        String nome = scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        if (unidadesCurriculares.containsKey(codigo)){
            System.err.println("Esse código é existe!");
            return;
        }
        System.out.print("Sigla: ");
        String sigla = scanner.nextLine();
        System.out.print("Creditos: ");
        Integer creditos = scanner.nextInt();
        System.out.print("Ementa: ");
        scanner.nextLine();
        String ementa = scanner.nextLine();
        System.out.println("=====================================");

        UnidadeCurricular uc = new UnidadeCurricular(nome, codigo, sigla, creditos, ementa);

        System.out.println("Informe os objetivos da unidade curricular.");
        int i = 1;
        String confirm;
        do{
            System.out.print(i + "- ");
            String objetivo = scanner.nextLine();
            if (!objetivo.equals("")){
                uc.adicionarObjetivo(objetivo);
                i++;
            }else {
                System.out.println("Objetivo inserido está inválido!");
            }
            System.out.print("Deseja continuar?(S/N): ");
            confirm = scanner.next();
            scanner.nextLine();
        }while(!confirm.equals("N"));

        System.out.println("Informe os conteudos da unidade curricular.");
        i = 1;
        do{
            System.out.print(i + "- ");
            String conteudo = scanner.nextLine();
            if(!conteudo.equals("")){
                uc.adicionarConteudo(conteudo);
                i++;
            }else {
                System.err.println("Conteudo inserido está inválido!");
            }
            System.out.print("Deseja continuar?(S/N): ");
            confirm = scanner.next();
            scanner.nextLine();
        }while (confirm.equals("S"));

        unidadesCurriculares.put(codigo, uc);

        System.out.println("Unidade curricular " + nome + " criada com sucesso");

    }

    public void removaUnidadeCurricular(){
        if (unidadesCurriculares.isEmpty()){
            System.out.println("Não é possível remover, pois não existe nenhum componente curricular.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.print("Informe o código da unidade curricular: ");
        String codigo = scanner.nextLine();
        System.out.println("=====================================");

        if (unidadesCurriculares.remove(codigo) != null){
            System.out.println("Unidade curricular removida.");
        }else{
            System.out.println("Unidade curricular não encontrada.");
        }
    }

    public void alterarUnidadeCurricular(){
        if (unidadesCurriculares.isEmpty()){
            System.out.println("Não é possível alterar, pois não existe nenhum componente curricular.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("Informe o codigo da unidade curricular que deseja alterar: (Aperte enter se não deseja alterar)");
        String codigoDaUnidade = scanner.next();
        UnidadeCurricular temp = unidadesCurriculares.get(codigoDaUnidade);

        System.out.println("=====================================");
        System.out.println("Deseja alterar o nome: " + temp.getNome() + "?");
        String novaOpcao = scanner.nextLine();
        if (!novaOpcao.isEmpty()){
            temp.setNome(novaOpcao);
        }

        System.out.println("=====================================");
        System.out.println("Deseja alterar o código: " + temp.getCodigo() + "?");
        novaOpcao = scanner.nextLine();
        if (!novaOpcao.isEmpty()){
            if(!unidadesCurriculares.containsKey(novaOpcao)){
                unidadesCurriculares.remove(codigoDaUnidade);
                temp.setCodigo(novaOpcao);
                unidadesCurriculares.put(novaOpcao, temp);
            }else{
                System.out.println("Código já existente.");
            }
        }

        System.out.println("Deseja alterar a sigla: " + temp.getSigla() + "?");
        novaOpcao = scanner.next();
        if (!novaOpcao.isEmpty()){
            temp.setSigla(novaOpcao);
        }

        System.out.println("Deseja alterar a quantidade de creditos: " + temp.getCreditos() + "?");
        novaOpcao = scanner.next();
        if (!novaOpcao.isEmpty()){
            int novaOpcaoInt = Integer.parseInt(novaOpcao);
            temp.setCreditos(novaOpcaoInt);
        }

        System.out.println("Deseja alterar a ementa: " + temp.getEmenta() + "?");
        novaOpcao = scanner.nextLine();
        if (!novaOpcao.isEmpty()){
            temp.setEmenta(novaOpcao);
        }

        System.out.println("=====================================");
        if(!temp.getObjetivos().isEmpty()){
            for (var i = 0; i < temp.getObjetivos().size(); i++){
                System.out.println(i + " - " + temp.getObjetivos().get(i));
            }
        }else{
            System.out.println("Lista de Objetivos está vazia");
        }
        System.out.println("=====================================");
        System.out.println("Deseja adicionar algum objetivo?");
        novaOpcao = scanner.nextLine();
        if (!novaOpcao.equals("")){
            temp.adicionarObjetivo(novaOpcao);
        }

        System.out.println("Deseja remover algum objetivo? (Informe a posição do objetivo ou aperte enter para continuar)");
        novaOpcao = scanner.nextLine();
        if (!novaOpcao.equals("")){
            int novaOpcaoInt = Integer.parseInt(novaOpcao);
            temp.removeObjetivo(novaOpcaoInt);
        }

        System.out.println("=====================================");
        if(!temp.getConteudo().isEmpty()){
            for (var i = 0; i < temp.getConteudo().size(); i++){
                System.out.println(i + " - " + temp.getConteudo().get(i));
            }
        }else{
            System.out.println("Lista de conteudos está vazia");
        }
        System.out.println("=====================================");
        System.out.println("Deseja adicionar algum conteudo?");
        novaOpcao = scanner.nextLine();
        if (!novaOpcao.equals("")){
            temp.adicionarConteudo(novaOpcao);
        }

        System.out.println("Deseja remover algum conteudo? (Informe a posição do conteudo ou aperte enter para continuar)");
        novaOpcao = scanner.nextLine();
        if (!novaOpcao.equals("")){
            int novaOpcaoInt = Integer.parseInt(novaOpcao);
            temp.removeConteudo(novaOpcaoInt);
        }
    }

    public void exibirInformacoes(){
        if (unidadesCurriculares.isEmpty()){
            System.out.println("Não é possível alterar, pois não existe nenhum componente curricular.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("Informe o codigo da unidade curricular que deseja verificar:");
        String codigoDaUnidade = scanner.next();
        if (unidadesCurriculares.containsKey(codigoDaUnidade)){
            UnidadeCurricular temp = unidadesCurriculares.get(codigoDaUnidade);
            System.out.println(temp.toString());
        }else {
            System.out.println("A unidade curricular não existe.");
        }
    }

    public void listarTodasUnidadesCurriculares(){
        if (unidadesCurriculares.isEmpty()){
            System.out.println("Não é possível alterar, pois não existe nenhum componente curricular.");
            return;
        }

        for (var v: unidadesCurriculares.values()){
            System.out.println("Sigla: " + v.getSigla() + " - Nome: " + v.getNome() + " - Créditos: " + v.getCreditos());
        }
    }

    public static void main(String[] args) {
        App app = new App();
        int escolha;

        do {
            escolha = app.menu();

            switch (escolha) {
                case 1 -> app.adicioneUnidadeCurricular();
                case 2 -> app.removaUnidadeCurricular();
                case 3 -> app.alterarUnidadeCurricular();
                case 4 -> app.exibirInformacoes();
                case 5 -> app.listarTodasUnidadesCurriculares();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }while (escolha != 6);
    }
}
