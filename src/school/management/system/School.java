package school.management.system;

import java.util.ArrayList;

/**
 * Created by Gurmad Harir on 17 March 2024.
 * This class is responsible for keeping the track of School.
 */
public class School {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private int totalMoneyEarned;
    private int totalMoneySpent;

    /**
     * new Object school is created.
     * @param teachers -> List of teachers in the school
     * @param students -> List of students in the school.
     */
    public School(ArrayList<Teacher> teachers, ArrayList<Student> students) {
        this.teachers = teachers;
        this.students = students;
    }

    /**
     * Adds a teacher to the school
     * @param teacher -> The new teacher.
     */
    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }
    /**
     * Adds a student to the school
     * @param student -> The new student.
     */
    public void AddStudent(Student student) {
        this.students.add(student);
    }

    public void updateTotalMoneyEarned(int moneyEarned) {
        this.totalMoneyEarned += totalMoneyEarned;
    }

    public void updateTotalMoneySpent(int moneySpent) {
        this.totalMoneySpent -= totalMoneySpent;
    }

    /**
     * Getters
     * @return -> They will return fields of the school.
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }
}
