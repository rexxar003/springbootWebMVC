package programmerzamannow.webMVC.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest {

    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    private CreateAddressRequest address;
    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedia;
}
