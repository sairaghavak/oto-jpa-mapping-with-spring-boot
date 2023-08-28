package oto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author sairaghavak
 */
@Entity(name = "DirverLicense")
@Table(name = "driver_license")
@NoArgsConstructor
@Getter
public class DriverLicense {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "driver_license_id_pk")
  private Long id;

  @Column(name = "license_number")
  private String licenseNumber;

  @OneToOne
  @JoinColumn(name = "driver_id_fk", referencedColumnName = "driver_id_pk")
  private Driver driver;

  public DriverLicense(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  @Override
  public String toString() {
    return "{" + licenseNumber + "}";
  }
}
