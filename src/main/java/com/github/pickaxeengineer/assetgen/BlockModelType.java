package com.github.pickaxeengineer.assetgen;


public enum BlockModelType implements Generator {

    CUBE(TemplateLibrary.CUBE_MODEL_TEMPLATE);

    private final String template;

    BlockModelType(final String template) {
        this.template = template;
    }

    @Override
    public String generate(String modId, String registryName) {
        return template.replace(TemplateLibrary.MODID_PLACEHOLDER, modId).replace(TemplateLibrary.NAME_PLACEHOLDER, registryName);
    }

    @Override
    public String fileName(String modId, String registryName) {
        return "assets/"+modId+"/models/block/"+registryName+".json";
    }
}
