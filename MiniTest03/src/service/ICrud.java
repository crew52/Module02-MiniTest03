package service;

import entity.Material;

public interface ICrud {
    void addMaterial(Material material);
    void removeMaterial(String id);
    void updateMaterial(String id, Material updatedMaterial);
    void printMaterials();
}
