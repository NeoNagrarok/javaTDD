package tdd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ColorTest
{
	private Color color;

	@Before
	public void setUP()
	{
		this.color = new Color(122, 122, 122);
	}

	@After
	public void clean()
	{
		this.color = null;
	}

	@Test(expected=IllegalArgumentException.class)
	public void firstParamExceptionWithNegativeNumber()
	{
		this.color = new Color(-5, 0, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void secondParamExceptionWithNegativeNumber()
	{
		this.color = new Color(0, -5, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void thirdParamExceptionWithNegativeNumber()
	{
		this.color = new Color(0, 0, -5);
	}

	@Test(expected=IllegalArgumentException.class)
	public void firstParamExceptionWithHigherNumber()
	{
		this.color = new Color(300, 0, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void secondParamExceptionWithHigherNumber()
	{
		this.color = new Color(0, 300, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void thirdParamExceptionWithHigherNumber()
	{
		this.color = new Color(0, 0, 300);
	}

	@Test
	public void secondConstructorIsValid()
	{
		this.color = new Color("#FFD51A");
	}

	@Test(expected=IllegalArgumentException.class)
	public void secondConstructorIsNotValidFirstChar()
	{
		this.color = new Color("FFD51A");
	}

	@Test(expected=IllegalArgumentException.class)
	public void secondConstructorIsNotValidBadChar()
	{
		this.color = new Color("#FFG51A");
	}

	@Test(expected=IllegalArgumentException.class)
	public void secondConstructorIsNotValidTooLong()
	{
		this.color = new Color("#FFD51AFF");
	}

}
