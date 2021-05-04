
public class SLinkedList <T> implements List<T>{
	private SNode<T> head;
	private SNode<T> cursor;
	SLinkedList()
	{
		head=null;
		cursor=null;
	}
	@Override
	public void insert(T newElement) {
		if(newElement!=null)
		{
			
			if(head==null)//if list is empty
			{
				 head=new SNode<T>(newElement,null);
				 cursor=head;
			
			}
			else//list not empty
			{
				
				if(cursor.getNext()==null)//if at the end of list 
				{
					cursor.setNext(new SNode<T>(newElement,null));
				}
				else {
					SNode<T> temp=new SNode<T>(newElement,cursor.getNext());
					cursor.setNext(temp);
				}
				
				cursor=cursor.getNext();
			}
			
			
			
			
			
		}
		
	}
  
	@Override
	public void remove() {
		if(head!=null) {
		
		//if the cursor is in the beginning
		if(!gotoPrior())
		{	
			head=head.getNext();
			//if head is the only element its next is equal to null
			//else if head is not the only element its next becomes the head 
			
		}
		else
		{
			//if the cursor is not in the end or the beginning		 
			if(cursor.getNext().getNext()!=null)
			{
			cursor.setNext(cursor.getNext().getNext());
			cursor=cursor.getNext();
			}
			//if cursor is in the end
			if(cursor.getNext().getNext()==null)
				cursor.setNext(null);
				cursor=head;
		}
	}
	}

	@Override
	public void replace(T newElement) {
		if(head!=null&&newElement!=null)
			cursor.setElement(newElement);
		
	}

	@Override
	public void clear() {
		head=null;
		cursor=null;
	}

	@Override
	public boolean isEmpty() {
		if(head==null)
			return true;
		return false;
	}

	@Override
	public boolean gotoBeginning() {
		if(head!=null)
		{
			cursor=head;
			return true ;
		}
		return false;
	}

	@Override
	public boolean gotoEnd() {
		if(head==null)
			return false;
		while(cursor.getNext()!=null)
			cursor=cursor.getNext();
		return true;
		}
	
	@Override
	public boolean gotoNext() {
		if(head!=null&&cursor.getNext()!=null) {
		this.cursor=this.cursor.getNext();
		return true;
		}
		return false;
	}
	public boolean gotoPrior()
	{
		if(head==null||cursor==head)
			return false;
	
		 SNode<T> tempCursor=head;
		 while(tempCursor.getNext()!=cursor)
		 {
			 tempCursor=tempCursor.getNext();
			 
		 }
		 cursor=tempCursor;
		 return true;
		
	}

	@Override
	public T getCursor() {
		if(head!=null)
		return  cursor.getElement();
		
			return null;
	}
	public String toString()
	{
		 String temp="";
		SNode<T> tempCursor=head;
		
		 while(tempCursor!=null)
		 {
			 temp+=tempCursor.getElement();
			 temp+="->";
			 tempCursor=tempCursor.getNext();
		 }
		 temp+="null";
		return temp;
	}

}
