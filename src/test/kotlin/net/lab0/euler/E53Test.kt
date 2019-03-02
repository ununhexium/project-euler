package net.lab0.euler

import net.lab0.math.combinations
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class E53Test {
  @Test
  fun answer(){
    println(E53.f())
  }

  @Test
  fun `is commutative`(){
    assertThat(
        combinations(23, 10)
    ).isEqualTo(
        combinations(23, 13)
    )
  }
}