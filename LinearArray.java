public class LinearArray{
  public static void main(String [] args){
    int [] a = {10, 20, 30, 40, 50, 60};
    
    System.out.println("\n///// TEST 01: Copy Array example /////");
    int [] b = copyArray(a, a.length);
    printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    
    System.out.println("\n///// TEST 02: Print Reverse example /////");
    printArray(a); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    printReverse(a); // This Should Print: { 60, 50, 40, 30, 20, 10 } 
    
    
    System.out.println("\n///// TEST 03: Reverse Array example /////");
    reverseArray(b);
    printArray(b); // This Should Print: { 60, 50, 40, 30, 20, 10 } 
    
    
    System.out.println("\n///// TEST 04: Shift Left k cell example /////");
    b = copyArray(a, a.length);
    b=shiftLeft(b,3);
    printArray(b); // This Should Print: { 40, 50, 60, 0, 0, 0 } 
    
    System.out.println("\n///// TEST 05: Rotate Left k cell example /////");
    b = copyArray(a, a.length); 
    printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    b=rotateLeft(b,3);
    printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 
    
    System.out.println("\n///// TEST 06: Shift Right k cell example /////");
    b = copyArray(a, a.length);
    printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    b=shiftRight(b,3);
    printArray(b);  // This Should Print: { 0, 0, 0, 10, 20, 30 } 
    
    System.out.println("\n///// TEST 07: Rotate Right k cell example /////");
    b = copyArray(a, a.length);
    printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    b=rotateRight(b,3);
    printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 
    
    
    System.out.println("\n///// TEST 08: Insert example 1 /////");
    
    b = copyArray(a, a.length);
    printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    boolean bol=insert(b,6, 70, 2); // This Should Print: No space Left 
    System.out.println(bol); // This Should Print: false
    printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 
    
    System.out.println("\n///// TEST 09: Insert example 2 /////");
    int [] c = {10, 20, 30, 40, 50, 0, 0}; 
    printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 }
    bol=insert(c,5, 70, 2);  // This Should Print: Number of elements after insertion: 6
    System.out.println(bol); // This Should Print: true
    printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 
    
    System.out.println("\n///// TEST 10: Insert example 3 /////");
    printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 
    bol=insert(c,6, 70, 6); // This Should Print: Number of elements after insertion: 7 
    System.out.println(bol); // This Should Print: true
    printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
    
    System.out.println("\n///// TEST 11: Remove example 1 /////");
    
    printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
    bol=removeAll(c,7,90);
    System.out.println(bol); // This Should Print: false
    printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
    
    System.out.println("\n///// TEST 12: Remove example 2 /////");
    printArray(c);  // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
    bol=removeAll(c,7,70);
    System.out.println(bol); // This Should Print: true
    printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 } 
    
    
    
  }
  
  // Prints the contents of the source array
  public static void printArray(int [] source){
    System.out.print("{");
    for(int i=0;i<source.length;i++){
      System.out.print(source[i]);
      if(i<source.length-1)System.out.print(",");
    }
    System.out.print("}");
  }
  
  // Prints the contents of the source array in reverse order
  public static void printReverse(int [] source){
    System.out.print("{");
    for(int i=source.length-1;i>=0;i--){
      System.out.print(source[i]);
      if(i>0)System.out.print(",");
    }
    System.out.print("}");
  }
  
  
  // creates a copy of the source array and returns the reference of the newly created copy array
  public static int [] copyArray(int [] source, int len){
    int a[]=new int[len];
    for(int i=0;i<source.length;i++ ){
      a[i]=source[i];
    }
    return a; // remove this line    
  }
  
  // creates a reversed copy of the source array and returns the reference of the newly created reversed array
  public static void reverseArray(int [] source){
    int a;
    for(int i=0;i<source.length/2;i++ ){
      a=source[i];
      source[i]=source[source.length-1-i];
      source[source.length-1-i]=a;
    }
  }
  
  // Shifts all the elements of the source array to the left by 'k' positions
  // Returns the updated array
  public static int [] shiftLeft(int [] source, int k){  //done
    
    for(int i=0;i<source.length-k;i++){
      source[i]=source[i+k];
    }
    for(int i=source.length-k;i<source.length;i++){
      source[i]=0;
    }
    
    return source;     
  }
  
  // Rotates all the elements of the source array to the left by 'k' positions
  // Returns the updated array
  public static int [] rotateLeft(int [] source, int k){
    int temp;
    int a[]=new int[k+1];
    for(int i=0;i<=k;i++){
      a[i]=source[i];
    }
    shiftLeft( source,  k);
    int c=0;
    for(int i=source.length-k;i<source.length;i++){
      source[i]=a[c++];
      
    }
    return source; 
  }
  
  // Shifts all the elements of the source array to the right by 'k' positions
  // Returns the updated array
  public static int [] shiftRight(int [] source, int k){
    for(int i=0;i<source.length-k;i++){
      source[i+k]=source[i];
    }
    for(int i=0;i<k;i++){
      source[i]=0;
    }
    
    return source;    
  }
  
  // Rotates all the elements of the source array to the right by 'k' positions
  // Returns the updated array
  public static int [] rotateRight(int [] source, int k){
    int a[]=new int[k];
    int c=k;
    for(int i=0;i<a.length;i++){
      a[i]=source[c++];
    }
    shiftRight(source,  k);
    c=0;
    for(int i=0;i<a.length;i++){
      source[c++]=a[i];
    }
    return source; // remove this line  
    
  }
  
  /** @return true if insertion is successful; @return false otherwise
    * @param arr the reference to the linear array
    * @param size the number of elements that exists in the array. size<=arr.length
    * @param elem the element that is to be inserted
    * @param index the index in which the element is required to be inserted
    * if insertion is not successful due to lack space, print "No space Left"
    * if given index is invalid, print "Invalid Index"
    * if insertion is successful, print the 'Number of elements after insertion' is completed
    */
  public static boolean insert(int [] arr, int size, int elem, int index){
    if(arr.length<=size)return false;
    if(size<index) return false;
    if(index==size){
      arr[index]=elem;
    }else{
      int aa[]=new int[size-index];
      int ii=index;
      for(int i=0;i<aa.length;i++){
        aa[i]=arr[ii++];
      }
      ii=index+1;
      for(int i=0;i<aa.length&&ii<arr.length;i++){
        arr[ii++]=aa[i];
      } 
      arr[index]=elem;
      //  System.out.println(java.util.Arrays.toString(aa));
    }
    
    
    return true;    
  }
  
  /** 
   * removes all the occurences of the given element
   * @param arr the reference to the linear array
   * @param size the number of elements that exists in the array. size<=arr.length
   * @param elem the element to be removed
   * @return true if removal is successful; return false otherwise
   * if removal is successful, print the 'Number of elements after removal' is completed
   */  
  public static boolean removeAll(int [] arr, int size, int elem){
    boolean aaa=false;
    int c=0;
    for(int i =0;i<size;i++){
      if(arr[i]!=elem){
       c++;
      }
    }
    int ai[]=new int[c];
    c=0;
      for(int i =0;i<size;i++){
      if(arr[i]!=elem){
       ai[c++]=arr[i];      
      }
    }
   for(int i =0;i<ai.length;i++){
      if(arr[i]!=elem){
       arr[i]=ai[i];      
      }
    }
    for(int i=ai.length;i<size;i++){
    
       arr[i]=0;      
      aaa=true;
    }
   // System.out.println(java.util.Arrays.toString(ai));
    
    return aaa;  
  }
  
  
  
  
  
  
  
  
  
  
}
