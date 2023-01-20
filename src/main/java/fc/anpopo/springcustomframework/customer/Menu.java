package fc.anpopo.springcustomframework.customer;

import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String menuItemName) {
        return menuItems.stream()
            .filter(menuItem -> menuItem.matches(menuItemName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }

}
