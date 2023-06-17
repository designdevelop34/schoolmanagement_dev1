package com.schoolmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import com.schoolmanagement.domain.Gender;
import com.schoolmanagement.domain.UserRole;


@Getter
@Setter
@AllArgsConstructor//tüm fieldlarla parametreli const
@NoArgsConstructor//default const
@Entity
public class Dean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE);
    private Long id;

    @NotBlank(message = "username can not be space")
    @Size(min = 2, max = 20, message = "username '${validatedValue}' must be between {min} and {max}")
    @Column(nullable = false, length = 20)
    private String username;

    @NotBlank(message = "ssn can not be space")
    @Size(min = 9, max = 9, message = "ssn '${validatedValue}' must be 9 digit")
    @Column(nullable = false, length = 9)
    private String ssn;

    @NotBlank(message = "name can not be space")
    @Size(min = 2, max = 25, message = "name '${validatedValue}' must be between {min} and {max}")
    @Column(nullable = false, length = 25)
    private String name;

    @NotBlank(message = "surname can not be space")
    @Size(min = 2, max = 25, message = "surname '${validatedValue}' must be between {min} and {max}")
    @Column(nullable = false, length = 25)
    private String surname;

    @Column(nullable = false)
    private LocalDate birthDay;

    private LocalDate birthPlace;

    @Column(nullable = false,length = 25)
    @Size(min = 8,max = 25,message = "password '${validatedValue}' must be between{min} and{max}")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,25}$", message = "Not valid")  //regexle validation islemi yapmayi saglar, regexle belirtilen kisim disindakileri alma
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @NotBlank(message = "phoneNumber can not be space")
    @Size(min = 8)
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;


}