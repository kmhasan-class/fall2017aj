package bd.ac.seu.aj.midtermexam;

public class Car {
    private int carId;
    private String licensePlate;
    private CarType carType;
    private String make;
    private String model;
    private int year;
    private int color;

    public Car() {
    }

    public Car(int carId, String licensePlate, CarType carType, String make, String model, int year, int color) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getCarId() {
        return carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("carId=").append(carId);
        sb.append(", licensePlate='").append(licensePlate).append('\'');
        sb.append(", carType=").append(carType);
        sb.append(", make='").append(make).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", year=").append(year);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
