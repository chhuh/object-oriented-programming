package noobchain;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

class Timewatch {
	static long start_time;
	static long end_time;
	static float elapsed_time;
	Timewatch() {
		start_time = 0;
		end_time = 0;
		elapsed_time = 0;
	}
	static void start() { 
		start_time = System.currentTimeMillis();
	}
	static void end() { 
		end_time = System.currentTimeMillis();
	}
	static float get_elapsed_time() {
		elapsed_time = end_time - start_time;
		return elapsed_time;
	}
	static void print_elapsed_time() {
		//System.out.print("################# Elapsed Time: ");
		System.out.print(String.format("%.3f ��", get_elapsed_time()/1000)); //s
		//System.out.print(String.format("%.0f ms", get_elapsed_time())); //ms
	}
	static void print_elapsed_given_time(float time) {
		//System.out.print("################# Elapsed Time: ");
		System.out.print(String.format("%.3f ��", time/1000)); //s
		//System.out.print(String.format("%.0f ms", time)); //ms
	}
}

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;

	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		
		float[] f = new float[100];
		float sum=0;

		// BEGIN -- ������ ���� ����

		for(int i= 0; i<f.length; i++)
		{
			Timewatch.start();
			if(i==0) {
				System.out.println("Trying to Mine block 1... ");
				addBlock(new Block("Hi im the first block", "0"));
			}
			else {
				System.out.println("Trying to Mine block" + (i+1) + "... ");
				addBlock(new Block("Yo im the " + (i+1) + "th block",blockchain.get(blockchain.size()-1).hash));
			}
			Timewatch.end();
			f[i] = Timewatch.get_elapsed_time();
			sum += f[i];
		}
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = StringUtil.getJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
		
		// END -- ������ ���� ��
				
		// �Ʒ� ��� ����� OUTPUT.TXT ���Ϸ� �����Ͽ� ���� ����� �Բ� �����Ͽ��� �Ѵ�.
		// OUTPUT.TXT�� ����� ���� ��� ����� �޸��忡 �ٿ��ֱ� �Ͽ� �����ص� �ȴ�.
		
		// 
		System.out.println("��� 100���� �����ϴµ� �ҿ�� �ð�: " + sum/1000);

		System.out.println("��� 1���� �����ϴµ� �ҿ�� ��� �ð�: " + sum/100000);
		
	}
	
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
			
		}
		return true;
	}
	
	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
}