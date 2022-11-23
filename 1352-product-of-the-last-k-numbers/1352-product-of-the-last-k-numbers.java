class ProductOfNumbers {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int product = 1;
	    public ProductOfNumbers() {
	        
	    }
	    
	    public void add(int num) {
	       if(num==0)
	       {
	    	   arr.clear();
	    	   product=1;
	       }
	       else
	       {
               product*=num;
	    	   arr.add(product);
	       		
	       }
	    	   
	    }
	    
	    public int getProduct(int k) {
	       int size = arr.size()-k;
           // System.out.println("size -->>"+size);
             //System.out.println("k -->>"+k);
            //System.out.println("arr -->>"+arr);
             //System.out.println("product -->>"+product);
            //System.out.println(" ---------------->>");
	       if(size>0)return  (product/arr.get(size-1));
	       if(size==0) return product;
	       
	       return 0;
	    }
	}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */