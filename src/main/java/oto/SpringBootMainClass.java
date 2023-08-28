package oto;

import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author sairaghavak
 */
@SpringBootApplication
public class SpringBootMainClass {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext =
        SpringApplication.run(SpringBootMainClass.class, args);

    // 1. Create and save driver
    DriverRepository driverRepository = applicationContext.getBean(DriverRepository.class);
    DriverLicenseRepository driverLicenseRepository =
        applicationContext.getBean(DriverLicenseRepository.class);

    String driverName = "Robert D";
    Driver driver = new Driver(driverName);
    driverRepository.save(driver);

    // 2. Create DriverLicense and save -- Owning side of relationship
    DriverLicense driverLicense =
        new DriverLicense(UUID.nameUUIDFromBytes(driverName.getBytes()).toString());
    driverLicense.setDriver(driver);
    driverLicenseRepository.save(driverLicense);

    // 3. Retrieve Driver and DrivingLicense from db by their ids
    Optional<DriverLicense> getDriverLicense = driverLicenseRepository.findById(1l);
    Optional<Driver> getDriver = driverRepository.findById(1l);

    if (getDriverLicense.isPresent() && getDriver.isPresent()) {
      System.out.println(
          String.format(
              "DirverLicense %s is assigned to driver %s",
              getDriverLicense.get(), getDriver.get()));
      System.out.println("=========================");
      System.out.println(
          "Note: With Bi-Directional Mapping non-owning side Driver is also able to fetch"
              + " DriverLicense.");
      System.out.println("=========================");
      System.out.println(
          String.format("Driver %s has DriverLicense %s", getDriver.get(), getDriverLicense.get()));
    }
  }
}
