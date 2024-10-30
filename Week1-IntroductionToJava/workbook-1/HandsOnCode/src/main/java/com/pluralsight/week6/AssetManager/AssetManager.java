package com.pluralsight.week6.AssetManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssetManager {
    public static void main(String[] args) {

        List<Asset> assetList = new ArrayList<>();

        House home = new House("Main home", "Acquired yesterday", 1_000_000, "San Mateo", 3, 2000, 40);

        House vacationHouse = new House("Vacation House", "Long time ago", 4_000_000, "Lake Tahoe", 1, 5000, 1000);

        Vehicle beater = new Vehicle("Daily life", "Last year", 20_000, "Toyota", 2016, 24_000);

        Vehicle futureCar = new Vehicle("Electric", "Last week", 80_000, "Tesla", 2020, 10);

        assetList.addAll(List.of(home, vacationHouse, beater, futureCar)); // just trying out

        for (Asset asset : assetList){
            System.out.printf("""
                    
                    ---
                    Description: %s
                    Date Acquired: %s
                    Original Cost: %.2f
                    Current Value: %.2f
                    """, asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost(), asset.getValue());

            if (asset instanceof House){
                System.out.println(((House) asset).getAddress());
            }
            if (asset instanceof Vehicle){
                System.out.println(((Vehicle) asset).getMakeModel());
            }
        }
    }
}
