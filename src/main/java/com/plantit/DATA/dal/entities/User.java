package com.plantit.DATA.dal.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "degree")
    private String degree;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hobbies")
    private String hobbies;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_godfather")
    private User godFather;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user_type")
    private UserType userType;

    /***** COLLECTION *****/

    @OneToMany(mappedBy="user1", fetch = FetchType.LAZY)
    private Set<Conversation> conversationCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<UserHistoric> userHistoricCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<PasswordHistoric> passwordHistoricCollection;

    @OneToMany(mappedBy="godFather", fetch = FetchType.LAZY)
    private Set<User> godFatherCollection;

    @ManyToMany(mappedBy="userCollection", fetch = FetchType.LAZY)
    private Set<Maintenance> maintenanceCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<CreatedBy> createdByCollection;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<Plant> plantCollection;


    /***** CONSTRUCTOR *****/

    public User(String lastname, String firstname, String phone, String email, String password, String degree,
                String specialization, String hobbies, User godFather, Address address, UserType userType) {
        super();
        this.lastname = lastname;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.degree = degree;
        this.specialization = specialization;
        this.hobbies = hobbies;
        this.godFather = godFather;
        this.address = address;
        this.userType = userType;
    }


    /***** TO STRING *****/

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstname + '\'' +
                ", name='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", address=" + address +
                ", userType=" + userType +
                ", godFather=" + (godFather == null ? null : godFather.getIdUser()) + // Utilisation d'une expression ternaire pour éviter de l'appeler si godFather est nul
                ", degree='" + degree + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

    public static User fromId(Long idUser) {
        User user = new User();
        user.idUser = idUser;
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(this.getUserType().getLabel()));

        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}