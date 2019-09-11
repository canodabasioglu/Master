package com.odabasioglu.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class TextUtility {

	public static final Locale TURKISH = new Locale("tr", "TR");

	public static final String DEFAULT_DELIMITER = ",";

	public static void main(String[] args) {

	}

	public static String replaceString(String str, String searchString,
			String replacementString) {
		int searchLength = searchString.length();
		int index = str.indexOf(searchString);
		while (index >= 0) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(str.substring(0, index));
			buffer.append(replacementString);
			buffer.append(str.substring(index + searchLength));
			str = buffer.toString();
			index = str.indexOf(searchString);
		}
		return str;
	}

	public static String removeCharacter(String src, char[] removeChars) {
		StringBuffer buffer = new StringBuffer();
		char[] array = new char[src.length()];
		src.getChars(0, src.length(), array, 0);
		LOOP: for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < removeChars.length; j++) {
				if (array[i] == removeChars[j]) {
					continue LOOP;
				}
			}
			buffer.append(array[i]);
		}
		return buffer.toString();
	}

	public static String capitalFirstCharacter(String text) {
		return capitalFirstCharacter(text, TURKISH);
	}

	public static String capitalFirstCharacter(String text, Locale locale) {
		return text.substring(0, 1).toUpperCase(locale) + text.substring(1);
	}

	public static String properCharacter(String text) {

		return properCharacter(text, TURKISH);
	}

	public static String properCharacter(String text, Locale locale) {
		// like Lorem IPSUM
		StringTokenizer tk = new StringTokenizer(text);
		StringBuffer sb = new StringBuffer();
		sb.append(TextUtility.capitalize(tk.nextToken().toLowerCase(locale),
				locale));

		if (tk.countTokens() > 0) {
			while (tk.hasMoreTokens()) {
				sb.append(" "
						+ TextUtility.capitalize(tk.nextToken().toLowerCase(
								locale), locale));
			}
		}
		return sb.toString();
	}

	/**
	 * Replace all instances of a String within another String.
	 * 
	 * @param str
	 *            The complete String
	 * @param searchString
	 *            The search String
	 * @param replacementString
	 *            The replacement String
	 */

	public static String removeWhitespace(String src) {
		StringBuffer buffer = new StringBuffer();
		char[] array = new char[src.length()];
		src.getChars(0, src.length(), array, 0);
		for (int i = 0; i < array.length; i++) {
			if (!Character.isWhitespace(array[i])) {
				buffer.append(array[i]);
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns true if the given String contains at least one non alpha- numeric
	 * character.
	 * 
	 * @param str
	 *            The String
	 * @return True if one or more alpha-numeric characters are found
	 */

	public static boolean hasNonAlphaNumericCharacters(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetterOrDigit(chars[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if the given String contains at least one non alpha- numeric
	 * character. Characters in the ignore array are not checked.
	 * 
	 * @param str
	 *            The String
	 * @param ignore
	 *            An array of characters to ignore
	 * @return True if one or more alpha-numeric characters are found
	 */

	public static boolean hasNonAlphaNumericCharacters(String str, char[] ignore) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (isIgnore(chars[i], ignore)) {
				continue;
			}

			if (!Character.isLetterOrDigit(chars[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * String all non alpha-numeric characters from the given String.
	 * 
	 * @param str
	 *            The String
	 * @return The new String
	 */

	public static String stripNonAlphaNumericCharacters(String str) {
		StringBuffer buffer = new StringBuffer();

		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLetterOrDigit(chars[i])) {
				buffer.append(chars[i]);
			}
		}

		return buffer.toString();
	}

	/**
	 * Strip all non alpha-numeric characters from the given String. Characters
	 * contained in the ignore array will be left within the String.
	 * 
	 * @param str
	 *            The String
	 * @param ignore
	 *            An array of characters to ignore
	 * @return The new String
	 */

	public static String stripNonAlphaNumericCharacters(String str,
			char[] ignore) {
		StringBuffer buffer = new StringBuffer();

		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (isIgnore(chars[i], ignore)) {
				continue;
			}

			if (Character.isLetterOrDigit(chars[i])) {
				buffer.append(chars[i]);
			}
		}

		return buffer.toString();
	}

	/**
	 * Capitalize the first letter of the given text.
	 * 
	 * @param text
	 *            The original text
	 * @return The capitalized text
	 */

	public static String capitalize(String text) {
		return capitalize(text, TURKISH);
	}

	public static String capitalize(String text, Locale locale) {
		return text.substring(0, 1).toUpperCase(locale) + text.substring(1);
	}

	public static String properCase(String val) {
		// like Lorem IPSUM
		StringTokenizer tk = new StringTokenizer(val);
		StringBuffer sb = new StringBuffer();
		sb.append(TextUtility.capitalize(tk.nextToken().toLowerCase()));

		if (tk.countTokens() > 0) {
			while (tk.hasMoreTokens()) {
				sb.append(" " + tk.nextToken());
			}
		}
		return sb.toString();
	}

	public static String properCaseAll(String val) {

		return properCaseAll(val, TURKISH);
	}

	public static String properCaseAll(String val, Locale locale) {
		// like Lorem IPSUM
		StringTokenizer tk = new StringTokenizer(val);
		StringBuffer sb = new StringBuffer();
		sb.append(TextUtility.capitalize(tk.nextToken().toLowerCase(locale),
				locale));

		if (tk.countTokens() > 0) {
			while (tk.hasMoreTokens()) {
				sb.append(" "
						+ TextUtility.capitalize(tk.nextToken().toLowerCase(
								locale), locale));
			}
		}
		return sb.toString();
	}

	/**
	 * Split the given text using the given separator.
	 * 
	 * @param text
	 *            The original text
	 * @param separator
	 *            The separator
	 * @return The result List of String objects
	 */

	public static List splitString(String text, String separator) {
		return splitString(text, separator, true);
	}

	/**
	 * Split the given text using the given separator.
	 * 
	 * @param text
	 *            The original text
	 * @param separator
	 *            The separator
	 * @return The result List of String objects
	 */

	public static List splitString(String text, String separator,
			boolean removeWhitespace) {
		ArrayList elements = new ArrayList();
		StringTokenizer tk = new StringTokenizer(text, separator);

		while (tk.hasMoreTokens()) {
			if (removeWhitespace) {
				elements.add(removeWhitespace(tk.nextToken()));
			} else {
				elements.add(tk.nextToken());
			}
		}
		return elements;
	}

	/**
	 * Split the given String on whitespace characters.
	 * 
	 * @param text
	 *            The source String
	 * @return A List of String objects
	 */

	public static List splitStringOnWhitespace(String text) {
		List elements = new ArrayList();
		StringBuffer buffer = new StringBuffer();
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isWhitespace(chars[i])) {
				if (buffer.length() > 0) {
					elements.add(buffer.toString());
					buffer = new StringBuffer();
				}
			} else {
				buffer.append(chars[i]);
			}
		}

		if (buffer.length() > 0) {
			elements.add(buffer.toString());
		}

		return elements;
	}

	/**
	 * Split the String on newlines.
	 * 
	 * @param text
	 *            The source text
	 * @return A List of String objects
	 */

	public static List chompString(String text) {
		return splitString(text, "\n");
	}

	/**
	 * Join the given Object array using the DEFAULT_DELIMITER.
	 * 
	 * @param data
	 *            The data array
	 * @return The resulting String
	 */

	public static String join(Object[] data) {
		return join(data, DEFAULT_DELIMITER);
	}

	/**
	 * Join the given Object array using the given delimiter. The toString()
	 * method on each Object will be invoked to retrieve a String representation
	 * of the Object.
	 * 
	 * @param data
	 *            The data array
	 * @param delimiter
	 *            The delimiter String
	 * @return The resulting String
	 */

	public static String join(Object[] data, String delimiter) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			buffer.append(data.toString());
			if (i < data.length - 1) {
				buffer.append(delimiter);
			}
		}
		return buffer.toString();
	}

	/**
	 * Join the given Collection using the DEFAULT_DELIMITER.
	 * 
	 * @param data
	 *            The collection
	 * @return The resulting String
	 */

	public static String join(Collection data) {
		return join(data, DEFAULT_DELIMITER);
	}

	/**
	 * Join the given Collection using the given delimiter. The toString()
	 * method on each Object will be invoked to retrieve a String representation
	 * of the Object.
	 * 
	 * @param data
	 *            The collection
	 * @param delimiter
	 *            The delimiter String
	 * @return The resulting String
	 */

	public static String join(Collection data, String delimiter) {
		StringBuffer buffer = new StringBuffer();
		Iterator iter = data.iterator();
		while (iter.hasNext()) {
			buffer.append(iter.next().toString());
			if (iter.hasNext()) {
				buffer.append(delimiter);
			}
		}
		return buffer.toString();
	}

	/**
	 * Return true if the character is an ASCII character.
	 * 
	 * @param c
	 *            The character
	 * @return True if character is ASCII
	 */

	public static boolean isAscii(char c) {
		return (c & 0xff80) == 0;
	}

	/**
	 * Return true if the character is an extended ASCII character.
	 * 
	 * @param c
	 *            The character
	 * @return True if character is extended ASCII
	 */

	public static boolean isExtendedAscii(char c) {
		return (c & 0xff00) == 0;
	}

	/**
	 * Return true if the given character is a member of the ignore array.
	 * 
	 * @param c
	 *            The character
	 * @param ignore
	 *            An array of characters to ignore
	 * @return True if the character is in the ignore array
	 */

	private static boolean isIgnore(char c, char[] ignore) {
		for (int i = 0; i < ignore.length; i++) {
			if (c == ignore[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method fillZero.
	 * 
	 * @param str
	 * @param totalSize
	 * @return String
	 */
	public static String fillZero(String str, int totalSize) {

		if (str.length() >= totalSize)
			return str;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < totalSize - str.length(); i++) {
			sb.append("0");
		}
		return sb + str;
	}

	/**
	 * Method fillCIF. Verilen cif numarasýnýn baþýna toplam uzunluk <b>10
	 * </b> hane olacak þekilde '0' lar koyar
	 * 
	 * @param str
	 * @return String
	 */
	public static String fillCIF(String str) {
		return fillZero(str, 10);
	}

	/**
	 * Method hasEnoughLetters. returns if str has enough 'letters'
	 * 
	 * @param str
	 * @param minLetterCount
	 * @return boolean
	 */
	public static boolean hasEnoughLetters(String str, int minLetterCount) {
		if (str == null)
			return false;
		char[] chars = str.toCharArray();
		int letterCount = 0;
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLetter(chars[i])) {
				letterCount++;
			}
		}
		return (letterCount >= minLetterCount);
	}

	/**
	 * Method isConsecutive.
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isConsecutive(String str) {
		if (str == null)
			return false;
		if (str.length() == 1)
			return true;
		char[] chars = str.toCharArray();
		char firstChar = chars[0];
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != firstChar)
				return false;
		}
		return true;
	}

	/**
	 * Method removeNewLines. Removes new line characters from given String
	 * 
	 * @param strInput
	 * @return String
	 */
	public static String removeNewLines(String strInput) {

		if (strInput == null)
			return null;
		int length = strInput.length();
		if (length < 2)
			return strInput;

		char c13;
		char c10;

		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length - 1; i++) {
			c13 = strInput.charAt(i);
			c10 = strInput.charAt(i + 1);
			if ((int) c13 != 13 && (int) c10 != 10) {
				sb.append(c13);
			} else {
				sb.append(' ');
				i++;
			}

		}
		c13 = strInput.charAt(length - 1);

		if ((int) c13 != 13 && (int) c13 != 10)
			sb.append(c13);
		return sb.toString();
	}

}
