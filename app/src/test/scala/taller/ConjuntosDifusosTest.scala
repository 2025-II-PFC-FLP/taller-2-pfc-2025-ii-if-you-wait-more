package taller

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {

  val cd = new ConjuntosDifusos()

  test("prueba de grande") {
    val g = cd.grande(2, 3)
    assert(g(1) >= 0.0 && g(1) <= 1.0)
    assert(g(100) > g(5))
  }

  test("prueba de complemento") {
    val g = cd.grande(2, 2)
    val c = cd.complemento(g)
    assert(math.abs(c(10) + g(10) - 1.0) < 1e-6)
  }

test("prueba de inclusión") {
    val g1 = cd.grande(2, 3)
    val g2 = cd.grande(2, 2) // g2 incluye a g1
    assert(cd.inclusion(g1, g2)) // g1 ⊆ g2
  }
test("prueba de igualdad") {
    val g1 = cd.grande(2, 3)
    val g2 = cd.grande(2, 3) // igual a g1
    assert(cd.igualdad(g1, g2)) // g1 == g2
  }
}
