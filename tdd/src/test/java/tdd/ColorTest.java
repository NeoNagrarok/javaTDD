package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ColorTest
{
	private Color color;
	private Color hexaColor;

	@Before
	public void setUP()
	{
		this.color = new Color(255, 200, 145);
		this.hexaColor = new Color("#ffc891");
	}

	@After
	public void clean()
	{
		this.color = null;
		this.hexaColor = null;
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

	@Test
	public void testGetRed()
	{
		assertEquals(255, this.color.getRed());
		assertEquals(200, this.color.getGreen());
		assertEquals(145, this.color.getBlue());
		assertEquals(145, this.hexaColor.getBlue());
		assertEquals(255, this.hexaColor.getRed());
		assertEquals(200, this.hexaColor.getGreen());
		assertEquals("#ffc891", this.hexaColor.getHexValue());
	}

	@Test
	public void testGetGreen()
	{
		assertEquals(200, this.color.getGreen());
		assertEquals(255, this.color.getRed());
		assertEquals(145, this.color.getBlue());
		assertEquals(145, this.hexaColor.getBlue());
		assertEquals(255, this.hexaColor.getRed());
		assertEquals(200, this.hexaColor.getGreen());
		assertEquals("#ffc891", this.hexaColor.getHexValue());
	}

	@Test
	public void testGetBlue()
	{
		assertEquals(145, this.color.getBlue());
		assertEquals(255, this.color.getRed());
		assertEquals(200, this.color.getGreen());
		assertEquals("#ffc891", this.color.getHexValue());
		assertEquals(145, this.hexaColor.getBlue());
		assertEquals(255, this.hexaColor.getRed());
		assertEquals(200, this.hexaColor.getGreen());
		assertEquals("#ffc891", this.hexaColor.getHexValue());
	}

	@Test
	public void testGetHexValue()
	{
		assertEquals("#ffc891", this.hexaColor.getHexValue());
		assertEquals(145, this.hexaColor.getBlue());
		assertEquals(255, this.hexaColor.getRed());
		assertEquals(200, this.hexaColor.getGreen());
		assertEquals("#ffc891", this.color.getHexValue());
		assertEquals(145, this.color.getBlue());
		assertEquals(255, this.color.getRed());
		assertEquals(200, this.color.getGreen());
	}

	@Test
	public void testSetRed()
	{
		this.color.setRed(200);
		assertEquals(200, this.color.getRed());
		assertEquals(145, this.color.getBlue());
		assertEquals(200, this.color.getGreen());
		assertEquals("#c8c891", this.color.getHexValue());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetRedisNotValidWithNegativeNumber()
	{
		this.color.setRed(-5);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetRedisNotValidWithHigherNumber()
	{
		this.color.setRed(300);
	}

	@Test
	public void testSetGreen()
	{
		this.color.setGreen(145);
		assertEquals(145, this.color.getGreen());
		assertEquals(255, this.color.getRed());
		assertEquals(145, this.color.getBlue());
		assertEquals("#ff9191", this.color.getHexValue());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetGreenisNotValidWithNegativeNumber()
	{
		this.color.setGreen(-5);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetGreenisNotValidWithHigherNumber()
	{
		this.color.setGreen(300);
	}

	@Test
	public void testSetBlue()
	{
		this.color.setBlue(200);
		assertEquals(200, this.color.getBlue());
		assertEquals(255, this.color.getRed());
		assertEquals(200, this.color.getGreen());
		assertEquals("#ffc8c8", this.color.getHexValue());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetBlueisNotValidWithNegativeNumber()
	{
		this.color.setBlue(-5);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetBlueisNotValidWithHigherNumber()
	{
		this.color.setBlue(300);
	}

	@Test
	public void testSetHexValueIsValid()
	{
		this.color.setHexValue("#000000");
		assertEquals("#000000", this.color.getHexValue());
		assertEquals(0, this.color.getRed());
		assertEquals(0, this.color.getGreen());
		assertEquals(0, this.color.getBlue());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetHexValueIsNotValidFirstChar()
	{
		this.color.setHexValue("000000");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetHexValueIsNotValidBadChar()
	{
		this.color.setHexValue("#Z0Z0Z0");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetHexValueIsNotValidTooLong()
	{
		this.color.setHexValue("#00000000");
	}

	@Test
	public void testToString()
	{
		assertEquals("[value=#ffc891, r=255, g=200, b=145]", this.color.toString());
	}
}
