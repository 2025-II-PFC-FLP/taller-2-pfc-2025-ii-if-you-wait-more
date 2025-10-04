package taller

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {

  val cd = new ConjuntosDifusos()

  //pruebas de la función grande
  test("prueba de grande") {
    val g = cd.grande(2, 3)
    assert(g(1) >= 0.0 && g(1) <= 1.0)
    assert(g(100) > g(5))
  }
  test("grande con d=2, e=2 en x=0") {
    val g = cd.grande(2, 2)
    assert(math.abs(g(0) - 0.0) < 1e-6)
  }

  test("grande con d=1, e=1 en x=10") {
    val g = cd.grande(1, 1)
    assert(math.abs(g(10) - (10.0 / 11.0)) < 1e-6)
  }

  test("grande con d=2, e=3 en x=2") {
    val g = cd.grande(2, 3)
    val esperado = math.pow(2.0 / (2 + 2), 3)
    assert(math.abs(g(2) - esperado) < 1e-6)
  }

  test("grande con d=5, e=2 en x=10") {
    val g = cd.grande(5, 2)
    val esperado = math.pow(10.0 / 15.0, 2)
    assert(math.abs(g(10) - esperado) < 1e-6)
  }

  test("grande con d=3, e=1 en x=100") {
    val g = cd.grande(3, 1)
    val esperado = 100.0 / 103.0
    assert(math.abs(g(100) - esperado) < 1e-6)
  }

//fin de pruebas de la función grande

  //pruebas de la función complemento
  test("prueba de complemento") {
    val g = cd.grande(2, 2)
    val c = cd.complemento(g)
    assert(math.abs(c(10) + g(10) - 1.0) < 1e-6)
  }
  test("complemento de grande(2,2) en x=0") {
    val g = cd.grande(2, 2)
    val c = cd.complemento(g)
    assert(math.abs(c(0) - 1.0) < 1e-6) // porque g(0)=0 → complemento=1
  }

  test("complemento de grande(1,1) en x=10") {
    val g = cd.grande(1, 1)
    val c = cd.complemento(g)
    val esperado = 1.0 - (10.0 / 11.0)
    assert(math.abs(c(10) - esperado) < 1e-6) // ≈ 0.0909
  }

  test("complemento de grande(2,3) en x=2") {
    val g = cd.grande(2, 3)
    val c = cd.complemento(g)
    val esperado = 1.0 - math.pow(2.0 / (2 + 2), 3) // 1 - 0.125 = 0.875
    assert(math.abs(c(2) - esperado) < 1e-6)
  }

  test("complemento de grande(5,2) en x=10") {
    val g = cd.grande(5, 2)
    val c = cd.complemento(g)
    val esperado = 1.0 - math.pow(10.0 / 15.0, 2) // 1 - 0.444... = 0.555...
    assert(math.abs(c(10) - esperado) < 1e-6)
  }

  test("complemento de grande(3,1) en x=100") {
    val g = cd.grande(3, 1)
    val c = cd.complemento(g)
    val esperado = 1.0 - (100.0 / 103.0) // ≈ 0.02913
    assert(math.abs(c(100) - esperado) < 1e-6)
  }
//fin de pruebas de complemento

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
  test("prueba de unión e intersección") {
    val g1 = cd.grande(2, 3)
    val g2 = cd.grande(2, 2)
    val u = cd.union(g1, g2)
    val i = cd.interseccion(g1, g2)
    assert(u(10) >= math.max(g1(10), g2(10)) - 1e-6) //g1 ∪ g2
    assert(i(10) <= math.min(g1(10), g2(10)) + 1e-6) //g1 ∩ g2
  }
}
