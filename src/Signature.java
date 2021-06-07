import java.math.BigInteger;

public class Signature {
	
	private String text;
	private BigInteger r;
	private BigInteger s;
	
	public Signature(String text,BigInteger r,BigInteger s )
	{
		this.text = text;
		this.r = r;
		this.s = s;
	}
	
	public String getText()
	{
		return text;
	}
	
	public BigInteger getR()
	{
		return r;
	}
	
	public BigInteger getS()
	{
		return s;
	}
}
