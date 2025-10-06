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
    val g2 = cd.grande(2, 2)
    assert(cd.inclusion(g1, g2))
  }
  test("inclusión asdasd") {
    val g1 = cd.grande(1, 4)
    val g2 = cd.grande(1, 2)
    assert(cd.inclusion(g1, g2))
  }

  test("inclusión ads") {
    val g1 = cd.grande(2, 5)
    val g2 = cd.grande(2, 3)
    assert(cd.inclusion(g1, g2))
  }

  test("inclusión awd") {
    val g1 = cd.grande(3, 4)
    val g2 = cd.grande(3, 2)
    assert(cd.inclusion(g1, g2))
  }

  test("inclusiónqew ") {
    val g1 = cd.grande(1, 6)
    val g2 = cd.grande(1, 3)
    assert(cd.inclusion(g1, g2))
  }

  test("prueba de igualdad") {
    val g1 = cd.grande(2, 3)
    val g2 = cd.grande(2, 3)
    assert(cd.igualdad(g1, g2))
  }

  test("igualdad asd") {
    val g1 = cd.grande(1, 4)
    val g2 = cd.grande(1, 4)
    assert(cd.igualdad(g1, g2))
  }
  test("igualdad qwe") {
    val g1 = cd.grande(3, 2)
    val g2 = cd.grande(3, 2)
    assert(cd.igualdad(g1, g2))
  }
  test("igualdad zxc") {
    val g1 = cd.grande(5, 1)
    val g2 = cd.grande(5, 1)
    assert(cd.igualdad(g1, g2))
  }
  test("igualdad rty") {
    val g1 = cd.grande(4, 3)
    val g2 = cd.grande(4, 3)
    assert(cd.igualdad(g1, g2))
  }


  //pruebas de las funciones unión e intersección
  test("prueba de unión e intersección en x=2") {
    val g1 = cd.grande(2, 3)
    val g2 = cd.grande(2, 2)
    val u = cd.union(g1, g2)
    val i = cd.interseccion(g1, g2)
    val esperadoU = math.max(g1(2), g2(2))
    val esperadoI = math.min(g1(2), g2(2))
    assert(math.abs(u(2) - esperadoU) < 1e-6) //g1 ∪ g2
    assert(math.abs(i(2) - esperadoI) < 1e-6) //g1 ∩ g2
  }
  test("prueba de unión e intersección en x=5") {
    val g1 = cd.grande(1, 2)
    val g2 = cd.grande(2, 3)
    val u = cd.union(g1, g2)
    val i = cd.interseccion(g1, g2)
    val esperadoU = math.max(g1(5), g2(5))
    val esperadoI = math.min(g1(5), g2(5))
    assert(math.abs(u(5) - esperadoU) < 1e-6) //g1 ∪ g2
    assert(math.abs(i(5) - esperadoI) < 1e-6) //g1 ∩ g2
  }
  test("prueba de unión e intersección en x=10") {
    val g1 = cd.grande(3, 1)
    val g2 = cd.grande(5, 4)
    val u = cd.union(g1, g2)
    val i = cd.interseccion(g1, g2)
    val esperadoU = math.max(g1(10), g2(10))
    val esperadoI = math.min(g1(10), g2(10))
    assert(math.abs(u(10) - esperadoU) < 1e-6) //g1 ∪ g2
    assert(math.abs(i(10) - esperadoI) < 1e-6) //g1 ∩ g2
  }
  test("prueba de unión e intersección en x=15"){
    val g1 = cd.grande(2, 2)
    val g2 = cd.grande(4, 3)
    val u = cd.union(g1, g2)
    val i = cd.interseccion(g1, g2)
    val esperadoU = math.max(g1(15), g2(15))
    val esperadoI = math.min(g1(15), g2(15))
    assert(math.abs(u(15) - esperadoU) < 1e-6) //g1 ∪ g2
    assert(math.abs(i(15) - esperadoI) < 1e-6) //g1 ∩ g2
  }
  test("prueba de unión e intersección en x=50"){
    val g1 = cd.grande(1, 3)
    val g2 = cd.grande(3, 2)
    val u = cd.union(g1, g2)
    val i = cd.interseccion(g1, g2)
    val esperadoU = math.max(g1(50), g2(50))
    val esperadoI = math.min(g1(50), g2(50))
    assert(math.abs(u(50) - esperadoU) < 1e-6) //g1 ∪ g2
    assert(math.abs(i(50) - esperadoI) < 1e-6) //g1 ∩ g2
  }
}
