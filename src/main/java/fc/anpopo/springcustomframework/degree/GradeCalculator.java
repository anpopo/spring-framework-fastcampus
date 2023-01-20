package fc.anpopo.springcustomframework.degree;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;

    public GradeCalculator(List<Course> courseList) {
        this.courses = new Courses(courseList);
    }

    public double calculateGrade() {
        double totalCredit = courses.multipleCreditAndGrade();
        double totalCompletedCredit = courses.getTotalCompletedCredit();
        return totalCredit / totalCompletedCredit;
    }
}
