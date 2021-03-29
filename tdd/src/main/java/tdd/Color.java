package tdd;

import java.util.regex.*;

public class Color
{
	private int red;
	private int green;
	private int blue;

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
	}

	public Color(String hexaColor)
	{
		Pattern pattern = Pattern.compile("^#[a-fA-F0-9]{6}$");
		Matcher matcher = pattern.matcher(hexaColor);
		if (!matcher.find())
			throw new IllegalArgumentException();
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
}
