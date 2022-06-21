package DesignPattern.Builder;

public class CarWithBuilder {
    //required properties
    private String engine;
    private String fuel;
    private int wheel;
    private int seats;
    private String steering;

    //optional properties
    private String airBags;
    private String musicSystem;
    private String centralLock;
    private String sunRoof;

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        //required properties
        private String engine;
        private String fuel;
        private int wheel;
        private int seats;
        private String steering;

        //optional properties
        private String airBags;
        private String musicSystem;
        private String centralLock;
        private String sunRoof;

        public Builder withEngine(final String engine){
            this.engine = engine;
            return this;
        }

        public Builder withFuel(final String fuel){
            this.fuel = fuel;
            return this;
        }
        public Builder withSteering(final String steering){
            this.steering = steering;
            return this;
        }
        public Builder withSeats(final int seats){
            this.seats = seats;
            return this;
        }
        public Builder withWheel(final int wheel){
            this.wheel = wheel;
            return this;
        }
        public Builder withAirBags(final String airBags){
            this.airBags = airBags;
            return this;
        }
        public Builder withSunroof(final String sunRoof){
            this.sunRoof = sunRoof;
            return this;
        }
        public Builder withMusicSystem(final String musicSystem){
            this.musicSystem = musicSystem;
            return this;
        }
        public Builder withCentralLock(final String centralLock){
            this.centralLock = centralLock;
            return this;
        }

        public CarWithBuilder build(){
            if(this.engine == null || this.steering == null || this.seats == 0 || this.fuel == null || this.wheel == 0 ){
                throw new RuntimeException("All required properties are not present");
            }
            CarWithBuilder car = new CarWithBuilder();
            car.engine = engine;
            car.steering = steering;
            car.seats = seats;
            car.fuel = fuel;
            car.wheel = wheel;
            car.airBags = airBags;
            car.musicSystem = musicSystem;
            car.centralLock = centralLock;
            car.sunRoof = sunRoof;
            return car;
        }
    }
}
