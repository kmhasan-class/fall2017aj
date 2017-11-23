package bd.ac.seu.aj.midtermexam;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        CarDao carDao = new CarDaoImplementation();
        List<Car> carList = carDao.findAll();

        long count = carList
                .parallelStream()
                .filter(car -> car.getCarType() == CarType.SEDAN)
                .count();

        String string = "120";
        byte number = Byte.parseByte(string);
    }
}
