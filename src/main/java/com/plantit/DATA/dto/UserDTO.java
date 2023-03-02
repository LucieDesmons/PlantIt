package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plantit.DATA.dal.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    public static final Long ADMIN_ID = 1L;
    public static final Long BOTANIST_ID = 2L;
    public static final Long CUSTUMER_ID = 3L;

    private Long idUser;
    private String name;
    private String firstName;
    private String phone;
    private String email;
    private String login;
    private String password;
    private String degree;
    private String specialization;
    private String hobbies;
    private AddressDTO addressDTO;
    private UserDTO godFatherDTO;
    private UserTypeDTO userTypeDTO;
    private Set<ConversationDTO> conversationCollectionDTO;
    private Set<UserHistoricDTO> userHistoricCollectionDTO;
    private Set<PasswordHistoricDTO> passwordHistoricCollectionDTO;
    private Set<UserDTO> godFatherCollectionDTO;
    private Set<MaintenanceDTO> maintenanceCollectionDTO;
    private Set<CreatedByDTO> createdByCollectionDTO;

    @JsonIgnoreProperties({"user"})
    @JsonBackReference
    private Set<PlantDTO> plantCollectionDTO;

    public static UserDTO fromId(Long idUser) {
        UserDTO user = new UserDTO();
        user.idUser = idUser;
        return user;
    }

}
