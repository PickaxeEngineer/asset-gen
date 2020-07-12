package com.github.pickaxeengineer.assetgen;

public enum LootType implements Generator{

    SIMPLE_BLOCK(TemplateLibrary.LOOT_BLOCK_TEMPLATE);

    final String template;

    LootType(String template) {
        this.template = template;
    }


    @Override
    public String generate(String modId, String registryName) {
        return template.replace(TemplateLibrary.MODID_PLACEHOLDER, modId).replace(TemplateLibrary.NAME_PLACEHOLDER, registryName);
    }

    @Override
    public String fileName(String modId, String registryName) {
        return "data/"+modId+"/loot_tables/blocks/"+registryName+".json";
    }
}
