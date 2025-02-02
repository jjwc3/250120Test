package com.example.a250120test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "Main",
            ){
                composable("Main") {
                    Main(
                        modifier = Modifier
                            .background(color = Color(0xFFF6F6F8)),
//                        onNavigateToDrawing = {navController.navigate("Drawing")}
                    )
                }
                composable("Drawing") {
                    Drawing(
//                        modifier = Modifier
//                            .background(color = Color(0xFFF6F6F8)),
//                        onNavigateToMain = {navController.navigate("Drawing")}
                    )
                }
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    modifier: Modifier = Modifier,
//    onNavigateToDrawing : () -> Unit,
//    viewModel: MainViewModel,
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("기본 설정")},
                modifier = modifier,
                navigationIcon = {
                    IconButton(onClick = {}) {Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home"
                    ) }
                },
                actions = {
                    IconButton(onClick = {}) { Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Next"
                    )}
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF6F6F8))
            )},
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(color = Color(0xFFF6F6F8)
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Text(
                        text = "수업 요일",
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.size(3.dp))
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularButton(
                            text = "월",
                            isEnabled = true,
                        )
                        CircularButton(
                            text = "일",
                            isEnabled = false,
                        )
                        Text(
                            text = "부터 시작",
                            fontSize = 30.sp,
                        )
                    }
                    Spacer(modifier = Modifier.size(3.dp))
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val dateList: Array<String> = arrayOf("월", "화", "수", "목", "금", "토", "일")
                        for (i in dateList)
                            CircularButton(
                                text = i,
                            )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Text(
                        text = "수업시간",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                    Row (
                        modifier = Modifier
                            .height(40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = "1교시 ~ ",
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(includeFontPadding = false)
                            )
                        )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//
//                    )
//                        TextField(
//                            value = "",
//                            onValueChange = {},
//                            singleLine = true,
//                            textStyle = TextStyle(fontSize = 30.sp, textAlign = TextAlign.Center),
//                            modifier = Modifier
//                                .width(80.dp),
//                            colors = TextFieldDefaults.colors(
//                                focusedContainerColor = Color.White,
//                                unfocusedContainerColor = Color.White,
//                                focusedIndicatorColor = Color.Blue,
//                                unfocusedIndicatorColor = Color.Black,
//                                focusedTextColor = Color.Black,
//                                unfocusedLabelColor = Color.Black,
//                            ),
//                        )
                        BasicTextField(
                            value = "7",
                            onValueChange = {},
                            modifier = Modifier
                                .width(50.dp)
                                .fillMaxHeight(),
                            singleLine = true,
                            textStyle = TextStyle(
                                fontSize = 30.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            ),
                            decorationBox = { innerTextField -> run {
                                Box(
                                    modifier = Modifier
                                        .border(
                                            border = BorderStroke(2.dp, Color.Black),
                                            shape = RoundedCornerShape(corner = CornerSize(10.dp))
                                        ),
                                    contentAlignment = Alignment.BottomCenter,
                                ) {
                                    innerTextField()
                                }
                            }
                            }
                        )
                        Text(
                            text = "교시",
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Row (
                        modifier = Modifier,
//                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val timeState = rememberTimePickerState()
                        Text(text="수업 시작 시간: ", fontSize = 25.sp)
                        TimeInput(
                            state = timeState,
                            modifier = Modifier
//                                .width(200.dp)
                                .height(70.dp)
                        )
                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {}
            }
        }
    )
}


@Composable
fun Drawing(
//    modifier: Modifier = Modifier,
//    onNavigateToMain: () -> Unit,
) {}

@Composable
fun CircularButton (
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = false
) {
    Button(
        onClick = {},
        enabled = isEnabled,
        shape = CircleShape,
        border = if (isEnabled) BorderStroke(2.dp, Color(0xFF376FDD)) else null,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Black,
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        modifier = modifier.size(50.dp)
    ) {
        Text(
            text = text,
//                                style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth(),
            color = if (isEnabled) Color(0xFF376FDD) else Color.Black,
            fontSize = 20.sp
        )
    }
    Spacer(modifier = Modifier.size(3.dp))
}










class MainViewModel : ViewModel() {
    private val _data = mutableStateOf("")
    val data: State<String> = _data

    fun changeValue(value: String) {
        _data.value = value
    }
}








//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Main()
//}
