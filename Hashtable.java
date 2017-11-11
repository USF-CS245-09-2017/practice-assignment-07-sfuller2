import java.lang.Math;

public class Hashtable {
	
	private class HashNode {
		String key;
		String value;
		HashNode next;
		
		private HashNode(String key, String value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	private HashNode[] buckets;
	private int numBuckets;
	private int elements;
	
	public Hashtable() {
		numBuckets = 314527;
		buckets = new HashNode[numBuckets];
		elements = 0;
	}
	
	private int findBucket(String key) {
		int hashCode = Math.abs(key.hashCode());
		int bucket = hashCode % numBuckets;
		return bucket;
	}
	
	public boolean containsKey(String key) {
		return false;
	}
	
	public String get(String key) {
		int index = findBucket(key);
		HashNode temp = buckets[index];
		while(temp != null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		} return null;
	}
	
	public void put(String key, String value) {
		HashNode newNode = new HashNode(key, value);
		int index = findBucket(key);
		HashNode temp = buckets[index];
		newNode.next = temp;
		buckets[index] = newNode;
		elements++;
		
	}
	
	public String remove(String key) {
		String toReturn = "";
		int index = findBucket(key);
		HashNode temp = buckets[index];
		try {
			if(temp.key.equals(key)) {
				toReturn = temp.value;
				buckets[index] = temp.next;
				--elements;
			}
			HashNode previous = temp;
			while(previous != null) 
				previous = previous.next;
		}
		
		catch (Exception e) {
			System.out.println("Key is not present");
			return null;
		}
		return toReturn;
	}
	
}
