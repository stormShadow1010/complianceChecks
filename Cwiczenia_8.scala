object Cwiczenia_8 {

  def main(args: Array[String]) = {

    println("Zadanie 1")
    println(whichDayIsThat("Poniedzialek"));
    println(whichDayIsThat("Sroda"));
    println(whichDayIsThat("Piatek"));
    println(whichDayIsThat("Niedziela"));
    println(whichDayIsThat("Takdziela"));
    println()

    println("Zadanie 2")
    var konto1 = new KontoBankowe()
    var konto2 = new KontoBankowe(2000)

    println(konto1.stanKonta)
    println(konto2.stanKonta)

    konto1.wplata(500)
    konto2.wyplata(200)

    println(konto1.stanKonta)
    println(konto2.stanKonta)
    println()

    println("Zadanie 3")
    var osoba1 = new Osoba("Mieszko", "Piast")
    var osoba2 = new Osoba("Jan", "Luksemburski")
    var osoba3 = new Osoba("Otton", "Ludolfing")
    var osoba4 = new Osoba("Boleslaw", "Chrobry")

    println(powitanie(osoba1))
    println(powitanie(osoba2))
    println(powitanie(osoba3))
    println(powitanie(osoba4))
    println()

    println("Zadanie 4")
    println(operacje(0,inkrementacja))

    println("Zadanie 5")
    var osoba5 = new Osoba2("Jan", "Kowalski")
    var osoba6 = new Osoba2("Zbigniew", "Nowak") with Student()
    var osoba7 = new Osoba2("Katarzyna", "Zarembina") with Pracownik()
    var osoba8 = new Osoba2("Marcjanna", "Cabacka") with Nauczyciel()
    var osoba9 = new Osoba2("Ignacy", "Jakowlew") with Nauczyciel with Pracownik
    var osoba10 = new Osoba2("Urszula", "Gdaś") with Pracownik with Nauczyciel
    //kompilator poniżsżą konstrukcję oprotestował i stwierdził że do preferowaną cechę należy przeciążyć
    //var osoba11 = new Osoba2("Tomasz","Edelmann") with Pracownik with Student

    osoba7.pensja = 1000
    osoba8.pensja = 1000
    osoba9.pensja = 1000
    osoba10.pensja = 1000
    //osoba11.pensja = 1000
    println(osoba7.getPensja())
    println(osoba8.getPensja())
    println(osoba9.getPensja())
    println(osoba10.getPensja())
    //println(osoba11.getPensja())

  }

  def whichDayIsThat(day:String):String ={
    day match{
      case "Poniedzialek" => return "Praca";
      case "Wtorek" => return "Praca";
      case "Sroda" => return "Praca";
      case "Czwartek" => return "Praca";
      case "Piatek" => return "Praca";
      case "Sobota" => return "Weekend";
      case "Niedziela" => return "Weekend";
      case _ => return "Nie ma takiego dnia"
    }
  }

  def powitanie(osoba: Osoba): String = {
    val imieinazwisko = osoba.imie + " " + osoba.nazwisko
    imieinazwisko match{
      case "Mieszko Piast" => return "Witaj, Książę";
      case "Boleslaw Chrobry" => return "Witaj, Królu";
      case "Otton Ludolfing" => return "Witaj, Cesarzu";
      case _ => return "Witaj, Władco";
    }

  }

  def operacje(liczba: Int, funkcja: (Int) => Int): Int ={
    return funkcja(funkcja(funkcja(liczba)))
  }

  def inkrementacja(liczba: Int):Int ={
    return liczba+1;
  }
}

class KontoBankowe(private var saldoPoczatkowe: Int){

  var _stanKonta: Int = saldoPoczatkowe

  def wyplata(kwota:Int): Unit ={
    _stanKonta = _stanKonta-kwota
  }
  def wplata(kwota: Int): Unit ={
    _stanKonta = _stanKonta+kwota
  }

  def stanKonta: Int ={
    return _stanKonta
  }

  def this(){
    this(0);
  }
}

class Osoba(val imie: String, val nazwisko: String){

}

class Osoba2(val imie: String, val nazwisko: String){

  private var podatek: Double = 0

}

trait Student{
  val podatek = 0;
}

trait Nauczyciel extends Pracownik {
  override val podatek = 0.1
}

trait Pracownik{
  var pensja: Double = 0
  val podatek = 0.2

  def getPensja(): Double = {
    return pensja-(pensja*podatek)
  }
}
