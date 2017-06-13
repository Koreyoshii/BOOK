package test;

import org.junit.Test;

import domain.Book;
import domain.Member;

public class libraryTest {
	
	private Book book1,book2,book3;
	private Member member1;	
	//����û�
	public void addMember(){
		member1 = new Member();
		member1.setId("0001");
		member1.setName("����");
	}
	//���ͼ��
	public void addBook(){
		book1 = new Book();
		book2 = new Book();
		book3 = new Book();
		book1.setId("0001");
		book1.setiSBN("Cumt001");
		book1.settItle("����ѧԭ��");
		book1.setLoanTo(null);
		book2.setId("0002");
		book2.setiSBN("Cumt002");
		book2.settItle("��ҵ��������");
		book2.setLoanTo(null);
		book3.setId("0003");
		book3.setiSBN("Cumt003");
		book3.settItle("��ҵ��Դ�ƻ�");
		book3.setLoanTo(null);

	}
	//����ɹ�
	@Test
	public void loanSuccess(){
		this.addMember(); 
		this.addBook();
		member1.Loan(book1);
		member1.Loan(book2);
		member1.Loan(book3);
		System.out.println("***********�����¼***************");
		System.out.println("������" + member1.getName());
		System.out.println("������" + book1.gettItle() + "��" + book2.gettItle() + "��" + book3.gettItle());
		System.out.println("����ʱ�䣺" + member1.getLoans().get(0).getLoanDate());
		
	}
	//����ʧ��
	@Test
	public void loanFail(){
		this.loanSuccess();
		member1.Loan(book1);
		if(member1.validate(book1)==false){
			System.out.println("����ʧ��");
		}
	}
	//����
	@Test
	public void returnBook(){
		this.loanSuccess();
		member1.Return(book1);
		System.out.println("***********�����¼***************");
		System.out.println("������" + member1.getName());
		System.out.println("������" + book1.gettItle());
	}
}