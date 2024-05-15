package com.demo.theeventapp.presentation.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
    gotoRegister : () -> Unit,
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
            painter = painterResource(id = R.drawable.lldd),
            contentDescription = null,
            modifier = Modifier
                .height(80.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "LOG IN",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
        )
        EmailTextField()
        PasswordTextField()
        LoginButton(viewModel,userEmail,userPassword)
        ForgotPasswordText()
        RegisterText(onCreateAction = {})
    }

    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize()){
            Toast.makeText(
                LocalContext.current,
                res.error,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    res.data?.let { it ->
        if (it.status){
            gotoHome()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
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
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
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
            .padding(vertical = 8.dp),
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}

@Composable
fun LoginButton(viewModel: LoginViewModel, userEmail: String, userPassword: String) {
    Button(
        onClick = { viewModel.loginEvent(userEmail, userPassword) },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9fc5ff)),
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(2.dp))
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

@Composable
fun RegisterText( onCreateAction : () -> Unit) {
    Text(
        text = "Or Create an Account",
        color = Color.Blue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onCreateAction()
            },
        textAlign = TextAlign.Center
    )
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewLoginScreen() {
//    LoginScreen({ Log.d("TAG", "PreviewLoginScreen: ")})
//}
