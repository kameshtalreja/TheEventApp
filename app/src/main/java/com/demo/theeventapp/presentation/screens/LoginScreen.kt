package com.demo.theeventapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.theeventapp.R
import com.kamesh.newsapp.presentation.viewmodel.LoginViewModel

//@Preview(showBackground = true)
@Composable
fun LoginScreen(
    gotoHome : () -> Unit,
    viewModel : LoginViewModel = hiltViewModel()
) {

    var userEmail : String by remember { mutableStateOf("") }
    var userPassword : String by remember { mutableStateOf("") }

    val res = viewModel.loginResponse.value




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .height(60.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "Login",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        EmailTextField()
        PasswordTextField()
        LoginButton(viewModel,userEmail,userPassword)
        ForgotPasswordText()
    }

    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    res.data?.let { it ->
        if (it.status){
            gotoHome()
        }
    }
}

@Composable
fun EmailTextField() {
    var emailValue by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = emailValue,
        onValueChange = { emailValue = it },
        placeholder = { Text(text = "Email") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun PasswordTextField() {
    var passwordValue by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = passwordValue,
        onValueChange = { passwordValue = it },
        placeholder = { Text(text = "Password") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun LoginButton(viewModel: LoginViewModel, userEmail: String, userPassword: String) {
    Button(
        onClick = { viewModel.loginEvent(userEmail, userPassword) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "Login", color = Color.White)
    }
}

@Composable
fun ForgotPasswordText() {
    Text(
        text = "Forgot Password?",
        color = Color.Blue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewLoginScreen() {
//    LoginScreen()
}
