package programmerzamannow.webMVC.model;

import java.util.List;

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
    private CreateAddressRequest address;
    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedia;
}
