package com.lab.labeli.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Status {
    Reported(0),Pending(1),Delivered(2);
    private final int key;
    public static Status getStatus(Integer key){
        Map<Integer, Status> statusMap =
                Arrays.stream(Status.values()).collect(Collectors.toMap(Status::getKey, Function.identity()));
        return statusMap.get(key);
    }
}
