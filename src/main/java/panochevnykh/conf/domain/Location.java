package panochevnykh.conf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Table
@Entity
public class Location {
    @Id
    @JsonIgnore
    @GeneratedValue
    private Integer id;
    private String city;
    private String country;
    @JsonIgnore
    @OneToMany(mappedBy="location")
    private Collection<Conference> tenants;
    public Integer getId() {
        return id;
    }

    public Collection<Conference> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Conference> tenants) {
        this.tenants = tenants;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
