import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        Blockchain blockChain = new Blockchain(3);

        blockChain.addBlock(blockChain.newBlock(new String[]{"Apple = $120.000", "Google - $140,000"}));
        blockChain.addBlock(blockChain.newBlock(new String[]{"Amazon = $120.000", "Facebook - $140,000"}));
        blockChain.addBlock(blockChain.newBlock(new String[]{"Netflix = $120.000", "Microsoft - $140,000"}));

        System.out.println("Is Blockchain valid?: " + blockChain.isBlockChainValid());

        System.out.println(blockChain);


    }
}