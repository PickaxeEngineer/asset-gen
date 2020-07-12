package com.github.pickaxeengineer.assetgen;

public enum ItemModelType implements Generator{

    SIMPLE_ITEM(TemplateLibrary.ITEM_MODEL_TEMPLATE),
    ITEM_BLOCK(TemplateLibrary.ITEM_BLOCK_TEMPLATE),
    NONE("");

    final String template;

    ItemModelType(String template) {
        this.template = template;
    }

    @Override
    public String generate(String modId, String registryName) {
        return template.replace(TemplateLibrary.MODID_PLACEHOLDER,modId).replace(TemplateLibrary.NAME_PLACEHOLDER,registryName);
    }

    @Override
    public String fileName(String modId, String registryName) {
        return "assets/"+modId+"/models/item/"+registryName+".json";
    }
}
