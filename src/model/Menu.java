package model;

import org.nocrala.tools.texttablefmt.CellStyle;

import java.util.ArrayList;

public class Menu {
    public static ArrayList<String> menu =  new ArrayList<>(){{
        add("1. Display all");
        add("2. Add product");
        add("3. Update product");
        add("4. Delete product");
        add("5. Set row to display product");
        add("6. Search product");
        add("7. Read product");
        add("8. Exit");
    }};
}
