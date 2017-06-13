package domain;

import java.util.List;

public class LoanOnlyOneSpecification implements IsSpecification<Member>{
	
	private Book wantBook;	
	public LoanOnlyOneSpecification(Book wantBook){
		this.wantBook = wantBook;
	}
	public boolean isSatisfiedBy(Member member) {

		boolean i = false;
		List<Loan> list = member.getLoans();
		if(list == null){
			i=true; 
		}else{
			for(Loan loan:list){
				if(loan.getBook().getiSBN()!=wantBook.getiSBN()){
					i=true;
				}
			}
		}
		
		return i;
	}
	
}
