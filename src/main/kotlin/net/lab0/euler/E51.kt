package net.lab0.euler

import net.lab0.math.Numbers
import net.lab0.math.Primes
import net.lab0.math.digitsCountBase10
import net.lab0.math.power
import net.lab0.math.replaceDigitAt

object E51 {
  /**
   * By replacing the 1st digit of the 2-digit number *3,
   * it turns out that six of the nine possible values:
   * 13, 23, 43, 53, 73, and 83, are all prime.
   *
   * By replacing the 3rd and 4th digits of 56**3 with the same digit,
   * this 5-digit number is the first example having seven primes among the ten generated numbers,
   * yielding the family:
   * 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
   * Consequently 56003, being the first member of this family,
   * is the smallest prime with this property.
   *
   * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
   *
   */
  fun f(
      familySizeTarget: Int,
      maxPrimeSize: Long = Long.MAX_VALUE
  ): Long {
    val answer = Numbers.primes.dropWhile {
      it < 10
    }.takeWhile {
      it <= maxPrimeSize
    }.first { p ->
      val families = makeFamilies(p)

      families.any { family ->
        family.count() >= familySizeTarget
      }
    }

    println("Answer for family size $familySizeTarget is $answer, family is ${makeFamilies(answer).maxBy {
      it.count()
    }!!.toList().joinToString()}")

    return answer
  }

  fun makeFamilies(p: Long): Sequence<Sequence<Long>> {
    val (forAnyDigit, forNonZero) = getReplacementPattern(p)

    val replacements = forAnyDigit.asSequence().map { replacementPattern ->
      (0L..9L).asSequence().map { digit ->
        substitutions(p, replacementPattern, digit)
      }.filter(Primes::isPrime)
    } + forNonZero.asSequence().map { replacementPattern ->
      (1L..9L).asSequence().map { digit ->
        substitutions(p, replacementPattern, digit)
      }.filter(Primes::isPrime)
    }

    return replacements
  }

  fun substitutions(
      p: Long,
      replacementPattern: Long,
      digit: Long
  ): Long {
    // the number in which the digits will be replaced
    var output = p
    // the index to consider to replace a digit of output
    var index = 0L
    // do we have to replace at index?
    var consumableBooleans = replacementPattern

    while (consumableBooleans != 0L) {
      if (consumableBooleans % 2 == 1L) {
        output = output.replaceDigitAt(index, digit)
      }
      index++
      consumableBooleans = consumableBooleans.ushr(1)
    }
    return output
  }

  /**
   * @return 2 ranges,
   * the first to be used with any digit as replacement,
   * the second to be used with a digit in the range [1,9],
   * as using 0 would make the replacement "shorter" than the original number.
   * For instance:
   * 13 with the digit at index 1 replaced with 0 would become 3,
   * which is only 1 digit instead of 2.
   */
  fun getReplacementPattern(input: Long): Pair<LongRange, LongRange> {
    /*
     * when the replacement digit is 0,
     * we don't want to replace the first digit of input by 0,
     * as this would make the number "shorter"
     *
     * This translates to using a power of 2 that is 1 lower than the number of digits in the number
     */
    val exponent = input.digitsCountBase10()

    /*
     * Never replace all the numbers.
     * Never replace the first digit with 0.
     *
     * For instance, for 4 digits, where 1 means true, replace and 0 false, keep the existing digit
     * Never use 1111, the valid range is [1,1110]
     * Never lead with 1 when can replace with 0, the valid range is [1,111]
     * Adjust the range to avoid overlap ->
     * [1,111] + [1000, 1110]
     */
    val low = 1L
    val mid = (2L power exponent - 1L)
    val high = (2L power exponent) - 1
    return (low until mid) to (mid until high)
  }
}
