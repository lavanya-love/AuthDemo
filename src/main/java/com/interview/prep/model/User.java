package com.interview.prep.model;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String firstLine;
    private String county;
    private String postcode;

}
