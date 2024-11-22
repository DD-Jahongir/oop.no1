import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MySet<T> {
    private List<T> elements;

    // Конструктор
    public MySet() {
        this.elements = new ArrayList<>();
    }

    // Добавление элемента (без дублирования)
    public void add(T element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    // Удаление элемента
    public void remove(T element) {
        elements.remove(element);
    }

    // Объединение множеств
    public MySet<T> union(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        result.elements.addAll(this.elements); // Копируем текущие элементы
        for (T element : otherSet.elements) {
            if (!result.elements.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    // Пересечение множеств
    public MySet<T> intersection(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        for (T element : this.elements) {
            if (otherSet.elements.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    // Разность множеств
    public MySet<T> difference(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        for (T element : this.elements) {
            if (!otherSet.elements.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    // Вывод множества
    public void printSet() {
        System.out.println(elements);
    }

    // Пример использования
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MySet<Integer> set1 = new MySet<>();
        MySet<Integer> set2 = new MySet<>();

        System.out.println("Введите количество элементов для множества 1:");
        int n = scanner.nextInt(); // Считываем количество элементов

        for (int i = 1; i < n+1; i++) {
            System.out.println("Введите элемент множества №:" + i);
            int element = scanner.nextInt(); // Считываем элемент
            set1.add(element); // Добавляем в множество
        }


        System.out.println("Введите количество элементов для множества 2:");
        n = scanner.nextInt();

        for (int i = 1; i < (n+1); i++) {
            System.out.println("Введите элемент множества №:" + i );
            int element = scanner.nextInt(); // Считываем элемент
            set2.add(element); // Добавляем в множество
        }

        System.out.println("Множество 1:");
        set1.printSet();

        System.out.println("Множество 2:");
        set2.printSet();

        // Объединение
        MySet<Integer> unionSet = set1.union(set2);
        System.out.println("Объединение:");
        unionSet.printSet();

        // Пересечение
        MySet<Integer> intersectionSet = set1.intersection(set2);
        System.out.println("Пересечение:");
        intersectionSet.printSet();

        // Разность
        MySet<Integer> differenceSet = set1.difference(set2);
        System.out.println("Разность:");
        differenceSet.printSet();

        //Удаление элемента
        System.out.println("Введите элемент для удаления:");
        int el = scanner.nextInt();
        set1.remove(el);
        System.out.println("После удаления:");
        set1.printSet();

        scanner.close();
    }
}
