package edu.farmingdale.pizzapartybottomnavbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

// ToDo 4: Match the UI as in drawable gpa_design.png. Use the following hints:
// - The background color should be Color.Cyan
// - Fix padding, alignment, and keypad type

// ToDo 5:  Add the GpaAppScreen composable button that clears the input fields when clicked

fun calGPA(grade1: String, grade2: String, grade3: String): Double {
    val g1 = grade1.toDouble()
    val g2 = grade2.toDouble()
    val g3 = grade3.toDouble()
    return (g1 + g2 + g3) / 3

}


@Composable
fun GpaAppScreen() {

    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }


    // Declare variables for GPA result and background color
    var gpa by remember { mutableStateOf("") }
    var backColor by remember { mutableStateOf(Color.Cyan) }
    var btnLabel by remember { mutableStateOf("Calulate GPA") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(backColor),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },Modifier.padding(16.dp),
            label = { Text("Course 1 Grade")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )


        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it }, Modifier.padding(16.dp),
            label = { Text("Course 2 Grade") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )



        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },Modifier.padding(16.dp),
            label = { Text("Course 3 Grade") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )


        Button(onClick = {
                val gpaVal = calGPA(grade1, grade2, grade3)
                gpa = gpaVal.toString()
                if (gpaVal != null) {
                    gpa = gpaVal.toString()

                   // backColor = when {
                    //    gpaVal < 60 -> Color.Red
                    //    gpaVal in 60.0..79.0 -> Color.Yellow
                    //    else -> Color.Green
                   // }

                    if(gpaVal < 60){
                        backColor = Color(Color.Red.value)
                    }else if(gpaVal >= 60 && gpaVal <= 79){
                        backColor = Color(Color.Yellow.value)
                    }else{
                        backColor = Color(Color.Green.value)
                    }
                }
        }, modifier = Modifier.padding(top = 56.dp)) {
            Text(btnLabel)
        }


        if (true) {
            Text(
                text = "GPA: " + gpa,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Button(
            onClick = {
                grade1 = ""
                grade2 = ""
                grade3 = ""
                gpa = ""
                backColor = Color(Color.Cyan.value)
            })
        {

        }

    }
}


