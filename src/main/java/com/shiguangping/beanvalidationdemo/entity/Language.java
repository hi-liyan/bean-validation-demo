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

    @NotNull(message = "Language#id: 不能为空")
    private Long id;

    @NotNull(message = "Language#name: 不能为空")
    private String name;
}
