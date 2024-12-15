package service;

import entity.CrispyFlour;
import entity.Material;

public interface IDiscount {
    double getRealMoney();
    double calculateTotalAmount();
    void sortByCost();
    double calculateDiscountDifference();
}
