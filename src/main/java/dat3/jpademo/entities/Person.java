
package dat3.jpademo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int year;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Fee> fees;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
        this.fees = new ArrayList<>();
    }
    
    public Person(){}
    
    public void addFee(Fee fee) {
        this.fees.add(fee);
        if (fee != null) {
            fee.setPerson(this);
        }
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            address.setPerson(this);
        }
    }
    
    public Address getAddress() {
        return address;
    }

    public List<Fee> getFees() {
        return fees;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }  
   
    public void setYear(int year) {
        this.year = year;
    }
    
    public Long getId() {
        return id;
    }


    
}
