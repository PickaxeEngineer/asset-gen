package com.github.pickaxeengineer.assetgen;

public interface Generator {

    String generate(final String modId, final String registryName);

    String fileName(final String modId, final String registryName);

}
