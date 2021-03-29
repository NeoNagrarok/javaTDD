package tdd;

import java.util.regex.*;

public class Color
{
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
	}

	public Color(String hexaColor)
	{
		Pattern pattern = Pattern.compile("^#[a-fA-F0-9]{6}$");
		Matcher matcher = pattern.matcher(hexaColor);
		if (!matcher.find())
			throw new IllegalArgumentException();
	}

}
