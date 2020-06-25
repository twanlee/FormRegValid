package model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 5,max = 50, message = "Out range!")
    @NotEmpty(message = "Empty")
    @NotNull
    private String fName;
    @Size(min = 5,max = 50, message = "Out range!")
    @NotEmpty(message = "Empty")
    @NotNull
    private String lName;
    @Pattern(regexp = "(^$|[0-9]*$)", message = "Number phone is invalid!")
    @NotEmpty(message = "Empty")
    private String phone;
    @NotEmpty(message = "Empty")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Email is invalid!")
    private String email;
   @Min(18)
   @Max(100)
//   @NotEmpty(message = "Empty")
    private long age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
