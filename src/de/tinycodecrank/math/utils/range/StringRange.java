package de.tinycodecrank.math.utils.range;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class StringRange implements IRange<IndexElement<Character>, StringRange>
{
	public static final StringRange range(String str)
	{
		return new StringRange(str, Range.range(0, str.length()));
	}
	
	public static final StringRange rRange(String str)
	{
		return new StringRange(str, Range.rRange(0, str.length()));
	}
	
	private final String	str;
	private final Range		range;
	
	private StringRange(String str, Range range)
	{
		this.str	= str;
		this.range	= range;
	}
	
	@Override
	public Iterator<IndexElement<Character>> iterator()
	{
		return new Iterator<IndexElement<Character>>()
		{
			Iterator<Integer> iterator = range.iterator();
			
			@Override
			public boolean hasNext()
			{
				return iterator.hasNext();
			}
			
			@Override
			public IndexElement<Character> next()
			{
				int index = iterator.next();
				return new IndexElement<>(index, str::charAt);
			}
		};
	}
	
	public CharRange element()
	{
		return new CharRange(str, range);
	}
	
	public IndexRange index()
	{
		return new IndexRange(str, range);
	}
	
	@Override
	public StringRange reverse()
	{
		return new StringRange(str, range.reverse());
	}
	
	public int steps()
	{
		return this.range.steps();
	}
	
	public static final class IndexRange implements IRange<Integer, IndexRange>
	{
		private final String	str;
		private final Range		range;
		
		private IndexRange(String str, Range range)
		{
			this.str	= str;
			this.range	= range;
		}
		
		@Override
		public Iterator<Integer> iterator()
		{
			return this.range.iterator();
		}
		
		public CharRange element()
		{
			return new CharRange(str, range);
		}
		
		public StringRange iElem()
		{
			return new StringRange(str, range);
		}
		
		@Override
		public IndexRange reverse()
		{
			return new IndexRange(str, range.reverse());
		}
		
		public int steps()
		{
			return this.range.steps();
		}
	}
	
	public static final class CharRange implements IRange<Character, CharRange>
	{
		private final String	str;
		private final Range		range;
		
		private CharRange(String str, Range range)
		{
			this.str	= str;
			this.range	= range;
		}
		
		@Override
		public Iterator<Character> iterator()
		{
			return new Iterator<Character>()
			{
				Iterator<Integer> iterator = range.iterator();
				
				@Override
				public boolean hasNext()
				{
					return iterator.hasNext();
				}
				
				@Override
				public Character next()
				{
					return str.charAt(iterator.next());
				}
			};
		}
		
		public StringRange iElem()
		{
			return new StringRange(str, range);
		}
		
		public IndexRange index()
		{
			return new IndexRange(str, range);
		}
		
		@Override
		public CharRange reverse()
		{
			return new CharRange(str, range.reverse());
		}
		
		public Stream<Character> stream()
		{
			return StreamSupport.stream(spliterator(), false);
		}
		
		public int steps()
		{
			return this.range.steps();
		}
	}
}