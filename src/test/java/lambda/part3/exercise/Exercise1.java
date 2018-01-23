package lambda.part3.exercise;

import lambda.data.Employee;
import lambda.data.Person;
import lambda.part3.example.Example1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Exercise1 {

    private static Person personExtractor(Employee employee) {
        return employee.getPerson();
    }

    private static String fullNameExtractor(Person person) {
        return person.getFullName();
    }

    private static int fullNameLengthExtractor(String fullName) {
        return fullName.length();
    }

    @Test
    public void mapEmployeesToLengthOfTheirFullNames() {
        List<Employee> employees = Example1.getEmployees();
        List<Integer> lengths = new ArrayList<>();

        for (Employee employee : employees) {
            lengths.add(fullNameLengthExtractor(fullNameExtractor(personExtractor(employee))));
        }

        assertEquals(Arrays.asList(14, 19, 14, 15, 14, 16), lengths);
    }
}
