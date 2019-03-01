package net.lab0.math

object Numbers {
  val oddNumbers = sequence {
    var n = 1L
    while (true) {
      yield(n)
      n += 2
    }
  }
}


fun Long.digitAtIndex(index: Long): Long {
  return (this / (10L power index)) % 10
}

/**
 * @param index starting from the end (index 0 is units, 1 is tens, 3 is thousands)
 * @param replacement Which digit to use as replacement at `index`
 *
 * @return a new number where the `index` digit is now `replacement`
 *
 *
 */
fun Long.replaceDigitAt(index: Long, replacement: Long): Long {
  val e = 10L power index
  val toReplace = (this / e) % 10
  return this + (replacement - toReplace) * e
}

infix fun Long.power(l: Long): Long =
    when {
      l == 0L -> 1L
      l % 2L == 0L -> {
        val tmp = (this power l / 2)
        tmp * tmp
      }
      else -> this * (this power (l - 1))
    }

fun Long.digitsCountBase10(): Long {
  var power = 0L
  var n = this
  do {
    n /= 10
    power++
  } while (n > 0L)
  return power
}