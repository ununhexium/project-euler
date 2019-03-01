package net.lab0.euler

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.Disabled

internal class E51Test {
  @Test
  @Disabled
  fun answer() {
    println(E51.f(8))
  }

  @Test
  fun `the smallest number for a family of 6 members is 13`() {
    assertThat(
        E51.f(6)
    ).isEqualTo(
        13L
    )
  }

  @Test
  fun `the smallest number for a family of 7 members is 56003`() {
    assertThat(
        E51.f(7)
    ).isEqualTo(
        56003L
    )
  }

  @Test
  fun `check replacement patterns`(){
    assertThat(
        E51.getReplacementPattern(999L)
    ).isEqualTo(
            (0b1L..0b11L) to (0b100L..0b110L)
    )
  }
}
