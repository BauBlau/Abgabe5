package HashAlgorithm.sort;

public class Student {
    private String surname;
    private String prename;
    private int course;
    private int matriculationNumber;

    public Student(String surname, String prename, int course, int matriculationNumber) {
        super();
        this.surname = surname;
        this.prename = prename;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return "Student [surname=" + surname + ", prename=" + prename + ", course=" + course + ", matriculationNumber="
                + matriculationNumber + "]";
    }

    public String getSurname() {
        return surname;
    }

    public String getPrename() {
        return prename;
    }

    public int getCourse() {
        return course;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

}
