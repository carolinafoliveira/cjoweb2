public class App {

    public static void main(String[] args) {

        Produto produto = new Produto(1, "Notebook");
        Produto produto2 = new Produto(2, "Mouse");
        Produto produto3 = new Produto(3, "Teclado Mecanico");
        Produto produto4 = new Produto(4, "Monitor");

        produto.setNome("Notebook Lenovo");
        produto.setPreco(3500.00);

        produto2.setNome("Mouse Lenovo");
        produto2.setPreco(150.00);

        produto3.setNome("Teclado Mecanico Lenovo");
        produto3.setPreco(599.99);

        produto4.setNome("Monitor ThinkVision");
        produto4.setPreco(699.86);

        System.out.println(produto);
        System.out.println();

        System.out.println(produto2);
        System.out.println();

        System.out.println(produto3);
        System.out.println();

        System.out.println(produto4);
    }
}