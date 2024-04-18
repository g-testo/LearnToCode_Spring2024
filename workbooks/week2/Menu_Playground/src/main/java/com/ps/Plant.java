package com.ps;

public class Plant {
    private long id;
    private String species;
    private int weeksOld;
    private String dateLastPropagated;
    private boolean isReadyToPropagate;
    private String dateLastWatered;

    public Plant(long id, String species, int weeksOld) {
        this.id = id;
        this.species = species;
        this.weeksOld = weeksOld;
        this.dateLastPropagated = null;
        this.dateLastWatered = null;
        this.isReadyToPropagate = false;
    }

    public long getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeeksOld() {
        return weeksOld;
    }

    public void setWeeksOld(int weeksOld) {
        this.weeksOld = weeksOld;
    }

    public String getDateLastPropagated() {
        return dateLastPropagated;
    }

    public void setDateLastPropagated(String dateLastPropagated) {
        this.dateLastPropagated = dateLastPropagated;
    }

    public boolean isReadyToPropagate() {
        return isReadyToPropagate;
    }

    public void setReadyToPropagate(boolean readyToPropagate) {
        isReadyToPropagate = readyToPropagate;
    }

    public String getDateLastWatered() {
        return dateLastWatered;
    }

    public void setDateLastWatered(String dateLastWatered) {
        this.dateLastWatered = dateLastWatered;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "species='" + species + '\'' +
                ", weeksOld=" + weeksOld +
                ", dateLastPropagated='" + dateLastPropagated + '\'' +
                ", isReadyToPropagate=" + isReadyToPropagate +
                ", dateLastWatered='" + dateLastWatered + '\'' +
                '}';
    }

}
