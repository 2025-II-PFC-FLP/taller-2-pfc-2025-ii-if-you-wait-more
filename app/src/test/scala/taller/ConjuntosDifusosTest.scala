package taller

import org.scalatest.funsuite.AnyFunSuite

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

 /* test("prueba de union") {
    val g1 = cd.grande(2, 2)
    val g2 = cd.grande(5, 2)
    val u = cd.union(g1, g2)
    assert(u(10) == math.max(g1(10), g2(10)))
  }

  test("prueba de interseccion") {
    val g1 = cd.grande(2, 2)
    val g2 = cd.grande(5, 2)
    val i = cd.interseccion(g1, g2)
    assert(i(10) == math.min(g1(10), g2(10)))
  }*/

  test("prueba de inclusion") {
    val g1 = cd.grande(2, 2)
    val g2 = cd.grande(2, 3) // normalmente g2 es más permisivo
    assert(cd.inclusion(g1, g2))
  }

  test("prueba de igualdad") {
    val g1 = cd.grande(2, 2)
    val g2 = cd.grande(2, 2)
    assert(cd.igualdad(g1, g2))
  }

}
