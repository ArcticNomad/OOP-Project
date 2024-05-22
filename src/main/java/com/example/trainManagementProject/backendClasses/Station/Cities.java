package com.example.trainManagementProject.backendClasses.Station;

public enum Cities
{
    LAHORE,
    KARACHI,
    MULTAN,
    FAISALABAD,
    ISLAMABAD,
    PESHAWAR,
    RAWALPINDI;


    private static final double DISCOUNT = 0.2;
    private static final double BUSINESS_CHARGE=0.1;


    public static double getDiscount() {
        return DISCOUNT;
    }

    public static double getBusinessCharge()
    {
        return BUSINESS_CHARGE;
    }

}
