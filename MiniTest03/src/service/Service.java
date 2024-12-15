package service;

import entity.CrispyFlour;
import entity.Material;
import entity.Meat;

public class Service implements IDiscount, ICrud {
    private final Material[] materials;
    private int size;

    public Service(int capacity) {
        materials = new Material[capacity];
        size = 0;
    }

    @Override
    public void addMaterial(Material material) {
        if (size < materials.length) {
            materials[size++] = material;
        } else {
            System.out.println("Array is full. Cannot add more materials.");
        }
    }

    @Override
    public void removeMaterial(String id) {
        for (int i = 0; i < size; i++) {
            if (materials[i].getId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    materials[j] = materials[j + 1];
                }
                materials[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Material not found.");
    }

    @Override
    public void updateMaterial(String id, Material updatedMaterial) {
        for (int i = 0; i < size; i++) {
            if (materials[i].getId().equals(id)) {
                materials[i] = updatedMaterial;
                return;
            }
        }
        System.out.println("Material not found.");
    }

    @Override
    public double calculateTotalAmount() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += materials[i].getAmount();
        }
        return total;
    }

    @Override
    public void sortByCost() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (materials[i].getCost() > materials[j].getCost()) {
                    Material temp = materials[i];
                    materials[i] = materials[j];
                    materials[j] = temp;
                }
            }
        }
    }

    @Override
    public double calculateDiscountDifference() {
        double noDiscountTotal = 0;
        double withDiscountTotal = 0;
        for (int i = 0; i < size; i++) {
            noDiscountTotal += materials[i].getAmount();
            if (materials[i] instanceof CrispyFlour) {
                withDiscountTotal += materials[i].getAmount() * 0.95;
            } else if (materials[i] instanceof Meat) {
                withDiscountTotal += materials[i].getAmount() * 0.90;
            }
        }
        return noDiscountTotal - withDiscountTotal;
    }

    @Override
    public void printMaterials() {
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + materials[i].getId() + ", Name: " + materials[i].getName() +
                    ", Cost: " + materials[i].getCost() + ", Amount: " + materials[i].getAmount());
        }
    }

    @Override
    public double getRealMoney() {
        double totalAmount = 0;

        for (Material m : this.materials) {
            if (m instanceof CrispyFlour) {
                totalAmount += m.getAmount() * 0.95;
            } else if (m instanceof Meat) {
                totalAmount += m.getAmount() * 0.90;
            }
        }

        return totalAmount;
    }
}
