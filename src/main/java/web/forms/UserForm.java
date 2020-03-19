package web.forms;

import lombok.Data;
import web.model.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/*
 *
 *@Data 19.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */
@Data
public class UserForm {
    private Long id;
    private String name;
    private String password;
    private Role role;
}
