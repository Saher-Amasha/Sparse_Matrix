package lab5;

public class SparseMatrixEntry {
private double value;
private int i;
private int j;

public SparseMatrixEntry(double val,int i ,int j ) {
	value=val;
	this.i=i;
	this.j=j;
}
public int getI() {
	return i;
	}
public void setI(int i) {this.i=i;}
public int getJ() {
	return j;
	}
public void setJ(int j) { this.j=j;}

public double getValue() {
	return value;
	}
public void setValue(double newVal) {value=newVal;}


}

