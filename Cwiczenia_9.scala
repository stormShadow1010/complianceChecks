object Cwiczenia_9 {

  def main(args: Array[String]) = {

    val ct1 = new Container[Int](5);

    println("Zadanie 1")
    println(ct1.getContent)
    println(ct1.applyFunction(half))
    println()

    val mb1 = new No();
    val mb2 = new Yes(5);

    println("Zadanie 2")
    println(mb1.isInstanceOf[Maybe[_]])
    println(mb2.isInstanceOf[Maybe[_]])
    println()

    println("Zadanie 3")
    println(mb1)
    println(mb1.applyFunction(half))
    println(mb1.applyFunction(half).getOrElse(0))
    println(mb2)
    println(mb2.applyFunction(half))
    println(mb2.applyFunction(half).getOrElse(0))
    println()

    println("Zadanie 4")
    println(mb1.getOrElse(20))
    println(mb2.getOrElse(20))
    println()
  }

  def half(number: Int): Double ={
    return (number.toDouble)/2
  }

}

class Container[A](val a : A){

  def getContent:A ={
    return a;
  }

  def applyFunction[R](function: A=>R): R = {
    return function(a)
  }


}

trait Maybe [A]{

}

class No extends Maybe[Nothing]{

  def applyFunction[A,R](function: A=>R):No={
    return this;
  }

  def getOrElse[B](opt: B):B ={
    return opt;
  }
}

class Yes[A](var a: A) extends Maybe[A]{
  def applyFunction[R](function: A=>R):Yes[R]={
    return new Yes(function(a));
  }

  def getOrElse[B](opt: B):A ={
    return a;
  }
}
