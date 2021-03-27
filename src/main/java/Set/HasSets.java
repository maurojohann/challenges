package Set;

import java.util.HashSet;
import java.util.Set;

public class HasSets {
    public static void main(String[] args) {
        Set<Double> notasAlunos = new HashSet<>();

        notasAlunos.add(10.0);
        notasAlunos.add(9.0);
        notasAlunos.add(8.0);
        notasAlunos.add(7.0);
        notasAlunos.add(6.0);
        notasAlunos.add(5.0);
        notasAlunos.add(4.0);
        System.out.println(notasAlunos);
        notasAlunos.add(3.0);
        notasAlunos.add(2.0);
        notasAlunos.add(null);
        System.out.println(notasAlunos);
        notasAlunos.remove(4.0);
        System.out.println(notasAlunos);
    }
}
