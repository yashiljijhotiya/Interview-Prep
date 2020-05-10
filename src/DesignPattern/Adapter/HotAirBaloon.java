package DesignPattern.Adapter;

public class HotAirBaloon {

    String gasUsed = "Helium";

    void fly(String gasUsed){

    }

    String inflateWithGas(){
        return gasUsed;
    }
}
