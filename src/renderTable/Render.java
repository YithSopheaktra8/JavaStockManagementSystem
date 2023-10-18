package renderTable;

import model.Menu;
import model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Render {

    public static int totalRow = 2;

    public static void renderMenu(ArrayList<String> menus){
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);

        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        t.setColumnWidth(0, 8, 30);

        System.out.println((int)Math.ceil(5.0/3));

        t.addCell("Stock Management System",cellCenter);
        for(String menu : menus){
            t.addCell(menu);
        }
        System.out.println(t.render());
    }

    public static void renderSetRow(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter row to display : ");
        totalRow = input.nextInt();
    }

    public static void renderProduct(ArrayList<Product> products){
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);
        CellStyle cellLeft = new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellRight = new CellStyle(CellStyle.HorizontalAlign.right);

        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        t.setColumnWidth(0, 8, 30);

        t.addCell("ID");
        t.addCell("NAME");
        t.addCell("PRICE");
        t.addCell("QTY");
        t.addCell("DATE");

        for(Product product : products){
            t.addCell(product.getProductID()+"");
            t.addCell(product.getProductName());
            t.addCell(product.getUnitPrice()+"");
            t.addCell(product.getQuantity()+"");
            t.addCell(product.getDate()+"");
        }

        int page = (int) Math.ceil((double) products.size()/ totalRow);

//        for(int i = 0 ; i<totalRow; i++){
//            Product product = products.get(i);
//            t.addCell(product.getProductID()+"");
//            t.addCell(product.getProductName());
//            t.addCell(product.getUnitPrice()+"");
//            t.addCell(product.getQuantity()+"");
//            t.addCell(product.getDate()+"");
//        }


        Table table = new Table(2,BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0,10,50);
        table.setColumnWidth(1,10,50);


        table.addCell("Page : "+page,cellLeft);
        table.addCell("Total record : "+products.size(),cellRight);

        table.addCell("(P)Previous page",cellLeft);
        table.addCell("(N)Next page",cellRight);

        System.out.println(t.render());
        System.out.println(table.render());
    }

    public static void renderNextRecord(ArrayList<Product> products){

    }

    public static void renderAddProduct(ArrayList<Product> products){
        Scanner input = new Scanner(System.in);
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);

        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 8, 30);

        products.add(new Product().inputProduct(input));
        t.addCell("Add product to Stock successfully",cellCenter);
        System.out.println(t.render());
    }

    public static void renderUpdateProduct(ArrayList<Product> products){
        Scanner input = new Scanner(System.in);
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);

        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 8, 50);
        renderProduct(products);
        System.out.println("Input product ID to update : ");
        int updateId = input.nextInt();
        for(Product product : products){
            boolean isTrue = false;
            if (updateId == product.getProductID()){
                t.addCell("Update product in Stock",cellCenter);
                System.out.println("i(ID), n(Name), p(Price), q(Qty), *(all)");
                System.out.print("Choose option : ");
                char upChoice = input.next().charAt(0);
                if(upChoice == 'i' || upChoice == 'I'){
                    System.out.print("input new ID : ");
                    int newID = input.nextInt();
                    product.setProductID(newID);
                    break;
                } else if (upChoice == 'n' || upChoice == 'N') {
                    System.out.print("Input new Name : ");
                    String newName = input.nextLine();
                    product.setProductName(newName);
                } else if (upChoice == 'p') {
                    System.out.print("Input new Price : ");
                    double newPrice = input.nextDouble();
                    product.setUnitPrice(newPrice);
                } else if (upChoice == 'q' || upChoice == 'Q') {
                    System.out.print("Input new Quantity : ");
                    int newQty = input.nextInt();
                    product.setQuantity(newQty);
                } else if (upChoice == '*') {
                    System.out.print("Input new ID :");
                    int newID = input.nextInt();
                    product.setProductID(newID);
                    System.out.print("Input new Name : ");
                    input.nextLine();
                    String newName = input.nextLine();
                    product.setProductName(newName);
                    System.out.print("Input new Price : ");
                    double newPrice = input.nextDouble();
                    product.setUnitPrice(newPrice);
                    System.out.print("Input new Qty : ");
                    int newQty = input.nextInt();
                    product.setQuantity(newQty);
                    product.setDate(LocalDate.now());
                }
            }
        }
        t.addCell("Product update successfully",cellCenter);
        System.out.println(t.render());
    }

    public static void renderDeleteProduct(ArrayList<Product> products){
        Scanner input = new Scanner(System.in);
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);

        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 8, 50);
        renderProduct(products);

        System.out.print("choose ID to delete Product : ");
        int delID = input.nextInt();

        System.out.print("Are you sure ? Y/N : ");
        char choice = input.next().charAt(0);
        if(choice == 'y' || choice == 'Y'){
            products.removeIf(product -> product.getProductID() == delID);
            t.addCell("Remove product from stock Successfully !",cellCenter);
        }else {
            return;
        }
        System.out.println(t.render());
    }

    public static void renderSearch(ArrayList<Product> products){
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);
        CellStyle cellLeft = new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellRight = new CellStyle(CellStyle.HorizontalAlign.right);

        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        t.setColumnWidth(0, 8, 30);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name to search : ");
        String searchName = input.nextLine();
        t.addCell("ID");
        t.addCell("NAME");
        t.addCell("PRICE");
        t.addCell("QTY");
        t.addCell("DATE");
        System.out.println("--> Product that contain "+searchName+" in the productName are : ");
        for(Product product : products){
            if(product.getProductName().toLowerCase().contains(searchName)){
                t.addCell(product.getProductID()+"");
                t.addCell(product.getProductName());
                t.addCell(product.getUnitPrice()+"");
                t.addCell(product.getQuantity()+"");
                t.addCell(product.getDate()+"");
            }else{
                System.out.println("Product not found!");
            }
        }

        System.out.println(t.render());
    }

    public static void renderOneProduct(ArrayList<Product> products){
        Scanner input = new Scanner(System.in);
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);

        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND);
        t.setColumnWidth(0, 8, 30);
        System.out.print("Input product ID : ");
        int readProduct = input.nextInt();
        for (Product product : products){
            if(product.getProductID() == readProduct){
                t.addCell("ID              : "+product.getProductID());
                t.addCell("Name            : "+product.getProductName());
                t.addCell("Unit Price      : "+product.getUnitPrice());
                t.addCell("QTY             : "+product.getQuantity());
                t.addCell("Imported Date   : "+product.getDate());
            }else {
                System.out.println("Product ID not found!");
            }
        }



        System.out.println(t.render());

    }

}
