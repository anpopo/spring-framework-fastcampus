package fc.anpopo.springcustomframework.degree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {
    @DisplayName("과목을 생성한다")
    @Test
    void createCourseTest() {
        Assertions.assertThatCode(() -> new Course("OOP", 3, "A+"))
            .doesNotThrowAnyException();
    }

}
