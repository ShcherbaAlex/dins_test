package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private List<ContactDTO> contactDTO;
}
