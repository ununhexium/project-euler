package net.lab0.math

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory


internal class PrimeFilterTest {
    @TestFactory
    fun `are primes`(): Iterable<DynamicTest> {
        return listOf(
            2,
            3,
            5,
            7,
            113
        ).map{
            DynamicTest.dynamicTest(it.toString()) {
                assertThat(Primes.isPrime(it.toLong())).isTrue()
            }
        }
    }

    @TestFactory
    fun `are not primes`(): Iterable<DynamicTest> {
        return listOf(
            2*3,
            3*7,
            5*11,
            7*13,
            113*9
        ).map{
            DynamicTest.dynamicTest(it.toString()) {
                assertThat(Primes.isPrime(it.toLong())).isFalse()
            }
        }
    }
}
