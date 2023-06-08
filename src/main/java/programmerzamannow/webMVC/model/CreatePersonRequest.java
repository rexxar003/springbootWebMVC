package programmerzamannow.webMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest {
    
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
}
