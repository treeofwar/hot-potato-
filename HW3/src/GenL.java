
public class GenL <T> {

	public class ListNode 
	{
		
		private T data;
		public ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public int length =0;//tests for how long it is and goes up by 1 each time a node is made
	private ListNode head;
	private ListNode curr;
	private ListNode prev;
	private ListNode tail;
	public GenL()

	{
		head = curr = prev = null;
	}
	public  T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	public ListNode getCurrentNode() { 
	    if(curr != null) 
	    	return curr;
	    return null;
	}
	public void setCurrent(T aData) 
	{
		if(curr != null)
			curr.data = aData;
	}
	public void gotoNext()
	{
		if(curr ==null)
			return;
		prev = curr;
		curr = curr.link;
	}
	public void reset()
	{
		curr = head;
	}
	public boolean hasMore()
	{
		return curr != null;
	}
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData,null);
		if(head == null)
			tail = curr = head = newNode;
		{
			ListNode temp = head;
			while(temp != tail) {
				temp = temp.link;
			}
		}
		tail.link = newNode;
		newNode.link = head;
		tail = newNode;
		length++;
	}
	public void insertAFterCurrent(T aData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData,curr.link);
		curr.link = newNode;
	}
	public void removeAtCurr() {
		if(curr == null) {
			return;
		}
		if(tail == head) {
			prev = tail = curr = head =null;
			length=0;
			return;
		}
		if(curr == head) {
			head = head.link;
			tail.link = head;
			length--;
			return;
		}
		if(curr == tail) {
			prev.link = head;
			tail = prev;
			length--;
			return;
		}
		curr = curr.link;
		prev.link = curr;
		length--;
	}
	public void removeNode(T aData) {
		ListNode temp = this.findNodeWith(aData);
		if(temp != null) {
			while(curr != temp) {
				this.gotoNext();
			}
			this.removeAtCurr();
		}
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public boolean isContained(T aData)
	{
		return this.findNodeWith(aData) != null;
	}
	public void gotoItem(T aData)
	{
		ListNode temp = this.findNodeWith(aData);
		if(temp == null)
		return;
		this.reset();
		while(this.hasMore() && curr!=temp) 
			this.gotoNext();
	}
	private ListNode findNodeWith(T aData)
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.data.equals(aData))
				return temp;
			temp = temp.link;
		}
		return null;
	}
}
