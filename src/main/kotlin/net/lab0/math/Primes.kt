package net.lab0.math

object Primes {
  val divisors = sequence {
    yield(2L)
    var n = 3L
    while (n < Int.MAX_VALUE) {
      yield(n)
      n += 2L
    }
  }

  fun isPrime(n: Long): Boolean {
    divisors.forEach {
      if (it * it > n) return true
      if (n % it == 0L) return false
    }
    return true
  }

  val primes = Numbers.oddNumbers.filter(Primes::isPrime)
}
