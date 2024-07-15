/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa138816assignment;

/**
 *
 * @author abdir
 */
import java.util.Scanner;

public class Dsa138816Assignment {
    private Inventory inventory;
    private SupplierList supplierList;
    private OperationHistory operationHistory;
    private OrderQueue orderQueue;
    private Scanner scanner;

    public Dsa138816Assignment() {
        this.inventory = new Inventory();
        this.supplierList = new SupplierList();
        this.operationHistory = new OperationHistory();
        this.orderQueue = new OrderQueue();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1: addProduct(); break;
                case 2: removeProduct(); break;
                case 3: inventory.displayProducts(); break;
                case 4: addSupplier(); break;
                case 5: removeSupplier(); break;
                case 6: supplierList.displaySuppliers(); break;
                case 7: addOrder(); break;
                case 8: processOrder(); break;
                case 9: orderQueue.displayOrders(); break;
                case 10: undoLastOperation(); break;
                case 11: operationHistory.displayHistory(); break;
                case 12: exit = true; break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nSupplies Management System:");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Display Products");
        System.out.println("4. Add Supplier");
        System.out.println("5. Remove Supplier");
        System.out.println("6. Display Suppliers");
        System.out.println("7. Add Order");
        System.out.println("8. Process Order");
        System.out.println("9. Display Orders");
        System.out.println("10. Undo Last Operation");
        System.out.println("11. Display Operation History");
        System.out.println("12. Exit");
        System.out.print("Choose an option: ");
    }

    private void addProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(id, name, quantity);
        inventory.addProduct(product);
        operationHistory.addOperation("Added Product: " + product);
    }

    private void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product = inventory.getProduct(id);
        if (product != null) {
            inventory.removeProduct(id);
            operationHistory.addOperation("Removed Product: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void addSupplier() {
        System.out.print("Enter supplier ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter supplier name: ");
        String name = scanner.nextLine();

        Supplier supplier = new Supplier(id, name);
        supplierList.addSupplier(supplier);
        operationHistory.addOperation("Added Supplier: " + supplier);
    }

    private void removeSupplier() {
        System.out.print("Enter supplier ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Supplier supplier = supplierList.getSupplier(id);
        if (supplier != null) {
            supplierList.removeSupplier(id);
            operationHistory.addOperation("Removed Supplier: " + supplier);
        } else {
            System.out.println("Supplier not found.");
        }
    }

    private void addOrder() {
        System.out.print("Enter order details: ");
        String order = scanner.nextLine();
        orderQueue.addOrder(order);
        operationHistory.addOperation("Added Order: " + order);
    }

    private void processOrder() {
        String order = orderQueue.processOrder();
        if (order != null) {
            System.out.println("Processed Order: " + order);
            operationHistory.addOperation("Processed Order: " + order);
        } else {
            System.out.println("No orders to process.");
        }
    }

    private void undoLastOperation() {
        String operation = operationHistory.undoOperation();
        System.out.println("Undo Operation: " + operation);
    }

    public static void main(String[] args) {
        Dsa138816Assignment system = new Dsa138816Assignment();
        system.run();
    }
}
