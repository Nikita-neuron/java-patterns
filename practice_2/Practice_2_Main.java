package practice_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice_2_Main {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human(20, "Ashley", "Martinez", LocalDate.of(2002, 5, 20), 72));
        humans.add(new Human(21, "Rhonda", "Miller", LocalDate.of(2001, 10, 17), 61));
        humans.add(new Human(19, "Lauren", "Salas", LocalDate.of(2003, 8, 30), 75));
        humans.add(new Human(20, "Chad", "Powell", LocalDate.of(2002, 3, 25), 80));

        Stream<Human> humanStream = humans.stream();
        String result = humanStream.sorted(Comparator.comparingInt(o -> o.getAge() + o.getWeight()))
                .filter(o -> o.getWeight() % 5 == 0)
                .limit(4)
                .map(Human::getFirstName)
                .collect(Collectors.joining(" "));
//                .forEach(System.out::println);
        System.out.println(result);
    }
}
