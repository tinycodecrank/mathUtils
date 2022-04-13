package de.tinycodecrank.math.utils.range;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class ArrayRange
{
	private ArrayRange()
	{}
	
	public static final <T> ElementIndexArrayRange<T> range(T[] array)
	{
		return new ElementIndexArrayRange<>(array, Range.range(0, array.length));
	}
	
	public static final <T> ElementIndexArrayRange<T> rRange(T[] array)
	{
		return new ElementIndexArrayRange<>(array, Range.rRange(0, array.length));
	}
	
	private static interface IArrayRange<T, E extends IArrayRange<T, E>> extends Iterable<T>
	{
		public E reverse();
	}
	
	public static final class IndexArrayRange<T> implements IArrayRange<Integer, IndexArrayRange<T>>
	{
		private final T[]	array;
		private final Range	range;
		
		private IndexArrayRange(T[] array, Range range)
		{
			this.array	= array;
			this.range	= range;
		}
		
		@Override
		public Iterator<Integer> iterator()
		{
			return this.range.iterator();
		}
		
		public ElementArrayRange<T> element()
		{
			return new ElementArrayRange<>(array, range);
		}
		
		public ElementIndexArrayRange<T> iElem()
		{
			return new ElementIndexArrayRange<>(array, range);
		}
		
		@Override
		public IndexArrayRange<T> reverse()
		{
			return new IndexArrayRange<>(array, range.reverse());
		}
		
		public Stream<Integer> stream()
		{
			return StreamSupport.stream(spliterator(), false);
		}
		
		/**
		 * @return The amount of steps this range requires to traverse or -1 if it takes
		 *         an infinite amount of steps.
		 */
		public int steps()
		{
			return this.range.steps();
		}
	}
	
	public static final class ElementArrayRange<T> implements IArrayRange<T, ElementArrayRange<T>>
	{
		private final T[]	array;
		private final Range	range;
		
		private ElementArrayRange(T[] array, Range range)
		{
			this.array	= array;
			this.range	= range;
		}
		
		@Override
		public Iterator<T> iterator()
		{
			return new Iterator<T>()
			{
				Iterator<Integer> iterator = range.iterator();
				
				@Override
				public boolean hasNext()
				{
					return iterator.hasNext();
				}
				
				@Override
				public T next()
				{
					return array[iterator.next()];
				}
			};
		}
		
		public ElementIndexArrayRange<T> iElem()
		{
			return new ElementIndexArrayRange<>(array, range);
		}
		
		public IndexArrayRange<T> index()
		{
			return new IndexArrayRange<>(array, range);
		}
		
		@Override
		public ElementArrayRange<T> reverse()
		{
			return new ElementArrayRange<>(array, range.reverse());
		}
		
		public Stream<T> stream()
		{
			return StreamSupport.stream(spliterator(), false);
		}
		
		/**
		 * @return The amount of steps this range requires to traverse or -1 if it takes
		 *         an infinite amount of steps.
		 */
		public int steps()
		{
			return this.range.steps();
		}
	}
	
	public static final class ElementIndexArrayRange<T> implements IArrayRange<IndexElement<T>, ElementIndexArrayRange<T>>
	{
		private final T[]	array;
		private final Range	range;
		
		private ElementIndexArrayRange(T[] array, Range range)
		{
			this.array	= array;
			this.range	= range;
		}
		
		@Override
		public Iterator<IndexElement<T>> iterator()
		{
			return new Iterator<IndexElement<T>>()
			{
				Iterator<Integer> iterator = range.iterator();
				
				@Override
				public boolean hasNext()
				{
					return iterator.hasNext();
				}
				
				@Override
				public IndexElement<T> next()
				{
					int index = iterator.next();
					return new IndexElement<>(index, array[index]);
				}
			};
		}
		
		public IndexArrayRange<T> index()
		{
			return new IndexArrayRange<>(array, range);
		}
		
		public ElementArrayRange<T> element()
		{
			return new ElementArrayRange<>(array, range);
		}
		
		@Override
		public ElementIndexArrayRange<T> reverse()
		{
			return new ElementIndexArrayRange<>(array, range.reverse());
		}
		
		public Stream<IndexElement<T>> stream()
		{
			return StreamSupport.stream(spliterator(), false);
		}
		
		/**
		 * @return The amount of steps this range requires to traverse or -1 if it takes
		 *         an infinite amount of steps.
		 */
		public int steps()
		{
			return this.range.steps();
		}
	}
}