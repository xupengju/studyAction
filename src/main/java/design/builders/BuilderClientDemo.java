package design.builders;

/**
 * @author Milo on 2021/7/7.
 * @description
 */
public class BuilderClientDemo {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        Director director = new Director();
        director.constructCityCar(carBuilder);
        Car result = carBuilder.getResult();

        System.out.println(result);


        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructCityCar(carManualBuilder);
        Manual manual = carManualBuilder.getResult();


        System.out.println(manual);
    }
}
