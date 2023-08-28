package oto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author sairaghavak
 */
@Entity(name = "Driver")
@Table(name = "driver")
@NoArgsConstructor
@Getter
public class Driver {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "driver_id_pk")
  private Long id;

  @Column(name = "full_name")
  private String fullName;

  @OneToOne(mappedBy = "driver")
  private DriverLicense driverLicense;

  public Driver(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public String toString() {
    return "{" + fullName + "}";
  }
}
