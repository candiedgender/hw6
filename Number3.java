import java.util.Collection;

public class Number3<T extends Comparable<? super T>,
        C extends Collection<T>> {

    C c;

    public T findMin() {
        T min = null;
        for (T t : c) {
            if ((min == null) || t != null || t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }
}