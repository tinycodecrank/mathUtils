package de.tinycodecrank.math.utils.limit;

public class OutOfBoundsException extends RuntimeException
{
	private static final long	serialVersionUID		= 7533890917054854372L;
	private static final String	messageTemplateDouble	= "%s is %f but has to be between %f and %f.";
	private static final String	messageTemplateInteger	= "%s is %d but has to be between %d and %d";
	
	public OutOfBoundsException(double min, double value, double max, String valueName)
	{
		super(String.format(messageTemplateDouble, valueName, value, min, max));
	}
	
	public OutOfBoundsException(int min, int value, int max, String valueName)
	{
		super(String.format(messageTemplateInteger, valueName, value, min, max));
	}
	
	public OutOfBoundsException(String msg)
	{
		super(msg);
	}
}