package Problems.DataStructures;

import java.util.Arrays;

class MinHeap {
    private int capacity = 10;
    private int size = 0;
    
    int items[] = new int[capacity];
    
    private int getLeftChildIndex(int parentIndex){ return 2*parentIndex+1;}
    private int getRightChildIndex(int parentIndex){ return 2*parentIndex+2;}
    private int getParentIndex(int childIndex){ return (childIndex-1)/2;}
    
    private boolean hasLeftChild(int index){return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
    private boolean hasParent(int index){return getParentIndex(index)>=0;}
    
    private int leftChild(int parentIndex){return items[getLeftChildIndex(parentIndex)];}
    private int rightChild(int parentIndex){return items[getRightChildIndex(parentIndex)];}
    private int parent(int childIndex){return items[getParentIndex(childIndex)];}
    
    private void swap(int fi,int si){
        int temp = items[fi];
        items[fi]=items[si];
        items[si]=temp;
    } 
    private void ensureExtraCapacity(){
        if(size==capacity){
            items = Arrays.copyOf(items,capacity*2);
            capacity*=2;
        }
    }
    public MinHeap(int input[]){
        int n = input.length;
        capacity = n;size = n;
        items = Arrays.copyOf(input, n);
        int startIndex = (n / 2) - 1;
        for (int i = startIndex; i >= 0; i--) { 
            heapifyDown(i); 
        }  

    }
    public int peek(){
        if(size==0) throw new IllegalStateException();
        return items[0];
    }
    public int delete(){
        if(size==0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        heapifyDown(-1);
        size--;
        return item;
    }
    public void insert(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && parent(index)>items[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }
    public void heapifyDown(int fromIndex){
        int index = fromIndex==-1?0:fromIndex;
        while(hasLeftChild(index)){
            int biggerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)<leftChild(index))
                biggerChildIndex = getRightChildIndex(index);
            if(items[index]<items[biggerChildIndex])
                break;
            else
                swap(index,biggerChildIndex);
            index = biggerChildIndex;
        }
    }
    public String toString(){
        return Arrays.toString(Arrays.copyOf(items, size));
    }
    public static void main(String[] args) {
        int input[] = {5,4,3,2,1};
        MinHeap mh = new MinHeap(input);
        System.out.println(mh.toString());
        mh.insert(0);
        System.out.println(mh.toString());
        mh.delete();
        System.out.println(mh.toString());
    }
}