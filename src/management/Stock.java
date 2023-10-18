package management;

import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class Stock {
    public static ArrayList<Product> products = new ArrayList<>(){{
        add(new Product(100,"Coke",2.5,20, LocalDate.now()));
        add(new Product(101,"Anchor",2.5,10, LocalDate.now()));
        add(new Product(102,"Hanuman",2.5,25, LocalDate.now()));
        add(new Product(103,"IPhone",900.0,5, LocalDate.now()));
        add(new Product(104,"Mouse",10.0,12, LocalDate.now()));
    }};

}
