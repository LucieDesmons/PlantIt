package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idUser"
)
public class UserDTO {

    public static final Long ADMIN_ID = 1L;
    public static final Long BOTANIST_ID = 2L;
    public static final Long CUSTUMER_ID = 3L;

    private Long idUser;
    private String lastname;
    private String firstname;
    private String phone;
    private String email;
    private String login;
    private String password;
    private String degree;
    private String specialization;
    private String hobbies;
    private AddressDTO address;
    private UserDTO godFather;
    private UserTypeDTO userType;
    private Set<ConversationDTO> conversationCollection;
    private Set<UserHistoricDTO> userHistoricCollection;
    private Set<PasswordHistoricDTO> passwordHistoricCollection;
    private Set<UserDTO> godFatherCollection;
    private Set<MaintenanceDTO> maintenanceCollection;
    private Set<CreatedByDTO> createdByCollection;
    private Set<PlantDTO> plantCollection;

}
