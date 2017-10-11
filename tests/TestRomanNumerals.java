import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void testRomanNumerals_AcceptsLegalSymbols() {
		RomanNumerals num = new RomanNumerals();
		
		try {
			num.convertToInteger("MDCLXVI");
		}
		catch (IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testRomanNumerals_ThrowsExceptionForIllegalSymbols() {
		RomanNumerals num = new RomanNumerals();
		
		try {
			num.convertToInteger("A");
			fail();
		}
		catch (IllegalArgumentException e) {
			// Pass
		}
	}
	
	@Test
	public void testRomanNumerals_CanContainLegalRepetition() {
		RomanNumerals num = new RomanNumerals();
		
		try {
			num.convertToInteger("MCMLXXXIV");
		}
		catch (IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testRomanNumerals_ThrowsExceptionForTooMuchRepetition() {
		RomanNumerals num = new RomanNumerals();
		
		try {
			num.convertToInteger("MMMCMLXXXIV");
			fail();
		}
		catch (IllegalArgumentException e) {
			// Pass
		}
	}
	
	@Test
	public void testRomanNumerals_ThrowsExceptionForIllegalRepetition() {
		RomanNumerals num = new RomanNumerals();
		
		try {
			num.convertToInteger("DDC");
			fail();
		}
		catch (IllegalArgumentException e) {
			// Pass
		}
	}
	
	@Test
	public void testRomanNumerals_ThrowsExceptionForIllegalSymbolOrder() {
		RomanNumerals num = new RomanNumerals();
		
		try {
			num.convertToInteger("XXC");
			fail();
		}
		catch (IllegalArgumentException e) {
			// Pass
		}
	}
	
	@Test
	public void testRomanNumerals_ReturnsCorrectResultForDCCC() {
		RomanNumerals num = new RomanNumerals();
		assertEquals(800, num.convertToInteger("DCCC"));
	}
	
	@Test
	public void testRomanNumerals_ReturnsCorrectResultForMCMLXXXIV() {
		RomanNumerals num = new RomanNumerals();
		assertEquals(1984, num.convertToInteger("MCMLXXXIV"));
	}
	
	@Test
	public void testRomanNumerals_ReturnsCorrectResultForMMXIV() {
		RomanNumerals num = new RomanNumerals();
		assertEquals(2014, num.convertToInteger("MMXIV"));
	}

}
