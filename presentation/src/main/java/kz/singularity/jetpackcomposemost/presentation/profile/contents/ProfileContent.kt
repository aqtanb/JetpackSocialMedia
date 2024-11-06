package kz.singularity.jetpackcomposemost.presentation.profile.contents

import InfoCard
import InfoRow
import LoadingState
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.presentation.profile.viewmodels.ProfileState

@Composable
fun ProfileContent(state: ProfileState, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        if (state.isLoadingUsers) {
            LoadingState()
        } else {
            CurrentProfile(user = state.users.first(), navController)
        }
    }
}

@Composable
fun CurrentProfile(user: User, navController: NavController) {
    val context = LocalContext.current
    val phoneNumber = user.phone.filter { it.isDigit() }.substring(0, 11)
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(16.dp)
    ) {
        Text(
            text = user.username,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        InfoCard(title = "Contacts") {
            InfoRow(
                label = "Email",
                value = user.email,
                labelColor = Color.Gray,
                valueColor = Color.Blue,
                modifier = Modifier.clickable {
                    val emailIntent =
                        Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:${user.email}")
                        }
                    context.startActivity(emailIntent)
                }
            )
            InfoRow(
                label = "Full Name",
                value = user.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = "Phone",
                value = phoneNumber,
                labelColor = Color.Gray,
                valueColor = Color.Red,
                modifier = Modifier.clickable {
                    val phoneIntent =
                        Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:$phoneNumber")
                        }
                    context.startActivity(phoneIntent)
                }
            )
            InfoRow(
                label = "Website",
                value = user.website,
                labelColor = Color.Gray,
                valueColor = Color.Blue,
                modifier = Modifier.clickable {
                    val websiteIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://${user.website}"))
                    context.startActivity(websiteIntent)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .clickable {
                    navController.navigate("profile/todos/${user.id}")
                }
            ,
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "My ToDos",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        InfoCard(title = "Company") {
            InfoRow(
                label = "Company Name",
                value = user.company.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = "Catch Phrase",
                value = user.company.catchPhrase,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = "Business Services",
                value = user.company.bs,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        InfoCard(title = "Address") {
            InfoRow(
                label = "Street",
                value = user.address.street,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = "Suite",
                value = user.address.suite,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = "City",
                value = user.address.city,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
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
