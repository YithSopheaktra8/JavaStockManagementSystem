package mainMenu;

import java.util.Scanner;

import static helper.Helper.pressEnter;
import static management.Stock.products;
import static model.Menu.menu;
import static renderTable.Render.*;

public class MainMenu {
    public void runProgram() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            renderMenu(menu);
            System.out.print("Choose option : ");
            choice = input.nextInt();
            switch (choice){
                case 1 : {
                    renderProduct(products);
                    break;
                }
                case 2 : {
                    renderAddProduct(products);
                    break;
                }
                case 3 : {
                    renderUpdateProduct(products);
                    break;
                }
                case 4: {
                    renderDeleteProduct(products);
                    break;
                }
                case 5: {
                    renderSetRow();
                    break;
                }
                case 6 :{
                    renderSearch(products);
                    break;
                }
                case 7 : {
                    renderOneProduct(products);
                    break;
                }
                case 8 : {
                    System.out.println("Are you sure want to exit the program ? Y/N");
                    char makeChose;
                    input.nextLine();
                    makeChose = input.nextLine().charAt(0);
                    if(makeChose == 'y' || makeChose == 'Y') return;
                    else if (makeChose == 'n' || makeChose == 'N') break;
                }
                default:
                    System.out.println("Invalid option! choose again");
            }
            pressEnter();
        } while (choice != 8);
    }
}
