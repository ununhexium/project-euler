package net.lab0.euler

object E52 {
  fun f(): Long {
    return (1L..Long.MAX_VALUE).first { n ->
      val reference = countDigits(n)
      (2L..6L).all { factor ->
        countDigits(n * factor) == reference
      }
    }
  }

  private fun countDigits(it: Long): Map<Char, Int> {
    return it.toString().groupBy {
      it
    }.mapValues {
      it.value.size
    }
  }
}