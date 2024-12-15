package main;

import entity.CrispyFlour;
import entity.Meat;
import service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service(10);

        // Tạo 5 đối tượng CrispyFlour
        service.addMaterial(new CrispyFlour("CF1", "Crispy Flour 1", LocalDate.now(), 100, 10));
        service.addMaterial(new CrispyFlour("CF2", "Crispy Flour 2", LocalDate.now(), 120, 20));
        service.addMaterial(new CrispyFlour("CF3", "Crispy Flour 3", LocalDate.now(), 110, 15));
        service.addMaterial(new CrispyFlour("CF4", "Crispy Flour 4", LocalDate.now(), 130, 5));
        service.addMaterial(new CrispyFlour("CF5", "Crispy Flour 5", LocalDate.now(), 140, 8));

        // Tạo 5 đối tượng Meat
        service.addMaterial(new Meat("M1", "Meat 1", LocalDate.now(), 250, 2));
        service.addMaterial(new Meat("M2", "Meat 2", LocalDate.now(), 200, 3));
        service.addMaterial(new Meat("M3", "Meat 3", LocalDate.now(), 220, 1));
        service.addMaterial(new Meat("M4", "Meat 4", LocalDate.now(), 210, 4));
        service.addMaterial(new Meat("M5", "Meat 5", LocalDate.now(), 240, 2));

        // In danh sách vật liệu
        System.out.println("Materials before sorting:");
        service.printMaterials();

        // Tính tổng tiền của 10 vật liệu
        double totalAmount = service.calculateTotalAmount();
        System.out.println("Total amount: " + totalAmount);

        // Tính số chênh lệch giữa chiết khấu và không chiết khấu
        double discountDifference = service.calculateDiscountDifference();
        System.out.println("Discount difference: " + discountDifference);

        // Sắp xếp vật liệu theo giá và in ra
        service.sortByCost();
        System.out.println("\nMaterials after sorting by cost:");
        service.printMaterials();

        // Cập nhật và xóa vật liệu
        service.updateMaterial("CF2", new CrispyFlour("CF2", "Updated Crispy Flour", LocalDate.now(), 150, 25));
        service.removeMaterial("M3");

        System.out.println("\nMaterials after update and removal:");
        service.printMaterials();

        // Tính tổng tiền với chiết khấu
        double totalWithDiscount = service.getRealMoney();
        System.out.println("Total amount with discount: " + totalWithDiscount);
    }
}
