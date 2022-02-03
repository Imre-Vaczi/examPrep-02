package city;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (isEnoughArea(building)) {
            buildings.add(building);
        }
    }

    public Building findHighestBuilding() {
        return buildings.stream()
                .max(Comparator.comparing(Building::getLevels))
                .orElseThrow(() -> new IllegalStateException("No buildings in the city yet."));
    }

    public List<Building> findBuildingsByStreet(String streetName) {
        return buildings.stream()
                .filter(b -> b.getAddress().getStreet().equals(streetName))
                .toList();
    }

    public boolean isThereBuildingWithMorePeopleThan(int threshold) {
        return buildings.stream()
                .anyMatch(b -> b.calculateNumberOfPeopleCanFit() > threshold);
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    private boolean isEnoughArea(Building building) {
        int occupiedArea = buildings.stream()
                .mapToInt(b -> b.getArea())
                .sum();
        if (occupiedArea + building.getArea() > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        } else {
            return true;
        }
    }
}
