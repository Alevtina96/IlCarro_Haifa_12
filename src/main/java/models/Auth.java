package models;
import lombok.*;

@Setter
@Getter

@ToString
@Builder
public class Auth {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;

//    @AllArgsConstructor
//    @NoArgsConstructor
}
