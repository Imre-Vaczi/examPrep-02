package city;

public class Office extends Building{

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        if (validateTableNumberPerLevel(area, numberOfTablesPerLevel)) {
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }

    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        if (validateTableNumberPerLevel(area, numberOfTablesPerLevel)) {
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * numberOfTablesPerLevel;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    private boolean validateTableNumberPerLevel(int area, int numberOfTablesPerLevel) {
        int ratio = area / numberOfTablesPerLevel;
        if (ratio < 2 | ratio > 5) {
            throw new IllegalArgumentException("Invalid area-numberOfTablesPerLevel ratio.");
        } else {
            return true;
        }
    }
}
