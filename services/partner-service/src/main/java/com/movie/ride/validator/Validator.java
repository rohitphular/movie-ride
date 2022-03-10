package com.movie.ride.validator;


public interface Validator<T> {

    boolean isValid(final T t);

}