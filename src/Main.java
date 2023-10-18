import mainMenu.MainMenu;
import management.Stock;

import static management.Stock.products;
import static renderTable.Render.renderAddProduct;
import static renderTable.Render.renderProduct;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.runProgram();
    }
}
