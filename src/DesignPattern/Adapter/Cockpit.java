package DesignPattern.Adapter;

public class Cockpit {

    public static void main(String[] args) {
        HotAirBaloon hotAirBaloon = new HotAirBaloon();
        Adapter hotAirBalloonAdapter = new Adapter(hotAirBaloon);
        hotAirBalloonAdapter.fly();
    }

}
