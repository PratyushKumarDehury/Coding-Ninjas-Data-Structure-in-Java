Implement a polynomial class, that contains following functions -
1. setCoefficient -
This function sets coefficient for a particular degree value. If term with given degree is not there in the polynomial, then corresponding term (with specified degree and value) is added. If the term is already present in the polynomial, then previous coefficient value is replaced by given coefficient value.
2. add -
Adds two polynomials and returns a new polynomial which has the result.
3. subtract -
Subtracts two polynomials and returns a new polynomial which has the result.
4. multiply -
Multiplies two polynomials and returns a new polynomial which has the result.
5. print -
Prints all the terms (only terms with non zero coefficients are to be printed) in increasing order of degree.
Print pattern for a single term : "x"
And multiple terms should be printed separated by space. For more clarity, refer sample test cases.

Note : Only keep those terms which have non - zero coefficients.

Input Format:
The first line of input contains count of the number of coefficients in polynomial 1(C1)
The next line of input has C1 degrees for polynomial 1.
The next line of input has C1 coefficients for polynomial 1.  
The next line of input contains count of the number of coefficients in polynomial 2(C2)
The next line of input has C2 degrees for polynomial 2.
The next line of input has C2 coefficients for polynomial 2.  
The next line of input has the choice for the function you want to implement.

Output Format:
The output will be printed in case of print function same as that of print function format.

Sample Input 1 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 1 :
P1 + P2 = 2x2 2x3 3x4 4x6
Sample Input 2 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 2 :
P1 - P2 = 2x3 -3x4 4x6






import java.util.Scanner;
public class Polynomial {

	 public int degree[] = new int[200];
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
	public void setCoefficient(int degree, int coeff){
     this.degree[degree] = coeff;
		
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i = 0; i < 200; i++){
            if(degree[i] != 0)
                System.out.print(degree[i] +  "x" + (i) + " ");
        }
	}
    
    

	
    
    
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
    for(int i = 0; i < 200; i++){
        this.degree[i] = this.degree[i] + p.degree[i];
    }
        return this;
    }
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
			 for(int i = 0; i < 200; i++){
                 this.degree[i] = this.degree[i] - p.degree[i];
             }
        return this;
	}
    
    
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		 int x[] = new int[200];
        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 200; j++){
                    int deg = (i) + (j);
                if(deg < 200){
                    x[deg] += this.degree[i]*p.degree[j];
                }
            }
        }
        for(int i = 0; i < 200; i++){
            this.degree[i] = x[i];
        }
         return this;
    }
}


