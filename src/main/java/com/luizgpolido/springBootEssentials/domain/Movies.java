package com.luizgpolido.springBootEssentials.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movies {
    private Long id;
    private String name;
    private String genre;

}
