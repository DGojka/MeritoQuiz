package com.example.meritoquiz.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meritoquiz.R

@Composable
fun HomeScreen(
    onStartQuizClick: () -> Unit = {}
) {
    HomeScreenContent(
        onStartQuizClick = onStartQuizClick
    )
}

@Composable
private fun HomeScreenContent(
    onStartQuizClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F4FA)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFF007AFF),
                            Color(0xFF0066FF)
                        )
                    ),
                    shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(0.8f),
                elevation = 12.dp,
                shape = RoundedCornerShape(25.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.merito_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(360.dp))

        CustomButton(text = "Start quiz!", onClick = onStartQuizClick)
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.82f)
            .height(85.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(25.dp),
                ambientColor = Color(0xFFA68BFF),
                spotColor = Color(0xFFA68BFF)
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color(0xFF000000)
        ),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(2.dp, Color(0xFF007AFF))
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
