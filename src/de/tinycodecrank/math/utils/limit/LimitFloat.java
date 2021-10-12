package de.tinycodecrank.math.utils.limit;

public final class LimitFloat
{
	public final float min, max;
	
	public LimitFloat(float min, float max)
	{
		this.min	= min;
		this.max	= max;
	}
	
	public boolean inRange(float value)
	{
		return inRange(min, value, max);
	}
	
	public static boolean inRange(float min, float value, float max)
	{
		return min <= value && value <= max;
	}
	
	/**
	 * @deprecated use clamp instead of limit
	 */
	@Deprecated
	public float limit(float value)
	{
		return this.clamp(value);
	}
	
	public float clamp(float value)
	{
		return clamp(min, value, max);
	}
	
	/**
	 * @deprecated use clamp instead of limit
	 */
	@Deprecated
	public static float limit(float min, float value, float max)
	{
		return clamp(min, value, max);
	}
	
	public static float clamp(float min, float value, float max)
	{
		return Math.min(max, Math.max(min, value));
	}
	
	public void assertLimit(float value, String valueName) throws OutOfBoundsException
	{
		assertLimit(min, value, max, valueName);
	}
	
	public static void assertLimit(float min, float value, float max, String valueName) throws OutOfBoundsException
	{
		if (!inRange(min, value, max))
		{
			throw new OutOfBoundsException(min, value, max, valueName);
		}
	}
}