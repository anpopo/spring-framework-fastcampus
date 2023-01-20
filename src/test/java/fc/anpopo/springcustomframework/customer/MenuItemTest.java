package fc.anpopo.springcustomframework.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @DisplayName("메뉴를 생성한다")
    @Test
    void createMenuItemTest() {
        Assertions.assertThatCode(() -> new MenuItem("만두", 5000))
            .doesNotThrowAnyException();
    }
}
