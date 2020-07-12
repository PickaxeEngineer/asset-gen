package com.github.pickaxeengineer.assetgen;

public enum BlockType {
    CUBE(BlockStateType.SIMPLE_CUBE, BlockModelType.CUBE);

    final BlockStateType blockStateType;
    final BlockModelType blockModelType;

    BlockType(BlockStateType blockStateType, BlockModelType blockModelType) {
        this.blockStateType = blockStateType;
        this.blockModelType = blockModelType;
    }
}
