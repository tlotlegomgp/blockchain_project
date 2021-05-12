
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Block {

    private int index;
    private String records;
    private String hash;
    private String prevHash;
    private long timestamp;
    private int nonce;

    public Block(int index, long timestamp, String prevHash, String records) {
        this.index = index;
        this.records = records;
        this.prevHash = prevHash;
        this.timestamp = timestamp;
        nonce = 0;
        hash = Block.calcHash(this);
    }

    public int getIndex() {
        return index;
    }

    public String getRecords() {
        return records;
    }

    public String getHash() {
        return hash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public static String calcHash(Block block){
        if (block != null){
            MessageDigest messageDigest = null;

            try {
                messageDigest = MessageDigest.getInstance("SHA-256");

            } catch (NoSuchAlgorithmException e) {
                return null;
            }

            String blockString = block.string();

            final byte bytes[] = messageDigest.digest(blockString.getBytes());
            final StringBuilder stringBuilder = new StringBuilder();

            for(final byte b: bytes){
                String hexadecimal = Integer.toHexString(0xff & b);

                if (hexadecimal.length() == 1)
                    stringBuilder.append('0');

                stringBuilder.append(hexadecimal);
            }

            return stringBuilder.toString();

        }

        return null;
    }

    public String string() {
        return index + timestamp + prevHash + records + nonce;
    }

    public String toString(){

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date date;
        date = new Date(timestamp);
        return "Index: " + index + "\nTimestamp: " + date + "\nHash: " + hash + "\nPrev-Hash: " + prevHash + "\nNonce: " + nonce + "\nTrades: ";
    }

    public void mineBlock(int difficulty){
        nonce = 0;

        while(!getHash().substring(0, difficulty).equals(Utils.zeros(difficulty))){
            nonce++;
            hash = Block.calcHash(this);
        }
    }
}
