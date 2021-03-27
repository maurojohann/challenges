package maps;

import java.util.HashMap;
import java.util.Map;

public class ExemploHasMap {
    public static void main(String[] args) {

        Map<String, Integer> campeoesMudiaisFifa= new HashMap<>();

        campeoesMudiaisFifa.put("Brasil", 5);
        campeoesMudiaisFifa.put("Alemanha", 4);
        campeoesMudiaisFifa.put("Italia", 4);
        campeoesMudiaisFifa.put("Uruguai", 2);
        campeoesMudiaisFifa.put("Franca", 2);
        campeoesMudiaisFifa.put("Argentina", 2);
        campeoesMudiaisFifa.put("Espanha", 1);
        campeoesMudiaisFifa.put("Inglatera", 5);

        System.out.println(campeoesMudiaisFifa);

        campeoesMudiaisFifa.get(3);

        System.out.println(campeoesMudiaisFifa);


    }
}
