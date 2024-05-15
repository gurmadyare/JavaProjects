package school.management.system;

/**
 * Created by Gurmad Harir on 16 March 2024.
 * This class is responsible for keeping the track of students info.
 */
public class Student {
    //fields
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * TO create a new student by initializing.
     * @param id    -> id for the student : unique.
     * @param name  -> name of the student.
     * @param grade -> grade of the student.
     * feesTotal for every new student will be $10,000 per year.
     * fees paid initially will be 0
     */
    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 10000;
    }

    /**
     * Used to update the student's grade.
     * @param grade -> It will be the new grade of the student.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Keeps adding the fees to the fees paid.
     * The school is going to receive the funds.
     * @param feesPaid -> is the fees that the student pays.
     */
    public void setFeesPaid(int feesPaid) {
        this.feesPaid += feesPaid;
    }

    /**
     * Getters
     * @return -> returns the student's fields.
     */
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    public int getFeesPaid() { return feesPaid;}
    public int getFeesTotal() { return feesTotal; }


}
