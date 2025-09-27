package taller

class ConjuntosDifusos {

  // Definición del tipo conjunto difuso: Int => Double
  type ConjDifuso = Int => Double

  // Función para obtener el grado de pertenencia
  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }

  // Conjunto difuso de números grandes
  def grande(d: Int, e: Int): ConjDifuso = {
    // Implementación pendiente
    (x: Int) => {
      if (x <= d) 0.0
      else if (x >= e) 1.0
      else (x - d).toDouble / (e - d)
    }
  }

  // Complemento de un conjunto difuso
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
