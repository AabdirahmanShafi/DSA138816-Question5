/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa138816assignment;

/**
 *
 * @author abdir
 */
import java.util.Stack;

public class OperationHistory {
    private Stack<String> history;

    public OperationHistory() {
        this.history = new Stack<>();
    }

    public void addOperation(String operation) {
        history.push(operation);
    }

    public String undoOperation() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return "No operations to undo.";
    }

    public void displayHistory() {
        for (String operation : history) {
            System.out.println(operation);
        }
    }
}
