package fc.anpopo.springcustomframework.degree;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DegreeCalculatorTest {

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courseList = List.of(
            new Course("OOP", 3, "A+"),
            new Course("자료구조", 3, "A+"),
            new Course("알고리즘", 3, "A+")
        );

        GradeCalculator gradeCalculator = new GradeCalculator(courseList);

        double gradeResult = gradeCalculator.calculateGrade();

        Assertions.assertThat(gradeResult).isEqualTo(4.5);
    }
}
