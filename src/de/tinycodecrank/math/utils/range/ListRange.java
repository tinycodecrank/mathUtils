package de.tinycodecrank.math.utils.range;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class ListRange
{
	private ListRange()
	{}
	
	public static final <T> ElementIndexListRange<T> range(List<T> list)
	{
		return new ElementIndexListRange<>(list, Range.range(0, list.size()));
	}
	
	public static final <T> ElementIndexListRange<T> rRange(List<T> list)
	{
		return new ElementIndexListRange<>(list, Range.rRange(0, list.size()));
	}
	
	public static final class IndexListRange<T> implements IRange<Integer, IndexListRange<T>>
	{
		private final List<T>	list;
		private final Range		range;
		
		private IndexListRange(List<T> list, Range range)
		{
			this.list	= list;
			this.range	= range;
		}
		
		@Override
		public Iterator<Integer> iterator()
		{
			return this.range.iterator();
		}
		
		public ElementListRange<T> element()
		{
			return new ElementListRange<>(list, range);
		}
		
		public ElementIndexListRange<T> iElem()
		{
			return new ElementIndexListRange<>(list, range);
		}
		
		@Override
		public IndexListRange<T> reverse()
		{
			return new IndexListRange<>(list, range.reverse());
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
	
	public static final class ElementListRange<T> implements IRange<T, ElementListRange<T>>
	{
		private final List<T>	list;
		private final Range		range;
		
		private ElementListRange(List<T> list, Range range)
		{
			this.list	= list;
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
					return list.get(iterator.next());
				}
			};
		}
		
		public ElementIndexListRange<T> iElem()
		{
			return new ElementIndexListRange<>(list, range);
		}
		
		public IndexListRange<T> index()
		{
			return new IndexListRange<>(list, range);
		}
		
		@Override
		public ElementListRange<T> reverse()
		{
			return new ElementListRange<>(list, range.reverse());
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
	
	public static final class ElementIndexListRange<T> implements IRange<IndexElement<T>, ElementIndexListRange<T>>
	{
		private final List<T>	list;
		private final Range		range;
		
		private ElementIndexListRange(List<T> list, Range range)
		{
			this.list	= list;
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
					return new IndexElement<>(index, list.get(index));
				}
			};
		}
		
		public IndexListRange<T> index()
		{
			return new IndexListRange<>(list, range);
		}
		
		public ElementListRange<T> element()
		{
			return new ElementListRange<>(list, range);
		}
		
		@Override
		public ElementIndexListRange<T> reverse()
		{
			return new ElementIndexListRange<>(list, range.reverse());
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