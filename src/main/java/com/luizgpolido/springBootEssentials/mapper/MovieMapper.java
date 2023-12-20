package com.luizgpolido.springBootEssentials.mapper;

import com.luizgpolido.springBootEssentials.domain.Movies;
import com.luizgpolido.springBootEssentials.requests.MoviePostRequestBody;
import com.luizgpolido.springBootEssentials.requests.MoviePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    public abstract Movies toMovie(MoviePostRequestBody moviePostRequestBody);
    public abstract Movies toMovie(MoviePutRequestBody moviePutRequestBody);
}
