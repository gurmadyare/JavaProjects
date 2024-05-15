package school.management.system;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //let's create a new teacher objects
        Teacher jama = new Teacher(1, "Jama Gure", 2000);
        Teacher ambaro = new Teacher(2, "Ambaro Abdi", 3000);
        Teacher farah = new Teacher(3, "Farah Muse", 1500);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(jama);
        teachers.add(ambaro);
        teachers.add(farah);

        //let's create new student objects
        Student hassan = new Student(1, "Hassan Mohamed", 5);
        Student mohamed = new Student(2, "Mohamed Ali", 10);
        Student halima = new Student(3, "Halima Ahmed", 5);

        ArrayList<Student> students = new ArrayList<>();
        students.add(halima);
        students.add(mohamed);
        students.add(hassan);

        //school object
        School aynan = new School(teachers, students);
        System.out.println(aynan.getTotalMoneyEarned());






    }
}
