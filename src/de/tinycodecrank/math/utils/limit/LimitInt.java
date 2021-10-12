package de.tinycodecrank.math.utils.limit;

public final class LimitInt
{
	public final int min, max;
	
	public LimitInt(int min, int max)
	{
		this.min	= min;
		this.max	= max;
	}
	
	public static boolean inRange(int min, int value, int max)
	{
		return min <= value && value <= max;
	}
	
	public boolean inRange(int value)
	{
		return inRange(min, value, max);
	}
	
	/**
	 * @deprecated use clamp instead of limit
	 */
	@Deprecated
	public static int limit(int min, int value, int max)
	{
		return clamp(min, value, max);
	}
	
	public static int clamp(int min, int value, int max)
	{
		return Math.min(max, Math.max(min, value));
	}
	
	/**
	 * @deprecated use clamp instead of limit
	 */
	@Deprecated
	public int limit(int value)
	{
		return this.clamp(value);
	}
	
	public int clamp(int value)
	{
		return limit(min, value, max);
	}
	
	public void assertLimit(int value, String valueName) throws OutOfBoundsException
	{
		assertLimit(min, value, max, valueName);
	}
	
	public static void assertLimit(int min, int value, int max, String valueName) throws OutOfBoundsException
	{
		if (!inRange(min, value, max))
		{
			throw new OutOfBoundsException(min, value, max, valueName);
		}
	}
}