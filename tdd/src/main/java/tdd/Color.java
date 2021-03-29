package tdd;

import java.util.regex.*;

public class Color
{
	private int red;
	private int green;
	private int blue;

	private String hexValue;

	public Color(int red, int green, int blue)
	{
		if (
			red < 0 ||
			red > 255 ||
			green < 0 ||
			green > 255 ||
			blue < 0 ||
			blue > 255
		)
			throw new IllegalArgumentException();
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.rbgToHex();
	}

	public Color(String hexValue)
	{
		Pattern pattern = Pattern.compile("^#[a-fA-F0-9]{6}$");
		Matcher matcher = pattern.matcher(hexValue);
		if (!matcher.find())
			throw new IllegalArgumentException();
		this.hexValue = hexValue;
		this.hexToRgb();
	}

	public int getRed()
	{
		return this.red;
	}

	public int getGreen()
	{
		return this.green;
	}

	public int getBlue()
	{
		return this.blue;
	}

	public String getHexValue()
	{
		return this.hexValue;
	}

	public void setRed(int red)
	{
		if (
			red < 0 ||
			red > 255
		)
			throw new IllegalArgumentException();
		this.red = red;
		this.rbgToHex();
	}

	public void setGreen(int green)
	{
		if (
			green < 0 ||
			green > 255
		)
			throw new IllegalArgumentException();
		this.green = green;
		this.rbgToHex();
	}

	public void setBlue(int blue)
	{
		if (
			blue < 0 ||
			blue > 255
		)
			throw new IllegalArgumentException();
		this.blue = blue;
		this.rbgToHex();
	}

	public void setHexValue(String hexValue)
	{
		Pattern pattern = Pattern.compile("^#[a-fA-F0-9]{6}$");
		Matcher matcher = pattern.matcher(hexValue);
		if (!matcher.find())
			throw new IllegalArgumentException();
		this.hexValue = hexValue;
		this.hexToRgb();
	}

	private void hexToRgb()
	{
		this.red = Integer.valueOf(this.hexValue.substring(1, 3), 16);
		this.green = Integer.valueOf(this.hexValue.substring(3, 5), 16);
		this.blue = Integer.valueOf(this.hexValue.substring(5, 7), 16);
	}

	private void rbgToHex()
	{
		this.hexValue = String.format("#%02x%02x%02x", this.red, this.green, this.blue);
	}
}
