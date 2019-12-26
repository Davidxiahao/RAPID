package utils;

import check.detection.ApkMetaInfo;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BriefBlockGraph;

import java.util.*;

public class CheckedAPIInvoke {
    public String methodJNIName;
    public ApkMetaInfo apkMetaInfo;
    public SootMethod targetMethod;
    public Unit invokeUnit;
    public Set<Unit> ifCheckUnitSet = new HashSet<>();
    public Unit ifCheckUnit;
    public String condition;
    public List<Unit> apiUnitList = new ArrayList<>();
    public List<Unit> theOtherUnitList = new ArrayList<>();
    public BriefBlockGraph briefBlockGraph;

    public SplittedBlocks apiBlocks;
    public SplittedBlocks theOtherBlocks;
    public SplittedBlocks blocksForDotDump;

    public CheckedAPIInvoke(String methodJNIName, ApkMetaInfo apkMetaInfo, SootMethod targetMethod,
                            Unit invokeUnit, Set<Unit> ifCheckUnitSet, String condition,
                            List<Unit> apiUnitList, List<Unit> theOtherUnitList,
                            BriefBlockGraph briefBlockGraph){
        this.methodJNIName = methodJNIName;
        this.apkMetaInfo = apkMetaInfo;
        this.targetMethod = targetMethod;
        this.invokeUnit = invokeUnit;
        this.ifCheckUnitSet.addAll(ifCheckUnitSet);
        this.condition = condition;
        this.apiUnitList.addAll(apiUnitList);
        this.theOtherUnitList.addAll(theOtherUnitList);
        this.briefBlockGraph = briefBlockGraph;
        buildBlocks();
    }

    private void buildBlocks(){
        Set<Block> apiBlocksSet = new HashSet<>();
        Set<Block> theOtherBlocksSet = new HashSet<>();
        Map<Unit, Block> headUnit2Block = new HashMap<>();
        for (Block block : briefBlockGraph.getBlocks()){
            headUnit2Block.put(block.getHead(), block);
        }
        for (Unit unit : apiUnitList){
            if (headUnit2Block.containsKey(unit)){
                apiBlocksSet.add(headUnit2Block.get(unit));
            }
        }
        for (Unit unit : theOtherUnitList){
            if (headUnit2Block.containsKey(unit)){
                theOtherBlocksSet.add(headUnit2Block.get(unit));
            }
        }
        apiBlocks = new SplittedBlocks(apiBlocksSet);
        theOtherBlocks = new SplittedBlocks(theOtherBlocksSet);
        Set<Block> dotDumpSet = new HashSet<>();
        dotDumpSet.addAll(apiBlocksSet);
        dotDumpSet.addAll(theOtherBlocksSet);
        for (Block block : briefBlockGraph.getBlocks()){
            for (Unit unit : ifCheckUnitSet){
                if (block.getTail().equals(unit) && hasSame(block.getSuccs(), dotDumpSet)){
                    dotDumpSet.add(block);
                    ifCheckUnit = unit;
                }
            }
        }
        blocksForDotDump = new SplittedBlocks(dotDumpSet);
    }

    public boolean hasSame(List<Block> a, Set<Block> b){
        for (Block aBlock : a){
            if (b.contains(aBlock)) return true;
        }
        return false;
    }
}
