# 1-1 JPA Mapping with Spring Boot

- This is a SpringBoot application sample that demonstrates the one to one mapping in JPA having `spring-boot-starter-data-jpa` as main dependency along with `spring-boot-starter-web`, `h2`, and `lombok`.

- How does it work?
  - This sample app will create schema at the application startup and inserts a record in each table i.e., `driver` and `driver_license` tables and creates a 1-1 association.
    - The bi-directional mapping is verified by retrieving the `DrivingLicense` from `Driver` entity.

- How to browse the H2 db?
  - Start the application, it will listen at port 2023
  - Browse the H2 DB at `http://localhost:2023/srk-h2`
    - Connect to Db with JDBC url: `jdbc:h2:/workspace/oto-db`
      - username: `sa`
      - password:
  - Query tables `driver`, and `driver_license`. You should see that tables `driver` and `driver_license` has one record in each table.

**Note:** In BiDirectional mapping the non-owining side of the relationship will also have a reference of owning side. In this example `Driver` is the non-owning side that has a reference of owning side i.e., `DrivingLicense`.
