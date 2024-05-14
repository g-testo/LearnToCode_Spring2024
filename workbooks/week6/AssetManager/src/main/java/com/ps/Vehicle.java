package com.ps;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(
            String description,
            String dateAcquired,
            double originalCost,
            String makeModel,
            int year,
            int odometer
    ) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue(){
        int carAge = calculateCarAge();

        double carValue;

        if(carAge < 4){
            carValue = calculateCarValue(.03);
        } else if(carAge < 7){
            carValue = calculateCarValue(.06);
        } else if(carAge < 11){
            carValue = calculateCarValue(.08);
        } else {
            carValue = 1000;
        }

        String lowerCaseMakeModel = this.makeModel.toLowerCase();
        if(
                this.odometer > 100_000 &&
                !lowerCaseMakeModel.contains("honda") &&
                !lowerCaseMakeModel.contains("toyota")
        ){
            return carValue * .75;
        } else{
            return carValue;
        }
    }
    public int calculateCarAge(){
        int currentYear = LocalDate.now().getYear();
        return currentYear - this.year;
    }
    public double calculateCarValue(double depreciationRate){
        int age = calculateCarAge();
        return this.getOriginalCost() * (1 - (age * depreciationRate));
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "makeModel='" + makeModel + '\'' +
                ", year=" + year +
                ", odometer=" + odometer +
                '}';
    }
}
