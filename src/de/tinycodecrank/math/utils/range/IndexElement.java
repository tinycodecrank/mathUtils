package de.tinycodecrank.math.utils.range;

import java.util.function.IntFunction;

public final class IndexElement<T>
{
	private final int	index;
	private final T		element;
	
	public IndexElement(int index, IntFunction<T> source)
	{
		this.index		= index;
		this.element	= source.apply(index);
	}
	
	public IndexElement(int index, T[] source)
	{
		this.index		= index;
		this.element	= source[index];
	}
	
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
	
	@Override
	public String toString()
	{
		return "@" + index + " : " + element;
	}
}