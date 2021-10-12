package de.tinycodecrank.math.utils.range;

import java.util.Iterator;
import java.util.List;

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
	
	private static interface IListRange<T, E extends IListRange<T, E>> extends Iterable<T>
	{
		public E reverse();
	}
	
	public static final class IndexListRange<T> implements IListRange<Integer, IndexListRange<T>>
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
	}
	
	public static final class ElementListRange<T> implements IListRange<T, ElementListRange<T>>
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
	}
	
	public static final class ElementIndexListRange<T> implements IListRange<IndexElement<T>, ElementIndexListRange<T>>
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
	}
}