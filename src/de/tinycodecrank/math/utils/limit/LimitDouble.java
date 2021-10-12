package de.tinycodecrank.math.utils.limit;

public final class LimitDouble
{
	public final double min, max;
	
	public LimitDouble(double min, double max)
	{
		this.min	= min;
		this.max	= max;
	}
	
	public boolean inRange(double value)
	{
		return inRange(min, value, max);
	}
	
	public static boolean inRange(double min, double value, double max)
	{
		return min <= value && value <= max;
	}
	
	/**
	 * @deprecated use clamp instead of limit
	 */
	@Deprecated
	public double limit(double value)
	{
		return this.clamp(value);
	}
	
	public double clamp(double value)
	{
		return clamp(min, value, max);
	}
	
	/**
	 * @deprecated use clamp instead of limit
	 */
	@Deprecated
	public static double limit(double min, double value, double max)
	{
		return clamp(min, value, max);
	}
	
	public static double clamp(double min, double value, double max)
	{
		return Math.min(max, Math.max(min, value));
	}
	
	public void assertLimit(double value, String valueName) throws OutOfBoundsException
	{
		assertLimit(min, value, max, valueName);
	}
	
	public static void assertLimit(double min, double value, double max, String valueName) throws OutOfBoundsException
	{
		if (!inRange(min, value, max))
		{
			throw new OutOfBoundsException(min, value, max, valueName);
		}
	}
}