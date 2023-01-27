package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val question1 = Question(1, "Quel est ce pays ?", R.drawable.argentine,
            "Argentine",
            "Australie",
            "Inde",
            "Fiji", 1
        )

        questionsList.add(question1)

        val question2 = Question(2, "Quel est ce pays ?", R.drawable.allemagne,
            "Belgique",
            "Bresil",
            "Allemagne",
            "Danemark", 3
        )

        questionsList.add(question2)

        val question3 = Question(3, "Quel est ce pays ?", R.drawable.australie,
            "Nouvelle Zelande",
            "Australie",
            "Kuwait",
            "Inde", 2
        )

        questionsList.add(question3)

        val question4 = Question(4, "Quel est ce pays ?", R.drawable.belgique,
            "Nouvelle Zelande",
            "Australie",
            "Belgique",
            "Danemark", 3
        )
        questionsList.add(question4)

        val question5 = Question(5, "Quel est ce pays ?", R.drawable.bresil,
            "Etats-Unis",
            "Brésil",
            "France",
            "Pays de Galles", 2
        )

        questionsList.add(question5)

        val question6 = Question(6, "Quel est ce pays ?", R.drawable.danemark,
            "Angleterre",
            "Allemagne",
            "Turquie",
            "Danemark", 4
        )

        questionsList.add(question6)

        val question7 = Question(7, "Quel est ce pays ?", R.drawable.fiji,
            "Fiji",
            "Grande Bretagne",
            "Congo",
            "Canada", 1
        )

        questionsList.add(question7)

        val question8 = Question(8, "Quel est ce pays ?", R.drawable.inde,
            "Nepal",
            "France",
            "Andorre",
            "Inde", 4
        )

        questionsList.add(question8)

        val question9 = Question(9, "Quel est ce pays ?", R.drawable.kuwait,
            "Kuwait",
            "Brésil",
            "France",
            "Pays de Galles", 1
        )

        questionsList.add(question9)

        val question10 = Question(5, "Quel est ce pays ?", R.drawable.nouvelle_zelande,
            "Chili",
            "Nepal",
            "Mali",
            "Nouvelle Zelande", 4
        )

        questionsList.add(question10)



        return questionsList
    }

}