import java.math.BigInteger;
import java.security.spec.ECPoint;

public class CurveParameters {
	
	private String name;
	private BigInteger p;
	private BigInteger a;
	private BigInteger b;
	private BigInteger x;
	private BigInteger y;
	private BigInteger n;
	private BigInteger pk;
	private ECPoint public_key;
	
	public CurveParameters(String name, BigInteger p,BigInteger a,
			BigInteger b,  BigInteger x,  BigInteger y,  BigInteger n, BigInteger pk)
	{
		this.name=name;
		this.p = p;
		this.a = a;
		this.b = b;
		this.x = x;
		this.y = y;
		this.n = n;
		this.pk =pk;
		
	}
	public CurveParameters(String name, BigInteger p,BigInteger a,
			BigInteger b,  BigInteger x,  BigInteger y,  BigInteger n, ECPoint public_key)
	{
		this.name=name;
		this.p = p;
		this.a = a;
		this.b = b;
		this.x = x;
		this.y = y;
		this.n = n;
		this.public_key = public_key;
		
	}
	//Getter method for name
	public String getName()
	{
		return name;
	}
	//Getter method for P
	public BigInteger getP() 
	{
		return p;
	}
	//Getter method for A
	public BigInteger getA() 
	{
		return a;
	}
	//Getter method for B
	public BigInteger getB() 
	{
		return b;
	}
	//Getter method for X
	public BigInteger getX()
	{
		return x;
		
	}
	//Getter method for Y
	public BigInteger getY()
	{
		return y;
		
	}
	//Getter method for N
	public BigInteger getN()
	{
		return n;
		
	}
	public BigInteger getPK()
	{
		return pk;
		
	}
	public void setPublic_key(ECPoint xy)
	{
		this.public_key = xy;
	}
	public ECPoint getPublic_key()
	{
		return public_key;
	}
}
