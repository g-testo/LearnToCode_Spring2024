package com.ps;

public class House extends Asset{
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(
            String description,
            String dateAcquired,
            double originalCost,

            String address,
            int condition,
            int squareFoot,
            int lotSize
    ){
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public double getValue(){
        int valueRate;

        switch(this.condition){
            case 1:
                valueRate = 180;
                break;
            case 2:
                valueRate = 130;
                break;
            case 3:
                valueRate = 90;
                break;
            case 4:
                valueRate = 80;
                break;
            default:
                valueRate = 0;
                break;
        }

        int houseValue = this.squareFoot * valueRate;
        double lotValue = this.lotSize * .25;

        return houseValue + lotValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", condition=" + condition +
                ", squareFoot=" + squareFoot +
                ", lotSize=" + lotSize +
                '}';
    }
}
