package com.example.designwork

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.designwork.ui.theme.FontColor1
import com.example.designwork.ui.theme.MainColor
import com.example.designwork.ui.theme.MainColorDark

@Composable
fun CustomButton(buttonText : String, darkTheme: Boolean = isSystemInDarkTheme()) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if(darkTheme) MainColorDark else MainColor,
            contentColor = FontColor1
        )

    ) {
        Text(text = buttonText)
    }
}