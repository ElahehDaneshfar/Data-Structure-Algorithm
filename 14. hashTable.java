package ds.hashTable;

public class hashTable {
	 
	String HashArray[];
	int ArraySize;
	int size=0; //counter for number of element in the hashTable
	
	
	public hashTable( int numberOfSlot) {
		
		if(isPrime(numberOfSlot)) {
			HashArray= new String [numberOfSlot];
			ArraySize=numberOfSlot;
		}
		
		else {
			int primeCount = nextPrimeNumber(numberOfSlot);
			HashArray= new String [primeCount];
			ArraySize=primeCount;
			
			System.out.println("HashTable size given" + numberOfSlot + "is not prime");
			System.out.println("HashTable size changed to: " + primeCount );

		}
	}
	
	private boolean isPrime(int num) {
		for(int i=2;i*i<num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	private int nextPrimeNumber(int minNumber) {
		for(int i=minNumber ; true ; i++) {
			if(isPrime(i)) return i;
		}
	}
	
	// return preferred index position
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal %= ArraySize;
		
		if (hashVal<0) {
			hashVal+=ArraySize;
		}
		
		return hashVal; // ideal index position we'd like to insert or search in
	}
	
	// return stepSize greater than zero
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal %= ArraySize;
		
		if (hashVal<0) {
			hashVal+=ArraySize;
		}
		
		return 3 - hashVal % 3 ;  // use a prime number less than arraySize
	}
	
	public void insert(String word) {
		int hashVal= hashFunc1(word);
		int stepSize = hashFunc2(word);
		
		while(HashArray[hashVal]!=null) {
			hashVal+=stepSize;
			hashVal%=ArraySize;
		}
		
		HashArray[hashVal]=word;
		System.out.println(word + " inserted.");
		size++;
	}
	
	public String find(String word) {
		int hashVal= hashFunc1(word);
		int stepSize = hashFunc2(word);
		
		while(HashArray[hashVal]!= null) {
				
			if(HashArray[hashVal].equals(word)) {
				return HashArray[hashVal];
			}
			else {
				hashVal+=stepSize;
				hashVal%=ArraySize;
			}
		}
		return HashArray[hashVal];
	}
	
	public void display() {
		for(int i=0;i<ArraySize;i++) {
			if(HashArray[i]!=null)
				System.out.println(HashArray[i]+"");
			else
				System.out.println("**");
		}
	}
}
