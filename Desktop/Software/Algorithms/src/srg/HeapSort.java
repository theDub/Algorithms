package srg;

public class HeapSort {

	public int[] inputArray;
	public int inputArraySize;

	public HeapSort(int[] arr){
		this.inputArray = arr;
		this.inputArraySize = arr.length;

		//this.print("Initial Array");
	}

	public void sort(){
		this.buildHeap();
		while(this.inputArraySize - 1 != 0){
			this.swap(0, this.inputArraySize-1);
			this.inputArraySize--;
			this.percolateDown(0);
		}
		//this.print("Sorted Array");
	}

	// left child == 2i + 1, right child == 2i + 2
	public void percolateDown(int i){
		int leftChild = 2 * i + 1;
		int rightChild = 2*i + 2;
		int parent = i;
		int temp = 0;
		if(leftChild < this.inputArraySize && this.inputArray[parent] <= this.inputArray[leftChild]){
			temp = leftChild;
		}
		if(rightChild < this.inputArraySize && this.inputArray[temp] <= this.inputArray[rightChild]){
			temp = rightChild;
		}
		if(temp == 0){
			return;
		} else {
			this.swap(temp, i);
			this.percolateDown(temp);
		}


	}

	public void swap(int index1, int index2){
		int temp = this.inputArray[index1];
		this.inputArray[index1] = this.inputArray[index2];
		this.inputArray[index2]= temp;
	}

	public void propagate(int i){
		if(i != 0 && this.inputArray[((i+1)/2) - 1] < this.inputArray[i]){
			this.swap(i,(i+1)/2 - 1) ;
			this.propagate((i+1)/2 - 1);
		}
	}

	// root = 0; parent == (i+1)/2 - 1
	public void buildHeap(){
		for(int i = 1; i < this.inputArraySize; i++){
			this.propagate(i);
		}
		//this.print("Heap built");
	}

	//86745321
	public void print(String note){
		System.out.print(note + ":       ");
		for (int number : this.inputArray){
			System.out.print(number + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] integerArray = {2, 26, 8, 65, 99, 0, 1, 44, 46, 15, 73, 88};
		int[] myArr = {165,848,45,909,830,429,656,498,917,90,175,958,281,1,797,545,766,652,45,155,990,937,281,259,963,924,720,257,840,734,915};
		int[] wikipediaHeapTest =  { 6, 5, 3, 1, 8, 7, 2, 4 };

		HeapSort myHeap1 = new HeapSort(myArr);
		myHeap1.sort();

		System.out.print("\n");

		HeapSort myHeap2 = new HeapSort(integerArray);
		myHeap2.sort();

		System.out.print("\n");

		HeapSort myHeap = new HeapSort(wikipediaHeapTest);
		myHeap.sort();
	}

}