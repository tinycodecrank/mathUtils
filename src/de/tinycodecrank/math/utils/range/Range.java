package de.tinycodecrank.math.utils.range;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import de.tinycodecrank.math.utils.range.ArrayRange.ElementIndexArrayRange;
import de.tinycodecrank.math.utils.range.ListRange.ElementIndexListRange;

public class Range implements Iterable<Integer>
{
	public static <T> ElementIndexArrayRange<T> range(T[] array)
	{
		return ArrayRange.range(array);
	}
	
	public static <T> ElementIndexArrayRange<T> rRange(T[] array)
	{
		return ArrayRange.rRange(array);
	}
	
	public static <T> ElementIndexListRange<T> range(List<T> list)
	{
		return ListRange.range(list);
	}
	
	public static <T> ElementIndexListRange<T> rRange(List<T> list)
	{
		return ListRange.rRange(list);
	}
	
	public static Range range(int stop)
	{
		return new Range(0, stop, 1);
	}
	
	public static Range range(int start, int stop)
	{
		return new Range(start, stop, 1);
	}
	
	/**
	 * @param start
	 * @param stop
	 * @return the same as
	 *         {@linkplain Range#range(int start, int stop)}.{@linkplain Range#reverse()}
	 */
	public static Range rRange(int start, int stop)
	{
		return new Range(stop - 1, start - 1, -1);
	}
	
	public static Range range(int start, int stop, int step)
	{
		return new Range(start, stop, step);
	}
	
	public final int							start, stop, step;
	private final Supplier<Iterator<Integer>>	iteratorSupplier;
	
	private Range(int start, int stop, int step)
	{
		this.start	= start;
		this.stop	= stop;
		this.step	= step;
		validate();
		this.iteratorSupplier = assignIterator();
	}
	
	public Range reverse()
	{
		return new Range(this.stop - this.step, this.start - this.step, -this.step);
	}
	
	private void validate()
	{
		if (start > stop)
		{
			if (step > 0)
			{
				throw new IllegalStateException("Invalid Range: step must not be positive if start > stop");
			}
		}
		if (start < stop)
		{
			if (step < 0)
			{
				throw new IllegalStateException("Invalid Range: step must not be negative if start < stop");
			}
		}
	}
	
	private Supplier<Iterator<Integer>> assignIterator()
	{
		if (this.step == 0)
		{
			return () -> new Iterator<Integer>()
			{
				
				@Override
				public boolean hasNext()
				{
					return true;
				}
				
				@Override
				public Integer next()
				{
					return start;
				}
				
			};
		}
		if (this.start == this.stop)
		{
			return () -> new Iterator<Integer>()
			{
				
				@Override
				public boolean hasNext()
				{
					return false;
				}
				
				@Override
				public Integer next()
				{
					throw new NoSuchElementException("The range contains no elements!");
				}
			};
		}
		if (this.step > 0)
		{
			return () -> new Iterator<Integer>()
			{
				private int next = start;
				
				@Override
				public boolean hasNext()
				{
					return next < stop;
				}
				
				@Override
				public Integer next()
				{
					int current = next;
					this.next += step;
					return current;
				}
				
			};
		}
		else
		{
			return () -> new Iterator<Integer>()
			{
				private int next = start;
				
				@Override
				public boolean hasNext()
				{
					return next > stop;
				}
				
				@Override
				public Integer next()
				{
					int current = next;
					this.next += step;
					return current;
				}
				
			};
		}
	}
	
	@Override
	public Iterator<Integer> iterator()
	{
		return this.iteratorSupplier.get();
	}
}