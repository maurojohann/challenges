package testess;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;

public class  Teste {
    public static void main(String args[]) throws IOException{
        List<String> alfabeto = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
        List<String> entradas = new ArrayList<String>();
        Scanner sc = new Scanner(System.in,"ISO-8859-1");
     //   String text = "A banana is an elongated, edible fruit\n – botanically a berry – produced. by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called plantains, distinguishing them from dessert bananas. The fruit is variable in size, color, and firmness, but is usually elongated and curved, with soft flesh rich in starch covered with a rind, which may be green, yellow, red, purple, or brown when ripe. The fruits grow in clusters hanging from the top of the plant. Almost all modern edible seedless parthenocarp bananas come from two wild species – Musa acuminata and Musa balbisiana. The scientific names of most cultivated bananas are Musa acuminata, Musa balbisiana, and Musa × paradisiaca for the hybrid Musa acuminata × M. balbisiana, depending on their genomic constitution. The old scientific name for this hybrid, Musa sapientum, is no longer used.";
        

        while(true) {
          
          String frase = sc.nextLine()
                .trim()
                .toLowerCase()
                .replaceAll("\n", " ")
                .replaceAll("\t", " ");
                  
          if(frase.equals(".")) break;
          if(frase.length() < 0 || frase.isEmpty()) continue;

          List<String> vetPalavrasFrase = new ArrayList<>(Arrays.asList(frase.split(" ")));
          Map<String, String> dicionario = new HashMap<String, String>();

          alfabeto.stream().forEach(letra -> {
              
            dicionario.put(letra, "");
            
        });

        Map<String, Map<String, Integer>> repeticaoPalavra = new HashMap<String, Map<String, Integer>>();

        alfabeto.stream().forEach(letra -> {
            
            repeticaoPalavra.put(letra, new HashMap<String, Integer>());
        
        });

        vetPalavrasFrase.stream().forEach(palavra -> {
            
            repeticaoPalavra.get(palavra.substring(0, 1)).put(palavra, 0);
        
        });

        vetPalavrasFrase.stream().forEach(palavra -> {
            
            int qt = repeticaoPalavra.get(palavra.substring(0, 1)).get(palavra);
            qt++;
            repeticaoPalavra.get(palavra.substring(0, 1)).put(palavra, qt);
        
        });


        alfabeto.stream().forEach(letra -> {
            
            Map<String, Integer> map = repeticaoPalavra.get(letra);
            List<String> chaves = new ArrayList<String>(map.keySet());

            int qtTotalCharPorLetra = 0;
            
            for (String chave : chaves) {
                
                qtTotalCharPorLetra += map.get(chave) * chave.length();

            }

            int qtTotalCharMelhorCenario;
            int qtTotalCharMelhorCenarioAux = 10000;

            for (String chave : chaves) { 
                
                qtTotalCharMelhorCenario = (qtTotalCharPorLetra - (map.get(chave) * chave.length())) + (map.get(chave) * 2);
                
                if((qtTotalCharMelhorCenarioAux > qtTotalCharMelhorCenario) && chave.length() > 2) {
                    
                    qtTotalCharMelhorCenarioAux = qtTotalCharMelhorCenario;
                    dicionario.put(letra, chave);
                
                }
            
            }
        
        });

        String fraseAbreviada = vetPalavrasFrase
            .stream()
            .map(palavra -> {

                String primeiraLetra = palavra.substring(0, 1);
                return dicionario.get(primeiraLetra).equals(palavra) ? primeiraLetra + "." : palavra;
            
            }).collect(Collectors.joining(" "));;

            System.out.println(fraseAbreviada);
            int quantidadeAbreviacoes = 0;
            
            for(String letra : alfabeto) {

                if(!dicionario.get(letra).equals("")) {

                    quantidadeAbreviacoes++;
                
                }
            
            }

            System.out.println(quantidadeAbreviacoes);

            alfabeto.stream().forEach(letra -> {
                
                if(!dicionario.get(letra).equals("")) {
                    
                    System.out.println(letra + ". = " + dicionario.get(letra) );
                
                }
            
            });

        }
        
    }

}
