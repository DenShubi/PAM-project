package com.example.projeklogin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profile") },
                navigationIcon = {
                    IconButton(onClick = { /* Aksi kembali */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImageSection()
            Spacer(modifier = Modifier.height(32.dp))
            ProfileDetailsSection()
            Spacer(modifier = Modifier.height(32.dp))
            SettingsSection()
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E8B57))
            ) {
                Text("Edit Akun", color = Color.White)
            }
        }
    }
}

@Composable
fun ProfileImageSection() {
    Box(modifier = Modifier.size(140.dp)) {
        Image(
            painter = painterResource(id = R.drawable.herp),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .border(2.dp, Color(0xFF2E8B57), CircleShape)
        )
        Icon(
            imageVector = Icons.Default.PhotoCamera,
            contentDescription = "Ubah Foto",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .background(Color(0xFF2E8B57), CircleShape)
                .padding(8.dp)
                .size(24.dp)
        )
    }
}

@Composable
fun ProfileDetailsSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Detail Profil", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                InfoRow(icon = Icons.Default.Email, label = "Email", value = "jolybeer@gmail.com")
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                InfoRow(icon = Icons.Default.Phone, label = "No Telp", value = "082247283745")
            }
        }
    }
}

@Composable
fun SettingsSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Pengaturan", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                SettingsRow(icon = Icons.Default.Notifications, text = "Atur Notifikasi")
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                SettingsRow(icon = Icons.Default.MoreHoriz, text = "Ubah Kata Sandi")
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                SettingsRow(
                    icon = Icons.Default.ExitToApp,
                    text = "Keluar",
                    iconTint = Color.Red,
                    textColor = Color.Red
                )
            }
        }
    }
}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = label, tint = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = value, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun SettingsRow(
    icon: ImageVector,
    text: String,
    iconTint: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Aksi saat baris diklik */ }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = iconTint)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, color = textColor)
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}