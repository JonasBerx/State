package ui;

import domain.FunForRent;

import javax.swing.*;

public class UiFunForRent {

    private FunForRent funForRent;

    public UiFunForRent() {
        this.funForRent = new FunForRent();
    }

    public void menu() {
        String menu = "1. Add party item\n2. Remove party item\n3. Rent party item\n4. Return party item\n5. Repair party item\n6. Show available party items\n\n0. Stop\n\n\nMake your choice:";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addItem();
            } else if (choice == 2) {
                remove();
            } else if (choice == 3) {
                toon();
            } else if (choice == 4) {
                brengTerug();
            } else if (choice == 5) {
                repareer();
            } else if (choice == 6) {
                toonBeschikbaar();
            }
        }
    }

    private void toonBeschikbaar() {
        JOptionPane.showMessageDialog(null, this.funForRent.toonBeschikbaar());
    }

    private void repareer() {
        String name = JOptionPane.showInputDialog("Enter the name of the party item you want to repair");
        this.funForRent.repareer(name);
    }

    private void brengTerug() {
        String name = JOptionPane.showInputDialog("Enter the name of the party item you want to return");
        JOptionPane.showMessageDialog(null, this.funForRent.brengTerug(name));
    }

    private void toon() {
        String name = JOptionPane.showInputDialog("Enter the name of the party item you want to rent");
        JOptionPane.showMessageDialog(null, this.funForRent.leenUit(name));
    }

    private void remove() {
        String name = JOptionPane.showInputDialog("Enter the name of the party item you want to delete");
        this.funForRent.verwijder(name);
    }

    private void addItem() {
        String name = JOptionPane.showInputDialog("Name of the party item.");
        int price = Integer.parseInt(JOptionPane.showInputDialog("Price of the party item."));
        this.funForRent.voegToe(name, price);
    }

}