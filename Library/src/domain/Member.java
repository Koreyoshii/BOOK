package domain;
import java.util.ArrayList;

public class Member {

	private String id;
	private String name;
	private ArrayList<Loan> loans= new ArrayList<Loan>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Loan> getLoans() {
		return loans;
	}
	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
	
	public boolean CanLoan(Book book) {
		return book.getLoanTo() == null;

	}
	
	public Loan Loan(Book book) {
		Loan loan =null;
		//Member member=new Member();
		if (CanLoan(book) && this.validate(book)) {
			loan = LoanFactory.CreateLoan(book, this);
			Loans.add(loan);
			return loan;
		}else{
			return null;
		}
	}

	public Loan FindCurrentLoanFor(Book book){
		for(int i=0 ; i<loans.size() ; i++){
			if(loans.get(i).getBook().equals(book)){
				Loan bookLoan = loans.get(i);
				return bookLoan;
			}
		}
		return null;
	}
		

	public void Return(Book book) {
		Loan loan = FindCurrentLoanFor(book);
		if (!(loan == null)) {
			loan.MarkAsReturned();
			book.setLoanTo(null);
			System.out.println("还书成功！");

		}

	}
	
	public boolean validate(Book wantbook){
		HasReachMaxSpecification a = new HasReachMaxSpecification();
		LoanOnlyOneSpecification b = new LoanOnlyOneSpecification(wantbook);
		return (a.isSatisfiedBy(this) && b.isSatisfiedBy(this));
	}
}