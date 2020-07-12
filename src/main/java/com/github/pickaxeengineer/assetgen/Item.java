package com.github.pickaxeengineer.assetgen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Item {
    String modId();
    String registryName();
    ItemModelType itemType();
}
