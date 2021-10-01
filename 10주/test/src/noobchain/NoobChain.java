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
		System.out.print(String.format("%.3f 초", get_elapsed_time()/1000)); //s
		//System.out.print(String.format("%.0f ms", get_elapsed_time())); //ms
	}
	static void print_elapsed_given_time(float time) {
		//System.out.print("################# Elapsed Time: ");
		System.out.print(String.format("%.3f 초", time/1000)); //s
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

		// BEGIN -- 측정할 내용 시작

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
		
		// END -- 측정할 내용 끝
				
		// 아래 출력 결과는 OUTPUT.TXT 파일로 저장하여 과제 제출시 함께 제출하여야 한다.
		// OUTPUT.TXT를 만들기 위해 출력 결과를 메모장에 붙여넣기 하여 저장해도 된다.
		
		// 
		System.out.println("블록 100개를 생성하는데 소요된 시간: " + sum/1000);

		System.out.println("블록 1개를 생성하는데 소요된 평균 시간: " + sum/100000);
		
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