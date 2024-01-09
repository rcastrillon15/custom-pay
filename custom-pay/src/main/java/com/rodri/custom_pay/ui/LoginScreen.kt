package com.rodri.custom_pay.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {

    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(all = 16.dp)) {

        Text(text = "Username")

        Text(text = "Password")

        Button(onClick = {
            Toast.makeText(context, "Welcome VISA", Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Login")
        }
    }
}
