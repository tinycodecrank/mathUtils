package de.tinycodecrank.math.utils.range;

interface IRange<T, E extends IRange<T, E>> extends Iterable<T>
{
	public E reverse();
}