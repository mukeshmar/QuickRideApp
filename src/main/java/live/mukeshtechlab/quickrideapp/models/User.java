package live.mukeshtechlab.quickrideapp.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String gender;
    private double rating;
    private UserType userType;
}
