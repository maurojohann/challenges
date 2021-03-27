package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {
    public static void main(String[] args) {

        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Patricia");
        filaBanco.add("Roberto");
        filaBanco.add("Flavio");
        filaBanco.add("Pamela");
        filaBanco.add("Anderson");

        System.out.println(filaBanco);

        String clienteASerAtendido = filaBanco.poll();
        System.out.println("Cliente a ser Atendido: " +clienteASerAtendido);
        System.out.println(filaBanco);

        String primeiroCliente = filaBanco.peek();
        System.out.println("Primeiro Cliente na Fila: "+primeiroCliente);
        System.out.println(filaBanco);

       filaBanco.clear();
        String primeiroElementoOuError = filaBanco.poll();
        System.out.println(primeiroElementoOuError);

      //  System.out.println(filaBanco.spr);
    }
}
