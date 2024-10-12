package com.example.designwork

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designwork.ui.theme.DesignWorkTheme
import com.example.designwork.ui.theme.FontColor1
import com.example.designwork.ui.theme.FontColor2
import com.example.designwork.ui.theme.FontColor2Dark
import com.example.designwork.ui.theme.MainColor
import com.example.designwork.ui.theme.MainColorDark
import com.example.designwork.ui.theme.pacifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignWorkTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    //Screen Configuration
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

   Scaffold(
       topBar = { CustomAppBar(stringResource(R.string.app_name)) }
   ) {PaddingValues ->
        Column(Modifier
            .fillMaxSize()
            .padding(paddingValues = PaddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = stringResource(R.string.pizzaTitle),
                fontWeight = FontWeight.Bold,
                color = if(darkTheme) MainColorDark else MainColor,
                fontSize = (screenWidth/10).sp)

            Image(painter = painterResource(id = R.drawable.pizza_image),
                contentDescription = null,
                Modifier.size(200.dp))

            Row (
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                CustomButton(stringResource(R.string.CheeseText))
                CustomButton(stringResource(R.string.sausageText))
                CustomButton(stringResource(R.string.oliveText))
                CustomButton(stringResource(R.string.pepperText))
            }

            Text(text = stringResource(R.string.deliveryTime),
                color = if(darkTheme) FontColor2Dark else FontColor2,
                fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text = stringResource(R.string.deliveryTitle), color = if(darkTheme) MainColorDark else MainColor, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text = stringResource(R.string.pizzaDescription), color =if(darkTheme) FontColor2Dark else FontColor2,
                textAlign = TextAlign.Center, fontSize = 22.sp)

            Row (Modifier.fillMaxWidth().padding((screenWidth/20).dp, end =(screenWidth/20).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                ){
                Text(text = stringResource(R.string.priceText), color = if(darkTheme) MainColorDark else MainColor, fontWeight = FontWeight.Bold, fontSize = 44.sp)
                CustomButton(stringResource(R.string.buttonText))
            }
        }
   }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(appbarName: String,darkTheme: Boolean = isSystemInDarkTheme()){
    CenterAlignedTopAppBar(
        title = {Text(text = appbarName, fontFamily = pacifico )},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = if(darkTheme) MainColorDark else MainColor,
            titleContentColor = FontColor1
        )
    )
}




@Preview(showBackground = true)
@Composable
fun DesignWorkPreview() {
    DesignWorkTheme {
        MainScreen()
    }
}