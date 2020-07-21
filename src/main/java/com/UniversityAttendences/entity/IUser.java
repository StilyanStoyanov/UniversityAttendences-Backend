package com.UniversityAttendences.entity;


import com.UniversityAttendences.entity.enums.Role;

public interface IUser {
    Role getRole();

    String getUsername();

    String getPassword();
}