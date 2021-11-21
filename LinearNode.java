public class LinearNode<T>{
	
    private LinearNode<T> next;
    private T current;
	/**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
        current = null;
    }
    
    /**
     * Creates a node storing the specified element.
     *
     * @param elem  the element to be stored within the new node
     */
    public LinearNode (T elem)
    {
        next = null;
        current = elem;
    }
    
    /**
     * Returns the node that follows this one.
     *
     * @return  the node that follows the current one
     */
    public LinearNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one.
     *
     * @param node  the node to be set to follow the current one
     */
    public void setNext (LinearNode<T> node)
    {
        next = node;
    }
    
    /**
     * Returns the element stored in this node.
     *
     * @return  the element stored in this node
     */
    public T getElement()
    {
        return current;
    }
    
    /**
     * Sets the element stored in this node.
     *
     * @param elem  the element to be stored in this node
     */
    public void setElement (T elem)
    {
    	current = elem;
    }

}
