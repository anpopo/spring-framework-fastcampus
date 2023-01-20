package fc.anpopo.springcustomframework.customer;

public class Chef {

    public Cook makeCook(MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return cook;
    }
}
