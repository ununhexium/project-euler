package net.lab0.euler

import net.lab0.math.combinations
import java.math.BigInteger

object E53 {
  val threadshold = BigInteger.valueOf(1_000_000)

  fun f(): Int {
    data class C(val n: Long, val r: Long)

    val bounds = (0L..100L).map out@{ n ->
      (0L..n).map { r ->
        val combinations = combinations(n, r)
        if (combinations > threadshold) {
          return@out C(n, r)
        }
      }
    }.mapNotNull {
      it as? C
    }

    println(bounds.toList())

    /*
     * For C(23,10) > 1Million
     *
     * for values of `r`:
     *
     * 0...9,10,11,12,13,14...23
     * <-A-> <----B----> <--C-->
     *
     * In `A`, `r` is too small
     * In `C`, `r` is too big
     * The valid range is therefore B,
     * and the number of values in it is
     * (n+1) - cardinal(A) - cardinal(C) = (n+1) - 2*r
     */
    return bounds.sumBy {
      (it.n + 1 - 2 * it.r).toInt()
    }
  }
}

