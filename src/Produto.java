package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Produto{
    private Long id;
    public String name;
    private double price;
    private int quantity;
    public Produto(Long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "ID:"+id +"|" +"\s" +"Name:"+name +"|" +"\s" +"Price:"+price +"|"+"\s" +"Quantity:"+quantity; 
    }
}

class Main{
    static List<Produto> products = new ArrayList<>();
    public static void main(String[] args) {
        int op ;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1-Cadastro de produto");
            System.out.println("2-Filtrar produto");
            System.out.println("3-Preço total");
            System.out.println("4-Listar todos");
            System.out.println("5-mostrar total de cada estoque");
            System.out.println("6-Sair");
            System.out.print("opção:");
            op = sc.nextInt();
            switch (op) {
              case 1-> Cadastro(sc);
              case 2-> filtrar(sc);
              case 3-> total(sc);
              case 4->listar();
              case 5-> mostrar();
              case 6-> System.out.println("Programa encerrado");
              default -> System.out.println("Opção inválida!");
            }
        } while (op != 6);
        sc.close();
    }
    public static void Cadastro(Scanner sc){
        System.out.println("Digite o ID:");
        Long id = sc.nextLong();
        if(products.stream().anyMatch(product-> id.equals(product.getId()))){
            System.out.println("Produto já cadastrado");
            return;
        }
        sc.nextLine();
        System.out.print("Nome do produto:");

        String nome = sc.nextLine();
        System.out.print("Preço do produto:");
        double price = sc.nextDouble();
        System.out.print("Quantidade do produto:");
        int quantity = sc.nextInt();
        Produto produto = new Produto(id, nome, price, quantity);
        products.add(produto);
      
        System.out.println("Produto cadastrado  com sucesso");
        System.out.println("================================");
    }
    public static void filtrar(Scanner sc){
        if(products.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
            return;
        }
        System.out.println("Digite o ID:");
        long id = sc.nextInt();
        products.stream().filter(produtos -> id == produtos.getId()).forEach(System.out::println);
    }
    public static void total (Scanner sc){
         if(products.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
            return;
        }
        for (Produto produto : products) {
            System.out.println(produto);
        }
        double total = products.stream().mapToDouble(products-> products.getPrice()*products.getQuantity()).sum();
        System.out.println("Valor total dos produtos:"+total);
         System.out.println("================================");
    }
    public static void listar(){
        if(products.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
                return;}
                for (Produto produto : products) {
                    System.out.println(produto);
                    System.out.println("================================");
                }
}

public static void mostrar(){
      if(products.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
                return;
            }
            for (Produto produto : products) {
                System.out.println(produto);
            }
            int quantidade = products.stream().mapToInt(products-> products.getQuantity()).sum();
            System.out.println("Quantidade de total:"+quantidade);



             System.out.println("================================");
}

        public static void testCRUD() {
        products.clear();

        products.add(new Produto(1L, "Caneta", 2.5, 10));
        products.add(new Produto(2L, "Caderno", 15.0, 5));
        products.add(new Produto(3L, "Lápis", 1.0, 20));

        System.out.println("=== Lista de Produtos ===");
        listar();

        System.out.println("=== Total de Estoque ===");
        mostrar();

        System.out.println("=== Valor Total ===");
        total(null);
    }

}