package com.github.pickaxeengineer.assetgen;

public class TemplateLibrary {

    static final String MODID_PLACEHOLDER = "%MODID%";
    static final String NAME_PLACEHOLDER = "%REGNAME%";

    static final String CUBE_MODEL_TEMPLATE = "{\n" +
            "  \"parent\": \"block/cube_all\",\n" +
            "  \"textures\": {\n" +
            "    \"all\": \"" + MODID_PLACEHOLDER + ":block/" + NAME_PLACEHOLDER + "\"\n" +
            "  }\n" +
            "}";

    static final String CUBE_STATE_TEMPLATE = "{\n" +
            "  \"variants\": {\n" +
            "    \"\": {\"model\": \""+MODID_PLACEHOLDER+":block/"+NAME_PLACEHOLDER+"\"}\n" +
            "  }\n" +
            "}";

    static final String ITEM_BLOCK_TEMPLATE = "{\n" +
            "  \"parent\": \""+MODID_PLACEHOLDER+":block/"+NAME_PLACEHOLDER+"\"\n" +
            "}";

    static final String LOOT_BLOCK_TEMPLATE = "{\n" +
            "  \"type\": \"minecraft:block\",\n" +
            "  \"pools\": [\n" +
            "    {\n" +
            "      \"rolls\": 1,\n" +
            "      \"entries\": [\n" +
            "        {\n" +
            "          \"type\": \"minecraft:item\",\n" +
            "          \"name\": \""+MODID_PLACEHOLDER+":"+NAME_PLACEHOLDER+"\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"conditions\": [\n" +
            "        {\n" +
            "          \"condition\": \"minecraft:survives_explosion\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    static final String ITEM_MODEL_TEMPLATE = "{\n" +
            "  \"parent\": \"item/generated\",\n" +
            "  \"textures\": {\n" +
            "    \"layer0\": \""+TemplateLibrary.MODID_PLACEHOLDER+":item/"+TemplateLibrary.NAME_PLACEHOLDER+"\"\n" +
            "  }\n" +
            "}";

    private TemplateLibrary(){}
}
