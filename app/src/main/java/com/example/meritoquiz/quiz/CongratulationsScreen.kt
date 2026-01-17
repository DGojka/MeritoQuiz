package com.example.meritoquiz.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meritoquiz.R

@Composable
fun CongratulationsScreen(onBackToHomeClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.merito_logo),
            contentDescription = "Merito Logo",
            modifier = Modifier.fillMaxWidth(0.6f)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Gratulacje!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF007AFF)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Ukończyłeś quiz pomyślnie.",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onBackToHomeClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF007AFF))
        ) {
            Text("Wróć do ekranu głównego", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CongratulationsScreenPreview() {
    CongratulationsScreen(onBackToHomeClick = {})
}
