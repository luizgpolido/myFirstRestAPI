package com.luizgpolido.springBootEssentials.requests;

import lombok.Data;

@Data
public class MoviePostRequestBody {
    private String name;
    private String genre;
}
