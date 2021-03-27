package exemploOptionales;

import java.util.Optional;

public class ExemploOptional
{
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("Valor presente");
        System.out.println("Valor  opcional que está presente");
        optionalString.ifPresentOrElse(System.out::println,() -> System.out.println("Não Está Presente"));

        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("Valor  opcional que não está presente");
              optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("Null = Não está presente") );

        Optional<String> optionalEmpty = Optional.empty();
        System.out.println("Valor  opcional que não está presente");
        optionalEmpty.ifPresentOrElse(System.out::println, ()-> System.out.println("empty = não está presente"));




    }
}
