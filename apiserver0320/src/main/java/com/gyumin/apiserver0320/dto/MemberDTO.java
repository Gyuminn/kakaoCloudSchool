package com.gyumin.apiserver0320.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private String name;
    private String email;
    private String organization;
}