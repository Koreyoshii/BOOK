package domain;

import java.util.List;

public class HasReachMaxSpecification implements IsSpecification<Member> {
	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		loans=member.getLoans();
		for(Loan l:loans){
			if(l.getReturnDate()==null)count=count+1;			
		}
		if(count<3){
			return true;
		}
		//System.out.println(count);
		return false;
	}
}
