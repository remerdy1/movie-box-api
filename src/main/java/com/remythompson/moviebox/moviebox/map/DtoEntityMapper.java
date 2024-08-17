package com.remythompson.moviebox.moviebox.map;

public interface DtoEntityMapper<D, E> {
    public E toEntity(D dto);
    public D toDto(E entity);
}
