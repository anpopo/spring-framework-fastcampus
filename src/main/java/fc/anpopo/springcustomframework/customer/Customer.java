package fc.anpopo.springcustomframework.customer;

public class Customer {

    public MenuItem order(Menu menu, String menuName) {
        return menu.choose(menuName);
    }
}
