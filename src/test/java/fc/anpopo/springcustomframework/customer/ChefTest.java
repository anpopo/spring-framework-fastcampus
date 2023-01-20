package fc.anpopo.springcustomframework.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChefTest {

    @DisplayName("메뉴에 해당하는 음식을 만든다")
    @Test
    void makeCookTest() {
        Chef chef = new Chef();
        MenuItem menuItem = new MenuItem("만두", 5000);
        Cook cook = chef.makeCook(menuItem);

        Assertions.assertThat(cook).isEqualTo(new Cook("만두", 5000));
    }

}
