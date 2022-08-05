package com.example.tema4spring1.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String name;
    private String email;

    public Customers(String email, String name) {
    }

    public Integer getId() {
        return id;
    }
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
         public Customers() {
        
        }
    
}



