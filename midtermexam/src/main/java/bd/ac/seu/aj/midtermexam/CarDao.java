package bd.ac.seu.aj.midtermexam;

import java.util.List;

public interface CarDao {
    public Car findCar(int carId);
    public List<Car> findAll();
    public void addCar(Car car);
    public void delete(Car car);
    public void update(Car car);
}
