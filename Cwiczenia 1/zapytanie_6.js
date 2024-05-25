db.people.insertOne(
    {
    birth_date : ISODate("1999-08-09T04:00:00Z"),
    description :"to ja",
    email : "s17191@pjwstk.edu.pl",
    first_name : "Paweł",
    height : "180",
    job : "Student",
    last_name : "Machowiec",
    nationality : "Poland",
    sex : "Male",
    weight : "78",
    credit : {
        balance : "100",
        currency : "PLN",
        number : "0000000000000000",
        type : "visa-electron"
    },
    location : {
        address : {
            streetname : "Marszałkowska",
            streetnumber : "1"
        },
        city : "Warsaw"
    }
    }
)