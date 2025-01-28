package com.blogs.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.blogs.enums.*;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class User extends Base {

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30) // Changed column name to "last_name"
    private String lastName;

    @Column(name = "user_name",unique=true, length = 30) // Changed column name to "user_name"
    private String userName;

    @Column(name = "email",unique=true, length = 100) // Changed column name and increased length
    private String email;

    @Column(name = "mobile", length = 12) // Changed column name and increased length
    private String mobile;

    @Column(name = "dob") // Added column name for dob
    private LocalDate dob;

    @Column(name = "password", length = 8) // Changed column name to "password"
    private String password;

    @Column(name = "bio") // Added column for bio
    private String bio;

    @Column(name = "profile_image") // Add column for profile image, type BLOB or similar in DB
    private byte[] profileImage; // If you're using BLOB for image storage

    @Enumerated(EnumType.STRING)
    // Enum types for gender and status
    @Column(name = "gender")
    private Gender gender; // Assuming you define Gender enum

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status; // Assuming you define Status enum (active, inactive)

    // ManyToMany relationship with Community
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_communities", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "community_id")
    )
    private List<Community> communityList = new ArrayList<>();

    // OneToMany relationship with Post
    @OneToMany(mappedBy = "postUser", fetch = FetchType.LAZY) // Assuming Post has a 'postUser' field
    private List<Post> postList = new ArrayList<>();
}
