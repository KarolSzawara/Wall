package szawara.karol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    private List<Block> blocks;
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findInSubListBlockByColor(color,blocks);
    }
    public Optional<Block> findInSubListBlockByColor(String color,List<Block> blockList){
        for(Block block : blockList){
            if(block.getColor().equals(color)){
                 return Optional.of(block);
            }
            if(block instanceof CompositeBlock){
                var result=findInSubListBlockByColor(color,((CompositeBlock) block).getBlocks());
                if(result.isPresent()){
                    return result;
                }
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return addSubListOfBlocksByMaterial(material,blocks,new ArrayList<>());
    }
    public List<Block> addSubListOfBlocksByMaterial(String material,List<Block> blockToFilter,List<Block> blockToReturn){
        blockToFilter.forEach(block -> {
            if(block.getMaterial().equals(material)){
                blockToReturn.add(block);
            }
            if(block instanceof CompositeBlock){
                addSubListOfBlocksByMaterial(material,((CompositeBlock) block).getBlocks(),blockToReturn);
            }
        });
        return blockToReturn;
    }
    @Override
    public int count() {
        return countBlocksInComposite(blocks);
    }
    private int countBlocksInComposite(List<Block> list) {
        int count = 0;
        for (Block block : list) {
            count++;
            if (block instanceof CompositeBlock) {
                count += countBlocksInComposite(((CompositeBlock) block).getBlocks());
            }
        }
        return count;
    }
}
