package com.schoolmanagement.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter //lombok yapiyor
@AllArgsConstructor//parametreli cons. Lombok yapiyor
@NoArgsConstructor//parametresiz Cons--default
@Table(name="t_student")
@Entity  //db kayit icin koyduk.anatasion.bilgilendirme
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// PK olusturmak icin
    //@Setter(AccessLevel.NONE)  //Id nin setter i gelmeyecek
    private Long id;

    @Column(nullable = false,length = 25)
    @NotBlank(message = "username can not be space")
    @Size(min = 2,max = 25,message = "username '${validatedValue}' must be between{min} and{max}")
    private String username;

    @Column(nullable = false,length = 25)
    @NotBlank(message = "ssn can not be space")
    @Size(min=9, max = 9,message = "ssn '${validatedValue}' must must have 9 digits")
    private String ssn;

    @Column(nullable = false,length = 25)
    @NotBlank(message = "name can not be space")
    @Size(min = 2,max = 25,message = "name '${validatedValue}' must be between{min} and{max}")
    private String name;

    @Column(nullable = false,length = 25)
    @NotBlank(message = "surname can not be space")
    @Size(min = 2,max = 25,message = "surname '${validatedValue}' must be between{min} and{max}")
    private String surname;
    @Column(nullable = false)
    private LocalDate birthDay;
    private LocalDate birthPlace; //birt - birth ? String  - LocalDate ?

    @Column(nullable = false,length = 25)
    @Size(min = 8,max = 25,message = "password '${validatedValue}' must be between{min} and{max}")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,25}$", message = "Not valid")  //regexle validation islemi yapmayi saglar, regexle belirtilen kisim disindakileri alma
    private String password;

    @Enumerated(EnumType.STRING) //Bu anatation UserRol un  bir Enum oldugunu belirtir ve DB de String olarak saklar.
    private UserRole userRole;

    @NotBlank(message = "phoneNumber can not be space")
    @Size(min = 8)
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)//Bu anatation Gerder'in un  bir Enum oldugunu belirtir ve DB de String olarak saklar.
    private Gender gender;

    @Column(nullable = false,length = 25)
    @NotBlank(message = "mothername can not be space")
    @Size(min = 2,max = 25,message = "mothername '${validatedValue}' must be between{min} and{max}")
    private String motherName;

    @Column(nullable = false,length = 25)
    @NotBlank(message = "fathername can not be space")
    @Size(min = 2,max = 25,message = "fathername '${validatedValue}' must be between{min} and{max}")
    private String fatherName;

    private int studentNumber;

    @Email(message = "please provide a valid email")
    @Column(nullable = false, unique = true)
    private String email;

    private boolean isActive;


}
