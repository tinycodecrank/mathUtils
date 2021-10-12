package de.tinycodecrank.math.utils.range;

public final class IndexElement<T>
{
	private final int	index;
	private final T		element;
	
	public IndexElement(int index, T element)
	{
		this.index		= index;
		this.element	= element;
	}
	
	public int index()
	{
		return this.index;
	}
	
	public T element()
	{
		return this.element;
	}
}