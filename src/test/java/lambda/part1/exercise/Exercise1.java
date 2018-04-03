package lambda.part1.exercise;

import com.google.common.collect.FluentIterable;
import lambda.data.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Exercise1 {

    @Test
    public void sortPersonsByAgeUsingArraysSortComparator() {
        Person[] persons = getPersons();

        // TODO использовать Arrays.sort
        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        };

        Arrays.sort(persons, personComparator);


        assertArrayEquals(new Person[]{
            new Person("Иван", "Мельников", 20),
            new Person("Николай", "Зимов", 30),
            new Person("Алексей", "Доренко", 40),
            new Person("Артем", "Зимов", 45)
        }, persons);
    }

    @Test
    public void sortPersonsByAgeUsingArraysSortAnonymousComparator() {
        Person[] persons = getPersons();

        // TODO использовать Arrays.sort
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        assertArrayEquals(new Person[]{
            new Person("Иван", "Мельников", 20),
            new Person("Николай", "Зимов", 30),
            new Person("Алексей", "Доренко", 40),
            new Person("Артем", "Зимов", 45)
        }, persons);
    }

    @Test
    public void sortPersonsByLastNameThenFirstNameUsingArraysSortAnonymousComparator() {
        Person[] persons = getPersons();

        // TODO использовать Arrays.sort
        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int lastNameCompare = o1.getLastName().compareTo(o2.getLastName());
                if( lastNameCompare != 0){
                    return lastNameCompare;
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };

        Arrays.sort(persons, personComparator);

        assertArrayEquals(new Person[]{
            new Person("Алексей", "Доренко", 40),
            new Person("Артем", "Зимов", 45),
            new Person("Николай", "Зимов", 30),
            new Person("Иван", "Мельников", 20)
        }, persons);
    }

    @Test
    public void findFirstWithAge30UsingGuavaPredicate() {
        List<Person> persons = Arrays.asList(getPersons());

        // TODO использовать FluentIterable
        com.google.common.base.Predicate<Person> predicate = new com.google.common.base.Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getAge() == 30;
            }
        };

        com.google.common.base.Optional<Person> personOptional = FluentIterable.from(persons).firstMatch(predicate);

        if(personOptional.isPresent()) {
            assertEquals(new Person("Николай", "Зимов", 30), personOptional.get());
        }
    }

    @Test
    public void findFirstWithAge30UsingGuavaAnonymousPredicate() {
        List<Person> persons = Arrays.asList(getPersons());

        // TODO использовать FluentIterable
        com.google.common.base.Optional<Person> personOptional = FluentIterable.from(persons).firstMatch(new com.google.common.base.Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getAge() == 30;
            }
        });

        if(personOptional.isPresent()) {
            assertEquals(new Person("Николай", "Зимов", 30), personOptional.get());
        }
    }

    private Person[] getPersons() {
        return new Person[]{
            new Person("Иван", "Мельников", 20),
            new Person("Алексей", "Доренко", 40),
            new Person("Николай", "Зимов", 30),
            new Person("Артем", "Зимов", 45)
        };
    }
}
