# Sparse_Matrix
my iplemntation of sparse matrix [1]

space comlexity o (r)

the complecity of each function is written next to it :

  r is the number of elements different from the default value
  n is the length of the matrix 
	int getSize();//o(1)
	double get(int i ,int j);//o(r)   
	void put(int i ,int j,double x );//o(r) 
	void transpose();//o(1)
	void multByConstant(int c);//o(1)
  public void Addition(SparseMatrix B) o(n^2) 
  public void subtraction(SparseMatrix B)o(n^2)
  
  [1]https://en.wikipedia.org/wiki/Sparse_matrix
