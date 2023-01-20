package fc.anpopo.springcustomframework.customer;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Menu menu;
    @BeforeEach
    public void init() {
        menu = new Menu(List.of(new MenuItem("만두", 5000), new MenuItem("초밥", 10000)));
    }
    @DisplayName("메뉴를 주문한다")
    @Test
    void orderTest() {

        Customer customer = new Customer();
        MenuItem chooseMenuItem = customer.order(menu, "만두");

        Cook cook = new Cook(chooseMenuItem);

        Assertions.assertThat(chooseMenuItem.getName()).isEqualTo(cook.getName());
        Assertions.assertThat(chooseMenuItem.getPrice()).isEqualTo(cook.getPrice());

    }

}
