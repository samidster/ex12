import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> list = setList();

//        list.stream().forEach(System.out::println);
        System.out.println("-----Ascending sorted:");
        list.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge).thenComparing(User::getWeight)).forEach(System.out::println);

        System.out.println("-----Descending sorted:");
        list.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge).thenComparing(User::getWeight).reversed()).forEach(System.out::println);

        Map<String, List<User>> groupByName = list.stream().collect(Collectors.groupingBy(User::getName));
        groupByName.forEach((name,fio) -> {
            System.out.print("-----Grouped by name ");
            System.out.println(name + ":");
            fio.forEach(System.out::println);
                }
        );

        Map<Integer, List<User>> groupByAdult = list.stream().collect(Collectors.groupingBy(User::getAge));
        groupByAdult.forEach((age,user) -> {
                    System.out.print("-----Grouped by Adult ");
                    user.forEach(user1 -> {
                        age >= 18;
                    }System.out.println(user + ":");
                    fio.forEach(System.out::println);
                }
        );


    }

    private static List<User> setList() {
        return Arrays.asList(new User("Ivan",23,56.6),
                new User("Petr",17,61.7),
                new User("Stepan",13,36.5),
                new User("Andrey",68,84.7),
                new User("Stepan",18,49.4),
                new User("Petr",17,57.9));
    }
}
