package fc.anpopo.springcustomframework.customer;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("메뉴 이름에 해당하는 메뉴를 반환한다")
    @Test
    void chooseMenuTest() {
        Menu menu = new Menu(List.of(new MenuItem("만두", 5000), new MenuItem("초밥", 10000)));

        MenuItem menuItem = menu.choose("만두");

        Assertions.assertThat(menuItem).isEqualTo(new MenuItem("만두", 5000));
    }

    @DisplayName("메뉴가 없는 경우 예외를 반환한다.")
    @Test
    void chooseMenuNotContainsException() {
        Menu menu = new Menu(List.of(new MenuItem("만두", 5000), new MenuItem("초밥", 10000)));

        Assertions.assertThatThrownBy(() -> menu.choose("양념 갈비"))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 메뉴 이름입니다.");
    }

}
