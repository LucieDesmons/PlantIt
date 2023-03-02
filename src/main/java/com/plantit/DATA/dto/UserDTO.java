package com.plantit.DATA.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private AddressDTO address;
    private UserDTO godFather;
    @JsonIgnore
    private UserTypeDTO userType;
    private Set<ConversationDTO> conversationCollection;
    private Set<UserHistoricDTO> userHistoricCollection;
    private Set<PasswordHistoricDTO> passwordHistoricCollection;
    private Set<UserDTO> godFatherCollection;
    private Set<MaintenanceDTO> maintenanceCollection;
    private Set<CreatedByDTO> createdByCollection;
    private Set<PlantDTO> plantCollection;

    public static UserDTO fromId(Long idUser) {
        UserDTO user = new UserDTO();
        user.idUser = idUser;
        return user;
    }

}
