/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa138816assignment;

/**
 *
 * @author abdir
 */
import java.util.LinkedList;

public class SupplierList {
    private LinkedList<Supplier> suppliers;

    public SupplierList() {
        this.suppliers = new LinkedList<>();
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public Supplier getSupplier(int id) {
        for (Supplier supplier : suppliers) {
            if (supplier.getId() == id) {
                return supplier;
            }
        }
        return null;
    }

    public void removeSupplier(int id) {
        suppliers.removeIf(supplier -> supplier.getId() == id);
    }

    public void displaySuppliers() {
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }
    }
}
