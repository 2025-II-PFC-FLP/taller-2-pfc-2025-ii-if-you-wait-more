package taller

import scala.annotation.tailrec

class ConjuntosDifusos {

  // Definición del tipo conjunto difuso: Int => Double
  type ConjDifuso = Int => Double

  // Función para obtener el grado de pertenencia
  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }

  // Conjunto difuso de números grandes juan
  def grande(d: Int, e: Int): ConjDifuso = {
    (n: Int) => {
      val frac = n.toDouble / (n + d).toDouble
      math.pow(frac, e.toDouble)
    }
  }


  // Complemento de un conjunto difuso juan
  def complemento(c: ConjDifuso): ConjDifuso = {
    (x: Int) => 1.0 - c(x)
  }

  // Unión de dos conjuntos difusos
  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    (x: Int) => math.max(cd1(x), cd2(x))
  }

  // Intersección de dos conjuntos difusos
  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    (x: Int) => math.min(cd1(x), cd2(x))
  }

    // Inclusión (usar recursión de cola, intervalo [0,1000])
    def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
      @tailrec
      def inclusionAux(elem: Int): Boolean = {
        if (elem > 1000) true
        else if (cd1(elem) <= cd2(elem)) inclusionAux(elem + 1)
        else false
      }
      inclusionAux(0)
    }

    // Igualdad de conjuntos difusos
    def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
      inclusion(cd1, cd2) && inclusion(cd2, cd1)
    }


}
