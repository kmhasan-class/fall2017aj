package bd.ac.seu.aj.midtermexam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CarDaoImplementation implements CarDao {

    @Override
    public Car findCar(int carId) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM car WHERE carId = " + carId;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String licensePlate = resultSet.getString("licensePlate");
                CarType carType = CarType.valueOf(resultSet.getString("carType"));
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("year");
                int color = resultSet.getInt("color");

                Car car = new Car(carId, licensePlate, carType, make, model, year, color);
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public void update(Car car) {

    }
}
