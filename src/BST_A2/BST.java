package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  public BST_Node getRoot(){ return root; }

  @Override
  public boolean insert(String s) {
	  
	  if (s == null) {
		  return false;
	  }
	  
	  if (size == 0) {
		  root = new BST_Node(s);
		  size++;
		  return true;
	  } else {
		  if (root.insertNode(s)) {
			  size++;
			  return true;
		  } else {
			  return false;
		  }
	  }
  }
  @Override
  public boolean remove(String s) {
	  if (root == null) {
		  return false;
	  } else {
		  if (root.data.compareTo(s) == 0) {
			BST_Node newRoot = new BST_Node(root.data);
		  	newRoot.left = root;
		  	boolean result = root.removeNode(s, newRoot);
		  	root = newRoot.left;
		  	size--;
		  	return result;
		  } else {
			  if (root.removeNode(s, null)) {
				  size--;
				  return true;
			  }
			  return false;
		  }
	  }
  }

  @Override
  public String findMin() {
	  if (root != null) {
		  return root.findMin().data;
	  } else {
		  return null;
	  }
  }

  @Override
  public String findMax() {
	  if (root != null) {
		  return root.findMax().data;
	  } else {
		  return null;
	  }
  }

  @Override
  public boolean empty() {
	  if (size == 0) {
		  return true;
	  } else {
		  return false;
	  }
  }

  @Override
  public boolean contains(String s) {
	  if (s == null) {
		  return false;
	  }
	  
	  if (size == 0) {
		  return false;
	  } else {
		  return root.containsNode(s);
	  }
  }

  @Override
  public int size() {
	  return this.size;
  }

  @Override
  public int height() {
	  if (root == null) {
		  return -1;
	  } else {
		  return root.getHeight();
	  }
  }

}