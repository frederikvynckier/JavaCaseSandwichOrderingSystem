package be.abis.sos.test;

import be.abis.sos.model.Instructor;
import be.abis.sos.model.Session;
import be.abis.sos.model.Student;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Purnima","Kashyap");
        Instructor instructor = new Instructor("Kashyap","Kashyap");

        Session session = new Session("Java Training",
                LocalDate.of(2026,11,9),
                LocalDate.of(2026,11,13)
                );
        System.out.println(student);
        System.out.println(instructor);
        System.out.println(session);
    }
}
