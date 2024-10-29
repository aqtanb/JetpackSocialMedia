package kz.singularity.jetpackcomposemost.presentation.users

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.singularity.jetpackcomposemost.domain.model.User

@Composable
fun UserProfileContent(user: User) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) {
        Text(
            text = user.username,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        UserProfileSection(title = "") {
            ProfileInfoRow(
                label = "Email",
                value = user.email,
                labelColor = Color.Gray,
                valueColor = Color.Blue
            )
            ProfileInfoRow(
                label = "Full Name",
                value = user.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            ProfileInfoRow(
                label = "Phone",
                value = user.phone,
                labelColor = Color.Gray,
                valueColor = Color.Red
            )
            ProfileInfoRow(
                label = "Website",
                value = user.website,
                labelColor = Color.Gray,
                valueColor = Color.Blue
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        UserProfileSection(title = "Company") {
            ProfileInfoRow(
                label = "Company Name",
                value = user.company.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            ProfileInfoRow(
                label = "Catch Phrase",
                value = user.company.catchPhrase,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            ProfileInfoRow(
                label = "Business Services",
                value = user.company.bs,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        UserProfileSection(title = "Address") {
            ProfileInfoRow(
                label = "Street",
                value = user.address.street,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            ProfileInfoRow(
                label = "Suite",
                value = user.address.suite,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            ProfileInfoRow(
                label = "City",
                value = user.address.city,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            ProfileInfoRow(
                label = "Zipcode",
                value = user.address.zipcode,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Show On Map",
                    color = Color.Blue,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            val geoUri = Uri.parse("geo:${user.address.geo.lat},${user.address.geo.lng}?q=${Uri.encode("${user.address.geo.lat},${user.address.geo.lng}")}")
                            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri).apply {
                                setPackage("com.google.android.apps.maps")
                            }
                            context.startActivity(mapIntent)
                        }
                )
            }
        }
    }
}

@Composable
fun UserProfileSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                content()
            }
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String, labelColor: Color, valueColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            color = labelColor,
            modifier = Modifier.width(100.dp)
        )
        Text(text = value, color = valueColor)
    }
}
