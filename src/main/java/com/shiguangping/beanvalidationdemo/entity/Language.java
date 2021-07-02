package com.shiguangping.beanvalidationdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Language {

    @NotNull
    private Long id;

    @NotNull
    private String name;
}
