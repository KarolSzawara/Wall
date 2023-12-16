package szawara.karol;

import java.util.List;

public class SampleCompositeBlock implements CompositeBlock{
    SampleBlock sampleBlock;
    List<Block> blockList;

    public SampleCompositeBlock(SampleBlock sampleBlock, List<Block> blockList) {
        this.sampleBlock = sampleBlock;
        this.blockList = blockList;
    }

    @Override
    public String getColor() {
        return sampleBlock.getColor();
    }

    @Override
    public String getMaterial() {
        return sampleBlock.getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blockList;
    }
}
