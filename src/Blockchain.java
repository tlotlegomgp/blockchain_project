import java.util.ArrayList;

public class Blockchain {

    private ArrayList<Block> blocks;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.difficulty = difficulty;
        blocks = new ArrayList<>();

        //Genesis block
        Block block = new Block(0, System.currentTimeMillis(), null, "Apple - R120.000 \nGoogle - R140,000");
        block.mineBlock(difficulty);
        blocks.add(block);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Block recentBlock(){
        return blocks.get(blocks.size()-1);
    }

    public Block previousBlock(Block block){
        return blocks.get(block.getIndex() - 1);
    }

    public Block newBlock(String records){
        Block recentBlock = recentBlock();
        return new Block(recentBlock.getIndex() + 1, System.currentTimeMillis(), recentBlock.getHash(), records);
    }

    public void addBlock(Block block){
        if (block != null){
            block.mineBlock(difficulty);
            blocks.add(block);
        }
    }

    public boolean isGenesisBlockValid(){
        Block genesisBlock = blocks.get(0);
        if (genesisBlock.getIndex() != 0)
            return false;

        if (genesisBlock.getPrevHash() != null)
            return false;

        if (genesisBlock.getHash() == null || !Block.calcHash(genesisBlock).equals(genesisBlock.getHash()))
            return false;

        return true;
    }

    public boolean isNewBlockValid(Block newBlock, Block prevBlock){
        if (newBlock != null && prevBlock != null){
            if (prevBlock.getIndex() + 1 != newBlock.getIndex()){
                return false;
            }

            if (newBlock.getPrevHash() == null || !newBlock.getPrevHash().equals(prevBlock.getHash())){
                return false;
            }

            if (newBlock.getHash() == null || !Block.calcHash(newBlock).equals(newBlock.getHash())){
                return false;
            }

            return true;
        }

        return false;
    }

    public boolean isBlockValid(String data){
        for (Block block: blocks){
            if (data.equals(block.getRecords())){
                return true;
            }
        }

        return false;
    }

    public boolean isBlockChainValid(){
        if (!isGenesisBlockValid())
            return false;

        for (int i = 1; i < blocks.size(); i++){
            Block currentBlock = blocks.get(i);
            Block prevBlock = blocks.get(i -1);

            if (!isNewBlockValid(currentBlock, prevBlock))
                return false;
        }

        return true;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        for (Block block: blocks){
            stringBuilder.append(block).append("\n");

        }

        return stringBuilder.toString();
    }

    public void validateChain(){

        for (Block block: blocks){
            block.mineBlock(difficulty);

        }

    }

}
