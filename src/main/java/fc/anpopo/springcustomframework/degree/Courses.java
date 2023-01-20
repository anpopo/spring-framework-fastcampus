package fc.anpopo.springcustomframework.degree;

import java.util.List;

public class Courses {
    private List<Course> courses;

    public Courses(List<Course> courseList) {
        this.courses = courseList;
    }

    public double multipleCreditAndGrade() {
        return courses.stream()
            .mapToDouble(Course::multiplyCreditAndGrade)
            .sum();
    }

    public double getTotalCompletedCredit() {
        return courses.stream().mapToInt(Course::getCredit).sum();
    }
}
