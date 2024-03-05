package com.lab.labeli.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Tests {
    Formato_unico_adultos(1),Quimica_sanguinea_35(2);
    private final int key;
    public static Tests getTests(Integer key){
        Map<Integer, Tests> testsMap =
                Arrays.stream(Tests.values()).collect(Collectors.toMap(Tests::getKey, Function.identity()));
        return testsMap.get(key);
    }
}
