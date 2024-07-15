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
import java.util.Queue;

public class OrderQueue {
    private Queue<String> orders;

    public OrderQueue() {
        this.orders = new LinkedList<>();
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public String processOrder() {
        return orders.poll();
    }

    public void displayOrders() {
        for (String order : orders) {
            System.out.println(order);
        }
    }
}
