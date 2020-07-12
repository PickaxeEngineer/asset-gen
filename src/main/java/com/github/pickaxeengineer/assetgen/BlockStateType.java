package com.github.pickaxeengineer.assetgen;

public enum BlockStateType implements Generator {

    SIMPLE_CUBE(TemplateLibrary.CUBE_STATE_TEMPLATE);

    private final String template;

    BlockStateType(String template) {
        this.template = template;
    }

    @Override
    public String generate(String modId, String registryName) {
        return template.replace(TemplateLibrary.MODID_PLACEHOLDER, modId).replace(TemplateLibrary.NAME_PLACEHOLDER, registryName);
    }

    @Override
    public String fileName(String modId, String registryName) {
        return "assets/"+modId+"/blockstates/"+registryName+".json";
    }
}
