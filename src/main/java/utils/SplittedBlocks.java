package utils;

import soot.toolkits.graph.Block;
import soot.toolkits.graph.DirectedGraph;

import java.util.*;

public class SplittedBlocks implements DirectedGraph<Block> {
    public Set<Block> mBlocks = new HashSet<>();
    public List<Block> mHeads = new ArrayList<>();
    public List<Block> mTails = new ArrayList<>();

    public SplittedBlocks(Set<Block> blocks){
        mBlocks.addAll(blocks);
        buildHeads();
        buildTails();
    }

    private void buildHeads(){
        for (Block block : mBlocks){
            boolean isHead = false;
            for (Block pred : block.getPreds()){
                if (!mBlocks.contains(pred)){
                    isHead = true;
                    break;
                }
            }
            if (block.getPreds().size() == 0) isHead = true;
            if (isHead){
                mHeads.add(block);
            }
        }
    }

    private void buildTails(){
        for (Block block : mBlocks){
            boolean isTail = false;
            for (Block succ : block.getSuccs()){
                if (!mBlocks.contains(succ)){
                    isTail = true;
                    break;
                }
            }
            if (block.getSuccs().size() == 0) isTail = true;
            if (isTail){
                mTails.add(block);
            }
        }
    }

    public List<Block> getHeads(){return mHeads;}
    public List<Block> getTails(){return mTails;}
    public List<Block> getPredsOf(Block b){return b.getPreds();}
    public List<Block> getSuccsOf(Block b){return b.getSuccs();}
    public int size(){return mBlocks.size();}
    public Iterator<Block> iterator(){return mBlocks.iterator();}
}
