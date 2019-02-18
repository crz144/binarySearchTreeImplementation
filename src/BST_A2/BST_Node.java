package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  	public boolean containsNode(String s) {
  		if (this.data.compareTo(s) == 0) {
  			return true;
  		} else if (this.data.compareTo(s) < 0) {
  			if (right != null) {
  				return right.containsNode(s);
  			} else {
  				return false;
  			}
  		} else {
  			if (left != null) {
  				return left.containsNode(s);
  			} else {
  				return false;
  			}
  		}
  	}
 
  	public boolean insertNode(String s) { 
  		if (this.data.compareTo(s) == 0) {
  			return false;
  		} else if (this.data.compareTo(s) < 0) {
  			if (right == null) {
  				this.right = new BST_Node(s);
  				return true;
  			} else {
  				return right.insertNode(s);
  			}
  		} else {
  			if (left == null) {
  				this.left = new BST_Node(s);
  				return true;
  			} else {
  				return left.insertNode(s);
  			}
  		}
  	}
  
  	public boolean removeNode(String s, BST_Node parent) { 
  		if (this.data.compareTo(s) < 0 ) {
  			if (right != null) {
  				return right.removeNode(s, this);
  			} else {
  				return false;
  			}
  		} else if (this.data.compareTo(s) > 0) {
  			if (left != null) {
  				return left.removeNode(s, this);
  			} else {
  				return false;
  			}
  		} else {
  			if (left == null && right == null) {
  				if (parent.left == this) {
  					parent.left = null;
  					return true;
  				} else if (parent.right == this) {
  					parent.right = null;
  					return true;
  				}
  			} else if (left != null && right == null) {
  				if (parent.left == this) {
  					parent.left = this.left;
  					return true;
  				} else if (parent.right == this) {
  					parent.right = this.left;
  					return true;
  				}
  			} else if (left == null && right != null) {
  				if (parent.left == this) {
  					parent.left = this.right;
  					return true;
  				} else if (parent.right == this) {
  					parent.right = this.right;
  					return true;
  				}
  			} else {
  				this.data = this.left.findMax().data;
  				return this.left.removeNode(this.data, this);
  			}
  			return true;
  		}
  	}
  
  	public BST_Node findMin() { 
  		if (this.left != null) {
  			return this.left.findMin();
  		} else {
  			return this;
  		}
  	}
  
  	public BST_Node findMax() { 
  		if (this.right != null) {
  			return this.right.findMax();
  		} else {
  			return this;
  		}
  	}
  
  	public int getHeight() { 
  		if (left != null && right == null) {
  			return left.getHeight() + 1;
  		} else if (left == null && right != null) {
  			return right.getHeight() + 1;
  		} else if (right != null && left != null) {
  			return Math.max(left.getHeight(), right.getHeight()) + 1;
  		} else {
  			return 0;
  		}
  	}
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}