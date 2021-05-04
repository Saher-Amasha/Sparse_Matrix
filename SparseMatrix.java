
public class SparseMatrix implements Matrix{
	double defaultValue;
	int size;
	double constant=1;
	boolean transpose;
	
	
	
	SLinkedList <SparseMatrixEntry> values;
	
	SparseMatrix(){this(MAX_SIZE,0);}
	SparseMatrix(int size,double defaultValue)
	{
		this.size=size;
		this.defaultValue=defaultValue;
		values=new SLinkedList <SparseMatrixEntry>();
		transpose=false;
	}

	@Override
	public int getSize() {
		
		return size;
		
	}
	
	@Override
	public double get(int i, int j) {

		if(i<size&&i>=0&&j<size&&j>=0)
		{
			if(transpose==true)
			{
				int temp1=i;
				i=j;
				j=temp1;
			}
			
			values.gotoBeginning();
			if(values.isEmpty()==false)
				if(values.getCursor().getI()==i&&values.getCursor().getJ()==j)
				{
					double temp5= values.getCursor().getValue();
					values.gotoBeginning();
					return temp5*constant;
				}
			while(values.gotoNext()==true)
			{
				if(values.getCursor().getI()==i&&values.getCursor().getJ()==j)
					{
						double temp5= values.getCursor().getValue();
						values.gotoBeginning();
						return temp5*constant;
					}
				
			}
		
		
		return defaultValue;
		}
		return -1;
	}

	@Override
	public void put(int i, int j, double x) {
	
		if(i<size&&i>=0&&j<size&&j>=0)
		{
			
			if(transpose==true)
			{
				int temp1=i;
				i=j;
				j=temp1;
			}
			
			values.gotoBeginning();
			
			//deals with replace in head
			if(values.isEmpty()==false)
			if(values.getCursor().getI()==i&&values.getCursor().getJ()==j)
			{
					
					values.replace(new SparseMatrixEntry(x/this.constant,i,j));
				
					return;
			}
		
			
		while(values.gotoNext()==true)
		{
			
			if(values.getCursor().getI()==i&&values.getCursor().getJ()==j)
				{
					
					values.replace(new SparseMatrixEntry(x/this.constant,i,j));
				
					return;
				}
		
			
		}
		//done replace
		 values.insert(new SparseMatrixEntry(x/this.constant,i,j));
		
		}
		
		
		
		}
		
		


	@Override
	public void transpose() {
		if(transpose==false)
		transpose=true;
		else if(transpose==true)
		transpose=false;
			
	}


	@Override
	public void multByConstant(int c) {
		if(c==0)
		{
			constant=1;
			defaultValue=0;
			values.clear();
		}
		else
		{		
			constant*=c;
			defaultValue*=c;
		}
		
	}
	public void Addition(SparseMatrix B) {
		//runtime==========> O(n^2)
		double sum;
		for(int i=0;i<size;i++) 
		{
			for(int j=0;j<size;j++)
			{
				 sum=B.get(i, j)+this.get(i, j);
				if(sum==defaultValue)
				{
					// do nothing
				}
				else
				{
					this.put(i, j, sum);
				}
			}
		}
		
	}	
public void subtraction(SparseMatrix B)
	{
	//runtime==========> O(n^2)
			defaultValue-=B.defaultValue;
			double sum;
			for(int i=0;i<size;i++) 
			{
				for(int j=0;j<size;j++)
				{
					 sum=this.get(i, j)-B.get(i, j);
					if(sum==defaultValue)
					{
						// do nothing
					}
					else
					{
						this.put(i, j, sum);
					}
				}
			}
		
	}
	public String toString() {
		String temp="";
		
		for(int i=0;i<size;i++) 
		{
			for(int j=0;j<size;j++)
			{
				
			temp+=get(i,j)+" ";
			
			}
			temp+="\n";
		}
			
		return temp;
		
	}

}
