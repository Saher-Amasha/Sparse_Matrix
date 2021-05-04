package lab5;

public interface Matrix {
	final int MAX_SIZE = 100;
	int getSize();//o(1)
	double get(int i ,int j);//o(r) r is the number of elements different from the default value  
	void put(int i ,int j,double x );//o(r) r is the number of elements different from the default value  
	void transpose();//o(1)
	void multByConstant(int c);//o(1)

}
