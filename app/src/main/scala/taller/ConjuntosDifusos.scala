package taller

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
  //def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {  }

  // Intersección de dos conjuntos difusos
  //def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {}

  // Inclusión (usar recursión de cola, intervalo [0,1000])
  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    true
  }

  // Igualdad de conjuntos difusos
  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
true
  }
}
