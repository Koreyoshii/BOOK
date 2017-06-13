package domain;

public interface IsSpecification<T> {
	
	public boolean isSatisfiedBy(T entity);

}
