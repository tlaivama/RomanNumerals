
public class RomanNumerals {
	
	public int convertToInteger(String romanNum) throws IllegalArgumentException {
		if (!containsOnlyLegalSymbols(romanNum))
			throw new IllegalArgumentException("Numeral contained an illegal symbol");
		
		if (!containsOnlyLegalRepetitionOfSymbols(romanNum))
			throw new IllegalArgumentException("Numeral contained illegal repetition");
		
		if (!containsSymbolsInLegalOrder(romanNum))
			throw new IllegalArgumentException("Numeral contained symbols in illegal order");
		
		return calculateArabicFromRomanNumeral(romanNum);
	}
	
	private boolean containsOnlyLegalSymbols(String romanNum) {
		return romanNum.matches("[IVXLCDM]*");
	}
	
	private boolean containsOnlyLegalRepetitionOfSymbols(String romanNum) {
		return checkLegalityOfRepeatableSymbols(romanNum) && checkLegalityOfNonRepeatableSymbols(romanNum);
	}
	
	private boolean checkLegalityOfRepeatableSymbols(String romanNum) {
		String repeatableSymbols = "IXCM";
		
		for (char repeatableSymbol : repeatableSymbols.toCharArray()) {
			int repetitions = 0;
			
			for (char symbol : romanNum.toCharArray())
				if (symbol == repeatableSymbol)
					++repetitions;
			
			if (repetitions > 3)
				return false;
		}
		
		return true;
	}
	
	private boolean checkLegalityOfNonRepeatableSymbols(String romanNum) {
		String nonRepeatableSymbols = "VLD";
		
		for (char nonRepeatableSymbol : nonRepeatableSymbols.toCharArray()) {
			int repetitions = 0;
			
			for (char symbol : romanNum.toCharArray())
				if (symbol == nonRepeatableSymbol)
					++repetitions;
			
			if (repetitions > 1)
				return false;
		}
		
		return true;
	}
	
	/*
	 * Checks that only one subtraction is made (things like "XXC" will return false),
	 * the "5" symbols are not used in subtraction and
	 * that the "1" symbols can only be subtracted from the next 2 highest values
	 */
	private boolean containsSymbolsInLegalOrder(String romanNum) {
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		String num = romanNum;
		for (int i = 0; i < roman.length; ++i) {
			while (num.startsWith(roman[i])) {
				num = num.substring(roman[i].length());
			}
			
			for (int j = 0; j < i; ++j) {
				if (num.startsWith(roman[j]))
					return false;
			}
		}
		
		return true;
	}
	
	private int calculateArabicFromRomanNumeral(String romanNum) {
		int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		int result = 0;
		String num = romanNum;
		
		for (int i = 0; i < arabic.length; ++i) {
			while (num.startsWith(roman[i])) {
				result += arabic[i];
				num = num.substring(roman[i].length());
			}
		}
		
		return result;
	}
	
}
