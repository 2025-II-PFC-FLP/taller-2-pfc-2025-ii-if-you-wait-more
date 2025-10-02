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

}
