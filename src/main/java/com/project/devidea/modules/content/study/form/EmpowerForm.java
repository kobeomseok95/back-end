package com.project.devidea.modules.content.study.form;

import com.project.devidea.modules.content.study.Study_Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class EmpowerForm {
    @NotNull
    String NickName;
    @NotNull
    Study_Role role;
}
