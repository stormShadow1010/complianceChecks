import java.util
import scala.annotation.tailrec

object Cwiczenia_7 {

  def main(args: Array[String]) ={
    val week = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela");

    println("Zadanie 1")
    println(printListUsingFor(week));
    println(printOnlyP(week));
    println(printListUsingWhile(week));
    println();

    println("Zadanie 2")
    println(printListRecurrent(week));
    println(printListRecurrentBackwards(week));
    println()

    println("Zadanie 3")
    println(printListTailRec(week))
    println()

    println("Zadanie 4")
    println(printListUsingFoldl(week))
    println(printListUsingFoldr(week))
    println(printListFoldlOnlyP(week))
    println()

    var produkty = Map("Banan"->5.0, "Cytryna"->0.5, "Chleb"->2.4, "Ser"->8.2, "Orzechy"->4.0)

    println("Zadanie 5")
    println(produkty.transform((a,b)=>{(a,b*0.9)}))
    println()

    println("Zadanie 6")
    printTuple(new Tuple3("Hello", 0, 2.1))
    println()

    val successors = Map(
      "Charles V"->"Philip II",
      "George V"->"Edward VIII",
      "George VI"->"Elizabeth II",
      "Louis XIV"->"Louis XV",
      "Wilhelm I"->"Frederick III")
    println("Zadanie 7")
    println(successors.get("George V"))
    println(successors.get("Louis XIV"))
    println(successors.get("Elizabeth II"))
    println(successors.get("Nicolas II"))
    println()

    val list1 = List(1,2,3,0,4,5,0,6,7,8)

    println("Zadanie 8")
    println(removeZerosFromList(list1))
    println()

    println("Zadanie 9")
    println(incrementateValues(list1))
    println()

    val list2 = List(-10.0, -7.0, -2.5, -2.0, -1.75, 0, 3, 5, 12.0, 22, 53)

    println("Zadanie 10")
    println(abs5to12(list2))
    println()

  }

  def printListUsingFor(week: List[String]): String ={

    var ret = "";

    for(element<-week){
      ret = ret+element+", ";
    }

    return ret;
  }

  def printOnlyP(week: List[String]): String ={
    var ret = "";
    for(element<-week){
      if(element.startsWith("P")){
        ret = ret+element+", ";
      }
    }
    return ret;
  }

  def printListUsingWhile(week: List[String]):String ={
    var ret = "";
    var x = 0
    //println(week.length)
    while(x<week.length){
      ret = ret+week(x)+", ";
      x = x+1;
      //println(x)
    }
    return ret;
  }

  def printListRecurrent(week: List[String]):String ={
    if(week.length==1)
      return week.head;
    return week.head+", "+printListRecurrent(week.tail);
  }

  def printListRecurrentBackwards(week: List[String]):String ={
    if(week.length==1)
      return week.head;
    return printListRecurrentBackwards(week.tail)+", "+week.head;
  }

  def printListTailRec(week: List[String]):String ={
    @tailrec
    def iter(week: List[String], ret: String): String ={
      if(week.length == 0) ret
      else iter(week.tail, ret+", "+week.head)
    }
    return iter(week, "");
  }

  def printListUsingFoldl(week: List[String]):String ={
    val ret = week.foldLeft("")((a,b) =>{
      a+", "+b
    })
    return ret;
  }

  def printListUsingFoldr(week: List[String]):String ={
    val ret = week.foldRight("")((a,b) =>{
      a+", "+b
    })
    return ret;
  }

  def printListFoldlOnlyP(week: List[String]):String ={
    val ret = week.foldLeft("")((a,b) =>{
      if(b.startsWith("P")){
        a+", "+b
      }else{
        a
      }

    })
    return ret;
  }

  def printTuple(tuple3: (String, Integer, Double)): Unit ={
    println(tuple3._1.toString+" "+tuple3._2.toString+" "+tuple3._3.toString)
  }


  def removeZerosFromList(list: List[Int]): List[Int] ={
    @tailrec
    def iter(list: List[Int], ret: List[Int]): List[Int] ={
      if(list.isEmpty) ret
      else if(list.head == 0) iter(list.tail, ret)
      else iter(list.tail, ret= ret:::List(list.head))
    }
    return iter(list, List());
  }

  def incrementateValues(list: List[Int]):List[Int] ={
    return list map (n=>n+1)
  }

  def abs5to12(list: List[Double]): List[Double] ={
    return list filter (_>=(-5.0)) filter (_<=12) map (a=>a.abs)
  }
}