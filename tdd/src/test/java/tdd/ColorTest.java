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
	public void firstParamException()
	{
		this.color = new Color(-5, 0, 0);
	}


}
