import java.util.ArrayList;

/**
	Class that implements a hashtable with two generic types
	K for key
	V for value
	Separate Chaining is used to resolve the collisions
 */
public class HashMapLP < K, V > {
	// data member: number of elements added to the hashmap
	private int size;
	// data member: load factor at which rehashing is required
	private double loadFactor;
	// data member: Array of linked lists
	private HashMapEntry < K,
	V > [] hashTable;
	public static int getIterations;
	private int collisions;
	/**
		Default constructor
		Creates a hashmap with capacity 100 and load factor 0.9
	*/
	public HashMapLP() {
		this(100, 0.5);
	}
	/**
		Constructor with one parameter
		Creates a hashmap with capacity c and default load factor 0.9
		@param c the capacity of the hashtable
	*/
	public HashMapLP(int c) {
		this(c, 0.5);
	}
	/**
		Constructor with two parameters
		@param c the capacity of the hashtable
		@param lf the load factor for the hashtable
	*/
	public HashMapLP(int c, double lf) {
		hashTable = new HashMapEntry[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
		collisions = 0;
	}
	/**
		Method trimToPowerOf2 to create a hashtable with a size that is
		the closest power of two to c
		@param c the capacity intended for the hashtable
		@return the closet power of 2 to c
	*/
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity = capacity << 1; // * 2
		return capacity;
	}
	/**
		The hash function
		@param the hash code of the key
		@return a valid index in the hashtable
	*/
	private int hash(int hashCode) {
		return hashCode & (hashTable.length - 1);
	}
	/**
		Method to get the size of the hashtable
		@return the number of elements in the hashtable
	*/
	public int size() {
		return size;
	}
	/**
		new Method to clear the hashtable
	*/
	public void clear() {
		hashTable = new HashMapEntry[hashTable.length];
		size = 0;
	}
	/**
		Method to check if the hashtable is empty
		@return true if the hashtable is empty, false otherwise
	*/
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
		Search method
		@param key to be serached
		@return true if key was found, false otherwise
	*/
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		return false;
	}
	/**
		Method to get the value of a key
		@param key to be serached
		@return the value of the key if found, null otherwise
	*/
	public V get(K key) {
		int HTIndex = hash(key.hashCode());
		while (hashTable[HTIndex] != null) {
			if (hashTable[HTIndex].getKey().equals(key))
				return hashTable[HTIndex].getValue();
			HTIndex = (HTIndex + 1) % hashTable.length;
		}
		return null;
	}
	/**
		Method to remove a pair from the hashtable
		@param key to be searched and removed
		if the key is not found, the hashtable is unchanged
	*/
	public void remove(K key) {
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex] != null) { //key is in the hash map
			for (HashMapEntry < K, V > entry: hashTable) {
				if (entry.getKey().equals(key)) {
					entry = null;
					size--;
					break;
				}
			}
		}
	}
	/**
		Method to add a pair (key,value) to the hashtable
		@param key to be added
		@param value of the key to be added
		@return old value if the key was found or the new value if key was not found
	*/
	public V put(K key, V value) {
		if (get(key) != null) { // The key is in the hash map
			int HTIndex = hash(key.hashCode());
			while (hashTable[HTIndex] != null) {
				if (hashTable[HTIndex].getKey().equals(key)) {
					V old = hashTable[HTIndex].getValue();
					hashTable[HTIndex].setValue(value);
					return old;
				}
				HTIndex = (HTIndex + 1) & (hashTable.length - 1);
			}
		}
		// key not in the hash map - check load factor
		if (size >= hashTable.length * loadFactor)
			rehash();

		int HTIndex = hash(key.hashCode());
		//create a new LL if empty
		while (hashTable[HTIndex] != null) {
			HTIndex = (HTIndex + 1) & (hashTable.length - 1);
			collisions++;
		}
		hashTable[HTIndex] = new HashMapEntry < > (key, value);
		size++;
		return value;
	}
	/**
		Method to rehash the hashtable
    */
	private void rehash() {
		ArrayList < HashMapEntry < K, V >> list = toList();
		hashTable = new HashMapEntry[hashTable.length << 1]; // double the length of hashtable
		size = 0;
		for (HashMapEntry < K, V > entry: list) {
			if (entry != null) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}
	/**
		Method to return all the pairs (key,value) stored in the hashtable
		@return an array list with all the pairs (key,value)
    */
	public ArrayList < HashMapEntry < K,
	V >> toList() {
		ArrayList < HashMapEntry < K, V >> list = new ArrayList < > ();
		for (HashMapEntry < K, V > entry: hashTable) {
			if (entry != null) {
				list.add(entry);
			}

		}
		return list;
	}

	/**
		toString method
		@return formatted string with all the pairs (key,value) in the hashtable
	*/
	public String toString() {
		String out = "[";
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				out += hashTable[i].toString();
				out += "\n";
			}
		}
		out += "]";
		return out;
	}

	public void printClusters() {
		int clusters = 0;
		int largest = 0;
		int smallest = 0;
		int clusterSize = 0;
		int clusterCount = 0;
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				clusterSize++;
				clusterCount++;
			} else {
				if (clusterSize > largest) {
					largest = clusterSize;
				}
				if (clusterSize < smallest) {
					smallest = clusterSize;
				}
				if (clusterSize > 0) {
					clusters++;
				}
				clusterSize = 0;
			}
		}
		System.out.println("Capacity: " + hashTable.length);
		System.out.println("Total Collisions: " + collisions);
		System.out.println("Number of Clusters: " + clusters);
		System.out.println("Size of Largest Cluster: " + largest);
		System.out.println("Size of Smallest Cluster: " + smallest);
	}
}