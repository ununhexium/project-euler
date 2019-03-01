package net.lab0.math

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class NumbersKtTest {
  @Test
  fun `can replace digits`() {
    assertThat(
        12345L.replaceDigitAt(0, 9)
    ).isEqualTo(
        12349L
    )

    assertThat(
        12345L.replaceDigitAt(2, 9)
    ).isEqualTo(
        12945L
    )

    assertThat(
        0L.replaceDigitAt(2, 1)
    ).isEqualTo(
        100L
    )
  }

  @TestFactory
  fun `can get digit at index N`(): Iterable<DynamicTest> {
    return (0L..9L).map {
      DynamicTest.dynamicTest(it.toString()) {
        assertThat(
            9876543210L.digitAtIndex(it)
        ).isEqualTo(
            it
        )
      }
    }
  }

  @TestFactory
  fun `can find the number of digits of number in base 10`(): Iterable<DynamicTest> {
    return listOf(
        0L to 1L,
        1L to 1L,
        9L to 1L,
        10L to 2L,
        11L to 2L,
        99L to 2L,
        100L to 3L,
        101L to 3L
        ).map {
      DynamicTest.dynamicTest("${it.first} has ${it.second} digits") {
        assertThat(
            it.first.digitsCountBase10()
        ).isEqualTo(
            it.second
        )
      }
    }
  }
}