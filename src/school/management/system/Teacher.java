package school.management.system;

/**
 * Created by Gurmad Harir on 16 March 2024.
 * This class is responsible for keeping the track of teacher's info
 */
public class Teacher {
    //fields
    private int id;
    private String name;
    private int salary;

    /**
     * Creates a new teacher object and initializes.
     * @param id     -> id of the teacher : unique.
     * @param name   -> name of the teacher.
     * @param salary -> salary of the teacher.
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Getters
     * @return -> Returns the id, name, & salary of the teacher.
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    /**
     * Updates the salary of the teacher which depends on its day to day progress.
     * @param salary -> It will be the new salary of the teacher.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }


}
